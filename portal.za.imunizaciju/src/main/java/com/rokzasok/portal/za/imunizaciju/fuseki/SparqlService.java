package com.rokzasok.portal.za.imunizaciju.fuseki;

import com.rokzasok.portal.za.imunizaciju.fuseki.util.MetadataExtractor;
import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlAuthenticationUtilities;
import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlUtil;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class SparqlService {
    private static final String SPARQL_NAMED_GRAPH_URI = "/example/sparql/metadata";
    public static SparqlAuthenticationUtilities.ConnectionProperties conn;

    public static void main(String[] args) throws Exception {
        // run(AuthenticationUtilities.loadProperties());
    }

    public void createRdf(String xmlName) throws IOException, SAXException, TransformerException {

        System.out.println("[INFO] " + SparqlService.class.getSimpleName());

        // Referencing XML file with RDF data in attributes
        String xmlFilePath = String.format("./eUprava/src/main/resources/data/%s.xml", xmlName);

        String rdfFilePath = String.format("./eUprava/src/main/resources/data/rdfa/%s.rdf", xmlName);

        // Automatic extraction of RDF triples from XML file
        MetadataExtractor metadataExtractor = new MetadataExtractor();

        System.out.println("[INFO] Extracting metadata from RDFa attributes...");
        metadataExtractor.extractMetadata(
                new FileInputStream(xmlFilePath),
                new FileOutputStream(rdfFilePath));


        // Loading a default model with extracted metadata
        Model model = ModelFactory.createDefaultModel();
        model.read(rdfFilePath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);


        // Writing the named graph
        System.out.println("[INFO] Populating named graph \"" + SPARQL_NAMED_GRAPH_URI + "\" with extracted metadata.");
        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, out.toString());
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();



        // Read the triples from the named graph
        System.out.println();
        System.out.println("[INFO] Retrieving triples from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");

        System.out.println("[INFO] Selecting the triples from the named graph \"" + SPARQL_NAMED_GRAPH_URI + "\".");
        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);


        // Query the collection, dump output response as XML
        ResultSet results = query.execSelect();

        ResultSetFormatter.out(System.out, results);

        query.close() ;

        System.out.println("[INFO] End.");
    }
}
