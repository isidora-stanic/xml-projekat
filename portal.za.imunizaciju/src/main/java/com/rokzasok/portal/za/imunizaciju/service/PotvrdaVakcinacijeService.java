package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.portal.za.imunizaciju.exception.EntityNotFoundException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlException;
import com.rokzasok.portal.za.imunizaciju.exception.XmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.helper.UUIDHelper;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import com.rokzasok.portal.za.imunizaciju.transformation.XSLTransformer;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.*;

@Service
public class PotvrdaVakcinacijeService implements AbstractXmlService<PotvrdaVakcinacije> {
    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije";

    private static final String SPARQL_NAMED_GRAPH_URI = "/sparql/metadata";

    public static final String OUTPUT_FOLDER_XML = "output_xml";
    public static final String OUTPUT_FOLDER_PDF = "output_pdf";
    public static final String OUTPUT_FOLDER_HTML = "output_html";
    public static final String OUTPUT_FOLDER_METADATA = "output_metadata";

    @Autowired
    private AbstractXmlRepository<PotvrdaVakcinacije> potvrdaVakcinacijeRepository;

    @Autowired
    private XmlConversionAgent<PotvrdaVakcinacije> potvrdaVakcinacijeXmlConversionAgent;

    @Autowired
    private UUIDHelper uuidHelper;

    @Autowired
    private RDFService rdfService;

    //@PostConstruct
    public void injectRepositoryProperties() {
        this.potvrdaVakcinacijeRepository.injectRepositoryProperties(
                "/db/sample/potvrda-vakcinacije",
                jaxbContextPath,
                X_QUERY_FIND_ALL_POTVRDE_O_VAKCINACIJI_EXPRESSION,
                X_UPDATE_REMOVE_POTVRDA_BY_ID_EXPRESSION
        );
    }

    @Override
    public List<PotvrdaVakcinacije> findAll() {
        injectRepositoryProperties();

        try {
            return this.potvrdaVakcinacijeRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(PotvrdaVakcinacije.class, e.getMessage());
        }
    }

    @Override
    public PotvrdaVakcinacije findById(Long entityId) {
        injectRepositoryProperties();

        try {
            PotvrdaVakcinacije izvestaj = this.potvrdaVakcinacijeRepository.getEntity(entityId);
            if (izvestaj == null)
                throw new EntityNotFoundException(entityId, PotvrdaVakcinacije.class);
            return izvestaj;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(PotvrdaVakcinacije.class, e.getMessage());
        }
    }

    @Override
    public PotvrdaVakcinacije create(String entityXml) {
        injectRepositoryProperties();

        PotvrdaVakcinacije potvrdaVakcinacije;

        try {
            potvrdaVakcinacije = this.potvrdaVakcinacijeXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
            potvrdaVakcinacije.setDokumentId(this.uuidHelper.getUUID());
            this.handleMetadata(potvrdaVakcinacije);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new InvalidXmlException(ObrazacInteresovanja.class, e.getMessage());
        }

        try {
            potvrdaVakcinacije = potvrdaVakcinacijeRepository.createEntity(potvrdaVakcinacije);
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
            entityXml = this.potvrdaVakcinacijeXmlConversionAgent.marshall(potvrdaVakcinacije, this.jaxbContextPath);
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
    public PotvrdaVakcinacije update(String entityXml) {
        injectRepositoryProperties();

        PotvrdaVakcinacije potvrdaVakcinacije;
        try {
            potvrdaVakcinacije = this.potvrdaVakcinacijeXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(PotvrdaVakcinacije.class, e.getMessage());
        }

        try {
            if (!this.potvrdaVakcinacijeRepository.updateEntity(potvrdaVakcinacije)) {
                throw new EntityNotFoundException(potvrdaVakcinacije.getDokumentId(), PotvrdaVakcinacije.class);
            }
            return potvrdaVakcinacije;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(PotvrdaVakcinacije.class, e.getMessage());
        }

    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();

        try {
            return this.potvrdaVakcinacijeRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }

    public void handleMetadata(PotvrdaVakcinacije potvrda) {
        String idOsobe = Long.toString(potvrda.getOsoba().getIdOsobe());

        potvrda.setAbout(String.format("http://www.rokzasok.rs/rdf/database/potvrda-vakcinacije/%d", potvrda.getDokumentId()));
        potvrda.setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        potvrda.setRel("pred:kreiranOdStrane");
        potvrda.setHref(String.format("http://www.rokzasok.rs/rdf/database/osoba/%s", idOsobe));

        potvrda.getOsoba().setAbout(String.format("http://www.rokzasok.rs/rdf/database/osoba/%s", idOsobe));
        potvrda.getOsoba().setVocab("http://www.rokzasok.rs/rdf/database/predicate");

        ListIterator<PotvrdaVakcinacije.Doze.Doza> dozaIterator = potvrda.getDoze().getDoza().listIterator();
        while (dozaIterator.hasNext()) {
            int index = dozaIterator.nextIndex();
            PotvrdaVakcinacije.Doze.Doza doza = dozaIterator.next();
            doza.setAbout(String.format("http://www.rokzasok.rs/rdf/database/doza/%d", index));
            doza.setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        }

        potvrda.getRazlogIzdavanja().setDatatype("xs:#string");
        potvrda.getRazlogIzdavanja().setProperty("pred:razlogIzdavanja");
        potvrda.getDatumIzdavanja().setDatatype("xs:#date");
        potvrda.getDatumIzdavanja().setProperty("pred:datumIzdavanja");
    }

    public ByteArrayInputStream generateHtml(Long dokumentId) throws IOException, SAXException {
        String xslFile = "src/main/resources/data/xsl-transformations/potvrda_vakcinacije.xsl";
        String outputHtmlFile = "src/main/resources/data/xsl-transformations/generated/output-html/potvrda.html";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml/potvrda.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSLT_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_HTML(outputHtmlFile);

        PotvrdaVakcinacije potvrda = this.findById(dokumentId);

        try {
            this.potvrdaVakcinacijeXmlConversionAgent.marshallToFile(
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
}
