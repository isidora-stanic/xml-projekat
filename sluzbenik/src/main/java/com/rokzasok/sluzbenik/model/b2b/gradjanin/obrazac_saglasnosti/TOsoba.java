package com.rokzasok.sluzbenik.model.b2b.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_osoba", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", propOrder = {"ime", "prezime", "pol", "datumRodjenja", "adresa"})
public class TOsoba {

    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected String ime;
    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected String prezime;
    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected Pol pol;
    @XmlElement(name = "datum_rodjenja", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected DatumRodjenja datumRodjenja;
    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected TAdresa adresa;


    public String getIme() {
        return ime;
    }


    public void setIme(String value) {
        this.ime = value;
    }


    public String getPrezime() {
        return prezime;
    }


    public void setPrezime(String value) {
        this.prezime = value;
    }


    public Pol getPol() {
        return pol;
    }


    public void setPol(Pol value) {
        this.pol = value;
    }


    public DatumRodjenja getDatumRodjenja() {
        return datumRodjenja;
    }


    public void setDatumRodjenja(DatumRodjenja value) {
        this.datumRodjenja = value;
    }


    public TAdresa getAdresa() {
        return adresa;
    }


    public void setAdresa(TAdresa value) {
        this.adresa = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class DatumRodjenja {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


        public XMLGregorianCalendar getValue() {
            return value;
        }


        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:datumRodjenja";
            } else {
                return property;
            }
        }


        public void setProperty(String value) {
            this.property = value;
        }


        public String getDatatype() {
            if (datatype == null) {
                return "xs:date";
            } else {
                return datatype;
            }
        }


        public void setDatatype(String value) {
            this.datatype = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class Pol {

        @XmlValue
        protected TPol value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


        public TPol getValue() {
            return value;
        }


        public void setValue(TPol value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:pol";
            } else {
                return property;
            }
        }


        public void setProperty(String value) {
            this.property = value;
        }


        public String getDatatype() {
            if (datatype == null) {
                return "xs:string";
            } else {
                return datatype;
            }
        }


        public void setDatatype(String value) {
            this.datatype = value;
        }

    }

}
