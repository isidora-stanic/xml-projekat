package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.fuseki.util.MetadataExtractor;
import com.rokzasok.sluzbenik.fuseki.util.SparqlUtil;
import com.rokzasok.sluzbenik.helper.RDFDBConnectionProperties;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.web.HttpOp;
import org.apache.jena.sparql.resultset.ResultsFormat;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class RDFService {

    @Autowired
    private RDFDBConnectionProperties rdfdbConnectionProperties;

    @PostConstruct
    public void initAuth(){
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials("admin", System.getenv("RDF_DB_PASSWORD"));
        credsProvider.setCredentials(AuthScope.ANY, credentials);
        HttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        HttpOp.setDefaultHttpClient(httpclient);
    }

    // From a RDFa XML file extracts RDF/XML
    public boolean save(String rdfa, String named_graph_uri) {
        String tmpFilename = "" + System.currentTimeMillis() + ".xml";
        try {
            // TODO SKLONI OVAJ KOD
            PrintWriter p = new PrintWriter(new FileOutputStream(tmpFilename, true));
            p.println(rdfa);
            p.close();

            MetadataExtractor metadataExtractor = new MetadataExtractor();
            ByteArrayOutputStream xmlrdf = new ByteArrayOutputStream();
            System.out.println("[INFO] Extracting metadata from RDFa attributes...");
            metadataExtractor.extractMetadata(
                    new FileInputStream(new File(tmpFilename)),
                    xmlrdf);
            FileOutputStream xmlrdfOut = new FileOutputStream(new File(tmpFilename));
            xmlrdfOut.write(xmlrdf.toByteArray());
        } catch (IOException | SAXException | TransformerException e1) {
            e1.printStackTrace();
            return false;
        }

        // Loading a default model with extracted metadata
        Model model = ModelFactory.createDefaultModel();
        try {
            FileInputStream xmlrdfIn = new FileInputStream(new File(tmpFilename));
            model.read(xmlrdfIn, "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream outNTRIPLES = new ByteArrayOutputStream();
        model.write(outNTRIPLES, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);

        // Writing the named graph
        System.out.println("[INFO] Populating named graph \"" + named_graph_uri + "\" with extracted metadata.");
        String sparqlUpdate = SparqlUtil.insertData(rdfdbConnectionProperties.getDataEndpoint() + named_graph_uri, new String(outNTRIPLES.toByteArray()));
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, "http://localhost:3030/eUpravaDataset");//rdfdbConnectionProperties.getUpdateEndpoint());

        System.out.println(rdfdbConnectionProperties.getUpdateEndpoint());

        processor.execute();

        String res = getRDFAsJSON(rdfa);
        System.out.println("RESULT AS JSON:" + res);

        try {
            res = getRDFAsRDF(rdfa);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("RESULT AS RDF/XML:" + res);

        return true;
    }

    public String getRDFAsRDF(String rdfa) throws IOException, SAXException, TransformerException {
//        MetadataExtractor metadataExtractor = new MetadataExtractor();
//        ByteArrayOutputStream xmlrdf = new ByteArrayOutputStream();
//        System.out.println("[INFO] Extracting metadata from RDFa attributes...");
//        //String rdf = "";
//        InputStream targetStream = new ByteArrayInputStream(rdfa.getBytes());
//        metadataExtractor.extractMetadata(
//                targetStream,
//                xmlrdf);
//        System.out.println(xmlrdf);
//        return xmlrdf.toString();
        Model model = ModelFactory.createDefaultModel();
        InputStream xmlrdfIn = new ByteArrayInputStream(rdfa.getBytes());
        model.read(xmlrdfIn, "");

        ByteArrayOutputStream outNTRIPLES = new ByteArrayOutputStream();
        model.write(outNTRIPLES, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);
        return outNTRIPLES.toString();
    }

    public String getRDFAsJSON(String rdfa) {
        Model model = ModelFactory.createDefaultModel();
        InputStream xmlrdfIn = new ByteArrayInputStream(rdfa.getBytes());
        model.read(xmlrdfIn, "");

        ByteArrayOutputStream outNTRIPLES = new ByteArrayOutputStream();
        model.write(outNTRIPLES, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_JSON);

        return outNTRIPLES.toString();
    }

    public RDFDBConnectionProperties getRdfdbConnectionProperties() {
        return rdfdbConnectionProperties;
    }

    public void setRdfdbConnectionProperties(RDFDBConnectionProperties rdfdbConnectionProperties) {
        this.rdfdbConnectionProperties = rdfdbConnectionProperties;
    }

    public void runAndExportInGivenFormat(String sparqlQuery, String outputFilePath, ResultsFormat resultsFormat) {
        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(this.rdfdbConnectionProperties.getQueryEndpoint(), sparqlQuery);
        // Query the SPARQL endpoint, iterate over the result set...
        ResultSet results = query.execSelect();

        OutputStream output = null;
        try {
            output = new FileOutputStream(outputFilePath);
            ResultSetFormatter.output(output, results, resultsFormat);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        query.close();
    }

    public void runAndExportInNativeFormat(String sparqlQuery, String filePath) {
        QueryExecution query = QueryExecutionFactory.sparqlService(this.rdfdbConnectionProperties.getQueryEndpoint(), sparqlQuery);
        Model model = query.execDescribe();
        try {
            model.write(new FileOutputStream(filePath), "TURTLE");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        query.close();
    }

    /**
     * Pretraga metapodataka*/
    public ArrayList<String> search(String collection, String text) {
        String sparqlQuery = SparqlUtil.selectDistinctData(
                rdfdbConnectionProperties.getDataEndpoint() + collection,
                String.format("?s ?p ?o . filter (LCASE(str(?o))=%s)", text));

        return getDocumentsId(sparqlQuery);
    }

    public ArrayList<String> getDocumentsId(String sparqlQuery) {
        ArrayList<String> ids = new ArrayList<String>();

        System.out.println("Query: " + sparqlQuery);

        QueryExecution queryExecution = QueryExecutionFactory
                .sparqlService(this.rdfdbConnectionProperties.getQueryEndpoint(), sparqlQuery);

        ResultSet results = queryExecution.execSelect();

        String varName;
        RDFNode varValue;

        while (results.hasNext()) {


            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();
            System.out.println("Result: " + querySolution);

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                System.out.println("variable binding: " + varName + varValue);
                ids.add(varValue.toString());
            }
        }

        queryExecution.close();
        return ids;
    }
}
