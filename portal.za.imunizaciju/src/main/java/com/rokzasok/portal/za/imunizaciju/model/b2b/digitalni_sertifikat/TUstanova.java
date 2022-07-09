package com.rokzasok.portal.za.imunizaciju.model.b2b.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TUstanova", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", propOrder = {"naziv", "mesto"})
public class TUstanova {
    public TUstanova() {
    }

    public TUstanova(String naziv, String mesto) {
        this.naziv = naziv;
        this.mesto = mesto;
    }

    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String naziv;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String mesto;


    public String getNaziv() {
        return naziv;
    }


    public void setNaziv(String value) {
        this.naziv = value;
    }


    public String getMesto() {
        return mesto;
    }


    public void setMesto(String value) {
        this.mesto = value;
    }

}
