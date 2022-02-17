package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.model.dto.DokumentiKorisnikaDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Service
public class B2BService {

    // dokumenti od korisnka
    public DokumentiKorisnikaDTO getDokumentiKorisnika(String idKorisnika) {
        WebClient client = WebClient.create("http://localhost:9090");

        DokumentiKorisnikaDTO dokumenti = client.get()
                .uri("/b2b/dokumenti-po-korisniku/" + idKorisnika)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(DokumentiKorisnikaDTO.class)
                .log()
                .block();
        return dokumenti;
    }
}
