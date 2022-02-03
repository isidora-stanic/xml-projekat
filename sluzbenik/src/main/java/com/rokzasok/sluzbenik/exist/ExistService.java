package com.rokzasok.sluzbenik.exist;

import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Service;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

@Service
public class ExistService {

    public static www.rokzasok.rs.euprava.exist.AuthenticationUtilities.ConnectionProperties conn;

    public static final HashMap<String, HashMap<String, String>> argumenti = new HashMap<String, HashMap<String, String>>() {{
        put("iskazivanje-interesovanja", new HashMap<String, String>() {{
            put("existdb-route", "/db/gradjanin/iskazivanje-interesovanja");
            put("primer-route","./eUprava/src/main/resources/data/iskazivanje_interesovanja_primer.xml");
            put("class-name", "ObrazacInteresovanja");
            put("package-route","www.rokzasok.rs.euprava.gradjanin.iskazivanje_interesovanja");}});
        put("obrazac-saglasnosti", new HashMap<String, String>() {{
            put("existdb-route", "/db/gradjanin/obrazac-saglasnosti");
            put("primer-route","./eUprava/src/main/resources/data/obrazac_saglasnosti_primer.xml");
            put("class-name", "ObrazacSaglasnosti");
            put("package-route","www.rokzasok.rs.euprava.gradjanin.obrazac_saglasnosti");}});
        put("zahtev-za-sertifikat", new HashMap<String, String>() {{
            put("existdb-route", "/db/gradjanin/zahtev-za-sertifikat");
            put("primer-route","./eUprava/src/main/resources/data/zahtev_za_sertifikat_primer.xml");
            put("class-name", "Zahtev");
            put("package-route","www.rokzasok.rs.euprava.gradjanin.zahtev_za_sertifikat");}});
        put("digitalni-sertifikat", new HashMap<String, String>() {{
            put("existdb-route", "/db/sluzbenik/digitalni-sertifikat");
            put("primer-route","./eUprava/src/main/resources/data/digitalni_sertifikat_primer.xml");
            put("class-name", "DigitalniSertifikat");
            put("package-route","www.rokzasok.rs.euprava.sluzbenik.digitalni_sertifikat");}});
        put("izvestaj-o-imunizaciji", new HashMap<String, String>() {{
            put("existdb-route", "/db/sluzbenik/izvestaj-o-imunizaciji");
            put("primer-route","./eUprava/src/main/resources/data/izvestaj_o_imunizaciji_primer.xml");
            put("class-name", "IzvestajOImunizaciji");
            put("package-route","www.rokzasok.rs.euprava.sluzbenik.izvestaj_o_imunizaciji");}});
        put("potvrda-vakcinacije", new HashMap<String, String>() {{
            put("existdb-route", "/db/zdravstveni-radnik/potvrda-vakcinacije");
            put("primer-route","./eUprava/src/main/resources/data/potvrda_vakcinacije_primer.xml");
            put("class-name", "PotvrdaVakcinacije");
            put("package-route","www.rokzasok.rs.euprava.zdravstveni_radnik.potvrda_vakcinacije");}});
    }};

    public void store(Object objToStoreInXml, String obrazacName) throws Exception {

        System.out.println("[INFO] Storing " + obrazacName.toUpperCase().replace('-', ' '));

        // initialize collection and document identifiers
        String collectionId = null;
        String documentId = null;
        String filePath = null;
        Class parserClass = null;
        String jaxbContext = null;

        collectionId = argumenti.get(obrazacName).get("existdb-route");

        try {
            documentId = objToStoreInXml.getClass()
                    .getDeclaredMethod("getDokumentId").invoke(objToStoreInXml).toString();
            System.out.println("try - " + documentId);
        } catch (Exception e) {
            Object documentInfo = objToStoreInXml.getClass()
                    .getDeclaredMethod("getDokumentInfo").invoke(objToStoreInXml);
            System.out.println(documentInfo);
            documentId = documentInfo.getClass().getDeclaredMethod("getDokumentId").invoke(documentInfo).toString();
            System.out.println("catch - " + documentId);
        } finally {
            if (documentId == null)
                documentId = "1.xml";
        }

        filePath = argumenti.get(obrazacName).get("primer-route");
        jaxbContext = argumenti.get(obrazacName).get("package-route");

        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- file path: " + filePath);
        System.out.println("\t- document ID: " + documentId + "\n");

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);


        // encapsulation of the database driver functionality
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        // entry point for the API which enables you to get the Collection reference
        DatabaseManager.registerDatabase(database);

        // a collection of Resources stored within an XML database
        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();

        try {

            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = getOrCreateCollection(collectionId);

            /*
             *  create new XMLResource with a given id
             *  an id is assigned to the new resource if left empty (null)
             */

            System.out.println("[INFO] Inserting the document: " + documentId + ".xml");
            res = (XMLResource) col.createResource(documentId + ".xml", XMLResource.RESOURCE_TYPE);

            JAXBContext context = JAXBContext.newInstance(jaxbContext);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // marshal the contents to an output stream
            marshaller.marshal(objToStoreInXml.getClass().cast(objToStoreInXml), os);

            // link the stream to the XML resource
            res.setContent(os);
            System.out.println("[INFO] Storing the document: " + res.getId());

            col.storeResource(res);
            System.out.println("[INFO] Done.");

        } finally {

            //don't forget to cleanup
            if (res != null) {
                try {
                    ((EXistResource) res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }

            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
    }

    public void retrieve(String obrazacName, String documentId) throws Exception {


        System.out.println("[INFO] Revtrieving " + obrazacName.toUpperCase().replace('-', ' ') + " [dokumentId = "+ documentId + "]");

        // initialize collection and document identifiers
        String collectionId = null;
        Class parserClass = null;
        String jaxbContext = null;


            System.out.println("[INFO] Passing the arguments... ");

            collectionId = argumenti.get(obrazacName).get("existdb-route");
            parserClass = Class.forName(argumenti.get(obrazacName).get("package-route") + "." + argumenti.get(obrazacName).get("class-name"));
            jaxbContext = argumenti.get(obrazacName).get("package-route");

        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- document ID: " + documentId + "\n");

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;
        XMLResource res = null;

        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            System.out.println("[INFO] Retrieving the document: " + documentId);
            res = (XMLResource)col.getResource(documentId + ".xml");

            if(res == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {

                System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");
                JAXBContext context = JAXBContext.newInstance(jaxbContext);

                Unmarshaller unmarshaller = context.createUnmarshaller();

                Object obrazac = parserClass.cast(unmarshaller.unmarshal(res.getContentAsDOM()));

                System.out.println("[INFO] Showing the document as JAXB instance: ");
                System.out.println(obrazac);// todo return this

            }
        } finally {
            //don't forget to clean up!

            if(res != null) {
                try {
                    ((EXistResource)res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }

            if(col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
    }

    private static Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
        return getOrCreateCollection(collectionUri, 0);
    }

    private static Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset) throws XMLDBException {

        Collection col = DatabaseManager.getCollection(conn.uri + collectionUri, conn.user, conn.password);

        // create the collection if it does not exist
        if (col == null) {

            if (collectionUri.startsWith("/")) {
                collectionUri = collectionUri.substring(1);
            }

            String pathSegments[] = collectionUri.split("/");

            if (pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();

                for (int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/" + pathSegments[i]);
                }

                Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);

                if (startCol == null) {

                    // child collection does not exist

                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);

                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");

                    System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);

                    col.close();
                    parentCol.close();

                } else {
                    startCol.close();
                }
            }
            return getOrCreateCollection(collectionUri, ++pathSegmentOffset);
        } else {
            return col;
        }
    }
}
