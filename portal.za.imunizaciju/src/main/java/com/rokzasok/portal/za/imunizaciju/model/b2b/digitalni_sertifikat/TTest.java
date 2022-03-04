package com.rokzasok.portal.za.imunizaciju.model.b2b.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TTest", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", propOrder = {"naziv", "opis", "vrstaUzorka", "proizvodjac", "datumIVremeUzorkovanja", "datumIVremeRezultata", "rezultat", "laboratorija"})
public class TTest {

    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String naziv;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String opis;
    @XmlElement(name = "vrsta_uzorka", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true, defaultValue = "N/A")
    protected String vrstaUzorka;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true, defaultValue = "N/A")
    protected String proizvodjac;
    @XmlElement(name = "datum_i_vreme_uzorkovanja", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String datumIVremeUzorkovanja;
    @XmlElement(name = "datum_i_vreme_rezultata", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String datumIVremeRezultata;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true, defaultValue = "N/A")
    protected String rezultat;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true, defaultValue = "N/A")
    protected String laboratorija;

    public TTest() {
    }

    public TTest(String naziv, String opis) {
        this.naziv = naziv;
        this.opis = opis;
        this.vrstaUzorka = "N/A";
        this.proizvodjac = "N/A";
        this.datumIVremeUzorkovanja = "N/A";
        this.datumIVremeRezultata = "N/A";
        this.rezultat = "N/A";
        this.laboratorija = "N/A";
    }

    public String getNaziv() {
        return naziv;
    }


    public void setNaziv(String value) {
        this.naziv = value;
    }


    public String getOpis() {
        return opis;
    }


    public void setOpis(String value) {
        this.opis = value;
    }


    public String getVrstaUzorka() {
        return vrstaUzorka;
    }


    public void setVrstaUzorka(String value) {
        this.vrstaUzorka = value;
    }


    public String getProizvodjac() {
        return proizvodjac;
    }


    public void setProizvodjac(String value) {
        this.proizvodjac = value;
    }


    public String getDatumIVremeUzorkovanja() {
        return datumIVremeUzorkovanja;
    }


    public void setDatumIVremeUzorkovanja(String value) {
        this.datumIVremeUzorkovanja = value;
    }


    public String getDatumIVremeRezultata() {
        return datumIVremeRezultata;
    }


    public void setDatumIVremeRezultata(String value) {
        this.datumIVremeRezultata = value;
    }


    public String getRezultat() {
        return rezultat;
    }


    public void setRezultat(String value) {
        this.rezultat = value;
    }


    public String getLaboratorija() {
        return laboratorija;
    }


    public void setLaboratorija(String value) {
        this.laboratorija = value;
    }

}
