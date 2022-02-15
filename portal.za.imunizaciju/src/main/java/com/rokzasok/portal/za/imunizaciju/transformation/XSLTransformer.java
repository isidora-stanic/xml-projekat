package com.rokzasok.portal.za.imunizaciju.transformation;

import net.sf.saxon.TransformerFactoryImpl;
import org.apache.fop.apps.FopFactory;
import org.springframework.util.ResourceUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XSLTransformer {
    private FopFactory fopFactory;

    private TransformerFactory transformerFactory;

    private static DocumentBuilderFactory documentFactory;

    private String XSLT_FILE;
    private String XSL_FO_FILE;
    private String OUTPUT_FILE_PDF;
    private String OUTPUT_FILE_HTML;

    public static final String FOP_CONF = "src/main/resources/fop.xconf";


    public XSLTransformer() throws SAXException, IOException{
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);
        // Initialize FOP factory object
        fopFactory = FopFactory.newInstance(ResourceUtils.getFile(FOP_CONF));
        // Setup the XSLT transformer factory
        transformerFactory = new TransformerFactoryImpl();
    }

    public String getXSLT_FILE() {
        return XSLT_FILE;
    }

    public void setXSLT_FILE(String XSLT_FILE) {
        this.XSLT_FILE = XSLT_FILE;
    }

    public String getXSL_FO_FILE() {
        return XSL_FO_FILE;
    }

    public void setXSL_FO_FILE(String XSL_FO_FILE) {
        this.XSL_FO_FILE = XSL_FO_FILE;
    }

    public String getOUTPUT_FILE_PDF() {
        return OUTPUT_FILE_PDF;
    }

    public void setOUTPUT_FILE_PDF(String OUTPUT_FILE_PDF) {
        this.OUTPUT_FILE_PDF = OUTPUT_FILE_PDF;
    }

    public String getOUTPUT_FILE_HTML() {
        return OUTPUT_FILE_HTML;
    }

    public void setOUTPUT_FILE_HTML(String OUTPUT_FILE_HTML) {
        this.OUTPUT_FILE_HTML = OUTPUT_FILE_HTML;
    }

    public void generateHTML(String inputFilePath) throws FileNotFoundException {
        try {
            // Initialize Transformer instance
            StreamSource transformSource = new StreamSource(ResourceUtils.getFile(this.XSLT_FILE));
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Generate XHTML
            transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

            // Transform DOM to HTML
            DOMSource source = new DOMSource(buildDocument(inputFilePath));
            StreamResult result = new StreamResult(new FileOutputStream(this.OUTPUT_FILE_HTML));
            transformer.transform(source, result);

        } catch (IOException | TransformerException | TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
    }

    public org.w3c.dom.Document buildDocument(String filePath) {
        org.w3c.dom.Document document = null;
        try {

            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            document = builder.parse(ResourceUtils.getFile(filePath));

            if (document != null)
                System.out.println("[INFO] File parsed with no errors.");
            else
                System.out.println("[WARN] Document is null.");

        } catch (Exception e) {
            return null;

        }

        return document;
    }

}
