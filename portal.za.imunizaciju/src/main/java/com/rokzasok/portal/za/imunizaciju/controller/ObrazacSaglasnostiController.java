package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti.KolekcijaObrazacaSaglasnosti;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.portal.za.imunizaciju.service.ObrazacSaglasnostiService;
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
@RequestMapping(value = "api/obrazac-saglasnosti")
public class ObrazacSaglasnostiController {
    @Autowired
    ObrazacSaglasnostiService obrazacSaglasnostiService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<KolekcijaObrazacaSaglasnosti> findAll() {
        KolekcijaObrazacaSaglasnosti kolekcijaObrazacaSaglasnosti = new KolekcijaObrazacaSaglasnosti();
        kolekcijaObrazacaSaglasnosti.setObrasciSaglasnosti(this.obrazacSaglasnostiService.findAll());
        return new ResponseEntity<>(kolekcijaObrazacaSaglasnosti, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ObrazacSaglasnosti> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.obrazacSaglasnostiService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ObrazacSaglasnosti> create(@RequestBody String body) {
        return new ResponseEntity<>(this.obrazacSaglasnostiService.create(body), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ObrazacSaglasnosti> update(@RequestBody String body) {
        return new ResponseEntity<>(this.obrazacSaglasnostiService.update(body), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.obrazacSaglasnostiService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // todo: delete?
//    @GetMapping(value="/by/{osobaId}")
//    ResponseEntity<KolekcijaObrazacaSaglasnosti> getSaglasnostByOsoba(@PathVariable("osobaId") Long osobaId) {
//        KolekcijaObrazacaSaglasnosti kolekcijaObrazacaSaglasnosti = new KolekcijaObrazacaSaglasnosti();
//        kolekcijaObrazacaSaglasnosti.setObrasciSaglasnosti(this.obrazacSaglasnostiService.getSaglasnostByOsoba(osobaId.toString()));
//        return new ResponseEntity<>(kolekcijaObrazacaSaglasnosti, HttpStatus.OK);
//    }

    @GetMapping(value = "/html/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.obrazacSaglasnostiService.generateHtml(dokumentId);
        }
        catch (IOException | SAXException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=obrazac.html");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/pdf/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdf(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.obrazacSaglasnostiService.generatePDF(dokumentId);
        }
        catch (IOException | SAXException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=obrazac.pdf");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }
}
