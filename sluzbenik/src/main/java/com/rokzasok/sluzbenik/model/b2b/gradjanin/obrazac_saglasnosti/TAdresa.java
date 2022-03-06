package com.rokzasok.sluzbenik.model.b2b.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_adresa", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", propOrder = {"opstina", "mesto", "ulica", "broj"})
public class TAdresa {

    @XmlElement(name = "Opstina", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected String opstina;
    @XmlElement(name = "Mesto", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected String mesto;
    @XmlElement(name = "Ulica", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected String ulica;
    @XmlElement(name = "Broj", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
    protected int broj;


    public String getOpstina() {
        return opstina;
    }


    public void setOpstina(String value) {
        this.opstina = value;
    }


    public String getMesto() {
        return mesto;
    }


    public void setMesto(String value) {
        this.mesto = value;
    }


    public String getUlica() {
        return ulica;
    }


    public void setUlica(String value) {
        this.ulica = value;
    }


    public int getBroj() {
        return broj;
    }


    public void setBroj(int value) {
        this.broj = value;
    }

}
