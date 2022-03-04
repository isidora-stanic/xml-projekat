package com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_doza", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", propOrder = {"tip", "proizvodjac", "datum", "brojSerije", "brojDoze", "ustanova"})
public class TDoza {

    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String tip;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String proizvodjac;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "broj_serije", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String brojSerije;
    @XmlElement(name = "broj_doze", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brojDoze;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected TUstanova ustanova;

    public TDoza() {
    }

    public TDoza(String tip, String proizvodjac, XMLGregorianCalendar datum, String brojSerije, BigInteger brojDoze, String mesto, String naziv) {
        this.tip = tip;
        this.proizvodjac = proizvodjac;
        this.datum = datum;
        this.brojSerije = brojSerije;
        this.brojDoze = brojDoze;
        this.ustanova = new TUstanova(mesto, naziv);
    }


    public String getTip() {
        return tip;
    }


    public void setTip(String value) {
        this.tip = value;
    }


    public String getProizvodjac() {
        return proizvodjac;
    }


    public void setProizvodjac(String value) {
        this.proizvodjac = value;
    }


    public XMLGregorianCalendar getDatum() {
        return datum;
    }


    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }


    public String getBrojSerije() {
        return brojSerije;
    }


    public void setBrojSerije(String value) {
        this.brojSerije = value;
    }


    public BigInteger getBrojDoze() {
        return brojDoze;
    }


    public void setBrojDoze(BigInteger value) {
        this.brojDoze = value;
    }


    public TUstanova getUstanova() {
        return ustanova;
    }


    public void setUstanova(TUstanova value) {
        this.ustanova = value;
    }

}
