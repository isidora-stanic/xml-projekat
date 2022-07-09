package com.rokzasok.sluzbenik.model.b2b.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_ustanova", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", propOrder = {"naziv", "mesto"})
public class TUstanova {

    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected String naziv;
    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
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
