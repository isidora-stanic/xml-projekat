package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.model.b2b.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.sluzbenik.model.dokumenti.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.rokzasok.sluzbenik.model.dto.DokumentiIzPretrageDTO;
import com.rokzasok.sluzbenik.model.dto.DokumentiKorisnikaDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.xml.datatype.DatatypeConfigurationException;

@Service
public class B2BService {

    private static final String BASE_URI = "http://localhost:9091";

    // dokumenti od korisnka
    public DokumentiKorisnikaDTO getDokumentiKorisnika(String idKorisnika) {
        WebClient client = WebClient.create(BASE_URI);

        DokumentiKorisnikaDTO dokumenti = client.get()
                .uri("/b2b/dokumenti-po-korisniku/" + idKorisnika)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(DokumentiKorisnikaDTO.class)
                .log()
                .block();
        return dokumenti;
    }

    // pretraga dokumenata
    public DokumentiIzPretrageDTO pretraziDokumenteSaPortala(String query) {
        WebClient client = WebClient.create(BASE_URI);

        DokumentiIzPretrageDTO dokumenti = client.get()
                .uri(Builder -> Builder.path("/b2b/search").queryParam("query", query).build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(DokumentiIzPretrageDTO.class)
                .log()
                .block();
        return dokumenti;
    }

    // dokumenti sa portala
    public ObrazacInteresovanja getIskazivanjeInteresovanja(String id) {
        WebClient client = WebClient.create(BASE_URI);

        ObrazacInteresovanja dokument = client.get()
                .uri("/b2b/iskazivanje-interesovanja/" + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(ObrazacInteresovanja.class)
                .log()
                .block();
        return dokument;
    }

    public ObrazacSaglasnosti getObrazacSaglasnosti(String id) {
        WebClient client = WebClient.create(BASE_URI);

        ObrazacSaglasnosti dokument = client.get()
                .uri("/b2b/obrazac-saglasnosti/" + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(ObrazacSaglasnosti.class)
                .log()
                .block();
        return dokument;
    }

    public PotvrdaVakcinacije getPotvrdaVakcinacije(String id) {
        WebClient client = WebClient.create(BASE_URI);

        PotvrdaVakcinacije dokument = client.get()
                .uri("/b2b/potvrda-vakcinacije/" + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(PotvrdaVakcinacije.class)
                .log()
                .block();
        return dokument;
    }

    public Zahtev getZahtevZaSertifikat(String id) {
        WebClient client = WebClient.create(BASE_URI);

        Zahtev dokument = client.get()
                .uri("/b2b/zahtev-za-sertifikat/" + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(Zahtev.class)
                .log()
                .block();
        return dokument;
    }

    // podaci za izvestaj
    public IzvestajOImunizaciji getIzvestajOImunizaciji(String odDatum, String doDatum) throws DatatypeConfigurationException {
        WebClient client = WebClient.create(BASE_URI);

        IzvestajOImunizaciji dokument = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/b2b/izvestaj-o-imunizaciji/")
                        .queryParam("odKad", odDatum)
                        .queryParam("doKad", doDatum)
                        .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(IzvestajOImunizaciji.class)
                .log()
                .block();

        return dokument;
    }

    public PotvrdaVakcinacije getPoslednjaPotvrdaVakcinacije(long idPacijenta) {
        WebClient client = WebClient.create(BASE_URI);

        PotvrdaVakcinacije dokument = client.get()
                .uri("/b2b/poslednja-potvrda-vakcinacije/" + idPacijenta)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(PotvrdaVakcinacije.class)
                .log()
                .block();
        return dokument;
    }
}
