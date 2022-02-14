package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat.KolekcijaZahtevaZaSertifikat;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.portal.za.imunizaciju.service.ZahtevZaSertifikatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "api/zahtev-za-sertifikat")
public class ZahtevZaSertifikatController {
    @Autowired
    ZahtevZaSertifikatService zahtevZaSertifikatService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<KolekcijaZahtevaZaSertifikat> findAll() {
        KolekcijaZahtevaZaSertifikat kolekcijaZahtevaZaSertifikat = new KolekcijaZahtevaZaSertifikat();
        kolekcijaZahtevaZaSertifikat.setZahteviZaSertifikat(this.zahtevZaSertifikatService.findAll());
        return new ResponseEntity<>(kolekcijaZahtevaZaSertifikat, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Zahtev> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.zahtevZaSertifikatService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Zahtev> create(@RequestBody String body) {
        return new ResponseEntity<>(this.zahtevZaSertifikatService.create(body), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Zahtev> update(@RequestBody String body) {
        return new ResponseEntity<>(this.zahtevZaSertifikatService.update(body), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.zahtevZaSertifikatService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
