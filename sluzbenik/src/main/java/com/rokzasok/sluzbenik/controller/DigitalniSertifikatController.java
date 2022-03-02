package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat.DigitalniSertifikat;
import com.rokzasok.sluzbenik.service.DigitalniSertifikatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
@RequestMapping(value = "/api/digitalni-sertifikat")
public class DigitalniSertifikatController {

    @Autowired
    private DigitalniSertifikatService digitalniSertifikatService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DigitalniSertifikat> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.digitalniSertifikatService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DigitalniSertifikat> create(@RequestBody String body) {
        return new ResponseEntity<>(this.digitalniSertifikatService.create(body), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DigitalniSertifikat> update(@RequestBody String body) {
        return new ResponseEntity<>(this.digitalniSertifikatService.update(body), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.digitalniSertifikatService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/html/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml(@PathVariable Long dokumentId) {
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

    @GetMapping(value = "/pdf/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdf(@PathVariable Long dokumentId) {
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
