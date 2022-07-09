package com.rokzasok.sluzbenik.controller;

import com.rokzasok.sluzbenik.helper.XmlConversionAgent;
import com.rokzasok.sluzbenik.model.dokumenti.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.rokzasok.sluzbenik.model.dokumenti.izvestaj_o_imunizaciji.KolekcijaIzvestaja;
import com.rokzasok.sluzbenik.service.B2BService;
import com.rokzasok.sluzbenik.service.IzvestajOImunizacijiService;
import com.rokzasok.sluzbenik.service.SparqlToDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;

@Controller
@RequestMapping(value = "/api/izvestaj-o-imunizaciji")
public class IzvestajOImunizacijiController {

    @Autowired
    private IzvestajOImunizacijiService izvestajService;

    @Autowired
    private SparqlToDTOService sparqlToDTOService;

    @Autowired
    private B2BService b2bService;

    @Autowired
    private XmlConversionAgent<IzvestajOImunizaciji> izvestajOImunizacijiXmlConversionAgent;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<KolekcijaIzvestaja> findAll() {
        KolekcijaIzvestaja kolekcijaIzvestajOImunizaciji = new KolekcijaIzvestaja();
        kolekcijaIzvestajOImunizaciji.setIzvestaj(this.izvestajService.findAll());
        return new ResponseEntity<>(kolekcijaIzvestajOImunizaciji, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<IzvestajOImunizaciji> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.izvestajService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<IzvestajOImunizaciji> create(@RequestBody String body) {
        return new ResponseEntity<>(this.izvestajService.create(body), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<IzvestajOImunizaciji> update(@RequestBody String body) {
        return new ResponseEntity<>(this.izvestajService.update(body), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.izvestajService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/gen", produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<IzvestajOImunizaciji> findOne(@RequestParam("odKad") String odKad, @RequestParam("doKad") String doKad) {
        IzvestajOImunizaciji izvestaj;
        try {
            izvestaj = b2bService.getIzvestajOImunizaciji(odKad, doKad);
            izvestaj.setBrIzdatihZahtevaZaSertifikat(sparqlToDTOService.getBrojDigitalnihSertifikata(odKad, doKad));
            izvestaj.setDatumIzdavanja(
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(
                            LocalDate.now().toString()));
            izvestaj = izvestajService.create(izvestajOImunizacijiXmlConversionAgent.marshall(izvestaj, "com.rokzasok.sluzbenik.model.dokumenti.izvestaj_o_imunizaciji"));
        } catch (DatatypeConfigurationException | JAXBException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(izvestaj, HttpStatus.OK);
    }


    @GetMapping(value = "/html/{dokumentId}")
    ResponseEntity<InputStreamResource> getHtml(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.izvestajService.generateHtml(dokumentId);
        }
        catch (IOException | SAXException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=izvestaj.html");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/pdf/{dokumentId}")
    ResponseEntity<InputStreamResource> getPdf(@PathVariable Long dokumentId) {
        ByteArrayInputStream is;
        try {
            is = this.izvestajService.generatePDF(dokumentId);
        }
        catch (IOException | SAXException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline: filename=izvestaj.pdf");

        return new ResponseEntity<>(new InputStreamResource(is), headers, HttpStatus.OK);
    }
}
