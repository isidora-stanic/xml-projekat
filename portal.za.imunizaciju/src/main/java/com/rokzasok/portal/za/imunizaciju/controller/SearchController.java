package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.service.SparqlToDTOService;
import com.rokzasok.portal.za.imunizaciju.service.TextSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

@Controller
@RequestMapping("search/")
public class SearchController {
    @Autowired
    private SparqlToDTOService sparqlToDTOService;

    @Autowired
    private TextSearchService textSearchService;

    @GetMapping(value = "/iskazivanje-interesovanja/{idDokumenta}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Boolean> searchIskazivanjeInteresovanja(@PathVariable Long idDokumenta, @RequestParam String query) throws XPathExpressionException, JAXBException, ParserConfigurationException {
        return new ResponseEntity<>(textSearchService.searchIskazivanjeInteresovanja(query, idDokumenta), HttpStatus.OK);
    }

}
