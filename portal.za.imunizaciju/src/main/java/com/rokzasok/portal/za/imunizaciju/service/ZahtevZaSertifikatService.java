package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.portal.za.imunizaciju.exception.EntityNotFoundException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlException;
import com.rokzasok.portal.za.imunizaciju.exception.XmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.helper.UUIDHelper;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.util.List;

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_QUERY_FIND_ALL_ZAHTEV_ZA_SERTIFIKAT_EXPRESSION;
import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_UPDATE_REMOVE_ZAHTEV_ZA_SERTIFIKAT_BY_ID_EXPRESSION;

@Service
public class ZahtevZaSertifikatService implements AbstractXmlService<Zahtev> {
    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.zahtev_za_sertifikat";

    private static final String SPARQL_NAMED_GRAPH_URI = "/sparql/metadata";

    public static final String OUTPUT_FOLDER_XML = "output_xml";
    public static final String OUTPUT_FOLDER_PDF = "output_pdf";
    public static final String OUTPUT_FOLDER_HTML = "output_html";
    public static final String OUTPUT_FOLDER_METADATA = "output_metadata";

    @Autowired
    private AbstractXmlRepository<Zahtev> zahtevZaSertifikatRepository;

    @Autowired
    private XmlConversionAgent<Zahtev> zahtevZaSertifikatConverionAgent;

    @Autowired
    private UUIDHelper uuidHelper;

    @Autowired
    private RDFService rdfService;

    public void injectRepositoryProperties() {
        this.zahtevZaSertifikatRepository.injectRepositoryProperties(
                "/db/sample/zahtev_za_sertifikat",
                jaxbContextPath,
                X_QUERY_FIND_ALL_ZAHTEV_ZA_SERTIFIKAT_EXPRESSION,
                X_UPDATE_REMOVE_ZAHTEV_ZA_SERTIFIKAT_BY_ID_EXPRESSION);
    }

    @Override
    public List<Zahtev> findAll() {
        injectRepositoryProperties();

        try {
            return this.zahtevZaSertifikatRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(Zahtev.class, e.getMessage());
        }
    }

    @Override
    public Zahtev findById(Long entityId) {
        injectRepositoryProperties();

        try {
            Zahtev zahtev = this.zahtevZaSertifikatRepository.getEntity(entityId);
            if (zahtev == null) {
                throw new EntityNotFoundException(entityId, Zahtev.class);
            }
            return zahtev;
        } catch (JAXBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (XMLDBException e) {
            throw new InvalidXmlDatabaseException(Zahtev.class, e.getMessage());
        }
    }

    @Override
    public Zahtev create(String entityXml) {
        injectRepositoryProperties();
        Zahtev zahtev;

        try {
            zahtev = this.zahtevZaSertifikatConverionAgent.unmarshall(entityXml, this.jaxbContextPath);
            zahtev.setDokumentId(this.uuidHelper.getUUID());
            this.handleMetadata(zahtev);
        } catch (JAXBException e) {
            throw new InvalidXmlException(Zahtev.class, e.getMessage());
        }

        try {
            zahtev = zahtevZaSertifikatRepository.createEntity(zahtev);
        } catch (JAXBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (XMLDBException e) {
            throw new InvalidXmlDatabaseException(Zahtev.class, e.getMessage());
        }

        try {
            entityXml = this.zahtevZaSertifikatConverionAgent.marshall(zahtev, this.jaxbContextPath);
            System.out.println(entityXml);
            if (!rdfService.save(entityXml, SPARQL_NAMED_GRAPH_URI)) {
                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
            }
        } catch (JAXBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
        return zahtev;
    }

    @Override
    public Zahtev update(String entityXml) {
        injectRepositoryProperties();

        Zahtev zahtev;
        try {
            zahtev = this.zahtevZaSertifikatConverionAgent.unmarshall(entityXml, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(Zahtev.class, e.getMessage());
        }
        try {
            if (!this.zahtevZaSertifikatRepository.updateEntity(zahtev)) {
                throw new EntityNotFoundException(zahtev.getDokumentId(), Zahtev.class);
            }
            return zahtev;

        } catch (JAXBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (XMLDBException e) {
            throw new InvalidXmlException(Zahtev.class, e.getMessage());
        }
    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();
        try {
            return this.zahtevZaSertifikatRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }


    private void handleMetadata(Zahtev zahtev) {
        zahtev.setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        zahtev.setAbout("http://www.rokzasok.rs/rdf/database/zahtev-za-sertifikat/" + zahtev.getDokumentId());
        zahtev.setRel("pred:kreiranOdStrane");
        zahtev.setHref("http://www.rokzasok.rs/rdf/database/osoba/" + zahtev.getPacijent().getJmbg()); // todo: id umesto JMBG

        zahtev.getRazlogPodnosenja().setDatatype("xs:string");
        zahtev.getRazlogPodnosenja().setProperty("pred:razlogPodnosenja");

        zahtev.getMesto().setDatatype("xs:string");
        zahtev.getMesto().setProperty("pred:mestoPodnosenja");

        zahtev.getDatum().setDatatype("xs:date");
        zahtev.getDatum().setProperty("pred:datumPodnosenja");

        zahtev.getPacijent().setAbout("http://www.rokzasok.rs/rdf/database/osoba/" + zahtev.getPacijent().getJmbg()); // todo: id umesto JMBG
        zahtev.getPacijent().setVocab("http://www.rokzasok.rs/rdf/database/predicate");

    }

}