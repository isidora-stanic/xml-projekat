package com.rokzasok.sluzbenik.fuseki.util;

public class SparqlUtil {


    /* The following operation causes all of the triples in all of the graphs to be deleted */
    private static final String DROP_ALL = "DROP ALL";

    /* Removes all of the triples from a named graphed */
    private static final String DROP_GRAPH_TEMPLATE = "DROP GRAPH <%s>";

    /**
     * A template for creating SPARUL (SPARQL Update) query can be found here:
     * https://www.w3.org/TR/sparql11-update/
     */
    /* Insert RDF data into the default graph */
    private static final String UPDATE_TEMPLATE = "INSERT DATA { %s }";

    /* Insert RDF data to an arbitrary named graph */
    private static final String UPDATE_TEMPLATE_NAMED_GRAPH = "INSERT DATA { GRAPH <%1$s> { %2$s } }";


    /* Simple SPARQL query on a named graph */
    private static final String SELECT_NAMED_GRAPH_TEMPLATE = "SELECT * FROM <%1$s> WHERE { %2$s }";

    private static final String SELECT_DISTINCT_NAMED_GRAPH_TEMPLATE = "SELECT DISTINCT ?s FROM <%1$s> WHERE { %2$s }";

    private static final String SELECT_OBJECT_ONLY_NAMED_GRAPH_TEMPLATE = "SELECT ?o FROM <%1$s> WHERE { %2$s }";

    private static final String SELECT_PREDICATE_AND_OBJECT_NAMED_GRAPH_TEMPLATE = "SELECT ?p ?o FROM <%1$s> WHERE { %2$s }";

    private static final String DESCRIBE_NAMED_GRAPH_TEMPLATE = "DESCRIBE <%1$s> FROM <%2$s> WHERE { %3$s }";

    /* Plain text RDF serialization format */
    public static final String NTRIPLES = "N-TRIPLES";

    /* An XML serialization format for RDF data */
    public static final String RDF_XML = "RDF/XML";

    /* An JSON serialization format for RDF data */
    public static final String RDF_JSON = "RDF/JSON";

    public String dropAll() {
        return DROP_ALL;
    }

    public String dropGraph(String graphURI) {
        return String.format(DROP_GRAPH_TEMPLATE, graphURI);
    }

    /* Inserts data to the default graph */
    public String insertData(String ntriples) {
        return String.format(UPDATE_TEMPLATE, ntriples);
    }

    public static String insertData(String graphURI, String ntriples) {
        return String.format(UPDATE_TEMPLATE_NAMED_GRAPH, graphURI, ntriples);
    }

    public static String selectData(String graphURI, String sparqlCondition) {
        return String.format(SELECT_NAMED_GRAPH_TEMPLATE, graphURI, sparqlCondition);
    }

    public String selectObjectOnly(String graphURI, String sparqlCondition) {
        return String.format(SELECT_OBJECT_ONLY_NAMED_GRAPH_TEMPLATE, graphURI, sparqlCondition);
    }

    public String selectPredicateAndObject(String graphURI, String sparqlCondition) {
        return String.format(SELECT_PREDICATE_AND_OBJECT_NAMED_GRAPH_TEMPLATE, graphURI, sparqlCondition);
    }

    public String describe(String type, String graphURI, String sparqlCondition) {
        return String.format(DESCRIBE_NAMED_GRAPH_TEMPLATE, type, graphURI, sparqlCondition);
    }

    public static String selectDistinctData(String graphURI, String sparqlCondition) {
        return String.format(SELECT_DISTINCT_NAMED_GRAPH_TEMPLATE, graphURI, sparqlCondition);
    }

    public static String selectBrojDigitalnihSertifikataUVremenskomPeriodu(String d1, String d2, String dataEndpointString) {
        return "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "\n" +
                "SELECT (count(?dokument) as ?brDokumenata) FROM <" + dataEndpointString + "/sparql/metadata>\n" +
                "WHERE {\n" +
                "  ?dokument <http://www.rokzasok.rs/rdf/database/predicate/datumKreiranja> ?date .\n" +
                "  FILTER (?date >= \"" + d1 + "\"^^xsd:date && ?date <= \"" + d2 + "\"^^xsd:date) .\n" +
                "  FILTER regex(str(?dokument), \".digitalni-sertifikat.\") .\n" +
                "}";
    }

    public static String selectKreiranOdStrane(String osobaId, String dataEndpointString) {
        return "SELECT * FROM <" + dataEndpointString + "/sparql/metadata>\n" +
                "WHERE {\n" +
                "  ?dokument <http://www.rokzasok.rs/rdf/database/predicate/kreiranOdStrane> \"" + osobaId + "\" ; " +
                "  <http://www.rokzasok.rs/rdf/database/predicate/datumKreiranja> ?date .\n" +
                "}";
    }

    public static String selectReferenciraniDokumenti(String dokumentUri, String dataEndpointString) {
        return "SELECT * FROM <" + dataEndpointString + "/sparql/metadata>\n" +
                "WHERE {\n" +
                "  <http://www.rokzasok.rs/rdf/database/" + dokumentUri + "> <http://www.rokzasok.rs/rdf/database/predicate/prethodniDokument> ?dokument \n" +
                "}";
    }

    public static String selectDokumentiKojiReferenciraju(String dokumentUri, String dataEndpointString) {
        return "SELECT * FROM <" + dataEndpointString + "/sparql/metadata>\n" +
                "WHERE {\n" +
                "  ?dokument <http://www.rokzasok.rs/rdf/database/predicate/prethodniDokument> <http://www.rokzasok.rs/rdf/database/zahtev-za-sertifikat/6015179123301212231>\n" +
                "}";
    }


}
