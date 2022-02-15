package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.exception.EntityNotFoundException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlException;
import com.rokzasok.portal.za.imunizaciju.exception.XmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.helper.UUIDHelper;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.Dan;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.SpisakTermina;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.Termini;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

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
    private UUIDHelper uuidHelper;


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
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();

        try {
            return this.spisakTerminaAbstractXmlRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }
/*
    public Dan zakaziTermin(String mesto, LocalDate zeljeniDatum) {
        SpisakTermina spisakTermina = findById(1L);
        List<Termini> terminiPoMestu = spisakTermina.getTermini();

        for (Termini termini : terminiPoMestu) {
            if (termini.getMesto().equals(mesto)) {
                List<Dan> dani = termini.getDan();

                dani.sort(Comparator.comparing(o -> o.getDatum().toGregorianCalendar()));


                for (int i = 0; i < dani.size(); i++) {
                    Dan dan = dani.get(i);
                    LocalDate datumDana = LocalDate.of(dan.getDatum().getYear(), dan.getDatum().getMonth(), dan.getDatum().getDay());

                    if (datumDana == zeljeniDatum) {
                        boolean canAddTermin = checkSlobodniTerminiZaDan(dan);

                        if (canAddTermin) {
                            dan.setBrojZakazanihTermina(dan.getBrojZakazanihTermina().add(BigInteger.ONE));
                            return dan;
                        }
                        if (i + 1 < dani.size()) {
                            Dan mozdaSutraDan = dani.get(i + 1);
                            LocalDate mozdaSutraDatum = LocalDate.of(mozdaSutraDan.getDatum().getYear(), mozdaSutraDan.getDatum().getMonth(), mozdaSutraDan.getDatum().getDay());

                            LocalDate sutra = zeljeniDatum.plusDays(1);

                            if (mozdaSutraDatum == sutra) {
                                boolean canAddTermin2 = checkSlobodniTerminiZaDan(mozdaSutraDan);
                                if (canAddTermin2) {
                                    mozdaSutraDan.setBrojZakazanihTermina(mozdaSutraDan.getBrojZakazanihTermina().add(BigInteger.ONE));
                                    return mozdaSutraDan;
                                }
                            }
                        }

                    }
                    BigInteger maxBrojTermina = dan.getMaxBrojTermina();

                }

            }
        }

    }*/

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

    private Dan checkDan(LocalDate datum, List<Dan> dani) throws DatatypeConfigurationException {
        boolean found = false;

        for (Dan dan : dani) {
            LocalDate datumDana = LocalDate.of(dan.getDatum().getYear(), dan.getDatum().getMonth(), dan.getDatum().getDay());
            if (datumDana.equals(datum)) {
                found = true;
                if (checkSlobodniTerminiZaDan(dan)) {
                    // todo: smanji br vakcine za 1 (remove) - sa bekendom, ide Event!
                    dan.setBrojZakazanihTermina(dan.getBrojZakazanihTermina().add(BigInteger.ONE));
                    return dan;
                }
            }
        }
        if (!found) {
            Dan noviDan = new Dan();
            noviDan.setBrojZakazanihTermina(BigInteger.ONE); // jedan zakazan dan - ovaj sto sad dodajemo
            noviDan.setDatum(DatatypeFactory.newInstance().newXMLGregorianCalendar(datum.toString()));
            noviDan.setMaxBrojTermina(MAX_BROJ_TERMINA);
            dani.add(noviDan);
            return noviDan;
        }
        return null;
    }

    public Dan zakaziTermin(String mesto, LocalDate zeljeniDatum, String tipVakcine, int unapred) {
        // if (!servis.checkImaVakcine(tipVakcine)) return null // throw... todo: Komunikacija sa bekendom!!!
        SpisakTermina spisakTermina = findById(1L);
        List<Dan> dani = checkMesto(mesto, spisakTermina);
        for (int i = 0; i < unapred; i++) {
            Dan dan = null;
            try {
                dan = checkDan(zeljeniDatum.plusDays(i), dani);
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace(); // todo exception
            }
            if (dan != null) {

                try {
                    update(spisakTerminaXmlConversionAgent.marshall(spisakTermina, jaxbContextPath));
                } catch (JAXBException e) {
                    e.printStackTrace(); // todo exception
                }

                return dan;
            }
        }
        return null; // ili throw kao "Ne moze se zakazati toliko unapred, nema termina..."
    }

    private Termini addMesto(String mesto, SpisakTermina spisak) {
        Termini novoMesto = new Termini();
        novoMesto.setMesto(mesto);

        spisak.getTermini().add(novoMesto);
        return novoMesto;
    }

}
