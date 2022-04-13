package com.rokzasok.portal.za.imunizaciju.controller;

import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiKorisnikaDTO;
import com.rokzasok.portal.za.imunizaciju.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/api/dokumenti")
public class DokumentiController {
    @Autowired
    private SparqlToDTOService sparqlToDTOService;
    @Autowired
    private B2BService b2bService;

    @Autowired
    IskazivanjeInteresovanjaService zahtjevZaImunizacijuService;
    @Autowired
    ObrazacSaglasnostiService obrazacSaglasnostiService;
    @Autowired
    PotvrdaVakcinacijeService potvrdaVakcinacijeService;
    @Autowired
    ZahtevZaSertifikatService zahtevZaSertifikatService;


    @GetMapping(value = "/digitalni-sertifikati-korisnika/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DokumentiKorisnikaDTO> getDigitalniSertifikatiKorisnika(@PathVariable("id") Long id) {
        return new ResponseEntity<>(sparqlToDTOService.getDokumentiKorisnikaPortal(id), HttpStatus.OK);
    }

    @GetMapping(value = "/dokumenti-po-korisniku/{idKorisnika}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<DokumentiKorisnikaDTO> getDokumentiKorisnika(@PathVariable("idKorisnika") Long idKorisnika) {
        System.out.println("ayo?");
        DokumentiKorisnikaDTO d1 = sparqlToDTOService.getDokumentiKorisnikaPortal(idKorisnika);
        DokumentiKorisnikaDTO d2 = b2bService.getDigitalniSertifikatiKorisnika(idKorisnika);
        DokumentiKorisnikaDTO dFinal = new DokumentiKorisnikaDTO();
        dFinal.setIdKorisnika(idKorisnika);
        dFinal.setListaDokumenata(new ArrayList<>());
        dFinal.getListaDokumenata().addAll(d1.getListaDokumenata());
        dFinal.getListaDokumenata().addAll(d2.getListaDokumenata());
        return new ResponseEntity<>(dFinal, HttpStatus.OK);
    }

    // pdf, html
    @GetMapping(value = "/html/iskazivanje-interesovanja/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml1(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.zahtjevZaImunizacijuService.generateHtml(dokumentId);
        }
        catch (IOException | SAXException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=potvrda.html");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/pdf/iskazivanje-interesovanja/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdf1(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.zahtjevZaImunizacijuService.generatePDF(dokumentId);
        }
        catch (IOException | SAXException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=zahtev.pdf");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/html/obrazac-saglasnosti/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml2(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.obrazacSaglasnostiService.generateHtml(dokumentId);
        }
        catch (IOException | SAXException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=obrazac.html");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/pdf/obrazac-saglasnosti/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdf2(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.obrazacSaglasnostiService.generatePDF(dokumentId);
        }
        catch (IOException | SAXException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=obrazac.pdf");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/html/potvrda-vakcinacije/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml3(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.potvrdaVakcinacijeService.generateHtml(dokumentId);
        }
        catch (IOException | SAXException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=potvrda.html");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/pdf/potvrda-vakcinacije/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdfFo3(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            //is = this.potvrdaVakcinacijeService.generatePDF_FO(dokumentId);
            is = this.potvrdaVakcinacijeService.generatePDF_HTML(dokumentId);
        }
        catch (IOException | SAXException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=potvrda.pdf");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/html/zahtev-za-sertifikat/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml4(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.zahtevZaSertifikatService.generateHtml(dokumentId);
        }
        catch (IOException | SAXException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=zahtev.html");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/pdf/zahtev-za-sertifikat/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdf4(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.zahtevZaSertifikatService.generatePDF(dokumentId);
        }
        catch (IOException | SAXException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=zahtev.pdf");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    // digitalni sa sluzbenika pdf i html
    @GetMapping(value = "/html/digitalni-sertifikat/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml5(@PathVariable Long dokumentId) {
        InputStreamResource is;
        is = this.b2bService.generateHtmlDigitalni(dokumentId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=sertifikat.html");

        return new ResponseEntity<>(is, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/pdf/digitalni-sertifikat/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdf5(@PathVariable Long dokumentId) {
        InputStreamResource is;
        is = this.b2bService.generatePdfDigitalni(dokumentId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=sertifikat.pdf");

        return new ResponseEntity<>(is, headers, HttpStatus.OK);
    }

}
