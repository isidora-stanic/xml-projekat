package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;
import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiIzPretrageDTO;
import com.rokzasok.portal.za.imunizaciju.model.dto.MetadataQueryDTO;
import com.rokzasok.portal.za.imunizaciju.service.SparqlToDTOService;
import com.rokzasok.portal.za.imunizaciju.service.TextSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.util.List;

@Controller
@RequestMapping("search/")
public class SearchController {

    @Autowired
    private SparqlToDTOService sparqlToDTOService;

    @Autowired
    private TextSearchService textSearchService;

    // todo mora u neki dto da se pretvori, ovo nece moci da se posalje u xml formatu...
    @GetMapping(value = "/portal", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DokumentiIzPretrageDTO> searchText(@RequestParam String query) throws XPathExpressionException, JAXBException, ParserConfigurationException {
        return new ResponseEntity<>(textSearchService.searchAll(query), HttpStatus.OK);
    }

    // todo mora u neki dto da se pretvori, ovo nece moci da se posalje u xml formatu...
    @GetMapping(value = "/portal/metadata", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<List<Identifiable>> searchMetadata(@RequestBody MetadataQueryDTO metadata) throws XPathExpressionException, JAXBException, ParserConfigurationException {
        return new ResponseEntity<>(textSearchService.searchMetadata(metadata), HttpStatus.OK);
    }

}
