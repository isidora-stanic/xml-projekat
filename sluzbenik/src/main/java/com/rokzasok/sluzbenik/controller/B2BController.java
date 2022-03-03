package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.model.dto.DostupnostResponseDTO;
import com.rokzasok.sluzbenik.model.ostalo.dostupne_doze.DostupneDoze;
import com.rokzasok.sluzbenik.service.DostupneDozeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

@Controller
@RequestMapping(value = "b2b/")
public class B2BController {

    @Autowired
    private DostupneDozeService dostupneDozeService;

    // vakcine

    @GetMapping(value = "/vakcine/proveri-dostupnost/{tipVakcine}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DostupnostResponseDTO> proveriDostupnostVakcine(@PathVariable("tipVakcine") String tipVakcine) {
        DostupnostResponseDTO response = new DostupnostResponseDTO(
                this.dostupneDozeService.proveriDostupnostVakcine(tipVakcine));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/vakcine/ukloni-dozu/{tipVakcine}")
    ResponseEntity<Void> ukloniDozuVakcine(@PathVariable("tipVakcine") String tipVakcine) {
        try {
            this.dostupneDozeService.removeDoze(tipVakcine, BigInteger.ONE);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
