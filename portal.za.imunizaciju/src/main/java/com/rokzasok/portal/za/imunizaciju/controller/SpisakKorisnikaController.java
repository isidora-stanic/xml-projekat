package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.model.dto.CreateKorisnikDTO;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_korisnika.Korisnik;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_korisnika.SpisakKorisnika;
import com.rokzasok.portal.za.imunizaciju.service.SpisakKorisnikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
@RequestMapping(value = "/api/korisnici")
public class SpisakKorisnikaController {
    @Autowired
    private SpisakKorisnikaService spisakKorisnikaService;

    @GetMapping(produces = APPLICATION_XML_VALUE)
    ResponseEntity<SpisakKorisnika> get() {
        return new ResponseEntity<>(this.spisakKorisnikaService.findById(1L), HttpStatus.OK);
    }

    @PostMapping(produces = APPLICATION_XML_VALUE)
    ResponseEntity<SpisakKorisnika> create(@RequestBody String body) {
        return new ResponseEntity<>(this.spisakKorisnikaService.create(body), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<SpisakKorisnika> update(@RequestBody String body) {
        return new ResponseEntity<>(this.spisakKorisnikaService.update(body), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Korisnik> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(this.spisakKorisnikaService.getKorisnik(id), HttpStatus.OK);
    }

    @PatchMapping(value = "/dodaj-gradjanina", produces = APPLICATION_XML_VALUE)
    ResponseEntity<Korisnik> addGradjanin(@RequestBody CreateKorisnikDTO createKorisnikDTO) {
        return new ResponseEntity<>(this.spisakKorisnikaService.addKorisnik(createKorisnikDTO, "gradjanin"), HttpStatus.OK);
    }

    @PatchMapping(value = "/dodaj-zdravstvenog-radnika", produces = APPLICATION_XML_VALUE)
    ResponseEntity<Korisnik> addZdravstveniRadnik(@RequestBody CreateKorisnikDTO createKorisnikDTO) {
        return new ResponseEntity<>(this.spisakKorisnikaService.addKorisnik(createKorisnikDTO, "zdravstveni_radnik"), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> removeKorisnik(@PathVariable Long id) {

        try {
            this.spisakKorisnikaService.removeKorisnik(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
