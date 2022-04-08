package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.fuseki.SparqlService;
import com.rokzasok.portal.za.imunizaciju.service.IskazivanjeInteresovanjaService;
import org.apache.jena.query.ResultSet;
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
import java.util.List;

@Controller
@RequestMapping(value = "api/iskazivanje-interesovanja")
public class IskazivanjeInteresovanjaController {

    @Autowired
    IskazivanjeInteresovanjaService zahtjevZaImunizacijuService;

    @Autowired
    SparqlService sparqlService;

    public void registracija(){

    }

    /*@PostMapping(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ObrazacInteresovanja> interesovanjeZaPrijemVakcine(@RequestBody String body){
        String b = "fsd";
        return new ResponseEntity<>(this.zahtjevZaImunizacijuService.create(body), HttpStatus.OK);//post
        //TODO:podnosi se samo prije prve doze, salje mu se mejl da je uspjesno podnio zahtjev, dodjeljuje mu se termin
    }*/

    public void dokumentSaglasnosti(){
        //post
        //TODO:samo se salje dokument saglasnosti za prijem vakcine na bek
    }

    public void zahtjevZaIzdavanjeZelenogSertifikata(){
        //post
        //TODO:samo se salje zahtjev za zeleni sertifikat na bek
    }

    public void pregledDokumenata(){
        //get
        //TODO: kao query param se salje koji tip dokumenta zeli da vidi: bilo koji kojeg je sam poslao ili koji mu je izdat
        //TODO: omoguciti i dobavljanje u pdf ili xhtml formatu(to negdje drugo treba, nego samo napomena ovde)
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ObrazacInteresovanja> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.zahtjevZaImunizacijuService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ObrazacInteresovanja> create(@RequestBody String body) {
        return new ResponseEntity<>(this.zahtjevZaImunizacijuService.create(body), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ObrazacInteresovanja> update(@RequestBody String body) {
        return new ResponseEntity<>(this.zahtjevZaImunizacijuService.update(body), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.zahtjevZaImunizacijuService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping(value = "/html/{dokumentId}")
//    ResponseEntity<InputStreamResource> getHtml(@PathVariable Long dokumentId) {
//        ByteArrayInputStream is;
//        try {
//            is = this.zahtjevZaImunizacijuService.generateHtml(dokumentId);
//        }
//        catch (IOException | SAXException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline: filename=potvrda.html");
//
//        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/pdf/{dokumentId}")
//    ResponseEntity<InputStreamResource> getPdf(@PathVariable Long dokumentId) {
//        ByteArrayInputStream is;
//        try {
//            is = this.zahtjevZaImunizacijuService.generatePDF(dokumentId);
//        }
//        catch (IOException | SAXException | JAXBException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline: filename=zahtev.pdf");
//
//        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
//    }
}
