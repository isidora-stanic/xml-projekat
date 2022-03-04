package com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDoza", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", propOrder = {"tip", "proizvodjac", "datum", "brojSerije", "brojDoze", "ustanova"})
@XmlSeeAlso({DigitalniSertifikat.Vakcinacija.Doza.class})
public class TDoza {
    public TDoza() {
    }

    public TDoza(String tip, String proizvodjac, XMLGregorianCalendar datum, String brojSerije, BigInteger brojDoze, String nazivUstanove, String mestoUstanove) {
        this.tip = new Tip(tip);
        this.proizvodjac = new Proizvodjac(proizvodjac);
        this.datum = new Datum(datum);
        this.brojSerije = new BrojSerije(brojSerije);
        this.brojDoze = new BrojDoze(brojDoze);
        this.ustanova = new TUstanova(nazivUstanove, mestoUstanove);
    }

    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected Tip tip;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected Proizvodjac proizvodjac;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected Datum datum;
    @XmlElement(name = "broj_serije", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected BrojSerije brojSerije;
    @XmlElement(name = "broj_doze", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected BrojDoze brojDoze;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected TUstanova ustanova;


    public Tip getTip() {
        return tip;
    }


    public void setTip(Tip value) {
        this.tip = value;
    }


    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }


    public void setProizvodjac(Proizvodjac value) {
        this.proizvodjac = value;
    }


    public Datum getDatum() {
        return datum;
    }


    public void setDatum(Datum value) {
        this.datum = value;
    }


    public BrojSerije getBrojSerije() {
        return brojSerije;
    }


    public void setBrojSerije(BrojSerije value) {
        this.brojSerije = value;
    }


    public BrojDoze getBrojDoze() {
        return brojDoze;
    }


    public void setBrojDoze(BrojDoze value) {
        this.brojDoze = value;
    }


    public TUstanova getUstanova() {
        return ustanova;
    }


    public void setUstanova(TUstanova value) {
        this.ustanova = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class BrojDoze {
        public BrojDoze() {
        }

        public BrojDoze(BigInteger value) {
            this.value = value;
        }

        @XmlValue
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger value;


        public BigInteger getValue() {
            return value;
        }


        public void setValue(BigInteger value) {
            this.value = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class BrojSerije {

        public BrojSerije() {
        }

        public BrojSerije(String value) {
            this.value = value;
        }

        @XmlValue
        protected String value;


        public String getValue() {
            return value;
        }


        public void setValue(String value) {
            this.value = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class Datum {
        public Datum() {
        }

        public Datum(XMLGregorianCalendar value) {
            this.value = value;
        }

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;


        public XMLGregorianCalendar getValue() {
            return value;
        }


        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class Proizvodjac {
        public Proizvodjac(String value) {
            this.value = TProizvodjacVakcine.fromValue(value);
        }

        public Proizvodjac() {
        }

        @XmlValue
        protected TProizvodjacVakcine value;


        public TProizvodjacVakcine getValue() {
            return value;
        }


        public void setValue(TProizvodjacVakcine value) {
            this.value = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class Tip {
        public Tip() {
        }

        public Tip(String value) {
            this.value = TTipVakcine.fromValue(value);
        }

        @XmlValue
        protected TTipVakcine value;


        public TTipVakcine getValue() {
            return value;
        }


        public void setValue(TTipVakcine value) {
            this.value = value;
        }

    }

}
