
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_osoba", namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", propOrder = {
        "jmbg",
        "ime",
        "prezime",
        "pol",
        "datumRodjenja",
        "brojPasosa",
        "id"
})
public class TOsoba {

    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected String jmbg;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected String ime;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected String prezime;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    @XmlSchemaType(name = "string")
    protected TPol pol;
    @XmlElement(name = "datum_rodjenja", namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(name = "broj_pasosa", namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected String brojPasosa;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected Id id;


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


    public String getBrojPasosa() {
        return brojPasosa;
    }


    public void setBrojPasosa(String value) {
        this.brojPasosa = value;
    }


    public Id getId() {
        return id;
    }


    public void setId(Id value) {
        this.id = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Id {

        @XmlValue
        protected long value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


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
