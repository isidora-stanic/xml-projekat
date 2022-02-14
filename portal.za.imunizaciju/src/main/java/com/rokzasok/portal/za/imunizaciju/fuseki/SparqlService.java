package com.rokzasok.portal.za.imunizaciju.fuseki;

import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlAuthenticationUtilities;
import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlUtil;
import com.rokzasok.portal.za.imunizaciju.helper.RDFDBConnectionProperties;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SparqlService {
    private static final String SPARQL_NAMED_GRAPH_URI = "/data/sparql/metadata";
    public static SparqlAuthenticationUtilities.ConnectionProperties conn;

    @Autowired
    private RDFDBConnectionProperties rdfdbConnectionProperties;

    // todo sredi da vrati nesto pametno
    public ResultSet getAllKreiranOdStrane(String osobaId) {
        System.out.println("[INFO] Retrieving dokument kreiranOdStrane " + osobaId +" from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectKreiranOdStrane(osobaId);
        System.out.println(sparqlQuery);
        QueryExecution query = QueryExecutionFactory.sparqlService("http://localhost:3030/eUpravaDataset", sparqlQuery);
        ResultSet results = query.execSelect();
        ResultSetFormatter.out(System.out, results);
        query.close();
        return results;
    }

    // todo sredi da vrati nesto pametno
    public ResultSet getAllOdDo(String d1, String d2) {
        System.out.println("[INFO] Retrieving dokument od " + d1 +" do " + d2 + " from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
        String sparqlQuery = SparqlUtil.selectAllDatumPodnosenja(d1, d2);
        System.out.println(sparqlQuery);
        QueryExecution query = QueryExecutionFactory.sparqlService("http://localhost:3030/eUpravaDataset", sparqlQuery);
        ResultSet results = query.execSelect();
        ResultSetFormatter.out(System.out, results);
        query.close();
        return results;
    }
}
