package com.rokzasok.sluzbenik.fuseki.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SparqlAuthenticationUtilities {
    static public class ConnectionProperties {

        public String endpoint;
        public String dataset;

        public String queryEndpoint;
        public String updateEndpoint;
        public String dataEndpoint;


        public ConnectionProperties(Properties props) {
            super();
            dataset = props.getProperty("rdfdb.conn.dataset").trim();
            endpoint = props.getProperty("rdfdb.conn.endpoint").trim();

            queryEndpoint = String.join("/", endpoint, dataset, props.getProperty("rdfdb.conn.query").trim());
            updateEndpoint = String.join("/", endpoint, dataset, props.getProperty("rdfdb.conn.update").trim());
            dataEndpoint = String.join("/", endpoint, dataset, props.getProperty("rdfdb.conn.data").trim());

            System.out.println("[INFO] Parsing connection properties:");
            System.out.println("[INFO] Query endpoint: " + queryEndpoint);
            System.out.println("[INFO] Update endpoint: " + updateEndpoint);
            System.out.println("[INFO] Graph store endpoint: " + dataEndpoint);
        }
    }

    /**
     * Read the configuration properties for the example.
     *
     * @return the configuration object
     */
    public static ConnectionProperties loadProperties() throws IOException {
        String propsName = "application.properties";

        InputStream propsStream = openStream(propsName);
        if (propsStream == null)
            throw new IOException("Could not read properties " + propsName);

        Properties props = new Properties();
        props.load(propsStream);

        return new ConnectionProperties(props);
    }

    /**
     * Read a resource for an example.
     *
     * @param fileName
     *            the name of the resource
     * @return an input stream for the resource
     * @throws IOException
     */
    public static InputStream openStream(String fileName) throws IOException {
        return SparqlAuthenticationUtilities.class.getClassLoader().getResourceAsStream(fileName);
    }
}
