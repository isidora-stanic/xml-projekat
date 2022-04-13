package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat.DigitalniSertifikat;
import com.rokzasok.sluzbenik.model.ostalo.dostupne_doze.DostupneDoze;
import com.rokzasok.sluzbenik.service.DostupneDozeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
@RequestMapping(value = "/api/dostupne-doze")
public class DostupneDozeController {
    @Autowired
    private DostupneDozeService dostupneDozeService;

    @GetMapping(produces = APPLICATION_XML_VALUE)
    ResponseEntity<DostupneDoze> get() {
        return new ResponseEntity<>(this.dostupneDozeService.findById(1L), HttpStatus.OK);
    }

    @PostMapping(produces = APPLICATION_XML_VALUE)
    ResponseEntity<DostupneDoze> create(@RequestBody String body) {
        return new ResponseEntity<>(this.dostupneDozeService.create(body), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DostupneDoze> update(@RequestBody String body) {
        return new ResponseEntity<>(this.dostupneDozeService.update(body), HttpStatus.OK);
    }

    @GetMapping(value = "/dodaj-doze", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DostupneDoze> addDoze(@RequestParam("naziv-vakcine") String nazivVakcine, @RequestParam("broj-doza") BigInteger brojDoza) {
        return new ResponseEntity<>(this.dostupneDozeService.addDoze(nazivVakcine, brojDoza), HttpStatus.OK);
    }
}
