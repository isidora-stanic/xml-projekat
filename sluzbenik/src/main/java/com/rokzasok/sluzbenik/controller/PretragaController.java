package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.model.dto.DokumentiIzPretrageDTO;
import com.rokzasok.sluzbenik.service.TextSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pretraga")
public class PretragaController {

    @Autowired
    private TextSearchService textSearchService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DokumentiIzPretrageDTO> pretraziSve(@RequestParam String query) {
        return new ResponseEntity<>(this.textSearchService.searchAll(query), HttpStatus.OK);
    }
}
