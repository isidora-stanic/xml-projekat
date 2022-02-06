package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.dokumenti.digitalni_sertifikat.DigitalniSertifikat;
import com.rokzasok.sluzbenik.dokumenti.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.rokzasok.sluzbenik.dokumenti.izvestaj_o_imunizaciji.KolekcijaIzvestaja;
import com.rokzasok.sluzbenik.service.DigitalniSertifikatService;
import com.rokzasok.sluzbenik.service.IzvestajOImunizacijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/digitalni-sertifikat")
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
}
