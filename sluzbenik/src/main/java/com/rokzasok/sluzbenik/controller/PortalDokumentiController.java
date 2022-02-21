package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.model.b2b.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.sluzbenik.model.dto.DokumentiKorisnikaDTO;
import com.rokzasok.sluzbenik.service.B2BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/dokumenti")
public class PortalDokumentiController {

    @Autowired
    private B2BService b2bService;


    @GetMapping(value="iskazivanje-interesovanja/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ObrazacInteresovanja> getIskazivanjeInteresovanja(@PathVariable String id) {
        return new ResponseEntity<>(b2bService.getIskazivanjeInteresovanja(id), HttpStatus.OK);
    }

    @GetMapping(value="obrazac-saglasnosti/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ObrazacSaglasnosti> getObrazacSaglasnosti(@PathVariable String id) {
        return new ResponseEntity<>(b2bService.getObrazacSaglasnosti(id), HttpStatus.OK);
    }

    @GetMapping(value="potvrda-vakcinacije/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<PotvrdaVakcinacije> getPotvrdaVakcinacije(@PathVariable String id) {
        return new ResponseEntity<>(b2bService.getPotvrdaVakcinacije(id), HttpStatus.OK);
    }

    @GetMapping(value="zahtev-za-sertifikat/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Zahtev> getZahtevZaSertifikat(@PathVariable String id) {
        return new ResponseEntity<>(b2bService.getZahtevZaSertifikat(id), HttpStatus.OK);
    }

    @GetMapping(value = "{idKorisnika}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DokumentiKorisnikaDTO> getDokumentiKorisnika(@PathVariable("idKorisnika") Long idKorisnika) {
        return new ResponseEntity<>(b2bService.getDokumentiKorisnika(idKorisnika.toString()), HttpStatus.OK);
    }

    
}
