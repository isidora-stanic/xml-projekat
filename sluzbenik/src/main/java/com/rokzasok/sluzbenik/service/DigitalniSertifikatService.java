package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat.DigitalniSertifikat;
import com.rokzasok.sluzbenik.exception.EntityNotFoundException;
import com.rokzasok.sluzbenik.exception.InvalidXmlDatabaseException;
import com.rokzasok.sluzbenik.exception.InvalidXmlException;
import com.rokzasok.sluzbenik.exception.XmlDatabaseException;
import com.rokzasok.sluzbenik.helper.UUIDHelper;
import com.rokzasok.sluzbenik.helper.XmlConversionAgent;
import com.rokzasok.sluzbenik.repository.AbstractXmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.util.List;

import static com.rokzasok.sluzbenik.helper.XQueryExpressions.X_QUERY_FIND_ALL_DIGITALNI_SERTIFIKAT_EXPRESSION;
import static com.rokzasok.sluzbenik.helper.XQueryExpressions.X_UPDATE_REMOVE_DIGITALNI_SERTIFIKAT_BY_ID_EXPRESSION;

@Service
public class DigitalniSertifikatService implements AbstractXmlService<DigitalniSertifikat> {

    private final String jaxbContextPath = "com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat";

    private static final String SPARQL_NAMED_GRAPH_URI = "/sparql/metadata";

    @Autowired
    private AbstractXmlRepository<DigitalniSertifikat> digitalniSertifikatAbstractXmlRepository;

    @Autowired
    private XmlConversionAgent<DigitalniSertifikat> digitalniSertifikatXmlConversionAgent;

    @Autowired
    private RDFService rdfService;

    @Autowired
    private UUIDHelper uuidHelper;

    public void injectRepositoryProperties() {
        this.digitalniSertifikatAbstractXmlRepository.injectRepositoryProperties(
                "/db/sample/digitalni_sertifikat",
                jaxbContextPath,
                X_QUERY_FIND_ALL_DIGITALNI_SERTIFIKAT_EXPRESSION,
                X_UPDATE_REMOVE_DIGITALNI_SERTIFIKAT_BY_ID_EXPRESSION
        );
    }

    @Override
    public List<DigitalniSertifikat> findAll() {
        injectRepositoryProperties();

        try {
            return this.digitalniSertifikatAbstractXmlRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(DigitalniSertifikat.class, e.getMessage());
        }
    }

    @Override
    public DigitalniSertifikat findById(Long entityId) {
        injectRepositoryProperties();

        try {
            DigitalniSertifikat izvestaj = this.digitalniSertifikatAbstractXmlRepository.getEntity(entityId);
            if (izvestaj == null)
                throw new EntityNotFoundException(entityId, DigitalniSertifikat.class);
            return izvestaj;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(DigitalniSertifikat.class, e.getMessage());
        }
    }

    @Override
    public DigitalniSertifikat create(String xmlEntity) {
        injectRepositoryProperties();

        DigitalniSertifikat izvestaj;
        try {
            izvestaj = this.digitalniSertifikatXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
            izvestaj.setDokumentId(this.uuidHelper.getUUID());
            this.handleMetadata(izvestaj);
        } catch (JAXBException e) {
            throw new InvalidXmlException(DigitalniSertifikat.class, e.getMessage());
        }

        try {
            izvestaj = digitalniSertifikatAbstractXmlRepository.createEntity(izvestaj);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(DigitalniSertifikat.class, e.getMessage());
        }

        /*
            Save to RDF DB
            We marshall because we need RDFa (which was set by handleMetadata)
         */
        try {
            xmlEntity = this.digitalniSertifikatXmlConversionAgent.marshall(izvestaj, this.jaxbContextPath);
            System.out.println(xmlEntity);
            if (!rdfService.save(xmlEntity, SPARQL_NAMED_GRAPH_URI)) {
                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //izvestajClient.sendIzvestaj(izvestaj);

        return izvestaj;
    }

    @Override
    public DigitalniSertifikat update(String xmlEntity) {
        injectRepositoryProperties();

        DigitalniSertifikat izvestaj;
        try {
            izvestaj = this.digitalniSertifikatXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(DigitalniSertifikat.class, e.getMessage());
        }

        try {
            if (!this.digitalniSertifikatAbstractXmlRepository.updateEntity(izvestaj)) {
                throw new EntityNotFoundException(izvestaj.getDokumentId(), DigitalniSertifikat.class);
            }
            return izvestaj;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(DigitalniSertifikat.class, e.getMessage());
        }

    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();

        try {
            return this.digitalniSertifikatAbstractXmlRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }

    private void handleMetadata(DigitalniSertifikat izvestaj) {
        izvestaj.setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        izvestaj.setAbout("http://www.rokzasok.rs/rdf/database/digitalni-sertifikat/" + izvestaj.getDokumentId().toString());
        izvestaj.setRel("pred:prethodniDokument");
        izvestaj.setHref("http://www.rokzasok.rs/rdf/database/zahtev-za-sertifikat/url_prethodnog_dokumenta"); // todo: NE IDE ZAKUCANA VREDNOST


        izvestaj.getGradjanin().getId().setProperty("pred:kreiranOdStrane");
        izvestaj.getGradjanin().getId().setDatatype("xs:#string");

        izvestaj.getInfoOSertifikatu().getDatum().setProperty("pred:datumIzdavanja");
        izvestaj.getInfoOSertifikatu().getDatum().setDatatype("xs:#string");
    }
}
