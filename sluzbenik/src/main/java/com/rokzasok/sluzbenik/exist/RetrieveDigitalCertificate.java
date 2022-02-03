package com.rokzasok.sluzbenik.exist;

import org.exist.xmldb.EXistResource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import www.rokzasok.rs.euprava.sluzbenik.digitalni_sertifikat.DigitalniSertifikat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;

public class RetrieveDigitalCertificate {
    
	public static void main(String[] args) throws Exception {
		RetrieveDigitalCertificate.run(www.rokzasok.rs.euprava.exist.AuthenticationUtilities.loadProperties(), args);
	}
    
    /**
     * conn XML DB connection properties
     * args[0] Should be the collection ID to access
     * args[1] Should be the document ID to store in the collection
     */
    public static void run(www.rokzasok.rs.euprava.exist.AuthenticationUtilities.ConnectionProperties conn, String args[]) throws Exception {
       

    	System.out.println("[INFO] " + RetrieveDigitalCertificate.class.getSimpleName());
    	
    	// initialize collection and document identifiers
        String collectionId = null;
		String documentId = null; 
        
        if (args.length == 2) {
        	
        	System.out.println("[INFO] Passing the arguments... ");
        	
        	collectionId = args[0];
        	documentId = args[1];
        } else {
        	
        	System.out.println("[INFO] Using defaults.");
        	
        	collectionId = "/db/sluzbenik/digitalni-sertifikat";
        	documentId = "digitalni_sertifikat_1.xml";
        }

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
            res = (XMLResource)col.getResource(documentId);
            
            if(res == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {
            	
            	System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");
                JAXBContext context = JAXBContext.newInstance("www.rokzasok.rs.euprava.sluzbenik.digitalni_sertifikat");
    			
    			Unmarshaller unmarshaller = context.createUnmarshaller();
    			
    			DigitalniSertifikat digitalniSertifikat = (DigitalniSertifikat) unmarshaller.unmarshal(res.getContentAsDOM());
    			
    			System.out.println("[INFO] Showing the document as JAXB instance: ");
    			System.out.println(digitalniSertifikat);
    			System.out.println("jmbg: " + digitalniSertifikat.getGradjanin().getJmbg());
    			
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
}