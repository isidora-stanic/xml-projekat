package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije.KolekcijaPotvrdaVakcinacije;
import com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.portal.za.imunizaciju.service.PotvrdaVakcinacijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "api/potvrda-vakcinacije")
public class PotvrdaVakcinacijeController {
    @Autowired
    PotvrdaVakcinacijeService potvrdaVakcinacijeService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<KolekcijaPotvrdaVakcinacije> findAll() {
        KolekcijaPotvrdaVakcinacije kolekcijaPotvrdaVakcinacije = new KolekcijaPotvrdaVakcinacije();
        kolekcijaPotvrdaVakcinacije.setPotvrdeVakcinacije(this.potvrdaVakcinacijeService.findAll());
        return new ResponseEntity<>(kolekcijaPotvrdaVakcinacije, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<PotvrdaVakcinacije> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.potvrdaVakcinacijeService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<PotvrdaVakcinacije> create(@RequestBody String body) {
        return new ResponseEntity<>(this.potvrdaVakcinacijeService.create(body), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<PotvrdaVakcinacije> update(@RequestBody String body) {
        return new ResponseEntity<>(this.potvrdaVakcinacijeService.update(body), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.potvrdaVakcinacijeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
