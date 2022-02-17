package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.fuseki.SparqlService;
import com.rokzasok.portal.za.imunizaciju.model.b2b.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiKorisnikaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SparqlToDTOService {
    @Autowired
    private SparqlService sparqlService;

    public DokumentiKorisnikaDTO getDokumentiKorisnika(Long idKorisnika) {
        try {
            List<SparqlService.SparqlQueryResult> sparqlDokumentLinkovi = sparqlService.getAllKreiranOdStrane(idKorisnika.toString());

            DokumentiKorisnikaDTO dokumentiKorisnikaDTO = new DokumentiKorisnikaDTO();
            dokumentiKorisnikaDTO.setListaDokumenata(new ArrayList<>());

            for (SparqlService.SparqlQueryResult sparqlQueryResult : sparqlDokumentLinkovi) {
                dokumentiKorisnikaDTO.getListaDokumenata().add(new DokumentiKorisnikaDTO.DokumentDTO(sparqlQueryResult.getVarValue().toString(), "tipDokumenta", null));
            }

            return dokumentiKorisnikaDTO;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public IzvestajOImunizaciji generateIzvestaj(String odDatum, String doDatum) {
        try {
            List<SparqlService.SparqlQueryResult> sparqlRezultati = sparqlService.getAllOdDo(odDatum, doDatum);
            System.out.println(sparqlRezultati);
            // todo: mora se testirati da li se dobija sta nam treba - odvojeno link od datuma

            // todo mozda je bolje da imamo vise sparql upita koji se pozivaju da bi se lepo racunalo sve sto treba

            // todo: treba izracunati: 1) broj interesovanja za imunizaciju
            //                         2) broj zahteva za digitalni sertifikat
            //                         3) broj izdatih digitalnih sertifikata (to mora sa strane sluzbenika da se popuni, ovde moze sa tipa 0 ili -1)
            //                         4) broj potvrda vakcinacije
            //                         5) broj datih prvih doza, drugih i trecih... (potvrda sadrzi najvecu dozu = 1/2/3)
            //                         6) raspodela datih doza po proizvodjacima (potvrda sadrzi proizvodjaca = ...)
            //              - datumi od i do

            return new IzvestajOImunizaciji(); // todo popuni podacima

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
