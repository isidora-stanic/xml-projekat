package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.model.b2b.digitalni_sertifikat.DigitalniSertifikat;
import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiKorisnikaDTO;
import com.rokzasok.portal.za.imunizaciju.model.dto.DostupnostResponseDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Objects;

@Service
public class B2BService {

    private static final String BASE_URI = "http://localhost:9090";

    // vakcine
    public boolean proveriDostupnostVakcine(String tipVakcine) {
        WebClient client = WebClient.create(BASE_URI);

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
        WebClient client = WebClient.create(BASE_URI);

        HttpStatus status = Objects.requireNonNull(client.get()
                .uri("/b2b/vakcine/ukloni-dozu/" + tipVakcine)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve().toBodilessEntity().block()).getStatusCode();

        return status.equals(HttpStatus.OK);
    }

    public DokumentiKorisnikaDTO getDigitalniSertifikatiKorisnika(Long idKorisnika) {
        WebClient client = WebClient.create(BASE_URI);

        DokumentiKorisnikaDTO dokumenti = client.get()
                .uri("/b2b/digitalni-sertifikati-korisnika/" + idKorisnika)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(DokumentiKorisnikaDTO.class)
                .log()
                .block();

        return dokumenti;
    }

    public InputStreamResource generateHtmlDigitalni(Long dokumentId) {
        WebClient client = WebClient.create(BASE_URI);

        InputStreamResource stream = client.get()
                .uri("/api/digitalni-sertifikat/html/" + dokumentId)
                .retrieve()
                .bodyToMono(InputStreamResource.class)
                .log()
                .block();

        return stream;
    }

    public InputStreamResource generatePdfDigitalni(Long dokumentId) {
        WebClient client = WebClient.create(BASE_URI);

        InputStreamResource stream = client.get()
                .uri("/api/digitalni-sertifikat/pdf/" + dokumentId)
                .retrieve()
                .bodyToMono(InputStreamResource.class)
                .log()
                .block();

        return stream;
    }
}
