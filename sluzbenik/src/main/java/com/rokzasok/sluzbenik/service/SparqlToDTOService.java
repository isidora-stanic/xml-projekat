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

    public Long getBrojDigitalnihSertifikata(String odDatum, String doDatum) {
        try {
            List<SparqlService.SparqlQueryResult> sparqlBrDIgitalnih = sparqlService.getBrojDigitalnihSertifikataUVremenskomPeriodu(odDatum, doDatum);

            return Long.valueOf(sparqlBrDIgitalnih.get(0).getVarValue().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}