package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.fuseki.SparqlService;
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
}
