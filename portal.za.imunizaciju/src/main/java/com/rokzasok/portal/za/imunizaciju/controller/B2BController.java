package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.model.b2b.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiKorisnikaDTO;
import com.rokzasok.portal.za.imunizaciju.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "b2b/")
public class B2BController {

    @Autowired
    private SparqlToDTOService sparqlToDTOService;

    @Autowired
    private IskazivanjeInteresovanjaService iskazivanjeInteresovanjaService;
    @Autowired
    private ObrazacSaglasnostiService obrazacSaglasnostiService;
    @Autowired
    private PotvrdaVakcinacijeService potvrdaVakcinacijeService;
    @Autowired
    private ZahtevZaSertifikatService zahtevZaSertifikatService;

    // korisnici
    @GetMapping(value = "/dokumenti-po-korisniku/{idKorisnika}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DokumentiKorisnikaDTO> getDokumentiKorisnika(@PathVariable("idKorisnika") Long idKorisnika) {
        return new ResponseEntity<>(sparqlToDTOService.getDokumentiKorisnika(idKorisnika), HttpStatus.OK);
    }

    // dokumenti sa portala koji su potrebni sluzbeniku
    @GetMapping(value = "/iskazivanje-interesovanja/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ObrazacInteresovanja> getIskazivanjeInteresovanja(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iskazivanjeInteresovanjaService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/obrazac-saglasnosti/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ObrazacSaglasnosti> getObrazacSaglasnosti(@PathVariable("id") Long id) {
        return new ResponseEntity<>(obrazacSaglasnostiService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/potvra-vakcinacije/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<PotvrdaVakcinacije> getPotvrdaVakcinacije(@PathVariable("id") Long id) {
        return new ResponseEntity<>(potvrdaVakcinacijeService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/zahtev-za-sertifikat/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Zahtev> getZahtevZaSertifikat(@PathVariable("id") Long id) {
        return new ResponseEntity<>(zahtevZaSertifikatService.findById(id), HttpStatus.OK);
    }

    // podaci za izvestaj // todo dovrsi metodu u servisu...
    @GetMapping(value = "/izvestaj-o-imunizaciji/", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<IzvestajOImunizaciji> getIzvestajOImunizaciji(@RequestParam("odKad") String odKad, @RequestParam("doKad") String doKad) {
        return new ResponseEntity<>(sparqlToDTOService.generateIzvestaj(odKad, doKad), HttpStatus.OK);
    }



}
