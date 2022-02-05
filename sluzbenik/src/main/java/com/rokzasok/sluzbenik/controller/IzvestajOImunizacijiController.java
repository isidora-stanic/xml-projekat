package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.dokumenti.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.rokzasok.sluzbenik.service.IzvestajOImunizacijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@RequestMapping(value = "/izvestaj")
public class IzvestajOImunizacijiController {

    @Autowired
    private IzvestajOImunizacijiService izvestajService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<List<IzvestajOImunizaciji>> findAll() {
        //KolekcijaIzvestajOImunizacijia kolekcijaIzvestajOImunizacijia = new KolekcijaIzvestajOImunizacijia();
        //kolekcijaIzvestajOImunizacijia.setIzvestajOImunizaciji(this.izvestajService.findAll());
        //return new ResponseEntity<>(kolekcijaIzvestajOImunizacijia, HttpStatus.OK);
        return new ResponseEntity<>(this.izvestajService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<IzvestajOImunizaciji> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.izvestajService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<IzvestajOImunizaciji> create(@RequestBody String body) {
        return new ResponseEntity<>(this.izvestajService.create(body), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<IzvestajOImunizaciji> update(@RequestBody String body) {
        return new ResponseEntity<>(this.izvestajService.update(body), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.izvestajService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // todo
//    @GetMapping(value = "/pdf/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> pdf(@PathVariable Long id) {
//        ByteArrayInputStream bis = this.izvestajService.generatePdf(id);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=izvestaj.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
//
//    @GetMapping(value = "/html/{id}")
//    public ResponseEntity<InputStreamResource> html(@PathVariable Long id) {
//        ByteArrayInputStream bis = this.izvestajService.generateHtml(id);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=izvestaj.html");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .body(new InputStreamResource(bis));
//    }
//
//    @GetMapping(value = "/metadata/json/{id}")
//    public ResponseEntity<InputStreamResource> jsonMetadata(@PathVariable Long id) {
//        ByteArrayInputStream bis = this.izvestajService.exportMetadataAsJson(id);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=izvestaj.json");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .body(new InputStreamResource(bis));
//    }
//
//    @GetMapping(value = "/metadata/xml/{id}")
//    public ResponseEntity<InputStreamResource> xmlMetadata(@PathVariable Long id) {
//        ByteArrayInputStream bis = this.izvestajService.exportMetadataAsXml(id);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=izvestaj.xml");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .body(new InputStreamResource(bis));
//    }
//
//    @GetMapping(value = "/metadata/rdf/{id}")
//    public ResponseEntity<InputStreamResource> rdfMetadata(@PathVariable Long id) {
//        ByteArrayInputStream bis = this.izvestajService.exportMetadataAsRdf(id);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=izvestaj.ttl");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .body(new InputStreamResource(bis));
//    }

}
