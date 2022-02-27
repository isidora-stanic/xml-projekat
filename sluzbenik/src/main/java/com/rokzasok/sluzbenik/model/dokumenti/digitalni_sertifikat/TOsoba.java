
package com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TOsoba", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", propOrder = {
        "jmbg",
        "ime",
        "prezime",
        "pol",
        "datumRodjenja",
        "brojPasosa",
        "id"
})
public class TOsoba {

    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String jmbg;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String ime;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String prezime;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected Pol pol;
    @XmlElement(name = "datum_rodjenja", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected DatumRodjenja datumRodjenja;
    @XmlElement(name = "broj_pasosa", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected BrojPasosa brojPasosa;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected Id id;

    public TOsoba() {
    }

    public TOsoba(String jmbg, String ime, String prezime, TPol pol, XMLGregorianCalendar datumRodjenja, String brojPasosa, Long id) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = new Pol();
        this.pol.setValue(pol);
        this.datumRodjenja = new DatumRodjenja(datumRodjenja);
        this.brojPasosa = new BrojPasosa(brojPasosa);
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




    public BrojPasosa getBrojPasosa() {
        return brojPasosa;
    }


    public void setBrojPasosa(BrojPasosa value) {
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
    public static class BrojPasosa {

        public BrojPasosa() {
        }

        public BrojPasosa(String value) {
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
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class DatumRodjenja {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;

        public DatumRodjenja(XMLGregorianCalendar value) {
            this.value = value;
        }

        public DatumRodjenja() {
        }

        public XMLGregorianCalendar getValue() {
            return value;
        }


        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }

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


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Pol {

        @XmlValue
        protected TPol value;


        public TPol getValue() {
            return value;
        }


        public void setValue(TPol value) {
            this.value = value;
        }

    }

}
