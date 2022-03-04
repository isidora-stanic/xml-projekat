package com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAdresa", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", propOrder = {"mesto", "ulica", "broj"})
public class TAdresa {

    @XmlElement(name = "Mesto", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String mesto;
    @XmlElement(name = "Ulica", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String ulica;
    @XmlElement(name = "Broj", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat")
    protected int broj;

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
