package com.rokzasok.portal.za.imunizaciju.fuseki;

import com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.fuseki.util.MetadataExtractor;
import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlAuthenticationUtilities;
import com.rokzasok.portal.za.imunizaciju.fuseki.util.SparqlUtil;
import com.rokzasok.portal.za.imunizaciju.helper.RDFDBConnectionProperties;
import com.rokzasok.portal.za.imunizaciju.service.IskazivanjeInteresovanjaService;
import com.rokzasok.portal.za.imunizaciju.service.ObrazacSaglasnostiService;
import org.apache.jena.base.Sys;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
        System.out.println(results.hasNext());
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
