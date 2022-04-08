package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.exception.EntityNotFoundException;
import com.rokzasok.sluzbenik.exception.InvalidXmlDatabaseException;
import com.rokzasok.sluzbenik.exception.InvalidXmlException;
import com.rokzasok.sluzbenik.exception.XmlDatabaseException;
import com.rokzasok.sluzbenik.helper.XmlConversionAgent;
import com.rokzasok.sluzbenik.model.ostalo.dostupne_doze.DostupneDoze;
import com.rokzasok.sluzbenik.model.ostalo.dostupne_doze.TTipVakcine;
import com.rokzasok.sluzbenik.repository.AbstractXmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.math.BigInteger;
import java.util.List;

import static com.rokzasok.sluzbenik.helper.XQueryExpressions.X_QUERY_FIND_ALL_DOSTUPNE_DOZE_EXPRESSION;
import static com.rokzasok.sluzbenik.helper.XQueryExpressions.X_UPDATE_REMOVE_DOSTUPNE_DOZE_BY_ID_EXPRESSION;

@Service
public class DostupneDozeService implements AbstractXmlService<DostupneDoze> {
    private final String jaxbContextPath = "com.rokzasok.sluzbenik.model.ostalo.dostupne_doze";

    @Autowired
    private AbstractXmlRepository<DostupneDoze> dostupneDozeAbstractXmlRepository;

    @Autowired
    private XmlConversionAgent<DostupneDoze> dostupneDozeXmlConversionAgent;

    public void injectRepositoryProperties() {
        this.dostupneDozeAbstractXmlRepository.injectRepositoryProperties("/db/sample/dostupne-doze", jaxbContextPath, X_QUERY_FIND_ALL_DOSTUPNE_DOZE_EXPRESSION, X_UPDATE_REMOVE_DOSTUPNE_DOZE_BY_ID_EXPRESSION);
    }

    @Override
    public List<DostupneDoze> findAll() {
        injectRepositoryProperties();

        try {
            return this.dostupneDozeAbstractXmlRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(DostupneDoze.class, e.getMessage());
        }
    }

    @Override
    public DostupneDoze findById(Long entityId) {
        injectRepositoryProperties();

        try {
            DostupneDoze dostupneDoze = this.dostupneDozeAbstractXmlRepository.getEntity(entityId);
            if (dostupneDoze == null) throw new EntityNotFoundException(entityId, DostupneDoze.class);
            return dostupneDoze;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(DostupneDoze.class, e.getMessage());
        }
    }

    @Override
    public DostupneDoze create(String entityXml) {
        injectRepositoryProperties();

        DostupneDoze dostupneDoze;
        try {
            dostupneDoze = this.dostupneDozeXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
            dostupneDoze.setDokumentId(1L);
        } catch (JAXBException e) {
            throw new InvalidXmlException(DostupneDoze.class, e.getMessage());
        }

        try {
            dostupneDoze = dostupneDozeAbstractXmlRepository.createEntity(dostupneDoze);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(DostupneDoze.class, e.getMessage());
        }

        return dostupneDoze;

    }

    @Override
    public DostupneDoze update(String entityXml) {
        injectRepositoryProperties();

        DostupneDoze dostupneDoze;
        try {
            dostupneDoze = this.dostupneDozeXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(DostupneDoze.class, e.getMessage());
        }

        try {
            if (!this.dostupneDozeAbstractXmlRepository.updateEntity(dostupneDoze)) {
                throw new EntityNotFoundException(dostupneDoze.getDokumentId(), DostupneDoze.class);
            }
            return dostupneDoze;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(DostupneDoze.class, e.getMessage());
        }
    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();

        try {
            return this.dostupneDozeAbstractXmlRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }

    public DostupneDoze addDoze(String tipVakcine, BigInteger noveDoze) {
        DostupneDoze dostupneDoze;
        System.out.println("Trazim dozeeeeeee!!!");
        try {
            dostupneDoze = findById(1L);
        } catch (EntityNotFoundException e) {
            System.out.println("Nema spiska korisnika! Sad cu da kreiram jedan!!!");
            create("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<dostupneDoze xmlns=\"www.rokzasok.rs/dostupne-doze-vakcina\"\n" +
                    " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                    " xsi:schemaLocation=\"www.rokzasok.rs/dostupne-doze-vakcina ./schema/dostupne_doze.xsd\">\n" +
                    "    <brojDoza tipVakcine=\"Pfizer-BioNtech\">10</brojDoza>\n" +
                    "    <brojDoza tipVakcine=\"Sputnik V (Gamaleya istraživački centar)\">10</brojDoza>\n" +
                    "    <brojDoza tipVakcine=\"AstraZeneca\">10</brojDoza>\n" +
                    "    <brojDoza tipVakcine=\"Moderna\">10</brojDoza>\n" +
                    "    <brojDoza tipVakcine=\"Sinopharm\">10</brojDoza>\n" +
                    "</dostupneDoze>");
            dostupneDoze = findById(1L);
        }
        List<DostupneDoze.BrojDoza> dozePoTipu = dostupneDoze.getBrojDoza();

        for (DostupneDoze.BrojDoza brojDoza : dozePoTipu) {
            if (brojDoza.getTipVakcine().value().equals(tipVakcine)) {
                brojDoza.setValue(brojDoza.getValue().add(noveDoze));
                try {
                    update(dostupneDozeXmlConversionAgent.marshall(dostupneDoze, jaxbContextPath));
                } catch (JAXBException e) {
                    throw new InvalidXmlException(DostupneDoze.class, "Greška pri konvertovanju u XML");
                }
                return dostupneDoze;
            }
        }

        throw new EntityNotFoundException(1L, DostupneDoze.BrojDoza.class);
    }

    public DostupneDoze removeDoze(String tipVakcine, BigInteger obrisaneDoze) throws InvalidXmlException, EntityNotFoundException {
        DostupneDoze dostupneDoze = findById(1L);
        List<DostupneDoze.BrojDoza> dozePoTipu = dostupneDoze.getBrojDoza();

        for (DostupneDoze.BrojDoza brojDoza : dozePoTipu) {
            if (brojDoza.getTipVakcine().value().equals(tipVakcine)) {
                brojDoza.setValue(brojDoza.getValue().subtract(obrisaneDoze));
                try {
                    update(dostupneDozeXmlConversionAgent.marshall(dostupneDoze, jaxbContextPath));
                } catch (JAXBException e) {
                    throw new InvalidXmlException(DostupneDoze.class, "Greška pri konvertovanju u XML");
                }
                return dostupneDoze;
            }
        }

        throw new EntityNotFoundException(1L, DostupneDoze.BrojDoza.class);
    }

    public DostupneDoze addTipVakcine(String tipVakcine, BigInteger brojDostupnihDoza) {
        DostupneDoze dostupneDoze = findById(1L);
        List<DostupneDoze.BrojDoza> dozePoTipu = dostupneDoze.getBrojDoza();

        for (DostupneDoze.BrojDoza brojDoza : dozePoTipu) {
            if (brojDoza.getTipVakcine().value().equals(tipVakcine)) {
                throw new InvalidXmlException(DostupneDoze.class, "Već postoji tip vakcine");
            }
        }

        DostupneDoze.BrojDoza noviTipVakcine = new DostupneDoze.BrojDoza();
        try {
            noviTipVakcine.setTipVakcine(TTipVakcine.fromValue(tipVakcine));
        } catch (IllegalArgumentException ex) {
            throw new InvalidXmlException(TTipVakcine.class, "Nedozvoljen tip vakcina");
        }
        noviTipVakcine.setValue(brojDostupnihDoza);

        dozePoTipu.add(noviTipVakcine);

        return dostupneDoze;
    }

    public DostupneDoze.BrojDoza findByTipVakcine(String tipVakcine) {
        DostupneDoze dostupneDoze = findById(1L);
        List<DostupneDoze.BrojDoza> dozePoTipu = dostupneDoze.getBrojDoza();

        for (DostupneDoze.BrojDoza brojDoza : dozePoTipu) {
            if (brojDoza.getTipVakcine().value().equals(tipVakcine)) {
                return brojDoza;
            }
        }
        return null;
    }

    public boolean proveriDostupnostVakcine(String tipVakcine){
        DostupneDoze.BrojDoza dostupnostDoza = findByTipVakcine(tipVakcine);
        return dostupnostDoza != null && (dostupnostDoza.getValue().compareTo(BigInteger.ZERO) != 0);
    }
}
