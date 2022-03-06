package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.exception.EntityNotFoundException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlException;
import com.rokzasok.portal.za.imunizaciju.exception.XmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.helper.UUIDHelper;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti.TOsoba;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije.TDoza;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije.TPol;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import com.rokzasok.portal.za.imunizaciju.transformation.XSLTransformer;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_QUERY_FIND_ALL_POTVRDE_O_VAKCINACIJI_EXPRESSION;
import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_UPDATE_REMOVE_POTVRDA_BY_ID_EXPRESSION;

@Service
public class PotvrdaVakcinacijeService implements AbstractXmlService<PotvrdaVakcinacije> {
    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije";

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

    @Autowired
    private ObrazacSaglasnostiService obrazacSaglasnostiService;

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

    public Document getDocument(Long entityId) {
        injectRepositoryProperties();

        try {
            PotvrdaVakcinacije potvrdaVakcinacije = this.potvrdaVakcinacijeRepository.getEntity(entityId);
            if (potvrdaVakcinacije == null)
                throw new EntityNotFoundException(entityId, ObrazacInteresovanja.class);
            return potvrdaVakcinacijeRepository.getDOMDoc(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacInteresovanja.class, e.getMessage());
        } catch (ParserConfigurationException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (IOException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (SAXException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }

    @Override
    public PotvrdaVakcinacije create(String entityXml) { // todo: verovatno nepotrebna metoda
        injectRepositoryProperties();

        PotvrdaVakcinacije potvrdaVakcinacije;

        try {
            potvrdaVakcinacije = this.potvrdaVakcinacijeXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
            potvrdaVakcinacije.setDokumentId(this.uuidHelper.getUUID());
            this.handleMetadata(potvrdaVakcinacije, 1L);
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

    public PotvrdaVakcinacije generateForObrazacSaglasnosti(Long idObrascaSaglasnosti) {
        PotvrdaVakcinacije potvrda = genPotvrdaVakcinacije(idObrascaSaglasnosti);

        this.handleMetadata(potvrda, idObrascaSaglasnosti);

        try {
            potvrdaVakcinacijeRepository.createEntity(potvrda);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
        }


        try {
            String entityXml = this.potvrdaVakcinacijeXmlConversionAgent.marshall(potvrda, this.jaxbContextPath);
            if (!rdfService.save(entityXml, SPARQL_NAMED_GRAPH_URI)) {
                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }


        return potvrda;
    }

    private PotvrdaVakcinacije genPotvrdaVakcinacije(Long idObrascaSaglasnosti) {
        ObrazacSaglasnosti obrazac = obrazacSaglasnostiService.findById(idObrascaSaglasnosti);
        PotvrdaVakcinacije potvrda = new PotvrdaVakcinacije();

        ObrazacSaglasnosti.EvidencijaPacijent.Pacijent pacijent = obrazac.getEvidencijaPacijent().getPacijent();
        TOsoba pacijentInfo = pacijent.getPacijentInfo();

        TPol pol = TPol.valueOf(pacijentInfo.getPol().getValue().value());

        // gadno datum parsiranje
        TOsoba.DatumRodjenja datumRodjenjaObrazac = pacijentInfo.getDatumRodjenja();

        XMLGregorianCalendar datumRodjenja = datumRodjenjaObrazac.getValue();

        // todo: ako ima broj pasosa, nije srpski drzavljanin i ne moze da dobije potvrdu
        //  potencijalno treba izmeniti sta se desava u tom slucaju (throw bad request?)
        if (pacijent.getBrojPasosa() != null && pacijent.getBrojPasosa().length() > 0){
            return null;
        }

        com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije.TOsoba osoba =
                new com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije.TOsoba(
                        pacijent.getJMBG(),
                        pacijentInfo.getIme(),
                        pacijentInfo.getPrezime(),
                        pol, datumRodjenja,
                        obrazac.getDokumentInfo().getIdPodnosioca().getValue());

        potvrda.setOsoba(osoba);

        List<ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.Doza> spisakDoza = obrazac.getEvidencijaVakcinacija().getTabela().getDoza();
        List<TDoza> spisakDozaZaPotvrdu = new ArrayList<>();

        for (ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.Doza doza : spisakDoza) {
            TDoza novaDoza = new TDoza(
                    doza.getTip().getValue().value(),
                    doza.getProizvodjac().getValue().value(),
                    doza.getDatum().getValue(),
                    doza.getBrojSerije().getValue(),
                    doza.getBrojDoze().getValue(),
                    obrazac.getEvidencijaVakcinacija().getUstanova().getNaziv(),
                    obrazac.getEvidencijaVakcinacija().getUstanova().getPunkt());
            spisakDozaZaPotvrdu.add(novaDoza);
        }
        potvrda.setDoze(new PotvrdaVakcinacije.Doze(spisakDozaZaPotvrdu));

        potvrda.setQrLink("nekilink.com"); // todo: generisanje qr koda

        potvrda.setDatumIzdavanja(LocalDate.now());

        potvrda.setDokumentId(uuidHelper.getUUID());
        return potvrda;
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

    public void handleMetadata(PotvrdaVakcinacije potvrda, Long idObrascaSaglasnosti) {
        potvrda.setAbout(String.format("http://www.rokzasok.rs/rdf/database/potvrda-vakcinacije/%d", potvrda.getDokumentId()));
        potvrda.setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        potvrda.setRel("pred:prethodniDokument");
        potvrda.setHref(String.format("http://www.rokzasok.rs/rdf/database/obrazac-saglasnosti/%s", idObrascaSaglasnosti));


        potvrda.getOsoba().getId().setProperty("pred:kreiranOdStrane");
        potvrda.getOsoba().getId().setDatatype("xs:#string");

        potvrda.getDatumIzdavanja().setDatatype("xs:#date");
        potvrda.getDatumIzdavanja().setProperty("pred:datumKreiranja");

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ByteArrayInputStream generatePDF_FO(Long dokumentId) throws IOException, SAXException, JAXBException {
        String xslFile = "src/main/resources/data/xsl-transformations/potvrda_vakcinacije_fo.xsl";
        String outputPdfFile = "src/main/resources/data/xsl-transformations/generated/output-pdf/potvrda.pdf";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml-fo/potvrda.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSL_FO_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_PDF(outputPdfFile);

        PotvrdaVakcinacije potvrda = this.findById(dokumentId);
        try {
            this.potvrdaVakcinacijeXmlConversionAgent.marshallToFile(potvrda, this.jaxbContextPath, outputXmlFile);
            xslTransformer.generatePDF_FO(outputXmlFile);
            return new ByteArrayInputStream(FileUtils.readFileToByteArray(new File(outputPdfFile)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
