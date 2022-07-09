package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.model.b2b.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.sluzbenik.model.b2b.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.sluzbenik.model.dto.DokumentiIzPretrageDTO;
import com.rokzasok.sluzbenik.model.dto.DokumentiKorisnikaDTO;
import com.rokzasok.sluzbenik.service.B2BService;
import com.rokzasok.sluzbenik.service.DigitalniSertifikatService;
import com.rokzasok.sluzbenik.service.IzvestajOImunizacijiService;
import com.rokzasok.sluzbenik.service.RDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/api/dokumenti")
public class PortalDokumentiController {

    @Autowired
    private B2BService b2bService;

    @Autowired
    private DigitalniSertifikatService digitalniSertifikatService;

    @Autowired
    private IzvestajOImunizacijiService izvestajOImunizacijiService;

    @Autowired
    private RDFService rdfService;

    @GetMapping(value = "/html/{tip}/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml5(@PathVariable String tip, @PathVariable Long dokumentId) {
        if (tip.equals("digitalni-sertifikat")) {
            ByteArrayInputStream is;
            try {
                is = this.digitalniSertifikatService.generateHtml(dokumentId);
            }
            catch (IOException | SAXException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=sertifikat.html");

            return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
        }
        else if (tip.equals("izvestaj-o-imunizaciji")) {

            ByteArrayInputStream is;
            try {
                is = this.izvestajOImunizacijiService.generateHtml(dokumentId);
            }
            catch (IOException | SAXException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=izvestaj.html");

            return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
        }
        else {
            InputStreamResource is;
            is = this.b2bService.generateHtmlPortal(tip, dokumentId);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=sertifikat.html");

            return new ResponseEntity<>(is, headers, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/pdf/{tip}/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdf5(@PathVariable String tip, @PathVariable Long dokumentId) {
        if (tip.equals("digitalni-sertifikat")) {
            ByteArrayInputStream is;
            try {
                is = this.digitalniSertifikatService.generatePDF(dokumentId);
            }
            catch (IOException | SAXException | JAXBException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=sertifikat.pdf");

            return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
        }
        else if (tip.equals("izvestaj-o-imunizaciji")) {
            ByteArrayInputStream is;
            try {
                is = this.izvestajOImunizacijiService.generatePDF(dokumentId);
            }
            catch (IOException | SAXException | JAXBException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=izvestaj.pdf");

            return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
        }
        else {
            InputStreamResource is;
            is = this.b2bService.generatePdfPortal(tip, dokumentId);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=sertifikat.pdf");

            return new ResponseEntity<>(is, headers, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/metadata/rdf/{tip}/{dokumentId}")
    ResponseEntity<InputStreamResource> getRDF(@PathVariable String tip, @PathVariable Long dokumentId) {
        if (tip.equals("digitalni-sertifikat")) {
            ByteArrayInputStream is;
            try {
                String xmlEntity = this.digitalniSertifikatService.getRdfaString(dokumentId);
                System.out.println(xmlEntity);
                is = new ByteArrayInputStream(this.rdfService.getRDFAsRDF(xmlEntity).getBytes());
            }
            catch (IOException | SAXException | JAXBException | TransformerException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=sertifikat-metadata.rdf");

            return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
        }
        else if (tip.equals("izvestaj-o-imunizaciji")) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
        else {
            InputStreamResource is;
            is = this.b2bService.generateRDFPortal(tip, dokumentId);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=metadata.rdf");

            return new ResponseEntity<>(is, headers, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/metadata/json/{tip}/{dokumentId}")
    ResponseEntity<InputStreamResource> getJSON(@PathVariable String tip, @PathVariable Long dokumentId) {
        if (tip.equals("digitalni-sertifikat")) {
            ByteArrayInputStream is;
            try {
                String xmlEntity = this.digitalniSertifikatService.getRdfaString(dokumentId);
                System.out.println(xmlEntity);
                is = new ByteArrayInputStream(this.rdfService.getRDFAsJSON(xmlEntity).getBytes());
            }
            catch (JAXBException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=sertifikat-metadata.json");

            return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
        }
        else if (tip.equals("izvestaj-o-imunizaciji")) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
        else {
            InputStreamResource is;
            is = this.b2bService.generateJSONPortal(tip, dokumentId);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline: filename=metadata.json");

            return new ResponseEntity<>(is, headers, HttpStatus.OK);
        }
    }


    @GetMapping(value="iskazivanje-interesovanja/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ObrazacInteresovanja> getIskazivanjeInteresovanja(@PathVariable String id) {
        return new ResponseEntity<>(b2bService.getIskazivanjeInteresovanja(id), HttpStatus.OK);
    }

    @GetMapping(value="obrazac-saglasnosti/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ObrazacSaglasnosti> getObrazacSaglasnosti(@PathVariable String id) {
        return new ResponseEntity<>(b2bService.getObrazacSaglasnosti(id), HttpStatus.OK);
    }

    @GetMapping(value="potvrda-vakcinacije/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<PotvrdaVakcinacije> getPotvrdaVakcinacije(@PathVariable String id) {
        return new ResponseEntity<>(b2bService.getPotvrdaVakcinacije(id), HttpStatus.OK);
    }

    @GetMapping(value="zahtev-za-sertifikat/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Zahtev> getZahtevZaSertifikat(@PathVariable String id) {
        return new ResponseEntity<>(b2bService.getZahtevZaSertifikat(id), HttpStatus.OK);
    }

    @GetMapping(value = "{idKorisnika}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DokumentiKorisnikaDTO> getDokumentiKorisnika(@PathVariable("idKorisnika") Long idKorisnika) {
        return new ResponseEntity<>(b2bService.getDokumentiKorisnika(idKorisnika.toString()), HttpStatus.OK);
    }

    @GetMapping(value = "zahtevi-za-sertifikat/neobradjeni", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DokumentiIzPretrageDTO> getZahteviZaSertNeobradjeni() {
        return new ResponseEntity<>(b2bService.getZahteviZaSertNeobradjeni(), HttpStatus.OK);
    }

    @GetMapping(value = "odbij/zahtev-za-sertifikat/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Zahtev> odbijZahteviZaSert(@PathVariable Long id, @RequestParam String razlog) throws MessagingException {
        return new ResponseEntity<>(b2bService.odbijZahteviZaSert(id, razlog), HttpStatus.OK);
    }

    
}
