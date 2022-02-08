package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije.PotvrdaVakcinacije;
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

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_QUERY_FIND_ALL_OBRAZAC_SAGLASNOSTI_EXPRESSION;
import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_UPDATE_REMOVE_OBRAZAC_SAGLASNOSTI_BY_ID_EXPRESSION;

@Service
public class ObrazacSaglasnostiService implements AbstractXmlService<ObrazacSaglasnosti> {
    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.obrazac_saglasnosti";

    private static final String SPARQL_NAMED_GRAPH_URI = "/sparql/metadata";

    public static final String OUTPUT_FOLDER_XML = "output_xml";
    public static final String OUTPUT_FOLDER_PDF = "output_pdf";
    public static final String OUTPUT_FOLDER_HTML = "output_html";
    public static final String OUTPUT_FOLDER_METADATA = "output_metadata";

    @Autowired
    private AbstractXmlRepository<ObrazacSaglasnosti> obrazacSaglasnostiRepository;

    @Autowired
    private XmlConversionAgent<ObrazacSaglasnosti> obrazacSaglasnostiXmlConversionAgent;

    @Autowired
    private UUIDHelper uuidHelper;

    @Autowired
    private RDFService rdfService;

    //@PostConstruct
    public void injectRepositoryProperties() {
        this.obrazacSaglasnostiRepository.injectRepositoryProperties(
                "/db/sample/obrazac_saglasnosti",
                jaxbContextPath,
                X_QUERY_FIND_ALL_OBRAZAC_SAGLASNOSTI_EXPRESSION,
                X_UPDATE_REMOVE_OBRAZAC_SAGLASNOSTI_BY_ID_EXPRESSION
        );
    }

    @Override
    public List<ObrazacSaglasnosti> findAll() {
        injectRepositoryProperties();

        try {
            return this.obrazacSaglasnostiRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacSaglasnosti.class, e.getMessage());
        }
    }

    @Override
    public ObrazacSaglasnosti findById(Long entityId) {
        injectRepositoryProperties();

        try {
            ObrazacSaglasnosti izvestaj = this.obrazacSaglasnostiRepository.getEntity(entityId);
            if (izvestaj == null)
                throw new EntityNotFoundException(entityId, ObrazacSaglasnosti.class);
            return izvestaj;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacSaglasnosti.class, e.getMessage());
        }
    }

    @Override
    public ObrazacSaglasnosti create(String entityXml) {
        injectRepositoryProperties();

        ObrazacSaglasnosti potvrdaVakcinacije;

        try {
            potvrdaVakcinacije = this.obrazacSaglasnostiXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
            potvrdaVakcinacije.setDokumentId(this.uuidHelper.getUUID());
            this.handleMetadata(potvrdaVakcinacije);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new InvalidXmlException(ObrazacInteresovanja.class, e.getMessage());
        }

        try {
            potvrdaVakcinacije = obrazacSaglasnostiRepository.createEntity(potvrdaVakcinacije);
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
            entityXml = this.obrazacSaglasnostiXmlConversionAgent.marshall(potvrdaVakcinacije, this.jaxbContextPath);
            System.out.println(entityXml);
            if (!rdfService.save(entityXml, SPARQL_NAMED_GRAPH_URI)) {
                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //izvestajClient.sendIzvestaj(izvestaj);
        return potvrdaVakcinacije;
    }

    @Override
    public ObrazacSaglasnosti update(String entityXml) {
        injectRepositoryProperties();

        ObrazacSaglasnosti potvrdaVakcinacije;
        try {
            potvrdaVakcinacije = this.obrazacSaglasnostiXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(ObrazacSaglasnosti.class, e.getMessage());
        }

        try {
            if (!this.obrazacSaglasnostiRepository.updateEntity(potvrdaVakcinacije)) {
                throw new EntityNotFoundException(potvrdaVakcinacije.getDokumentId(), ObrazacSaglasnosti.class);
            }
            return potvrdaVakcinacije;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacSaglasnosti.class, e.getMessage());
        }

    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();

        try {
            return this.obrazacSaglasnostiRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }

    private void handleMetadata(ObrazacSaglasnosti izvestaj) {
        izvestaj.getEvidencijaPacijent().getPacijent().setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        izvestaj.getEvidencijaPacijent().getPacijent().setAbout("http://www.rokzasok.rs/rdf/database/osoba/" +
                izvestaj.getEvidencijaPacijent().getPacijent().getPacijentInfo().getJmbg()); // TODO ID

        izvestaj.getEvidencijaPacijent().getPacijent().getPacijentInfo().getPol().setProperty("pred:pol");
        izvestaj.getEvidencijaPacijent().getPacijent().getPacijentInfo().getPol().setDatatype("xs:string");

        izvestaj.getEvidencijaPacijent().getPacijent().getPacijentInfo().getDatumRodjenja().setProperty("pred:datumRodjenja");
        izvestaj.getEvidencijaPacijent().getPacijent().getPacijentInfo().getDatumRodjenja().setDatatype("xs:date");

        izvestaj.getEvidencijaPacijent().getPacijent().getKontakt().getTelFiksni().setProperty("pred:brojFiksnogTelefona");
        izvestaj.getEvidencijaPacijent().getPacijent().getKontakt().getTelFiksni().setDatatype("xs:string");

        izvestaj.getEvidencijaPacijent().getPacijent().getKontakt().getEmail().setProperty("pred:email");
        izvestaj.getEvidencijaPacijent().getPacijent().getKontakt().getEmail().setDatatype("xs:string");


        for (ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.Doza doza : izvestaj.getEvidencijaVakcinacija().getTabela().getDoza()) {
            doza.setVocab("http://www.rokzasok.rs/rdf/database/predicate");
            doza.setRel("pred:saglasnost");
            doza.setAbout("http://www.rokzasok.rs/rdf/database/doza/" + doza.getBrojDoze().toString());
            doza.setHref("http://www.rokzasok.rs/rdf/database/obrazac-saglasnosti/" + doza.getBrojDoze().toString());

            doza.getTip().setProperty("pred:tipVakcine");
            doza.getTip().setDatatype("xs:#string");

            doza.getProizvodjac().setProperty("pred:proizvodjacVakcine");

            doza.getDatum().setProperty("pred:datumPrimanja");
            doza.getDatum().setDatatype("xs:#date");

            doza.getBrojSerije().setProperty("pred:brojSerije");
            doza.getBrojSerije().setDatatype("xs:#string");

            doza.getBrojDoze().setProperty("pred:brojDoze");
            doza.getBrojDoze().setDatatype("xs:#positiveInteger");
        }

        izvestaj.getDokumentInfo().setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        izvestaj.getDokumentInfo().setAbout("http://www.rokzasok.rs/rdf/database/obrazac-saglasnosti/" + izvestaj.getDokumentId());
        izvestaj.getDokumentInfo().setRel("pred:kreiranOdStrane");
        izvestaj.getDokumentInfo().setHref("http://www.rokzasok.rs/rdf/database/osoba/" + izvestaj.getEvidencijaPacijent().getPacijent().getPacijentInfo().getJmbg()); // TODO ID
    }
}
