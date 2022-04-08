package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.model.dto.DokumentiKorisnikaDTO;
import com.rokzasok.sluzbenik.model.dto.DostupnostResponseDTO;
import com.rokzasok.sluzbenik.service.DigitalniSertifikatService;
import com.rokzasok.sluzbenik.service.DostupneDozeService;
import com.rokzasok.sluzbenik.service.SparqlToDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

@Controller
@RequestMapping(value = "b2b")
public class B2BController {

    @Autowired
    private DostupneDozeService dostupneDozeService;

    @Autowired
    private SparqlToDTOService sparqlToDTOService;

    @Autowired
    private DigitalniSertifikatService digitalniSertifikatService;

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

    @GetMapping(value = "/digitalni-sertifikati-korisnika/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DokumentiKorisnikaDTO> getDigitalniSertifikatiKorisnika(@PathVariable("id") Long id) {
        return new ResponseEntity<>(sparqlToDTOService.getDokumentiKorisnikaSluzbenik(id), HttpStatus.OK);
    }

    @GetMapping(value = "/digitalni-sertifikat/html/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml5(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.digitalniSertifikatService.generateHtml(dokumentId);
        }
        catch (IOException | SAXException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=sertifikat.html");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/digitalni-sertifikat/pdf/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdf5(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.digitalniSertifikatService.generatePDF(dokumentId);
        }
        catch (IOException | SAXException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=sertifikat.pdf");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

}
