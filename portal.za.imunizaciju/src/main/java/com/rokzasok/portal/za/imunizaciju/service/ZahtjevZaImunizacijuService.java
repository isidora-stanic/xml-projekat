package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.exception.XmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.helper.UUIDHelper;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_QUERY_FIND_ALL_IZVESTAJI_EXPRESSION;
import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_UPDATE_REMOVE_IZVESTAJ_BY_ID_EXPRESSION;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class ZahtjevZaImunizacijuService implements AbstractXmlService<ObrazacInteresovanja> {

    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja";

    private static final String SPARQL_NAMED_GRAPH_URI = "/sparql/metadata";

    public static final String OUTPUT_FOLDER_XML = "output_xml";
    public static final String OUTPUT_FOLDER_PDF = "output_pdf";
    public static final String OUTPUT_FOLDER_HTML = "output_html";
    public static final String OUTPUT_FOLDER_METADATA = "output_metadata";

    @Autowired
    //@Qualifier("izvestajRepository")
    private AbstractXmlRepository<ObrazacInteresovanja> izvestajAbstractXmlRepository;

    @Autowired
    private XmlConversionAgent<ObrazacInteresovanja> izvestajXmlConversionAgent;

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
                "/db/sample/iskazivanje-interesovanja",
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
    public List<ObrazacInteresovanja> findAll() {
        injectRepositoryProperties();

        return null;
    }

    @Override
    public ObrazacInteresovanja findById(Long entityId) {
        injectRepositoryProperties();

        return null;
    }

    @Override
    public ObrazacInteresovanja create(String xmlEntity) {
        injectRepositoryProperties();

        ObrazacInteresovanja obrazacInteresovanja = null;
        try {
            obrazacInteresovanja = this.izvestajXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
            obrazacInteresovanja.setDokumentId(this.uuidHelper.getUUID());
            //this.handleMetadata(izvestaj);
        } catch (JAXBException e) {
            e.printStackTrace();
            //throw new InvalidXmlException(ObrazacInteresovanja.class, e.getMessage());
        }

        try {
            obrazacInteresovanja = izvestajAbstractXmlRepository.createEntity(obrazacInteresovanja);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacInteresovanja.class, e.getMessage());
        }

        /*
            Save to RDF DB
            We marshall because we need RDFa (which was set by handleMetadata)
         */
        try {
            xmlEntity = this.izvestajXmlConversionAgent.marshall(obrazacInteresovanja, this.jaxbContextPath);
            System.out.println(xmlEntity);
//            if (!rdfService.save(xmlEntity, SPARQL_NAMED_GRAPH_URI)) {
//                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
//            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //izvestajClient.sendIzvestaj(izvestaj);

        return obrazacInteresovanja;
    }

    @Override
    public ObrazacInteresovanja update(String entityXml) {
        injectRepositoryProperties();

        return null;
    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();

        return false;
    }
}