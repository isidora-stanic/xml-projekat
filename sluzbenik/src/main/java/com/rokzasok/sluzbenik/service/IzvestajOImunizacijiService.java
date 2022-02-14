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

    private final String jaxbContextPath = "com.rokzasok.sluzbenik.dokumenti.izvestaj_o_imunizaciji";

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

    // TODO
//    private void handleMetadata(IzvestajOImunizaciji izvestaj) {
//        izvestaj.setAbout(
//                String.format(
//                        "%s%s%s",
//                        System.getenv("FRONTEND_URL"),
//                        "/izvestaj/",
//                        izvestaj.getId()
//                )
//        );
//        izvestaj.getDatumPodnosenja().setContent(this.dateHelper.toDate(izvestaj.getDatumPodnosenja()));
//        izvestaj.setId(izvestaj.getId());
//
//        izvestaj.setVocab("http://ftn.uns.ac.rs.tim5/model/predicate");
//        izvestaj.getDatumPodnosenja().setProperty("pred:datum");
//    }
//
//    public ByteArrayInputStream generatePdf(Long id) {
//        Izvestaj izvestaj = this.findById(id);
//        try {
//            this.izvestajXmlConversionAgent.marshallToFile(izvestaj, this.jaxbContextPath,this.getXmlFilePath());
//            this.XSLFOTransformer.generatePDF(this.getXmlFilePath());
//
//        } catch (JAXBException | SAXException | FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.out.println("Error converting document to pdf.");
//        }
//
//        try {
//            return new ByteArrayInputStream(FileUtils.readFileToByteArray(new File(this.getPdfFilePath())));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
////
////    public ByteArrayInputStream generateHtml(Long id) {
////        IzvestajOImunizaciji izvestaj = this.findById(id);
////        try {
////            this.izvestajXmlConversionAgent.marshallToFile(izvestaj, this.jaxbContextPath,this.getXmlFilePath());
////            this.XSLFOTransformer.generateHTML(this.getXmlFilePath());
////
////        } catch (JAXBException | SAXException | FileNotFoundException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            System.out.println("Error converting document to pdf.");
////        }
////
////        try {
////            return new ByteArrayInputStream(FileUtils.readFileToByteArray(new File(this.getHtmlFilePath())));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        return null;
////    }
////
////    public String getXmlFilePath() {
////        String sep = System.getProperty("file.separator");
////        return String.format(".%s%s%sizvestaj.xml", sep, OUTPUT_FOLDER_XML, sep);
////    }
////
////    public String getPdfFilePath() {
////        String sep = System.getProperty("file.separator");
////        return String.format(".%s%s%sizvestaj.pdf", sep, OUTPUT_FOLDER_PDF, sep);
////    }
////
////    private String getHtmlFilePath() {
////        String sep = System.getProperty("file.separator");
////        return String.format(".%s%s%sizvestaj.html", sep, OUTPUT_FOLDER_HTML, sep);
////    }
////
////    public ByteArrayInputStream exportMetadataAsJson(Long zahtevId) {
////        String sparqlQuery = this.sparqlUtil.selectPredicateAndObject(
////                String.format(
////                        "%s%s",
////                        this.rdfService.getRdfdbConnectionProperties().getDataEndpoint(),
////                        SPARQL_NAMED_GRAPH_URI
////                ),
////                String.format("<%s/izvestaj/%d>  ?p  ?o", System.getenv("FRONTEND_URL"), zahtevId));
////        String sep = System.getProperty("file.separator");
////        String filePath = String.format(".%s%s%sizvestaj_metadata.json", sep, OUTPUT_FOLDER_METADATA, sep);
////        this.rdfService.runAndExportInGivenFormat(
////                sparqlQuery,
////                filePath,
////                ResultsFormat.FMT_RS_JSON
////        );
////        try {
////            return new ByteArrayInputStream(FileUtils.readFileToByteArray(new File(filePath)));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return null;
////    }
////
////    public ByteArrayInputStream exportMetadataAsXml(Long zahtevId) {
////        String sparqlQuery = this.sparqlUtil.selectPredicateAndObject(
////                String.format(
////                        "%s%s",
////                        this.rdfService.getRdfdbConnectionProperties().getDataEndpoint(),
////                        SPARQL_NAMED_GRAPH_URI
////                ),
////                String.format("<%s/izvestaj/%d>  ?p  ?o", System.getenv("FRONTEND_URL"), zahtevId));
////        String sep = System.getProperty("file.separator");
////        String filePath = String.format(".%s%s%sizvestaj_metadata.xml", sep, OUTPUT_FOLDER_METADATA, sep);
////        this.rdfService.runAndExportInGivenFormat(
////                sparqlQuery,
////                filePath,
////                ResultsFormat.FMT_RS_XML
////        );
////        try {
////            return new ByteArrayInputStream(FileUtils.readFileToByteArray(new File(filePath)));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return null;
////    }
////
////    public ByteArrayInputStream exportMetadataAsRdf(Long zahtevId) {
////        String sparqlQuery = this.sparqlUtil.describe(
////                String.format("%s/izvestaj/%d", System.getenv("FRONTEND_URL"), zahtevId),
////                String.format(
////                        "%s%s",
////                        this.rdfService.getRdfdbConnectionProperties().getDataEndpoint(),
////                        SPARQL_NAMED_GRAPH_URI
////                ),
////                String.format("<%s/izvestaj/%d>  ?p  ?o", System.getenv("FRONTEND_URL"), zahtevId));
////        String sep = System.getProperty("file.separator");
////        String filePath = String.format(".%s%s%sizvestaj_metadata.ttl", sep, OUTPUT_FOLDER_METADATA, sep);
////        this.rdfService.runAndExportInNativeFormat(
////                sparqlQuery,
////                filePath
////        );
////        try {
////            return new ByteArrayInputStream(FileUtils.readFileToByteArray(new File(filePath)));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return null;
////    }
////    public List<IzvestajOImunizaciji> pronadjiTerm(String term) {
////        try {
////            return this.izvestajAbstractXmlRepository.findEntities(String.format(XQueryExpressions.SEARCH_IZVESTAJI, term));
////        } catch (XMLDBException e) {
////            e.printStackTrace();
////        } catch (JAXBException e) {
////            e.printStackTrace();
////        }
////        return new ArrayList<>();
////    }

//    public List<IzvestajOImunizaciji> pronadjiMetadata(String metadata) {
//        String[] sts = metadata.split("\\*OR\\*");
//        Set<IzvestajOImunizaciji> retval = new HashSet<>();
//        for (String andsubstr : sts) {
//            String[] andsubstrtokens = andsubstr.split("\\*AND\\*");
//            System.out.println("Search by metadata AND substring: " + Arrays.toString(andsubstrtokens));
//            Set<String> ids = pretrageHelper.searchMetadata(andsubstrtokens, SPARQL_NAMED_GRAPH_URI);
//
//            ids.forEach((String s) -> {
//                try {
//                    retval.add(izvestajAbstractXmlRepository.getEntity(Long.parseLong(s)));
//                } catch (XMLDBException | JAXBException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        return new ArrayList<>(retval);
//    }
//
//    public List<String> getRefers(String about) {
//        return rdfService.search(SPARQL_NAMED_GRAPH_URI, about);
//    }
}
