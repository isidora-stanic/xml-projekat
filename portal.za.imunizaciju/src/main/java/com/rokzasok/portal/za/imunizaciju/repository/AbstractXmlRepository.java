package com.rokzasok.portal.za.imunizaciju.repository;

import com.rokzasok.portal.za.imunizaciju.helper.DbConnection;
import com.rokzasok.portal.za.imunizaciju.helper.XmlConversionAgent;
import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AbstractXmlRepository<T extends Identifiable> {

    private String collectionId;
    public String jaxbContextPath;
    private String X_QUERY_FIND_ALL_ENTITIES;
    private String X_UPDATE_REMOVE_ENTITY_BY_ID_EXPRESSION;

    @Autowired(required = true)
    DbConnection dbConnection;

    @Autowired
    XmlConversionAgent<T> xmlConversionAgent;

    public List<T> getAllEntities() throws XMLDBException, JAXBException {
        ArrayList<T> entities = new ArrayList<>();
        Collection collection = this.dbConnection.getCollection(this.collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        CompiledExpression compiledExpression = xQueryService.compile(this.X_QUERY_FIND_ALL_ENTITIES);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator resourceIterator = resourceSet.getIterator();
        while (resourceIterator.hasMoreResources()) {
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            entities.add(this.xmlConversionAgent.unmarshall(xmlResource.getContentAsDOM(), this.jaxbContextPath));
        }
        return entities;
    }

    public T getEntity(long entityId) throws XMLDBException, JAXBException {
        Collection collection = this.dbConnection.getCollection(this.collectionId);
        Long id = new Long(entityId);
        XMLResource xmlResource = (XMLResource) collection.getResource(id.toString() + ".xml");
        if (xmlResource == null) {
            return null;
        }

        return this.xmlConversionAgent.unmarshall(xmlResource.getContentAsDOM(), this.jaxbContextPath);
    }

    public T findEntity(String query, String param) throws XMLDBException, JAXBException {
        Collection collection = this.dbConnection.getCollection(this.collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        CompiledExpression compiledExpression = xQueryService.compile(String.format(query, param));
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator resourceIterator = resourceSet.getIterator();
        while (resourceIterator.hasMoreResources()) {
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            return (T) this.xmlConversionAgent.unmarshall(xmlResource.getContentAsDOM(), this.jaxbContextPath);
        }
        return null;
    }

    public T findEntity(String query, Long param) throws XMLDBException, JAXBException {
        Collection collection = this.dbConnection.getCollection(this.collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        CompiledExpression compiledExpression = xQueryService.compile(String.format(query, param));
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator resourceIterator = resourceSet.getIterator();
        while (resourceIterator.hasMoreResources()) {
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            return (T) this.xmlConversionAgent.unmarshall(xmlResource.getContentAsDOM(), this.jaxbContextPath);
        }
        return null;
    }

    public List<T> findEntities(String query) throws XMLDBException, JAXBException {
        Collection collection = this.dbConnection.getCollection(this.collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        CompiledExpression compiledExpression = xQueryService.compile(query);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator resourceIterator = resourceSet.getIterator();
        List<T> entities = new ArrayList<>();
        while (resourceIterator.hasMoreResources()) {
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            entities.add(this.xmlConversionAgent.unmarshall(xmlResource.getContentAsDOM(), this.jaxbContextPath));
        }
        return entities;
    }

    public T createEntity(T entity) throws XMLDBException, JAXBException {
        Collection collection = this.dbConnection.getCollection(this.collectionId);
        XMLResource xmlResource = (XMLResource) collection.createResource(entity.getDokumentId().toString() + ".xml", XMLResource.RESOURCE_TYPE);
        xmlResource.setContent(this.xmlConversionAgent.marshallToOutputStream(entity, this.jaxbContextPath));
        collection.storeResource(xmlResource);
        return this.getEntity(entity.getDokumentId());
    }

    public boolean updateEntity(T entity) throws XMLDBException, JAXBException {
        if (this.getEntity(entity.getDokumentId()) == null) {
            return false;
        }
        this.deleteEntity(entity.getDokumentId());
        this.createEntity(entity);
        return true;
    }

    public boolean deleteEntity(long entityId) throws XMLDBException {
        Collection collection = this.dbConnection.getCollection(this.collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        String expression = String.format(this.X_UPDATE_REMOVE_ENTITY_BY_ID_EXPRESSION, entityId + ".xml");
        CompiledExpression compiledExpression = xQueryService.compile(expression);
        xQueryService.execute(compiledExpression);
        return true;

    }

    public void injectRepositoryProperties(
            String collectionId,
            String jaxbContextPath,
            String X_QUERY_FIND_ALL_ENTITIES,
            String X_UPDATE_REMOVE_ENTITY_BY_ID_EXPRESSION
    ) {

        this.collectionId = collectionId;
        this.jaxbContextPath = jaxbContextPath;
        this.X_QUERY_FIND_ALL_ENTITIES = X_QUERY_FIND_ALL_ENTITIES;
        this.X_UPDATE_REMOVE_ENTITY_BY_ID_EXPRESSION = X_UPDATE_REMOVE_ENTITY_BY_ID_EXPRESSION;
    }
}
