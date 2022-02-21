package com.rokzasok.portal.za.imunizaciju.fuseki;

import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlAuthenticationUtilities;
import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlUtil;
import com.rokzasok.portal.za.imunizaciju.helper.RDFDBConnectionProperties;
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
    private static final String SPARQL_NAMED_GRAPH_URI = "/data/sparql/metadata";
    public static SparqlAuthenticationUtilities.ConnectionProperties conn;

    @Autowired
    private RDFDBConnectionProperties rdfdbConnectionProperties;

    public List<SparqlQueryResult> getAllKreiranOdStrane(String osobaId) throws IOException {
        System.out.println("[INFO] Retrieving dokument kreiranOdStrane " + osobaId + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectKreiranOdStrane(osobaId, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    // todo sredi da vrati nesto pametno
    public List<SparqlQueryResult> getAllOdDo(String d1, String d2) throws IOException {
        System.out.println("[INFO] Retrieving dokument od " + d1 + " do " + d2 + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectAllDatumPodnosenja(d1, d2, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    // za izvestaj
    public List<SparqlQueryResult> selectBrojIskazaInteresovanjaUVremenskomPeriodu(String d1, String d2) throws IOException {
        System.out.println("[INFO] Retrieving broj interesovanja od " + d1 + " do " + d2 + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectBrojIskazaInteresovanjaUVremenskomPeriodu(d1, d2, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    public List<SparqlQueryResult> selectBrojZahtevaZaSertifikatUVremenskomPeriodu(String d1, String d2) throws IOException {
        System.out.println("[INFO] Retrieving broj zahteva od " + d1 + " do " + d2 + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectBrojZahtevaZaSertifikatUVremenskomPeriodu(d1, d2, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    public List<SparqlQueryResult> selectBrojPotvrdaVakcinacijeUVremenskomPeriodu(String d1, String d2) throws IOException {
        System.out.println("[INFO] Retrieving broj potvrda od " + d1 + " do " + d2 + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectBrojPotvrdaVakcinacijeUVremenskomPeriodu(d1, d2, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    public List<SparqlQueryResult> getBrojPrimljenihXDoza(String d1, String d2, String brDoze) throws IOException {
        System.out.println("[INFO] Retrieving broj potvrda od " + d1 + " do " + d2 + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.getBrojPrimljenihXDoza(d1, d2, brDoze, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }

    public List<SparqlQueryResult> getBrojPoProizvodjacima(String d1, String d2, String proizvodjac) throws IOException {
        System.out.println("[INFO] Retrieving broj potvrda od " + d1 + " do " + d2 + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.getBrojPoProizvodjacima(d1, d2, proizvodjac, rdfdbConnectionProperties.getDataEndpoint());
        System.out.println(sparqlQuery);

        return getResults(sparqlQuery);
    }


    // parsiranje rezultata
    public List<SparqlQueryResult> getResults(String queryString) throws IOException {

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
