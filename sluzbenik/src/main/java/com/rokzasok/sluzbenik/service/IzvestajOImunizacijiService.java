package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat.DigitalniSertifikat;
import com.rokzasok.sluzbenik.model.dokumenti.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.rokzasok.sluzbenik.exception.EntityNotFoundException;
import com.rokzasok.sluzbenik.exception.InvalidXmlDatabaseException;
import com.rokzasok.sluzbenik.exception.InvalidXmlException;
import com.rokzasok.sluzbenik.exception.XmlDatabaseException;
import com.rokzasok.sluzbenik.helper.UUIDHelper;
import com.rokzasok.sluzbenik.helper.XmlConversionAgent;
import com.rokzasok.sluzbenik.repository.AbstractXmlRepository;
import com.rokzasok.sluzbenik.transformation.XSLTransformer;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
    public String getRdfaString(Long dokumentId) throws JAXBException {
        injectRepositoryProperties();

        IzvestajOImunizaciji dokument;
        dokument = this.findById(dokumentId);
        String entityXml = this.izvestajXmlConversionAgent.marshall(dokument, this.jaxbContextPath);
        System.out.println(entityXml);
        return entityXml;

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

    public ByteArrayInputStream generateHtml(Long dokumentId) throws IOException, SAXException {
        String xslFile = "src/main/resources/data/xsl-transformations/izvestaj_o_imunizaciji.xsl";
        String outputHtmlFile = "src/main/resources/data/xsl-transformations/generated/output-html/izvestaj.html";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml/izvestaj.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSLT_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_HTML(outputHtmlFile);

        IzvestajOImunizaciji izvestaj = this.findById(dokumentId);

        try {
            this.izvestajXmlConversionAgent.marshallToFile(
                    izvestaj,
                    this.jaxbContextPath,
                    outputXmlFile
            );

            xslTransformer.generateHTML(
                    outputXmlFile
            );
            return new ByteArrayInputStream(FileUtils.readFileToByteArray(
                    new File(outputHtmlFile)
            ));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ByteArrayInputStream generatePDF(Long dokumentId) throws IOException, SAXException, JAXBException {
        String xslFile = "src/main/resources/data/xsl-transformations/izvestaj_o_imunizaciji.xsl";
        String outputHtmlFile = "src/main/resources/data/xsl-transformations/generated/output-html/izvestaj.html";
        String outputPdfFile = "src/main/resources/data/xsl-transformations/generated/output-pdf/izvestaj.pdf";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml-fo/izvestaj.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSLT_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_HTML(outputHtmlFile);
        xslTransformer.setOUTPUT_FILE_PDF(outputPdfFile);

        IzvestajOImunizaciji izvestaj = this.findById(dokumentId);
        try {
            this.izvestajXmlConversionAgent.marshallToFile(
                    izvestaj,
                    this.jaxbContextPath,
                    outputXmlFile
            );
            xslTransformer.generatePDF_HTML(outputXmlFile);
            return new ByteArrayInputStream(FileUtils.readFileToByteArray(new File(outputPdfFile)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
