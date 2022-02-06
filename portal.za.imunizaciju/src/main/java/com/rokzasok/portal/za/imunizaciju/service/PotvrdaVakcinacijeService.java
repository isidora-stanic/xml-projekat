package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.portal.za.imunizaciju.exist.EntityNotFoundException;
import com.rokzasok.portal.za.imunizaciju.exist.InvalidXmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.exist.InvalidXmlException;
import com.rokzasok.portal.za.imunizaciju.exist.XmlDatabaseException;
import com.rokzasok.portal.za.imunizaciju.helper.UUIDHelper;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.repository.AbstractXmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import java.util.List;

import static com.rokzasok.portal.za.imunizaciju.helper.XQueryExpressions.*;

@Service
public class PotvrdaVakcinacijeService implements AbstractXmlService<PotvrdaVakcinacije> {
    private final String jaxbContextPath = "com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije";

    private static final String SPARQL_NAMED_GRAPH_URI = "/potvrda_vakcinacije/sparql/metadata";

    public static final String OUTPUT_FOLDER_XML = "output_xml";
    public static final String OUTPUT_FOLDER_PDF = "output_pdf";
    public static final String OUTPUT_FOLDER_HTML = "output_html";
    public static final String OUTPUT_FOLDER_METADATA = "output_metadata";

    @Autowired
    private AbstractXmlRepository<PotvrdaVakcinacije> potvrdaVakcinacijeRepository;

    @Autowired
    private XmlConversionAgent<PotvrdaVakcinacije> potvrdaVakcinacijeXmlConversionAgent;

    @Autowired
    private UUIDHelper uuidHelper;

    @PostConstruct
    public void injectRepositoryProperties() {
        this.potvrdaVakcinacijeRepository.injectRepositoryProperties(
                "/db/sample/potvrda-vakcinacije",
                jaxbContextPath,
                X_QUERY_FIND_ALL_POTVRDE_O_VAKCINACIJI_EXPRESSION,
                X_UPDATE_REMOVE_POTVRDA_BY_ID_EXPRESSION
        );
    }

    @Override
    public List<PotvrdaVakcinacije> findAll() {
        try {
            return this.potvrdaVakcinacijeRepository.getAllEntities();
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(PotvrdaVakcinacije.class, e.getMessage());
        }
    }

    @Override
    public PotvrdaVakcinacije findById(Long entityId) {
        try {
            PotvrdaVakcinacije izvestaj = this.potvrdaVakcinacijeRepository.getEntity(entityId);
            if (izvestaj == null)
                throw new EntityNotFoundException(entityId, PotvrdaVakcinacije.class);
            return izvestaj;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(PotvrdaVakcinacije.class, e.getMessage());
        }
    }

    @Override
    public PotvrdaVakcinacije create(String entityXml) {
        PotvrdaVakcinacije potvrdaVakcinacije;

        try {
            potvrdaVakcinacije = this.potvrdaVakcinacijeXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
            potvrdaVakcinacije.setDokumentId(this.uuidHelper.getUUID());
            //this.handleMetadata(izvestaj);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new InvalidXmlException(ObrazacInteresovanja.class, e.getMessage());
        }

        try {
            potvrdaVakcinacije = potvrdaVakcinacijeRepository.createEntity(potvrdaVakcinacije);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(ObrazacInteresovanja.class, e.getMessage());
        }

    /*
        Save to RDF DB
        We marshall because we need RDFa (which was set by handleMetadata)
     */
        try {
            entityXml = this.potvrdaVakcinacijeXmlConversionAgent.marshall(potvrdaVakcinacije, this.jaxbContextPath);
            System.out.println(entityXml);
//            if (!rdfService.save(xmlEntity, SPARQL_NAMED_GRAPH_URI)) {
//                System.out.println("[ERROR] Neuspesno cuvanje metapodataka zahteva u RDF DB.");
//            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //izvestajClient.sendIzvestaj(izvestaj);
        return potvrdaVakcinacije;
    }

    @Override
    public PotvrdaVakcinacije update(String entityXml) {
        PotvrdaVakcinacije potvrdaVakcinacije;
        try {
            potvrdaVakcinacije = this.potvrdaVakcinacijeXmlConversionAgent.unmarshall(entityXml, this.jaxbContextPath);
        } catch (JAXBException e) {
            throw new InvalidXmlException(PotvrdaVakcinacije.class, e.getMessage());
        }

        try {
            if (!this.potvrdaVakcinacijeRepository.updateEntity(potvrdaVakcinacije)) {
                throw new EntityNotFoundException(potvrdaVakcinacije.getDokumentId(), PotvrdaVakcinacije.class);
            }
            return potvrdaVakcinacije;
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        } catch (JAXBException e) {
            throw new InvalidXmlDatabaseException(PotvrdaVakcinacije.class, e.getMessage());
        }

    }

    @Override
    public boolean deleteById(Long entityId) {
        try {
            return this.potvrdaVakcinacijeRepository.deleteEntity(entityId);
        } catch (XMLDBException e) {
            throw new XmlDatabaseException(e.getMessage());
        }
    }
}
