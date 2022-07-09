package com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_osoba", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", propOrder = {"jmbg", "ime", "prezime", "pol", "datumRodjenja", "id"})
public class TOsoba {

    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String jmbg;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String ime;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String prezime;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    @XmlSchemaType(name = "string")
    protected TPol pol;
    @XmlElement(name = "datum_rodjenja", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected Id id;

    public TOsoba() {
        this.id = new Id();
    }

    public TOsoba(String jmbg, String ime, String prezime, TPol pol, XMLGregorianCalendar datumRodjenja, Long id) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.id = new Id(id);
    }


    public String getJmbg() {
        return jmbg;
    }


    public void setJmbg(String value) {
        this.jmbg = value;
    }


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


    public TPol getPol() {
        return pol;
    }


    public void setPol(TPol value) {
        this.pol = value;
    }


    public XMLGregorianCalendar getDatumRodjenja() {
        return datumRodjenja;
    }


    public void setDatumRodjenja(XMLGregorianCalendar value) {
        this.datumRodjenja = value;
    }


    public Id getId() {
        return id;
    }


    public void setId(Id value) {
        this.id = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class Id {

        @XmlValue
        protected long value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;

        public Id() {
        }

        public Id(long value) {
            this.value = value;
        }


        public long getValue() {
            return value;
        }


        public void setValue(long value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:kreiranOdStrane";
            } else {
                return property;
            }
        }


        public void setProperty(String value) {
            this.property = value;
        }


        public String getDatatype() {
            if (datatype == null) {
                return "xs:long";
            } else {
                return datatype;
            }
        }


        public void setDatatype(String value) {
            this.datatype = value;
        }

    }

}
