package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.fuseki.SparqlService;
import com.rokzasok.portal.za.imunizaciju.model.b2b.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiKorisnikaDTO;
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

    public DokumentiKorisnikaDTO getDokumentiKorisnika(Long idKorisnika) {
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

    public IzvestajOImunizaciji generateIzvestaj(String odDatum, String doDatum) {
        try {
            List<SparqlService.SparqlQueryResult> sparqlBrInteresovanja = sparqlService.selectBrojIskazaInteresovanjaUVremenskomPeriodu(odDatum, doDatum);
            List<SparqlService.SparqlQueryResult> sparqlBrZahteva = sparqlService.selectBrojZahtevaZaSertifikatUVremenskomPeriodu(odDatum, doDatum);

            // TODO: FALI U SEMI BROJ UKUPNO PRIMLJENIH VAKCINA
            //  - MADA TO MOZE I NA FRONTU DA SE IZRACUNA SABIRAJUCI SVE DOZE
            //List<SparqlService.SparqlQueryResult> sparqlBrPotvrda = sparqlService.selectBrojPotvrdaVakcinacijeUVremenskomPeriodu(odDatum, doDatum);

            // popunjavanje izvestaja
            IzvestajOImunizaciji izvestaj = new IzvestajOImunizaciji();

            izvestaj.setBrInteresovanja(Long.valueOf(sparqlBrInteresovanja.get(0).getVarValue().asNode().getLiteralValue().toString()));
            izvestaj.setBrIzdatihZahtevaZaSertifikat(0L);
            izvestaj.setBrPrimljenihZahtevaZaSertifikat(Long.valueOf(sparqlBrZahteva.get(0).getVarValue().asNode().getLiteralValue().toString()));

            // redni br doze
            setUpDoze(izvestaj, 1L, odDatum, doDatum);
            setUpDoze(izvestaj, 2L, odDatum, doDatum);
            setUpDoze(izvestaj, 3L, odDatum, doDatum);

            // proizvodjaci
            setUpProizvodjac(izvestaj, "Pfizer, BioNTech", odDatum, doDatum);
            setUpProizvodjac(izvestaj, "Sputnik V (Gamaleya istraživački centar)", odDatum, doDatum);
            setUpProizvodjac(izvestaj, "Sinopharm", odDatum, doDatum);
            setUpProizvodjac(izvestaj, "AstraZeneca", odDatum, doDatum);
            setUpProizvodjac(izvestaj, "Moderna", odDatum, doDatum);

            // postavljanje od - do datuma
            setUpPeriod(izvestaj, odDatum, doDatum);

            izvestaj.setDatumIzdavanja(
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(
                            String.valueOf(LocalDate.now())));

            return izvestaj;

        } catch (IOException | DatatypeConfigurationException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setUpDoze(IzvestajOImunizaciji izvestaj, Long brDoze, String odDatum, String doDatum) throws IOException {
        List<SparqlService.SparqlQueryResult> sparqlBrDoza = sparqlService.getBrojPrimljenihXDoza(odDatum, doDatum, brDoze.toString());
        IzvestajOImunizaciji.DozeVakcina.Doza doza = new IzvestajOImunizaciji.DozeVakcina.Doza();
        doza.setRedniBrojDoze(brDoze);
        doza.setBrojDatih(Long.valueOf(sparqlBrDoza.get(0).getVarValue().asNode().getLiteralValue().toString()));
        izvestaj.getDozeVakcina().getDoza().add(doza);
    }

    public void setUpProizvodjac(IzvestajOImunizaciji izvestaj, String proizvodjac, String odDatum, String doDatum) throws IOException {
        List<SparqlService.SparqlQueryResult> sparqlBrPfizer = sparqlService.getBrojPoProizvodjacima(odDatum, doDatum, proizvodjac);
        Long brP = Long.valueOf(sparqlBrPfizer.get(0).getVarValue().asNode().getLiteralValue().toString());
        IzvestajOImunizaciji.RaspodelaPoProizvodjacima.Proizvodjac p = new IzvestajOImunizaciji.RaspodelaPoProizvodjacima.Proizvodjac();
        p.setNaziv(proizvodjac);
        p.setBrojPrimljenihDoza(brP);
        izvestaj.getRaspodelaPoProizvodjacima().getProizvodjac().add(p);
    }

    public void setUpPeriod(IzvestajOImunizaciji izvestaj, String odDatum, String doDatum) throws DatatypeConfigurationException, ParseException {
        IzvestajOImunizaciji.PeriodIzvestaja period = new IzvestajOImunizaciji.PeriodIzvestaja();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(odDatum);
        Date date2 = format.parse(doDatum);

        GregorianCalendar cal1 = new GregorianCalendar();
        cal1.setTime(date1);
        GregorianCalendar cal2 = new GregorianCalendar();
        cal2.setTime(date2);

        XMLGregorianCalendar xmlGregCal1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal1);
        XMLGregorianCalendar xmlGregCal2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal2);

        period.setOd(xmlGregCal1);
        period.setDo(xmlGregCal2);
        izvestaj.setPeriodIzvestaja(period);
    }

    public Long getIdPoslednjePotvrde(Long idOsobe) {
        List<SparqlService.SparqlQueryResult> sparqlBrDigitalnih = null;
        try {
            sparqlBrDigitalnih = sparqlService.getPoslednjaPotvrdaVakcinacije(idOsobe);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String val = sparqlBrDigitalnih.get(0).getVarValue().toString().split("potvrda-vakcinacije/")[1];

        return Long.valueOf(val);
    }

}
