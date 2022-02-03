package com.rokzasok.sluzbenik.exist;

import org.exist.xmldb.EXistResource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import www.rokzasok.rs.euprava.exist.AuthenticationUtilities.*;
import www.rokzasok.rs.euprava.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import www.rokzasok.rs.euprava.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import www.rokzasok.rs.euprava.gradjanin.zahtev_za_sertifikat.Zahtev;
import www.rokzasok.rs.euprava.sluzbenik.digitalni_sertifikat.*;
import www.rokzasok.rs.euprava.zdravstveni_radnik.potvrda_vakcinacije.PotvrdaVakcinacije;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public class StoreAny {

    private static ConnectionProperties conn;

    public static void main(String[] args) throws Exception {
        args = new String[]{"/db/gradjanin/iskazivanje-interesovanja", "iskazivanje-interesovanja_x.xml", "./eUprava/src/main/resources/data/iskazivanje_interesovanja_primer.xml", "ObrazacInteresovanja", "www.rokzasok.rs.euprava.gradjanin.iskazivanje_interesovanja"};

        System.out.println("[INFO] Unmarshalling XML document to an JAXB instance: ");
        JAXBContext context = JAXBContext.newInstance("www.rokzasok.rs.euprava.gradjanin.iskazivanje_interesovanja");
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ObrazacInteresovanja obrazacInteresovanja = (ObrazacInteresovanja) unmarshaller.unmarshal(new File("./eUprava/src/main/resources/data/iskazivanje_interesovanja_primer.xml"));

        StoreAny.run(conn = www.rokzasok.rs.euprava.exist.AuthenticationUtilities.loadProperties(), obrazacInteresovanja, args);

        // obrazac saglasnosti
        args = new String[]{"/db/gradjanin/obrazac-saglasnosti", "obrazac_saglasnosti_x.xml", "./eUprava/src/main/resources/data/obrazac_saglasnosti_primer.xml", "ObrazacSaglasnosti", "www.rokzasok.rs.euprava.gradjanin.obrazac_saglasnosti"};

        System.out.println("opala stigli smo do obrasca saglasnosti");
        context = JAXBContext.newInstance("www.rokzasok.rs.euprava.gradjanin.obrazac_saglasnosti");
        unmarshaller = context.createUnmarshaller();

        ObrazacSaglasnosti obrazacSaglasnosti = (ObrazacSaglasnosti) unmarshaller.unmarshal(new File("./eUprava/src/main/resources/data/obrazac_saglasnosti_primer.xml"));
        StoreAny.run(conn = www.rokzasok.rs.euprava.exist.AuthenticationUtilities.loadProperties(), obrazacSaglasnosti, args);

        // zahtev za sertifikat
        args = new String[]{"/db/gradjanin/zahtev-za-sertifikat", "zahtev_za_sertifikat_x.xml", "./eUprava/src/main/resources/data/zahtev_za_sertifikat_primer.xml", "Zahtev", "www.rokzasok.rs.euprava.gradjanin.zahtev_za_sertifikat"};

        System.out.println("hajho hajho idemo zahtev za sertifikat");
        context = JAXBContext.newInstance("www.rokzasok.rs.euprava.gradjanin.zahtev_za_sertifikat");
        unmarshaller = context.createUnmarshaller();

        Zahtev zahtev = (Zahtev) unmarshaller.unmarshal(new File("./eUprava/src/main/resources/data/zahtev_za_sertifikat_primer.xml"));
        StoreAny.run(conn = www.rokzasok.rs.euprava.exist.AuthenticationUtilities.loadProperties(), zahtev, args);


        // potvrda o vakcinaciji
        args = new String[]{"/db/zdravstveni-radnik/potvrda-vakcinacije", "potvrda_vakcinacije_x.xml", "./eUprava/src/main/resources/data/potvrda_vakcinacije_primer.xml", "PotvrdaVakcinacije", "www.rokzasok.rs.euprava.zdravstveni_radnik.potvrda_vakcinacije"};

        System.out.println("ojhaaaa ovo je poslednji dokument - potvrda vakcinacije ");
        context = JAXBContext.newInstance("www.rokzasok.rs.euprava.zdravstveni_radnik.potvrda_vakcinacije");
        unmarshaller = context.createUnmarshaller();

        PotvrdaVakcinacije potvrda = (PotvrdaVakcinacije) unmarshaller.unmarshal(new File("./eUprava/src/main/resources/data/potvrda_vakcinacije_primer.xml"));
        StoreAny.run(conn = www.rokzasok.rs.euprava.exist.AuthenticationUtilities.loadProperties(), potvrda, args);


    }

    /**
     * conn XML DB connection properties
     * args[0] Should be the collection ID to access
     * args[1] Should be the document ID to store in the collection
     * args[2] Should be the document file path
     */
    public static void run(ConnectionProperties conn, Object obj, String args[]) throws Exception {

        System.out.println("[INFO] " + StoreDigitalCertificate.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String documentId = null;
        String filePath = null;
        Class parserClass = null;
        String jaxbContext = null;

        if (args.length > 0) {

            System.out.println("[INFO] Passing the arguments... ");

            collectionId = args[0];
            documentId = args[1];

            filePath = args[2];
            //parserClass = Class.forName(args[3]);
            jaxbContext = args[4];
        } else {

            System.out.println("[INFO] Using defaults.");

            collectionId = "/db/sluzbenik/digitalni-sertifikat";
            //documentId = "digitalni_sertifikat_1.xml";

            filePath = "./eUprava/src/main/resources/data/digitalni_sertifikat_primer.xml";

        }

        System.out.println("\t- collection ID: " + collectionId);
        //System.out.println("\t- document ID: " + documentId);
        System.out.println("\t- file path: " + filePath + "\n");

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

            // TODO JAXB UNMARSHAL FROM EXAMpLE
            //digitalCertificate.getGradjanin().setIme("Novo ime");
            //TOsobaDetailed gradjanin = new TOsobaDetailed();
            //TAdresa adresa = new TAdresa();
            //adresa.setBroj(1); adresa.setMesto("Novi Sad"); adresa.setUlica("Ulica");
            //gradjanin.setAdresa(adresa); gradjanin.setBrojPasosa("123456789"); gradjanin.setDatumRodjenja(new Date.of(LocalDate.of(1999, 12, 10))); gradjanin.setIme("Isidora"); gradjanin.setJmbg("1234567890123"); gradjanin.setPol(TPol.�); gradjanin.setPrezime("Stanic");
            //digitalCertificate.setGradjanin(gradjanin);
            //System.out.println("jmbg: " + digitalCertificate.getGradjanin().getJmbg());

            // todo: OVO OBAVEZNO MENJATI
//            try {
//                documentId = obj.getClass().getDeclaredMethod("getDokumentId").invoke(obj).toString();
//            } catch (Exception ex) {
//                documentId = obj.getClass().getDeclaredMethod("getDokumentInfo").invoke(obj).getClass().getDeclaredMethod("getDokumentId").invoke(obj).toString();
//            }

            documentId = "1";

            //documentId = "digitalni_sertifikat_" + digitalCertificate.getDokumentId().toString() + ".xml";
            System.out.println(obj.getClass().cast(obj));
            System.out.println("documentId = " + documentId);

            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

            JAXBContext context = JAXBContext.newInstance(jaxbContext);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // marshal the contents to an output stream
            marshaller.marshal(obj.getClass().cast(obj), os);

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
