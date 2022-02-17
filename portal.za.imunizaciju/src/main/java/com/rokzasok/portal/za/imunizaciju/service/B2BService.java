package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.model.dto.DostupnostResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.*;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class B2BService {

    // vakcine
    public boolean proveriDostupnostVakcine(String tipVakcine) {
        WebClient client = WebClient.create("http://localhost:9091");

        DostupnostResponseDTO dostupnost = client.get()
                .uri("/b2b/vakcine/proveri-dostupnost/" + tipVakcine)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(DostupnostResponseDTO.class)
                .log()
                .block();

        if (dostupnost != null && dostupnost.getDostupnost() != null) {
            return dostupnost.getDostupnost();
        }
        return false;
    }

    public boolean ukloniDozuVakcine(String tipVakcine) {
        WebClient client = WebClient.create("http://localhost:9091");

        HttpStatus status = Objects.requireNonNull(client.get()
                .uri("/b2b/vakcine/ukloni-dozu/" + tipVakcine)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve().toBodilessEntity().block()).getStatusCode();

        return status.equals(HttpStatus.OK);
    }
}
