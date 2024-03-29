package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.exception.EntityNotFoundException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlException;
import com.rokzasok.portal.za.imunizaciju.exception.XmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.portal.za.imunizaciju.model.dto.ZakazivanjeTerminaDTO;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_korisnika.SpisakKorisnika;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.Dan;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.SpisakTermina;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.Termini;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_QUERY_FIND_ALL_SPISAK_TERMINA;
import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_UPDATE_REMOVE_SPISAK_TERMINA_BY_ID_EXPRESSION;

@Service
public class SpisakTerminaService implements AbstractXmlService<SpisakTermina> {

    private static final BigInteger MAX_BROJ_TERMINA = BigInteger.valueOf(100);

    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina";

    @Autowired
    private AbstractXmlRepository<SpisakTermina> spisakTerminaAbstractXmlRepository;

    @Autowired
    private XmlConversionAgent<SpisakTermina> spisakTerminaXmlConversionAgent;

    @Autowired
    private B2BService b2bService;

    @Autowired
    private EmailService emailService;


    public void injectRepositoryProperties() {
        this.spisakTerminaAbstractXmlRepository.injectRepositoryProperties(
                "/db/sample/termini",
                jaxbContextPath,
                X_QUERY_FIND_ALL_SPISAK_TERMINA,
                X_UPDATE_REMOVE_SPISAK_TERMINA_BY_ID_EXPRESSION);
    }


    @Override
    public List<SpisakTermina> findAll() {
        injectRepositoryProperties();

        try {
            return this.spisakTerminaAbstractXmlRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(SpisakTermina.class, e.getMessage());
        }
    }

    @Override
    public SpisakTermina findById(Long entityId) {
        injectRepositoryProperties();

        try {
            SpisakTermina spisakTermina = this.spisakTerminaAbstractXmlRepository.getEntity(entityId);
            if (spisakTermina == null) throw new EntityNotFoundException(entityId, SpisakTermina.class);
            return spisakTermina;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(SpisakTermina.class, e.getMessage());
        }
    }

    @Override
    public SpisakTermina create(String entityXml) {
        injectRepositoryProperties();

        SpisakTermina spisakTermina;
        try {
            spisakTermina = this.spisakTerminaXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
            spisakTermina.setDokumentId(1L);
        } catch (JAXBException e) {
            throw new InvalidXmlException(SpisakTermina.class, e.getMessage());
        }

        try {
            spisakTermina = spisakTerminaAbstractXmlRepository.createEntity(spisakTermina);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(SpisakTermina.class, e.getMessage());
        }

        return spisakTermina;

    }

    @Override
    public SpisakTermina update(String entityXml) {
        injectRepositoryProperties();

        SpisakTermina spisakTermina;
        try {
            spisakTermina = this.spisakTerminaXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(SpisakTermina.class, e.getMessage());
        }

        try {
            if (!this.spisakTerminaAbstractXmlRepository.updateEntity(spisakTermina)) {
                throw new EntityNotFoundException(spisakTermina.getDokumentId(), SpisakTermina.class);
            }
            return spisakTermina;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(SpisakTermina.class, e.getMessage());
        }
    }

    @Override
    public String getRdfaString(Long dokumentId) throws JAXBException {
        injectRepositoryProperties();

        SpisakTermina dokument;
        dokument = this.findById(dokumentId);
        String entityXml = this.spisakTerminaXmlConversionAgent.marshall(dokument, this.jaxbContextPath);
        System.out.println(entityXml);
        return entityXml;

    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();

        try {
            return this.spisakTerminaAbstractXmlRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }

    private boolean checkSlobodniTerminiZaDan(Dan dan) {
        return dan.getBrojZakazanihTermina().compareTo(dan.getMaxBrojTermina()) < 0;
    }

    private List<Dan> checkMesto(String mesto, SpisakTermina spisak) {
        List<Termini> terminiPoMestu = spisak.getTermini();

        for (Termini termini : terminiPoMestu) {
            if (termini.getMesto().equals(mesto)) {
                termini.getDan().sort(Comparator.comparing(o -> o.getDatum().toGregorianCalendar()));
                return termini.getDan();
            }
        }

        return addMesto(mesto, spisak).getDan();
    }

    private Dan checkDan(LocalDate datum, List<Dan> dani, String tipVakcine, String ime) throws DatatypeConfigurationException, Exception {
        boolean found = false;

        String emailAddress = ime.toLowerCase(Locale.ROOT).trim().replace(" ", "")
                + "@gmail.com";

        for (Dan dan : dani) {
            LocalDate datumDana = LocalDate.of(dan.getDatum().getYear(), dan.getDatum().getMonth(), dan.getDatum().getDay());
            if (datumDana.equals(datum)) {
                found = true;
                if (checkSlobodniTerminiZaDan(dan)) {
                    if (!b2bService.ukloniDozuVakcine(tipVakcine)) {
                        emailService.sendNemaDostupnihDozaEmail(
                                emailAddress, tipVakcine);
                        throw new Exception("Neuspesno uzimanje vakcine");
                    }
                    dan.setBrojZakazanihTermina(dan.getBrojZakazanihTermina().add(BigInteger.ONE));
                    return dan;
                }
            }
        }
        if (!found) {
            if (!b2bService.ukloniDozuVakcine(tipVakcine)) {
                emailService.sendNemaDostupnihDozaEmail(
                        emailAddress, tipVakcine);
                throw new Exception("Neuspesno uzimanje vakcine");
            }

            Dan noviDan = new Dan();
            noviDan.setBrojZakazanihTermina(BigInteger.ONE); // jedan zakazan dan - ovaj sto sad dodajemo
            noviDan.setDatum(DatatypeFactory.newInstance().newXMLGregorianCalendar(datum.toString()));
            noviDan.setMaxBrojTermina(MAX_BROJ_TERMINA);
            dani.add(noviDan);
            return noviDan;
        }
        return null;
    }

    public Dan zakaziTermin(String mesto, LocalDate zeljeniDatum, String tipVakcine, int unapred, String ime) {
        if (zeljeniDatum.isBefore(LocalDate.now())) {
            throw new InvalidXmlException(ZakazivanjeTerminaDTO.class, "Odabran datum nije validan");
        }

        String emailAddress = ime.toLowerCase(Locale.ROOT).trim().replace(" ", "")
                + "@gmail.com";

        if (!b2bService.proveriDostupnostVakcine(tipVakcine)) {
            try {
                emailService.sendNemaDostupnihDozaEmail(
                        emailAddress, tipVakcine);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return null;
        }

        SpisakTermina spisakTermina = null;
        System.out.println("Trazim spisakkkk!!!");
        try {
            spisakTermina = findById(1L);
        } catch (EntityNotFoundException e) {
//            System.out.println("Nema spiska termina! Sad cu da kreiram jedan!!!");
//            create("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                    "<spisakTermina xmlns=\"www.rokzasok.rs/termini\"\n" +
//                    " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
//                    " xsi:schemaLocation=\"www.rokzasok.rs/termini ./schema/termini.xsd\">\n" +
//                    "</spisakTermina>");
//            spisakTermina = findById(1L);
        }
        List<Dan> dani = checkMesto(mesto, spisakTermina);
        for (int i = 0; i < unapred; i++) {
            Dan dan = null;
            try {
                dan = checkDan(zeljeniDatum.plusDays(i), dani, tipVakcine, ime);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (dan != null) {

                try {
                    update(spisakTerminaXmlConversionAgent.marshall(spisakTermina, jaxbContextPath));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }

                System.out.println("Nadjen termin! " + dan.getDatum() + " " + mesto);

                try {
                    emailService.sendSledeciTerminEmail(
                            emailAddress, dan.getDatum().toString(), mesto);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return dan;
            }
        }
        try {
            emailService.sendNemaSlobodnihTerminaEmail(
                    emailAddress, zeljeniDatum.toString(), mesto);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Termini addMesto(String mesto, SpisakTermina spisak) {
        Termini novoMesto = new Termini();
        novoMesto.setMesto(mesto);

        spisak.getTermini().add(novoMesto);
        return novoMesto;
    }

    public void initEmptySpisak() {
        this.create("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<spisakTermina xmlns=\"www.rokzasok.rs/termini\"\n" +
                " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                " xsi:schemaLocation=\"www.rokzasok.rs/termini ./schema/termini.xsd\">\n" +
                "</spisakTermina>");
    }

}
