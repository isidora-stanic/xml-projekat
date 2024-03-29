package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.exception.EntityNotFoundException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.exception.InvalidXmlException;
import com.rokzasok.portal.za.imunizaciju.exception.XmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.helper.UUIDHelper;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiIzPretrageDTO;
import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiKorisnikaDTO;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import com.rokzasok.portal.za.imunizaciju.transformation.XSLTransformer;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_QUERY_FIND_ALL_ZAHTEV_ZA_SERTIFIKAT_EXPRESSION;
import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.X_UPDATE_REMOVE_ZAHTEV_ZA_SERTIFIKAT_BY_ID_EXPRESSION;

@Service
public class ZahtevZaSertifikatService implements AbstractXmlService<Zahtev> {
    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat";

    private static final String SPARQL_NAMED_GRAPH_URI = "/sparql/metadata";

    public static final String OUTPUT_FOLDER_XML = "output_xml";
    public static final String OUTPUT_FOLDER_PDF = "output_pdf";
    public static final String OUTPUT_FOLDER_HTML = "output_html";
    public static final String OUTPUT_FOLDER_METADATA = "output_metadata";

    @Autowired
    private AbstractXmlRepository<Zahtev> zahtevZaSertifikatRepository;

    @Autowired
    private XmlConversionAgent<Zahtev> zahtevZaSertifikatConverionAgent;

    @Autowired
    private UUIDHelper uuidHelper;

    @Autowired
    private RDFService rdfService;

    public void injectRepositoryProperties() {
        this.zahtevZaSertifikatRepository.injectRepositoryProperties(
                "/db/sample/zahtev_za_sertifikat",
                jaxbContextPath,
                X_QUERY_FIND_ALL_ZAHTEV_ZA_SERTIFIKAT_EXPRESSION,
                X_UPDATE_REMOVE_ZAHTEV_ZA_SERTIFIKAT_BY_ID_EXPRESSION);
    }

    @Override
    public List<Zahtev> findAll() {
        injectRepositoryProperties();

        try {
            return this.zahtevZaSertifikatRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(Zahtev.class, e.getMessage());
        }
    }

    @Override
    public Zahtev findById(Long entityId) {
        injectRepositoryProperties();

        try {
            Zahtev zahtev = this.zahtevZaSertifikatRepository.getEntity(entityId);
            if (zahtev == null) {
                throw new EntityNotFoundException(entityId, Zahtev.class);
            }
            return zahtev;
        } catch (JAXBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (XMLDBException e) {
            throw new InvalidXmlDatabaseException(Zahtev.class, e.getMessage());
        }
    }
    public Document getDocument(Long entityId) {
        injectRepositoryProperties();

        try {
            Zahtev zahtev = this.zahtevZaSertifikatRepository.getEntity(entityId);
            if (zahtev == null)
                throw new EntityNotFoundException(entityId, ObrazacInteresovanja.class);
            return zahtevZaSertifikatRepository.getDOMDoc(entityId);
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
    public Zahtev create(String entityXml) {
        injectRepositoryProperties();
        Zahtev zahtev;

        try {
            zahtev = this.zahtevZaSertifikatConverionAgent.unmarshall(entityXml, this.jaxbContextPath);
            zahtev.setDokumentId(this.uuidHelper.getUUID());
            this.handleMetadata(zahtev);
        } catch (JAXBException e) {
            throw new InvalidXmlException(Zahtev.class, e.getMessage());
        }

        try {
            zahtev = zahtevZaSertifikatRepository.createEntity(zahtev);
        } catch (JAXBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (XMLDBException e) {
            throw new InvalidXmlDatabaseException(Zahtev.class, e.getMessage());
        }

        try {
            entityXml = this.zahtevZaSertifikatConverionAgent.marshall(zahtev, this.jaxbContextPath);
            System.out.println(entityXml);
            if (!rdfService.save(entityXml, SPARQL_NAMED_GRAPH_URI)) {
                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
            }
        } catch (JAXBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
        return zahtev;
    }

    @Override
    public Zahtev update(String entityXml) {
        injectRepositoryProperties();

        Zahtev zahtev;
        try {
            zahtev = this.zahtevZaSertifikatConverionAgent.unmarshall(entityXml, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(Zahtev.class, e.getMessage());
        }
        try {
            if (!this.zahtevZaSertifikatRepository.updateEntity(zahtev)) {
                throw new EntityNotFoundException(zahtev.getDokumentId(), Zahtev.class);
            }
            return zahtev;

        } catch (JAXBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (XMLDBException e) {
            throw new InvalidXmlException(Zahtev.class, e.getMessage());
        }
    }

    @Override
    public String getRdfaString(Long dokumentId) throws JAXBException {
        injectRepositoryProperties();

        Zahtev dokument;
        dokument = this.findById(dokumentId);
        String entityXml = this.zahtevZaSertifikatConverionAgent.marshall(dokument, this.jaxbContextPath);
        System.out.println(entityXml);
        return entityXml;

    }

    @Override
    public boolean deleteById(Long entityId) {
        injectRepositoryProperties();
        try {
            return this.zahtevZaSertifikatRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }


    private void handleMetadata(Zahtev zahtev) {
        zahtev.setVocab("http://www.rokzasok.rs/rdf/database/predicate");
        zahtev.setAbout("http://www.rokzasok.rs/rdf/database/zahtev-za-sertifikat/" + zahtev.getDokumentId());

        zahtev.getRazlogPodnosenja().setDatatype("xs:#string");
        zahtev.getRazlogPodnosenja().setProperty("pred:razlogPodnosenja");

        zahtev.getMesto().setDatatype("xs:#string");
        zahtev.getMesto().setProperty("pred:mestoPodnosenja");

        zahtev.getDatum().setDatatype("xs:#date");
        zahtev.getDatum().setProperty("pred:datumKreiranja");

        zahtev.getPacijent().getId().setDatatype("xs:#string");
        zahtev.getPacijent().getId().setProperty("pred:kreiranOdStrane");


    }

    public ByteArrayInputStream generateHtml(Long dokumentId) throws IOException, SAXException {
        String xslFile = "src/main/resources/data/xsl-transformations/zahtev_za_sertifikat.xsl";
        String outputHtmlFile = "src/main/resources/data/xsl-transformations/generated/output-html/zahtev.html";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml/zahtev.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSLT_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_HTML(outputHtmlFile);

        Zahtev zahtev = this.findById(dokumentId);

        try {
            this.zahtevZaSertifikatConverionAgent.marshallToFile(
                    zahtev,
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
        String xslFile = "src/main/resources/data/xsl-transformations/zahtev_za_sertifikat.xsl";
        String outputHtmlFile = "src/main/resources/data/xsl-transformations/generated/output-html/zahtev.html";
        String outputPdfFile = "src/main/resources/data/xsl-transformations/generated/output-pdf/zahtev.pdf";
        String outputXmlFile = "src/main/resources/data/xsl-transformations/generated/output-xml-fo/zahtev.xml";

        XSLTransformer xslTransformer = new XSLTransformer();
        xslTransformer.setXSLT_FILE(xslFile);
        xslTransformer.setOUTPUT_FILE_HTML(outputHtmlFile);
        xslTransformer.setOUTPUT_FILE_PDF(outputPdfFile);

        Zahtev zahtev = this.findById(dokumentId);
        try {
            this.zahtevZaSertifikatConverionAgent.marshallToFile(
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

    public DokumentiIzPretrageDTO getNeobradjeni() {
        DokumentiIzPretrageDTO zahtevi = new DokumentiIzPretrageDTO();
        zahtevi.setQuery("neobradjeni");
        zahtevi.setListaDokumenata(new ArrayList<>());
        List<Zahtev> neobradjeni = findAll().stream().filter(z -> z.getStatus() == null).collect(Collectors.toList());
        for (Zahtev z : neobradjeni) {
            zahtevi.getListaDokumenata().add(new DokumentiKorisnikaDTO.DokumentDTO("zahtev-za-sertifikat/"+z.getDokumentId(), z.getTipDokumenta(), z.getDatumKreiranja()));
        }
        return zahtevi;
    }

    public Zahtev odbijZahteviZaSert(Long id) throws JAXBException {
        Zahtev zahtev = findById(id);
        zahtev.setStatus(new Zahtev.Status());
        zahtev.getStatus().setValue(false);
        zahtev.getStatus().setDatatype("xs:#boolean");
        zahtev.getStatus().setProperty("pred:status");
        String zahtevXML = this.zahtevZaSertifikatConverionAgent.marshall(zahtev, this.jaxbContextPath);
        Zahtev z = update(zahtevXML);
        return z;
    }

    public Zahtev prihvatiZahteviZaSert(Long id) throws JAXBException {
        Zahtev zahtev = findById(id);
        zahtev.setStatus(new Zahtev.Status());
        zahtev.getStatus().setValue(true);
        zahtev.getStatus().setDatatype("xs:#boolean");
        zahtev.getStatus().setProperty("pred:status");
        String zahtevXML = this.zahtevZaSertifikatConverionAgent.marshall(zahtev, this.jaxbContextPath);
        Zahtev z = update(zahtevXML);
        return z;
    }
}
