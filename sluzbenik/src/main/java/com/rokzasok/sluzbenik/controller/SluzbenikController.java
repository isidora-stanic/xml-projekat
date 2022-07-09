package com.rokzasok.sluzbenik.controller;

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
@RequestMapping("/api/sluzbenik")
public class SluzbenikController {

    @Autowired
    B2BService b2bService;

    @GetMapping(value = "/dokumenti-korisnika/{idKorisnika}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DokumentiKorisnikaDTO> getDokumentiKorisnika(@PathVariable("idKorisnika") Long idKorisnika) {
        return new ResponseEntity<>(b2bService.getDokumentiKorisnika(idKorisnika.toString()), HttpStatus.OK);
    }

    public void odgovorNaZahtevZaZeleniSertifikat(){
        System.out.println("moze biti pozitivan ili negativan odgovor, obraditi oba slucaja");
    }

    public void izvestajOImunizaciji(){
        //TODO: ovaj izvjestaj sa fronta treba da primi datum od do
    }

    public void pregledStanjaVakcina(){

    }

    public void azuriranjeStanjaVakcina(){

    }

    public void pretraga(){
        //TODO:????????????????
    }
}
