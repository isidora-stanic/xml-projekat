package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije.ObjectFactory;
import com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.portal.za.imunizaciju.service.PotvrdaVakcinacijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "zdravstveni-radnik")
public class ZdravstveniRadnikController {

    @Autowired
    PotvrdaVakcinacijeService potvrdaVakcinacijeService;

    public void zahtjevGradjanina(){
        //get
        //TODO: zahtjev se dobavlja na osnovu idja zahtjeva, i prikazuje zr, on popunjava donji dio i u sledecoj metodi to salje na bek
    }

    public void izvrsiImunizaciju(){
        //put
        //TODO: ovdje se salje popunjen drugi dio zahtjeva za imunizaciju
    }

}
