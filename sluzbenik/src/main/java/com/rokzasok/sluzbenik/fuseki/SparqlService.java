package com.rokzasok.sluzbenik.fuseki;

import com.rokzasok.sluzbenik.fuseki.util.SparqlAuthenticationUtilities;
import com.rokzasok.sluzbenik.fuseki.util.SparqlUtil;
import com.rokzasok.sluzbenik.helper.RDFDBConnectionProperties;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SparqlService {
    private static final String SPARQL_NAMED_GRAPH_URI = "/example/sparql/metadata";
    public static SparqlAuthenticationUtilities.ConnectionProperties conn;
    @Autowired
    private RDFDBConnectionProperties rdfdbConnectionProperties;


    public List<SparqlQueryResult> getBrojDigitalnihSertifikataUVremenskomPeriodu(String d1, String d2) throws IOException {
        System.out.println("[INFO] Retrieving broj digitalnih sertifikata od " + d1 + " do " + d2 + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectBrojDigitalnihSertifikataUVremenskomPeriodu(d1, d2, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    public List<SparqlQueryResult> getAllKreiranOdStrane(String osobaId) throws IOException {
        System.out.println("[INFO] Retrieving dokument kreiranOdStrane " + osobaId + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectKreiranOdStrane(osobaId, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    public List<SparqlQueryResult> getPrethodniDokumenti(String dokumentURI) throws IOException {
        System.out.println("[INFO] Retrieving prethodni dokument " + dokumentURI + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectReferenciraniDokumenti(dokumentURI, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    public List<SparqlQueryResult> getIzvedeniDokumenti(String dokumentURI) throws IOException {
        System.out.println("[INFO] Retrieving izvedeni dokumenti " + dokumentURI + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectDokumentiKojiReferenciraju(dokumentURI, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    // parsiranje rezultata
    public List<SparqlQueryResult> getResults(String queryString) {

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(this.rdfdbConnectionProperties.getQueryEndpoint(), queryString);
        // Query the SPARQL endpoint, iterate over the result set...
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;
        List<SparqlQueryResult> retval = new ArrayList<>();

        while (results.hasNext()) {

            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                System.out.println(varName + ": " + varValue);

                SparqlQueryResult sparqlQueryResult = new SparqlQueryResult();
                sparqlQueryResult.setVarName(varName);
                sparqlQueryResult.setVarValue(varValue);
                retval.add(sparqlQueryResult);
            }
        }
        query.close();
        return retval;
    }

    public static class SparqlQueryResult {
        private String varName;

        private RDFNode varValue;

        public String getVarName() {
            return varName;
        }

        public void setVarName(String varName) {
            this.varName = varName;
        }

        public RDFNode getVarValue() {
            return varValue;
        }

        public void setVarValue(RDFNode varValue) {
            this.varValue = varValue;
        }
    }
}
