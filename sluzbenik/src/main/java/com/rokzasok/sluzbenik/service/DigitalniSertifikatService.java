package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.model.b2b.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.zahtev_za_sertifikat.*;
import com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije.TDoza;
import com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat.DigitalniSertifikat;
import com.rokzasok.sluzbenik.exception.EntityNotFoundException;
import com.rokzasok.sluzbenik.exception.InvalidXmlDatabaseException;
import com.rokzasok.sluzbenik.exception.InvalidXmlException;
import com.rokzasok.sluzbenik.exception.XmlDatabaseException;
import com.rokzasok.sluzbenik.helper.UUIDHelper;
import com.rokzasok.sluzbenik.helper.XmlConversionAgent;
import com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat.TOsoba;
import com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat.TPol;
import com.rokzasok.sluzbenik.repository.AbstractXmlRepository;
import com.rokzasok.sluzbenik.transformation.XSLTransformer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

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
    private XmlConversionAgent<Zahtev> zahtevXmlConversionAgent;

    @Autowired
    private RDFService rdfService;

    @Autowired
    private UUIDHelper uuidHelper;

    @Autowired
    private B2BService b2BService;

    @Autowired
    private SparqlToDTOService sparqlToDTOService;

    @Autowired
    private EmailService emailService;

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

    public Document getDocument(Long entityId) {
        injectRepositoryProperties();

        try {
            DigitalniSertifikat digitalniSertifikat = this.digitalniSertifikatAbstractXmlRepository.getEntity(entityId);
            if (digitalniSertifikat == null)
                throw new EntityNotFoundException(entityId, ObrazacInteresovanja.class);
            return digitalniSertifikatAbstractXmlRepository.getDOMDoc(entityId);
        } catch (XMLDBException | ParserConfigurationException | IOException | SAXException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacInteresovanja.class, e.getMessage());
        }
    }

    @Override
    public DigitalniSertifikat create(String xmlEntity) {
        injectRepositoryProperties();

        DigitalniSertifikat sertifikat;
        try {
            sertifikat = this.digitalniSertifikatXmlConversionAgent.unmarshall(xmlEntity, this.jaxbContextPath);
            sertifikat.setDokumentId(this.uuidHelper.getUUID());
            this.handleMetadata(sertifikat, 1L);
        } catch (JAXBException e) {
            throw new InvalidXmlException(DigitalniSertifikat.class, e.getMessage());
        }

        sertifikat = saveDigitalniSertifikat(sertifikat);

        //izvestajClient.sendIzvestaj(izvestaj);

        return sertifikat;
    }

    private DigitalniSertifikat saveDigitalniSertifikat(DigitalniSertifikat sertifikat) {
        injectRepositoryProperties();

        String xmlEntity;
        try {
            sertifikat = digitalniSertifikatAbstractXmlRepository.createEntity(sertifikat);
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
            xmlEntity = this.digitalniSertifikatXmlConversionAgent.marshall(sertifikat, this.jaxbContextPath);
            System.out.println(xmlEntity);
            if (!rdfService.save(xmlEntity, SPARQL_NAMED_GRAPH_URI)) {
                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sertifikat;
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
    public String getRdfaString(Long dokumentId) throws JAXBException {
        injectRepositoryProperties();

        DigitalniSertifikat dokument;
        dokument = this.findById(dokumentId);
        String entityXml = this.digitalniSertifikatXmlConversionAgent.marshall(dokument, this.jaxbContextPath);
        System.out.println(entityXml);
        return entityXml;

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

    private void handleMetadata(DigitalniSertifikat izvestaj, Long idZahtevaZaSertifikat) {
        izvestaj.setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        izvestaj.setAbout("http://www.rokzasok.rs/rdf/database/digitalni-sertifikat/" + izvestaj.getDokumentId().toString());
        izvestaj.setRel("pred:prethodniDokument");
        izvestaj.setHref("http://www.rokzasok.rs/rdf/database/zahtev-za-sertifikat/" + idZahtevaZaSertifikat);


        izvestaj.getGradjanin().getId().setProperty("pred:kreiranOdStrane");
        izvestaj.getGradjanin().getId().setDatatype("xs:#string");

        izvestaj.getInfoOSertifikatu().getDatum().setProperty("pred:datumKreiranja");
        izvestaj.getInfoOSertifikatu().getDatum().setDatatype("xs:#dateTime");
    }

    // ako ovde iz nekog razloga puca kod, to je zbog praznog konstruktora kod sertifikata
    public DigitalniSertifikat generateForZahtev(Long idZahteva) {
        injectRepositoryProperties();

        Zahtev zahtev = b2BService.getZahtevZaSertifikat(idZahteva.toString());
        DigitalniSertifikat sertifikat = new DigitalniSertifikat();

        com.rokzasok.sluzbenik.model.b2b.gradjanin.zahtev_za_sertifikat.TOsoba pacijent = zahtev.getPacijent();

        TOsoba noviGradjanin = new TOsoba(
                pacijent.getJmbg(),
                pacijent.getIme(),
                pacijent.getPrezime(),
                TPol.fromValue(pacijent.getPol().value()),
                pacijent.getDatumRodjenja(),
                pacijent.getBrojPasosa(),
                pacijent.getId().getValue()
        );
        sertifikat.setGradjanin(noviGradjanin);

        PotvrdaVakcinacije poslednjaPotvrdaVakcinacije = b2BService.getPoslednjaPotvrdaVakcinacije(pacijent.getId().getValue());

        List<DigitalniSertifikat.Vakcinacija.Doza> sertifikatDoze = new ArrayList<>();

        for ( TDoza doza : poslednjaPotvrdaVakcinacije.getDoze().getDoza()) {
            sertifikatDoze.add(new DigitalniSertifikat.Vakcinacija.Doza(
                    doza.getTip(),
                    doza.getProizvodjac(),
                    doza.getDatum(),
                    doza.getBrojSerije(),
                    doza.getBrojDoze(),
                    doza.getUstanova().getNaziv(),
                    doza.getUstanova().getMesto())
            );
        }

        Long idSertifikata = uuidHelper.getUUID();

        sertifikat.setVakcinacija(sertifikatDoze);
        sertifikat.setInfoOSertifikatu(idSertifikata);

        sertifikat.setDokumentId(idSertifikata);

        sertifikat.getInfoOSertifikatu().setQrLink("http://localhost:4200/pregled/digitalni-sertifikat/" + idSertifikata);

        handleMetadata(sertifikat, idZahteva);
        saveDigitalniSertifikat(sertifikat);

        b2BService.prihvatiZahtev(idZahteva);

        try {
            ByteArrayInputStream is = generatePDF(idSertifikata);

            byte[] pdfBytes = IOUtils.toByteArray(is);

            emailService.sendDigitalniSertifikatEmail(pacijent.getIme()
                    .toLowerCase(Locale.ROOT).trim().replace(" ", "")
                    + "@gmail.com", pdfBytes); // TODO: da bude username umesto korisnickog imena?

        } catch (IOException | SAXException | JAXBException | MessagingException e) {
            e.printStackTrace();
        }


        return sertifikat;

    }

    public ByteArrayInputStream generateHtml(Long dokumentId) throws IOException, SAXException {
        String xslFile = "src/main/resources/data/xsl-transformations/digitalni_sertifikat.xsl";
        String outputHtmlFile = "src/main/resources/data/xsl-transformations/generated/output-html/sertifikat.html";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml/sertifikat.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSLT_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_HTML(outputHtmlFile);

        DigitalniSertifikat sertifikat = this.findById(dokumentId);

        try {
            this.digitalniSertifikatXmlConversionAgent.marshallToFile(
                    sertifikat,
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
        String xslFile = "src/main/resources/data/xsl-transformations/digitalni_sertifikat.xsl";
        String outputHtmlFile = "src/main/resources/data/xsl-transformations/generated/output-html/sertifikat.html";
        String outputPdfFile = "src/main/resources/data/xsl-transformations/generated/output-pdf/sertifikat.pdf";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml-fo/sertifikat.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSLT_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_HTML(outputHtmlFile);
        xslTransformer.setOUTPUT_FILE_PDF(outputPdfFile);

        DigitalniSertifikat sertifikat = this.findById(dokumentId);
        try {
            System.out.println("dje puklo");
            this.digitalniSertifikatXmlConversionAgent.marshallToFile(
                    sertifikat,
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
