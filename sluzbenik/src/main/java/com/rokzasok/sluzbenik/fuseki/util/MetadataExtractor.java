package com.rokzasok.sluzbenik.fuseki.util;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.xml.sax.SAXException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class MetadataExtractor {
    private TransformerFactory transformerFactory;

    private static final String XSLT_FILE = "./src/main/resources/data/grddl.xsl";


    public MetadataExtractor() throws SAXException, IOException {

        // Setup the XSLT transformer factory
        transformerFactory = new TransformerFactoryImpl();
    }

    /**
     * Generates RDF/XML based on RDFa metadata from an XML containing
     * input stream by applying GRDDL XSL transformation.
     *
     * @param in XML containing input stream
     * @param out RDF/XML output stream
     */
    public void extractMetadata(InputStream in, OutputStream out) throws FileNotFoundException, TransformerException {

        // Create transformation source
        StreamSource transformSource = new StreamSource(new File(XSLT_FILE));

        // Initialize GRDDL transformer object
        Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);

        // Set the indentation properties
        grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Initialize transformation subject
        StreamSource source = new StreamSource(in);

        // Initialize result stream
        StreamResult result = new StreamResult(out);

        // Trigger the transformation
        grddlTransformer.transform(source, result);

    }


    public void test() throws Exception {

        System.out.println("[INFO] " + MetadataExtractor.class.getSimpleName());

        String filePath = "gen/grddl_metadata.rdf";

        InputStream in = new FileInputStream(new File("data/rdfa/contacts.xml"));

        OutputStream out = new FileOutputStream(filePath);

        extractMetadata(in, out);

        System.out.println("[INFO] File \"" + filePath + "\" generated successfully.");

        System.out.println("[INFO] End.");

    }

    public static void main(String[] args) throws Exception {
        new MetadataExtractor().test();
    }
}
