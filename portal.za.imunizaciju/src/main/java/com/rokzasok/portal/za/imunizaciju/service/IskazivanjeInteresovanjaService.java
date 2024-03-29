package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.exception.*;
import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlUtil;
import com.rokzasok.portal.za.imunizaciju.helper.UUIDHelper;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import com.rokzasok.portal.za.imunizaciju.transformation.XSLTransformer;
import org.apache.commons.io.FileUtils;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_QUERY_FIND_ALL_IZVESTAJI_EXPRESSION;
import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_UPDATE_REMOVE_IZVESTAJ_BY_ID_EXPRESSION;

@Service
public class IskazivanjeInteresovanjaService implements AbstractXmlService<ObrazacInteresovanja> {

    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja";

    private static final String SPARQL_NAMED_GRAPH_URI = "/sparql/metadata";

    public static final String OUTPUT_FOLDER_XML = "output_xml";
    public static final String OUTPUT_FOLDER_PDF = "output_pdf";
    public static final String OUTPUT_FOLDER_HTML = "output_html";
    public static final String OUTPUT_FOLDER_METADATA = "output_metadata";

    @Autowired
    //@Qualifier("izvestajRepository")
    private AbstractXmlRepository<ObrazacInteresovanja> obrazacInteresovanjaAbstractXmlRepository;

    @Autowired
    private XmlConversionAgent<ObrazacInteresovanja> obrazacInteresovanjaXmlConversionAgent;

    @Autowired
    private RDFService rdfService;

    @Autowired
    private EmailService emailService;

//
//    @Autowired
//    private PretrageHelper pretrageHelper;

//    private rs.ac.uns.ftn.tim5.transofrmation.XSLFOTransformer XSLFOTransformer;

    //    @Autowired
//    private DateHelper dateHelper;
//
    @Autowired
    private UUIDHelper uuidHelper;

    @Autowired
    private SpisakTerminaService spisakTerminaService;
//
//    @Autowired
//    private SparqlUtil sparqlUtil;

//    @Autowired
//    private IzvestajClient izvestajClient;

    //@PostConstruct
    public void injectRepositoryProperties() {
        this.obrazacInteresovanjaAbstractXmlRepository.injectRepositoryProperties(
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
        try {
            return this.obrazacInteresovanjaAbstractXmlRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacSaglasnosti.class, e.getMessage());
        }
    }

    @Override
    public ObrazacInteresovanja findById(Long entityId) {
        injectRepositoryProperties();

        try {
            ObrazacInteresovanja obrazacInteresovanja = this.obrazacInteresovanjaAbstractXmlRepository.getEntity(entityId);
            if (obrazacInteresovanja == null)
                throw new EntityNotFoundException(entityId, ObrazacInteresovanja.class);
            return obrazacInteresovanja;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacInteresovanja.class, e.getMessage());
        }
    }


    public Document getDocument(Long entityId) {
        injectRepositoryProperties();

        try {
            ObrazacInteresovanja obrazacInteresovanja = this.obrazacInteresovanjaAbstractXmlRepository.getEntity(entityId);
            if (obrazacInteresovanja == null)
                throw new EntityNotFoundException(entityId, ObrazacInteresovanja.class);
            return obrazacInteresovanjaAbstractXmlRepository.getDOMDoc(entityId);
        } catch (XMLDBException | ParserConfigurationException | IOException | SAXException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacInteresovanja.class, e.getMessage());
        }
    }

    @Override
    public ObrazacInteresovanja create(String xmlEntity) {
        injectRepositoryProperties();

        ObrazacInteresovanja obrazacInteresovanja = null;
        try {
            obrazacInteresovanja = this.obrazacInteresovanjaXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
//            if(!proveriDaLiMozeDaKreiraInteresovanje(obrazacInteresovanja.getOpstiPodaci().getIdPodnosioca().getValue())){
//                System.out.println("OBRAZAC INTERESOVANJA JE VEC NAPRAVLJEN I NIJE PROSLO 7 DANA, PA SE NE MOZE NAPRAVITI NOVI.");
//                throw new ObrazacInteresovanjaException("OBRAZAC INTERESOVANJA JE VEC NAPRAVLJEN I NIJE PROSLO 7 DANA, PA SE NE MOZE NAPRAVITI NOVI.");
//            }
            obrazacInteresovanja.setDokumentId(this.uuidHelper.getUUID());
            this.handleMetadata(obrazacInteresovanja);
        } catch (JAXBException e) {
            e.printStackTrace();
            //throw new InvalidXmlException(ObrazacInteresovanja.class, e.getMessage());
        }

        try {
            obrazacInteresovanja = obrazacInteresovanjaAbstractXmlRepository.createEntity(obrazacInteresovanja);
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
            xmlEntity = this.obrazacInteresovanjaXmlConversionAgent.marshall(obrazacInteresovanja, this.jaxbContextPath);
            System.out.println(xmlEntity);
            if (!rdfService.save(xmlEntity, SPARQL_NAMED_GRAPH_URI)) {
                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            emailService.uspesnoPoslatoInteresovanjeEmail(obrazacInteresovanja.getPodaciOOsobi().getEmail().getValue(), obrazacInteresovanja);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        spisakTerminaService.zakaziTermin(obrazacInteresovanja.getOpstiPodaci().getLokacijaOpstina().getValue(),
                LocalDate.now().plusDays(1), obrazacInteresovanja.getOpstiPodaci().getTipVakcine().getValue().value(),
                7, obrazacInteresovanja.getPodaciOOsobi().getIme() + ' ' + obrazacInteresovanja.getPodaciOOsobi().getPrezime());

        return obrazacInteresovanja;
    }

    @Override
    public ObrazacInteresovanja update(String entityXml) {
        injectRepositoryProperties();

        ObrazacInteresovanja obrazacInteresovanja;
        try {
            obrazacInteresovanja = this.obrazacInteresovanjaXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(ObrazacInteresovanja.class, e.getMessage());
        }

        try {
            if (!this.obrazacInteresovanjaAbstractXmlRepository.updateEntity(obrazacInteresovanja)) {
                throw new EntityNotFoundException(obrazacInteresovanja.getDokumentId(), ObrazacInteresovanja.class);
            }
            return obrazacInteresovanja;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacInteresovanja.class, e.getMessage());
        }
    }

    @Override
    public String getRdfaString(Long dokumentId) throws JAXBException {
        injectRepositoryProperties();

        ObrazacInteresovanja dokument;
        dokument = this.findById(dokumentId);
        String entityXml = this.obrazacInteresovanjaXmlConversionAgent.marshall(dokument, this.jaxbContextPath);
        System.out.println(entityXml);
        return entityXml;

    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();

        try {
            return this.obrazacInteresovanjaAbstractXmlRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }

    private void handleMetadata(ObrazacInteresovanja interesovanje){
        interesovanje.getPodaciOOsobi().setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        interesovanje.getPodaciOOsobi().setAbout("http://www.rokzasok.rs/rdf/database/osoba/" + interesovanje.getOpstiPodaci().getIdPodnosioca().getValue());

        interesovanje.getPodaciOOsobi().getEmail().setDatatype("xs:#string");
        interesovanje.getPodaciOOsobi().getEmail().setProperty("pred:email");

        interesovanje.getPodaciOOsobi().getBrojFiksnogTelefona().setProperty("pred:brojFiksnogTelefona");
        interesovanje.getPodaciOOsobi().getBrojFiksnogTelefona().setDatatype("xs:#string");

        interesovanje.getOpstiPodaci().setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        interesovanje.getOpstiPodaci().setAbout("http://www.rokzasok.rs/rdf/database/iskazivanje-interesovanja/" + interesovanje.getDokumentId().toString());

        interesovanje.getOpstiPodaci().getIdPodnosioca().setDatatype("xs:#string");
        interesovanje.getOpstiPodaci().getIdPodnosioca().setProperty("pred:kreiranOdStrane");

        interesovanje.getOpstiPodaci().getLokacijaOpstina().setDatatype("xs:#string");
        interesovanje.getOpstiPodaci().getLokacijaOpstina().setProperty("pred:lokacijaOpstina");

        interesovanje.getOpstiPodaci().getTipVakcine().setProperty("pred:tipVakcine");
        interesovanje.getOpstiPodaci().getTipVakcine().setDatatype("xs:#string");

        interesovanje.getOpstiPodaci().getDavalacKrvi().setDatatype("xs:#boolean");
        interesovanje.getOpstiPodaci().getDavalacKrvi().setProperty("pred:davalacKrvi");

        interesovanje.getOpstiPodaci().getDatumPodnosenja().setProperty("pred:datumKreiranja");
        interesovanje.getOpstiPodaci().getDatumPodnosenja().setDatatype("xs:#date");

    }



    public boolean proveriDaLiMozeDaKreiraInteresovanje(Long osobaId){
        System.out.println("[INFO] Retrieving obrasci interesovanja  by " + osobaId + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String pre7Dana = LocalDate.now().minusDays(7).format(formatter);
        String sparqlQuery = SparqlUtil.selectObrasciInteresovanjaByOsobaPre7Dana(Long.toString(osobaId), pre7Dana, rdfService.getRdfdbConnectionProperties().getDataEndpoint());
        System.out.println(sparqlQuery);
        QueryExecution query = QueryExecutionFactory.sparqlService(rdfService.getRdfdbConnectionProperties().getQueryEndpoint(), sparqlQuery);
        ResultSet results = query.execSelect();
        boolean retVal = !results.hasNext();
        ResultSetFormatter.out(System.out, results);
        query.close();
        return retVal;
    }

    public ByteArrayInputStream generateHtml(Long dokumentId) throws IOException, SAXException {
        String xslFile = "src/main/resources/data/xsl-transformations/iskazivanje_interesovanja.xsl";
        String outputHtmlFile = "src/main/resources/data/xsl-transformations/generated/output-html/interesovanje.html";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml/interesovanje.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSLT_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_HTML(outputHtmlFile);

        ObrazacInteresovanja potvrda = this.findById(dokumentId);

        try {
            this.obrazacInteresovanjaXmlConversionAgent.marshallToFile(
                    potvrda,
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
        String xslFile = "src/main/resources/data/xsl-transformations/iskazivanje_interesovanja.xsl";
        String outputHtmlFile = "src/main/resources/data/xsl-transformations/generated/output-html/iskazivanje_interesovanja.html";
        String outputPdfFile = "src/main/resources/data/xsl-transformations/generated/output-pdf/iskazivanje_interesovanja.pdf";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml-fo/iskazivanje_interesovanja.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSLT_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_HTML(outputHtmlFile);
        xslTransformer.setOUTPUT_FILE_PDF(outputPdfFile);

        ObrazacInteresovanja zahtev = this.findById(dokumentId);
        try {
            this.obrazacInteresovanjaXmlConversionAgent.marshallToFile(
                    zahtev,
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
