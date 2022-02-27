package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.fuseki.SparqlService;
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

    public Long getIdPoslednjePotvrde(Long idOsobe) {
        List<SparqlService.SparqlQueryResult> sparqlBrDigitalnih = sparqlService.getPoslednjaPotvrdaVakcinacije(idOsobe);

        String val = sparqlBrDigitalnih.get(0).getVarValue().asNode().getLiteralValue().toString().split("potvrda-vakcinacije/")[1].replace(">", "");

        return Long.valueOf(val);
    }

    public Long getBrojDigitalnihSertifikata(String odDatum, String doDatum) {
        try {
            List<SparqlService.SparqlQueryResult> sparqlBrDigitalnih = sparqlService.getBrojDigitalnihSertifikataUVremenskomPeriodu(odDatum, doDatum);

            return Long.valueOf(sparqlBrDigitalnih.get(0).getVarValue().asNode().getLiteralValue().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
