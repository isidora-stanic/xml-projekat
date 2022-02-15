package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.Dan;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.SpisakTermina;
import com.rokzasok.portal.za.imunizaciju.service.SpisakTerminaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
@RequestMapping(value = "/api/termini")
public class SpisakTerminaController {

    @Autowired
    private SpisakTerminaService spisakTerminaService;

    @GetMapping(value = "/nadji", produces = APPLICATION_XML_VALUE)
    ResponseEntity<Dan> nadjiTerminTestObrisi() {
        return new ResponseEntity<>(this.spisakTerminaService.zakaziTermin("Novi Sad", LocalDate.now().plusWeeks(1), "MODERNA", 5), HttpStatus.OK);
    }

    @PostMapping(value = "/dodaj", produces = APPLICATION_XML_VALUE)
    ResponseEntity<SpisakTermina> kreirajTermineObrisi(@RequestBody String body) {
        return new ResponseEntity<>(this.spisakTerminaService.create(body), HttpStatus.OK);
    }
}
