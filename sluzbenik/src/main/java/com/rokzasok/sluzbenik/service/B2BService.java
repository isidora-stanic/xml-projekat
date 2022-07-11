package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.exception.EntityNotFoundException;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.sluzbenik.model.dokumenti.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.rokzasok.sluzbenik.model.dto.DokumentiIzPretrageDTO;
import com.rokzasok.sluzbenik.model.dto.DokumentiKorisnikaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;

@Service
public class B2BService {

    private static final String BASE_URI = "http://localhost:9091";
    @Autowired
    private EmailService emailService;

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
        // dodavanje digitalnih sertifikata u rezultate -- NE TREBA JER SE NA PORTALU OBAVI SVA MEDJUSOBNA KOMUNIKACIJA
        // PA SE SPOJI SVE LEPO U JEDAN REZULTAT
//        List<DigitalniSertifikat> sertifikati = digitalniSertifikatService.findAll()
//                .stream()
//                .filter(s -> s.getGradjanin().getId().getValue() == Long.parseLong(idKorisnika))
//                .collect(Collectors.toList());
//        for (DigitalniSertifikat ds : sertifikati) {
//            dokumenti.getListaDokumenata()
//                    .add(new DokumentiKorisnikaDTO.DokumentDTO(
//                            "digitalni-sertifikat/"+ds.getDokumentId(),
//                            ds.getTipDokumenta(),
//                            ds.getDatumKreiranja()));
//        }
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

    public InputStreamResource generateHtmlPortal(String tip, Long dokumentId) {
        WebClient client = WebClient.create(BASE_URI);

        InputStreamResource stream = client.get()
                .uri("/api/dokumenti/html/"+ tip + "/" + dokumentId)
                .retrieve()
                .bodyToMono(InputStreamResource.class)
                .log()
                .block();

        return stream;
    }

    public InputStreamResource generateRDFPortal(String tip, Long dokumentId) {
        WebClient client = WebClient.create(BASE_URI);

        InputStreamResource stream = client.get()
                .uri("/api/dokumenti/metadata/rdf/"+ tip + "/" + dokumentId)
                .retrieve()
                .bodyToMono(InputStreamResource.class)
                .log()
                .block();

        return stream;
    }

    public InputStreamResource generateJSONPortal(String tip, Long dokumentId) {
        WebClient client = WebClient.create(BASE_URI);

        InputStreamResource stream = client.get()
                .uri("/api/dokumenti/metadata/json/"+ tip + "/" + dokumentId)
                .retrieve()
                .bodyToMono(InputStreamResource.class)
                .log()
                .block();

        return stream;
    }

    public InputStreamResource generatePdfPortal(String tip, Long dokumentId) {
        WebClient client = WebClient.create(BASE_URI);

        InputStreamResource stream = client.get()
                .uri("/api/dokumenti/pdf/" + tip + "/" + dokumentId)
                .retrieve()
                .bodyToMono(InputStreamResource.class)
                .log()
                .block();

        return stream;
    }

    public DokumentiIzPretrageDTO getZahteviZaSertNeobradjeni() {
        WebClient client = WebClient.create(BASE_URI);

        DokumentiIzPretrageDTO zahtevi = client.get()
                .uri("/b2b/zahtevi-za-sertifikat/neobradjeni")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(DokumentiIzPretrageDTO.class)
                .log()
                .block();

        return zahtevi;
    }

    public Zahtev prihvatiZahtev(Long idZahteva) {
        WebClient client = WebClient.create(BASE_URI);

        Zahtev Uzahtev = client.get()
                .uri("/b2b/prihvati/zahtev-za-sertifikat/"+idZahteva)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(Zahtev.class)
                .log()
                .block();

        return Uzahtev;
    }

    public Zahtev odbijZahteviZaSert(Long id, String razlog) throws MessagingException {
        WebClient client = WebClient.create(BASE_URI);

        Zahtev Uzahtev = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/b2b/odbij/zahtev-za-sertifikat/"+id)
                        .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToMono(Zahtev.class)
                .log()
                .block();

        emailService.sendOdbijenZahtevZaSertifikat(Uzahtev.getPacijent().getIme()+"@email.com", razlog);

        return Uzahtev;
    }

    public DokumentiKorisnikaDTO getRefDokumenti(String dokumentURI) {
        WebClient client = WebClient.create(BASE_URI);

        DokumentiKorisnikaDTO result = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/b2b/referencirani-dokumenti/"+dokumentURI)
                        .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, (err) -> {
                    System.out.println("Nema referenciranih dokumenata"); return null; })
                .bodyToMono(DokumentiKorisnikaDTO.class)
                .log()
                .block();

        return result;
    }

    public DokumentiKorisnikaDTO getKojiRefDokument(String dokumentURI) {
        WebClient client = WebClient.create(BASE_URI);

        DokumentiKorisnikaDTO result = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/b2b/referenciraju-dokument/"+dokumentURI)
                        .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, (err) -> {
                    System.out.println("Nema dokumenata koji referenciraju ovaj"); return null; })
                .bodyToMono(DokumentiKorisnikaDTO.class)
                .log()
                .block();

        return result;
    }
}
