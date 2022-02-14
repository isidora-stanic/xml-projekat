package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.exception.*;
import com.rokzasok.portal.za.imunizaciju.fuseki.SparqlService;
import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlUtil;
import com.rokzasok.portal.za.imunizaciju.helper.UUIDHelper;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_QUERY_FIND_ALL_IZVESTAJI_EXPRESSION;
import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_UPDATE_REMOVE_IZVESTAJ_BY_ID_EXPRESSION;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class IskazivanjeInteresovanjaService implements AbstractXmlService<ObrazacInteresovanja> {

    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja";

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

        return null;
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

    @Override
    public ObrazacInteresovanja create(String xmlEntity) {
        injectRepositoryProperties();

        ObrazacInteresovanja obrazacInteresovanja = null;
        try {
            obrazacInteresovanja = this.obrazacInteresovanjaXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
            if(!proveriDaLiMozeDaKreiraInteresovanje(obrazacInteresovanja.getPodaciOOsobi().getIdOsobe())){
                System.out.println("OBRAZAC INTERESOVANJA JE VEC NAPRAVLJEN I NIJE PROSLO 7 DANA, PA SE NE MOZE NAPRAVITI NOVI.");
                throw new ObrazacInteresovanjaException("OBRAZAC INTERESOVANJA JE VEC NAPRAVLJEN I NIJE PROSLO 7 DANA, PA SE NE MOZE NAPRAVITI NOVI.");
            }
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

        //izvestajClient.sendIzvestaj(izvestaj);

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
        interesovanje.getPodaciOOsobi().setAbout("http://www.rokzasok.rs/rdf/database/osoba/" + interesovanje.getPodaciOOsobi().getIdOsobe());

        interesovanje.getPodaciOOsobi().getEmail().setDatatype("xs:#string");
        interesovanje.getPodaciOOsobi().getEmail().setProperty("pred:email");

        interesovanje.getPodaciOOsobi().getBrojFiksnogTelefona().setProperty("pred:brojFiksnogTelefona");
        interesovanje.getPodaciOOsobi().getBrojFiksnogTelefona().setDatatype("xs:#string");

        interesovanje.getOpstiPodaci().setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        interesovanje.getOpstiPodaci().setAbout("http://www.rokzasok.rs/rdf/database/iskazivanje-interesovanja/" + interesovanje.getDokumentId().toString());
        interesovanje.getOpstiPodaci().setRel("pred:kreiranOdStrane");
        interesovanje.getOpstiPodaci().setHref("http://www.rokzasok.rs/rdf/database/osoba/" + interesovanje.getPodaciOOsobi().getJMBG());

        interesovanje.getOpstiPodaci().getLokacijaOpstina().setDatatype("xs:#string");
        interesovanje.getOpstiPodaci().getLokacijaOpstina().setProperty("pred:lokacijaOpstina");

        interesovanje.getOpstiPodaci().getTipVakcine().setProperty("pred:tipVakcine");
        interesovanje.getOpstiPodaci().getTipVakcine().setDatatype("xs:#string");

        interesovanje.getOpstiPodaci().getDavalacKrvi().setDatatype("xs:#boolean");
        interesovanje.getOpstiPodaci().getDavalacKrvi().setProperty("pred:davalacKrvi");

        interesovanje.getOpstiPodaci().getDatumPodnosenja().setProperty("pred:datumPodnosenja");
        interesovanje.getOpstiPodaci().getDatumPodnosenja().setDatatype("xs:#date");

    }

    public boolean proveriDaLiMozeDaKreiraInteresovanje(Long osobaId){
        System.out.println("[INFO] Retrieving obrasci interesovanja  by " + osobaId + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String pre7Dana = LocalDate.now().minusDays(7).format(formatter);
        String sparqlQuery = SparqlUtil.selectObrasciInteresovanjaByOsobaPre7Dana(Long.toString(osobaId), pre7Dana);
        System.out.println(sparqlQuery);
        QueryExecution query = QueryExecutionFactory.sparqlService("http://localhost:8080/fuseki/eUpravaDataset", sparqlQuery);
        ResultSet results = query.execSelect();
        boolean retVal = !results.hasNext();
        ResultSetFormatter.out(System.out, results);
        query.close();
        return retVal;
    }

}
