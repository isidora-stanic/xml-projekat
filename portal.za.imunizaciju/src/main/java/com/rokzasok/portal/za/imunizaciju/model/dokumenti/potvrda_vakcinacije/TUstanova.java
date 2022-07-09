package com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_ustanova", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", propOrder = {"naziv", "mesto"})
public class TUstanova {

    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String naziv;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String mesto;

    public TUstanova() {
    }

    public TUstanova(String mesto, String naziv) {
        this.naziv = naziv;
        this.mesto = mesto;
    }

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
