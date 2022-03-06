package com.rokzasok.portal.za.imunizaciju.service;

import org.w3c.dom.Document;

import java.util.List;

public interface AbstractXmlService<T> {

    List<T> findAll();

    T findById(Long entityId);

    T create(String entityXml);

    T update(String entityXml);

    //Document getDocument(Long entityId);

    boolean deleteById(Long entityId);
}

