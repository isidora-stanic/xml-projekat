package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.dokumenti.digitalni_sertifikat.DigitalniSertifikat;
import com.rokzasok.sluzbenik.dokumenti.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
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

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import java.util.List;

import static com.rokzasok.sluzbenik.helper.XQueryExpressions.X_QUERY_FIND_ALL_DIGITALNI_SERTIFIKAT_EXPRESSION;
import static com.rokzasok.sluzbenik.helper.XQueryExpressions.X_UPDATE_REMOVE_DIGITALNI_SERTIFIKAT_BY_ID_EXPRESSION;

@Service
public class DigitalniSertifikatService implements AbstractXmlService<DigitalniSertifikat> {

    private final String jaxbContextPath = "com.rokzasok.sluzbenik.dokumenti.digitalni_sertifikat";

    private static final String SPARQL_NAMED_GRAPH_URI = "/digitalni_sertifikat/sparql/metadata";

    public static final String OUTPUT_FOLDER_XML = "output_xml";
    public static final String OUTPUT_FOLDER_PDF = "output_pdf";
    public static final String OUTPUT_FOLDER_HTML = "output_html";
    public static final String OUTPUT_FOLDER_METADATA = "output_metadata";

    @Autowired
    //@Qualifier("izvestajRepository")
    private AbstractXmlRepository<DigitalniSertifikat> digitalniSertifikatAbstractXmlRepository;

    @Autowired
    private XmlConversionAgent<DigitalniSertifikat> digitalniSertifikatXmlConversionAgent;

//    @Autowired
//    private RDFService rdfService;
//
//    @Autowired
//    private PretrageHelper pretrageHelper;

//    private rs.ac.uns.ftn.tim5.transofrmation.XSLFOTransformer XSLFOTransformer;

    //    @Autowired
//    private DateHelper dateHelper;
//
    @Autowired
    private UUIDHelper uuidHelper;
//
//    @Autowired
//    private SparqlUtil sparqlUtil;

//    @Autowired
//    private IzvestajClient izvestajClient;

    //@PostConstruct
    public void injectRepositoryProperties() {
        this.digitalniSertifikatAbstractXmlRepository.injectRepositoryProperties(
                "/db/sample/digitalni_sertifikat",
                "com.rokzasok.sluzbenik.dokumenti.digitalni_sertifikat",
                X_QUERY_FIND_ALL_DIGITALNI_SERTIFIKAT_EXPRESSION,
                X_UPDATE_REMOVE_DIGITALNI_SERTIFIKAT_BY_ID_EXPRESSION
        );

//        this.XSLFOTransformer = new XSLFOTransformer();
//        try {
//            this.XSLFOTransformer.injectTransformerProperties(
//                    "classpath:transformations/xsl/izvestaj.xsl",
//                    "classpath:transformations/xsl_fo/izvestaj_fo.xsl",
//                    "output_pdf/izvestaj.pdf",
//                    "output_html/izvestaj.html"
//            );
//        } catch (SAXException | IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public List<DigitalniSertifikat> findAll() {
        try {
            return this.digitalniSertifikatAbstractXmlRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(IzvestajOImunizaciji.class, e.getMessage());
        }
    }

    @Override
    public DigitalniSertifikat findById(Long entityId) {
        try {
            DigitalniSertifikat izvestaj = this.digitalniSertifikatAbstractXmlRepository.getEntity(entityId);
            if (izvestaj == null)
                throw new EntityNotFoundException(entityId, IzvestajOImunizaciji.class);
            return izvestaj;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(IzvestajOImunizaciji.class, e.getMessage());
        }
    }

    @Override
    public DigitalniSertifikat create(String xmlEntity) {
        injectRepositoryProperties();

        DigitalniSertifikat izvestaj;
        try {
            izvestaj = this.digitalniSertifikatXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
            izvestaj.setDokumentId(this.uuidHelper.getUUID());
            //this.handleMetadata(izvestaj);
        } catch (JAXBException e) {
            throw new InvalidXmlException(IzvestajOImunizaciji.class, e.getMessage());
        }

        try {
            izvestaj = digitalniSertifikatAbstractXmlRepository.createEntity(izvestaj);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(IzvestajOImunizaciji.class, e.getMessage());
        }

        /*
            Save to RDF DB
            We marshall because we need RDFa (which was set by handleMetadata)
         */
        try {
            xmlEntity = this.digitalniSertifikatXmlConversionAgent.marshall(izvestaj, this.jaxbContextPath);
            System.out.println(xmlEntity);
//            if (!rdfService.save(xmlEntity, SPARQL_NAMED_GRAPH_URI)) {
//                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
//            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //izvestajClient.sendIzvestaj(izvestaj);

        return izvestaj;
    }

    @Override
    public DigitalniSertifikat update(String xmlEntity) {
        DigitalniSertifikat izvestaj;
        try {
            izvestaj = this.digitalniSertifikatXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(DigitalniSertifikat.class, e.getMessage());
        }

        try {
            if (!this.digitalniSertifikatAbstractXmlRepository.updateEntity(izvestaj)) {
                throw new EntityNotFoundException(izvestaj.getDokumentId(), IzvestajOImunizaciji.class);
            }
            return izvestaj;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(IzvestajOImunizaciji.class, e.getMessage());
        }

    }

    @Override
    public boolean deleteById(Long entityId) {
        try {
            return this.digitalniSertifikatAbstractXmlRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }
}
