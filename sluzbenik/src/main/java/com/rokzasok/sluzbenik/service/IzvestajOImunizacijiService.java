package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.model.dokumenti.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
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

import static com.rokzasok.sluzbenik.helper.XQueryExpressions.X_QUERY_FIND_ALL_IZVESTAJI_EXPRESSION;
import static com.rokzasok.sluzbenik.helper.XQueryExpressions.X_UPDATE_REMOVE_IZVESTAJ_BY_ID_EXPRESSION;

@Service
public class IzvestajOImunizacijiService implements AbstractXmlService<IzvestajOImunizaciji> {

    private final String jaxbContextPath = "com.rokzasok.sluzbenik.model.dokumenti.izvestaj_o_imunizaciji";

    private static final String SPARQL_NAMED_GRAPH_URI = "/sparql/metadata";

    public static final String OUTPUT_FOLDER_XML = "output_xml";
    public static final String OUTPUT_FOLDER_PDF = "output_pdf";
    public static final String OUTPUT_FOLDER_HTML = "output_html";
    public static final String OUTPUT_FOLDER_METADATA = "output_metadata";

    @Autowired
    //@Qualifier("izvestajRepository")
    private AbstractXmlRepository<IzvestajOImunizaciji> izvestajAbstractXmlRepository;

    @Autowired
    private XmlConversionAgent<IzvestajOImunizaciji> izvestajXmlConversionAgent;

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
        this.izvestajAbstractXmlRepository.injectRepositoryProperties(
                "/db/sample/izvestaj-o-imunizaciji",
                jaxbContextPath,
                X_QUERY_FIND_ALL_IZVESTAJI_EXPRESSION,
                X_UPDATE_REMOVE_IZVESTAJ_BY_ID_EXPRESSION
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
    public List<IzvestajOImunizaciji> findAll() {
        injectRepositoryProperties();

        try {
            return this.izvestajAbstractXmlRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(IzvestajOImunizaciji.class, e.getMessage());
        }
    }

    @Override
    public IzvestajOImunizaciji findById(Long entityId) {
        injectRepositoryProperties();

        try {
            IzvestajOImunizaciji izvestaj = this.izvestajAbstractXmlRepository.getEntity(entityId);
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
    public IzvestajOImunizaciji create(String xmlEntity) {
        injectRepositoryProperties();

        IzvestajOImunizaciji izvestaj;
        try {
            izvestaj = this.izvestajXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
            izvestaj.setDokumentId(this.uuidHelper.getUUID());
            //this.handleMetadata(izvestaj);
        } catch (JAXBException e) {
            throw new InvalidXmlException(IzvestajOImunizaciji.class, e.getMessage());
        }

        try {
            izvestaj = izvestajAbstractXmlRepository.createEntity(izvestaj);
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
            xmlEntity = this.izvestajXmlConversionAgent.marshall(izvestaj, this.jaxbContextPath);
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
    public IzvestajOImunizaciji update(String xmlEntity) {
        injectRepositoryProperties();

        IzvestajOImunizaciji izvestaj;
        try {
            izvestaj = this.izvestajXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(IzvestajOImunizaciji.class, e.getMessage());
        }

        try {
            if (!this.izvestajAbstractXmlRepository.updateEntity(izvestaj)) {
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
        injectRepositoryProperties();

        try {
            return this.izvestajAbstractXmlRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }
}
