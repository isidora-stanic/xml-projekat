package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.model.dto.ZakazivanjeTerminaDTO;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.Dan;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.SpisakTermina;
import com.rokzasok.portal.za.imunizaciju.service.SpisakTerminaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
@RequestMapping(value = "/api/termini")
public class SpisakTerminaController {

    @Autowired
    private SpisakTerminaService spisakTerminaService;

    @PostMapping(value = "/zakazi-termin", produces = APPLICATION_XML_VALUE)
    ResponseEntity<Dan> nadjiTermin(@RequestBody ZakazivanjeTerminaDTO terminDTO) {
        return new ResponseEntity<>(this.spisakTerminaService.zakaziTermin(terminDTO.getMesto(), 
                terminDTO.getDatum(), terminDTO.getTipVakcine(), terminDTO.getUnapred()), HttpStatus.OK);
    }

    @PostMapping(value = "", produces = APPLICATION_XML_VALUE)
    ResponseEntity<SpisakTermina> create(@RequestBody String body) {
        return new ResponseEntity<>(this.spisakTerminaService.create(body), HttpStatus.OK);
    }

    @GetMapping(produces = APPLICATION_XML_VALUE)
    ResponseEntity<SpisakTermina> get() {
        return new ResponseEntity<>(this.spisakTerminaService.findById(1L), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<SpisakTermina> update(@RequestBody String body) {
        return new ResponseEntity<>(this.spisakTerminaService.update(body), HttpStatus.OK);
    }

}
