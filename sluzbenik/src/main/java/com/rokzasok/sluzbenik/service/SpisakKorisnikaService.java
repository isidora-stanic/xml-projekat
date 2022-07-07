package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.exception.EntityNotFoundException;
import com.rokzasok.sluzbenik.exception.InvalidXmlDatabaseException;
import com.rokzasok.sluzbenik.exception.InvalidXmlException;
import com.rokzasok.sluzbenik.exception.XmlDatabaseException;
import com.rokzasok.sluzbenik.helper.UUIDHelper;
import com.rokzasok.sluzbenik.helper.XmlConversionAgent;
import com.rokzasok.sluzbenik.model.dto.CreateKorisnikDTO;
import com.rokzasok.sluzbenik.model.ostalo.spisak_korisnika.Korisnik;
import com.rokzasok.sluzbenik.model.ostalo.spisak_korisnika.SpisakKorisnika;
import com.rokzasok.sluzbenik.repository.AbstractXmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.stream.Collectors;

import static com.rokzasok.sluzbenik.helper.XQueryExpressions.*;

@Service
public class SpisakKorisnikaService implements AbstractXmlService<SpisakKorisnika> {

    private final String jaxbContextPath = "com.rokzasok.sluzbenik.model.ostalo.spisak_korisnika";

    @Autowired
    private AbstractXmlRepository<SpisakKorisnika> spisakKorisnikaAbstractXmlRepository;

    @Autowired
    private XmlConversionAgent<SpisakKorisnika> spisakKorisnikaXmlConversionAgent;

    @Autowired
    private UUIDHelper uuidHelper;


    public void injectRepositoryProperties() {
        this.spisakKorisnikaAbstractXmlRepository.injectRepositoryProperties(
                "/db/sample/korisnici",
                jaxbContextPath,
                X_QUERY_FIND_ALL_SPISAK_KORISNIKA,
                X_UPDATE_REMOVE_SPISAK_KORISNIKA_BY_ID_EXPRESSION);
    }


    @Override
    public List<SpisakKorisnika> findAll() {
        injectRepositoryProperties();

        try {
            return this.spisakKorisnikaAbstractXmlRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(SpisakKorisnika.class, e.getMessage());
        }
    }

    @Override
    public SpisakKorisnika findById(Long entityId) {
        injectRepositoryProperties();

        try {
            SpisakKorisnika spisakKorisnika = this.spisakKorisnikaAbstractXmlRepository.getEntity(entityId);
            if (spisakKorisnika == null) throw new EntityNotFoundException(entityId, SpisakKorisnika.class);
            return spisakKorisnika;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(SpisakKorisnika.class, e.getMessage());
        }
    }

    @Override
    public SpisakKorisnika create(String entityXml) {
        injectRepositoryProperties();

        SpisakKorisnika spisakKorisnika;
        try {
            spisakKorisnika = this.spisakKorisnikaXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
            spisakKorisnika.setDokumentId(1L);
        } catch (JAXBException e) {
            throw new InvalidXmlException(SpisakKorisnika.class, e.getMessage());
        }

        try {
            spisakKorisnika = spisakKorisnikaAbstractXmlRepository.createEntity(spisakKorisnika);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(SpisakKorisnika.class, e.getMessage());
        }

        return spisakKorisnika;

    }

    @Override
    public SpisakKorisnika update(String entityXml) {
        injectRepositoryProperties();

        SpisakKorisnika spisakKorisnika;
        try {
            spisakKorisnika = this.spisakKorisnikaXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(SpisakKorisnika.class, e.getMessage());
        }

        try {
            if (!this.spisakKorisnikaAbstractXmlRepository.updateEntity(spisakKorisnika)) {
                throw new EntityNotFoundException(spisakKorisnika.getDokumentId(), SpisakKorisnika.class);
            }
            return spisakKorisnika;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(SpisakKorisnika.class, e.getMessage());
        }
    }

    @Override
    public String getRdfaString(Long dokumentId) throws JAXBException {
        injectRepositoryProperties();

        SpisakKorisnika dokument;
        dokument = this.findById(dokumentId);
        String entityXml = this.spisakKorisnikaXmlConversionAgent.marshall(dokument, this.jaxbContextPath);
        System.out.println(entityXml);
        return entityXml;

    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();

        try {
            return this.spisakKorisnikaAbstractXmlRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }

    public Korisnik addKorisnik(CreateKorisnikDTO noviKorisnikDTO) {
        SpisakKorisnika spisakKorisnika;
        System.out.println("Trazim spisakkkk!!!");
        try {
            spisakKorisnika = findById(1L);
        } catch (EntityNotFoundException e) {
            System.out.println("Nema spiska korisnika! Sad cu da kreiram jedan!!!");
            create("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<spisakKorisnika xmlns=\"www.rokzasok.rs/korisnici\"\n" +
                    "                 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                    "                 xsi:schemaLocation=\"www.rokzasok.rs/korisnici ./schema/korisnici.xsd\">\n" +
                    "</spisakKorisnika>");
            spisakKorisnika = findById(1L);
        }
        List<Korisnik> korisnici = spisakKorisnika.getKorisnik();

        Korisnik noviKorisnik = new Korisnik();

        noviKorisnik.setKorisnickoIme(noviKorisnikDTO.getKorisnickoIme());
        noviKorisnik.setLozinka(noviKorisnikDTO.getLozinka());
        Korisnik.Uloge uloge = new Korisnik.Uloge();
        uloge.getUloga().add("sluzbenik");
        noviKorisnik.setUloge(uloge);

        noviKorisnik.setId(uuidHelper.getUUID());

        korisnici.add(noviKorisnik);
        try {
            update(spisakKorisnikaXmlConversionAgent.marshall(spisakKorisnika, jaxbContextPath));
        } catch (JAXBException e) {
            throw new InvalidXmlException(SpisakKorisnika.class, "Greška pri konvertovanju u XML");
        }

        return noviKorisnik;
    }

    public void removeKorisnik(Long idKorisnika) {
        SpisakKorisnika spisakKorisnika = findById(1L);
        List<Korisnik> korisnici = spisakKorisnika.getKorisnik();

        for (int i = 0; i < korisnici.size(); i++) {
            if (korisnici.get(i).getId() == idKorisnika) {
                korisnici.remove(i);
                break;
            }
        }

        try {
            String xmlEntity = spisakKorisnikaXmlConversionAgent.marshall(spisakKorisnika, jaxbContextPath);
            update(xmlEntity);
        } catch (JAXBException e) {
            throw new InvalidXmlException(SpisakKorisnika.class, "Greška pri konvertovanju u XML");
        } catch (XmlDatabaseException | InvalidXmlDatabaseException e) {
            e.printStackTrace();
        }
    }

    public Korisnik getKorisnik(Long idKorisnika) {
        SpisakKorisnika spisakKorisnika = findById(1L);
        List<Korisnik> korisnici = spisakKorisnika.getKorisnik();

        for (Korisnik korisnik : korisnici) {
            if (korisnik.getId() == idKorisnika) {
                return korisnik;
            }
        }

        throw new EntityNotFoundException(idKorisnika, Korisnik.class);
    }

    public Korisnik login(CreateKorisnikDTO korisnikDTO) {
        SpisakKorisnika korisnici = findById(1L);
        List<Korisnik> odgovarajuci = korisnici.getKorisnik().stream()
                .filter(k -> k.getKorisnickoIme().equals(korisnikDTO.getKorisnickoIme()) &&
                        k.getLozinka().equals(korisnikDTO.getLozinka())).collect(Collectors.toList());
        if (odgovarajuci.isEmpty()) {
            throw new EntityNotFoundException(0L, Korisnik.class);
        }
        return odgovarajuci.get(0);
    }
}