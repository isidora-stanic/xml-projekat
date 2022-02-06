package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.service.ZahtjevZaImunizacijuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/gradjanin")
public class GradjaninController {

    @Autowired
    ZahtjevZaImunizacijuService zahtjevZaImunizacijuService;

    public void registracija(){

    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ObrazacInteresovanja> interesovanjeZaPrijemVakcine(@RequestBody String body){
        String b = "fsd";
        return new ResponseEntity<>(this.zahtjevZaImunizacijuService.create(body), HttpStatus.OK);//post
        //TODO:podnosi se samo prije prve doze, salje mu se mejl da je uspjesno podnio zahtjev, dodjeljuje mu se termin
    }

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
}
