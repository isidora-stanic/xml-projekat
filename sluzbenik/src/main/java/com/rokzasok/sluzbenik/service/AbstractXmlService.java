package com.rokzasok.sluzbenik.service;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface AbstractXmlService<T> {

    List<T> findAll();

    T findById(Long entityId);

    T create(String entityXml);

    T update(String entityXml);

    boolean deleteById(Long entityId);

    String getRdfaString(Long dokumentId) throws JAXBException;
}

