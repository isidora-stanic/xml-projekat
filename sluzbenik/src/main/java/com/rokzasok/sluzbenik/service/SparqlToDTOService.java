package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.fuseki.SparqlService;
import com.rokzasok.sluzbenik.model.dto.DokumentiKorisnikaDTO;
import org.apache.jena.datatypes.xsd.XSDDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class SparqlToDTOService {
    @Autowired
    private SparqlService sparqlService;
    @Autowired
    private B2BService b2BService;


    public Long getBrojDigitalnihSertifikata(String odDatum, String doDatum) {
        try {
            List<SparqlService.SparqlQueryResult> sparqlBrDigitalnih = sparqlService.getBrojDigitalnihSertifikataUVremenskomPeriodu(odDatum, doDatum);

            return Long.valueOf(sparqlBrDigitalnih.get(0).getVarValue().asNode().getLiteralValue().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public DokumentiKorisnikaDTO getDokumentiKorisnikaSluzbenik(Long idKorisnika) {
        try {
            List<SparqlService.SparqlQueryResult> sparqlDokumentLinkovi = sparqlService.getAllKreiranOdStrane(idKorisnika.toString());

            DokumentiKorisnikaDTO dokumentiKorisnikaDTO = new DokumentiKorisnikaDTO();
            dokumentiKorisnikaDTO.setListaDokumenata(new ArrayList<>());

            dokumentiKorisnikaDTO.setIdKorisnika(idKorisnika);

            int i = 0;

            while (i < sparqlDokumentLinkovi.size()) {
                SparqlService.SparqlQueryResult result = sparqlDokumentLinkovi.get(i);
                String dokumentURI = result.getVarValue().toString();

                String tipDokumentaWithId = dokumentURI.split("database/")[1];

                String[] split = tipDokumentaWithId.split("/");

                String tipDokumenta = split[0].replaceAll("-", " ");
                tipDokumenta = tipDokumenta.substring(0, 1).toUpperCase() + tipDokumenta.substring(1);

                result = sparqlDokumentLinkovi.get(i + 1);
                XSDDateTime xsdDatum = (XSDDateTime) result.getVarValue().asNode().getLiteralValue();

                XMLGregorianCalendar xmlDatum = DatatypeFactory.newInstance().newXMLGregorianCalendar(xsdDatum.toString());


                dokumentiKorisnikaDTO.getListaDokumenata().add(new DokumentiKorisnikaDTO.DokumentDTO(dokumentURI, tipDokumenta, xmlDatum));

                i += 2;
            }

            return dokumentiKorisnikaDTO;

        } catch (IOException | DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return null;
    }


    public DokumentiKorisnikaDTO getReferenciraniDokumenti(String dokumentUri) {
        if (!dokumentUri.contains("digitalni")) {
            return b2BService.getRefDokumenti(dokumentUri);
        }
        try {
            List<SparqlService.SparqlQueryResult> sparqlDokumentLinkovi = sparqlService.getPrethodniDokumenti(dokumentUri);

            DokumentiKorisnikaDTO dokumentiKorisnikaDTO = new DokumentiKorisnikaDTO();
            dokumentiKorisnikaDTO.setListaDokumenata(new ArrayList<>());

            dokumentiKorisnikaDTO.setIdKorisnika(-1L);

            int i = 0;

            while (i < sparqlDokumentLinkovi.size()) {
                SparqlService.SparqlQueryResult result = sparqlDokumentLinkovi.get(i);
                String dokumentURI = result.getVarValue().toString();

                String tipDokumentaWithId = dokumentURI.split("database/")[1];

                String[] split = tipDokumentaWithId.split("/");

                String tipDokumenta = split[0].replaceAll("-", " ");
                tipDokumenta = tipDokumenta.substring(0, 1).toUpperCase() + tipDokumenta.substring(1);

                dokumentiKorisnikaDTO.getListaDokumenata().add(new DokumentiKorisnikaDTO.DokumentDTO(dokumentURI, tipDokumenta, null));

                i++;
            }

            return dokumentiKorisnikaDTO;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
