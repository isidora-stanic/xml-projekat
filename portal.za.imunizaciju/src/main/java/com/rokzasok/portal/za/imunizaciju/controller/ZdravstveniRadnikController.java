package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.service.PotvrdaVakcinacijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
