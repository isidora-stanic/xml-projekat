package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "zahtev", namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat")
public class Zahtev implements Identifiable {

    @XmlElement(name = "razlog_podnosenja", namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected RazlogPodnosenja razlogPodnosenja;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected Mesto mesto;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected Datum datum;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected TOsoba pacijent;
    @XmlElement(name = "dokument_id", namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Long dokumentId;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat")
    protected Status status;
    @XmlAttribute(name = "vocab")
    protected String vocab;
    @XmlAttribute(name = "about")
    protected String about;


    public RazlogPodnosenja getRazlogPodnosenja() {
        return razlogPodnosenja;
    }


    public void setRazlogPodnosenja(RazlogPodnosenja value) {
        this.razlogPodnosenja = value;
    }


    public Mesto getMesto() {
        return mesto;
    }


    public void setMesto(Mesto value) {
        this.mesto = value;
    }


    public Datum getDatum() {
        return datum;
    }


    public void setDatum(Datum value) {
        this.datum = value;
    }


    public TOsoba getPacijent() {
        return pacijent;
    }


    public void setPacijent(TOsoba value) {
        this.pacijent = value;
    }


    public Long getDokumentId() {
        return dokumentId;
    }


    public void setDokumentId(Long value) {
        this.dokumentId = value;
    }

    @Override
    public XMLGregorianCalendar getDatumKreiranja() {
        return this.datum.value;
    }

    @Override
    public String getTipDokumenta() {
        return "Zahtev za sertifikat";
    }


    public Status getStatus() {
        return status;
    }


    public void setStatus(Status value) {
        this.status = value;
    }


    public String getVocab() {
        if (vocab == null) {
            return "http://www.rokzasok.rs/rdf/database/predicate";
        } else {
            return vocab;
        }
    }


    public void setVocab(String value) {
        this.vocab = value;
    }


    public String getAbout() {
        return about;
    }


    public void setAbout(String value) {
        this.about = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class Datum {

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
                return "pred:datumPodnosenja";
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
    public static class Mesto {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


        public String getValue() {
            return value;
        }


        public void setValue(String value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:mestoPodnosenja";
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


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class RazlogPodnosenja {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


        public String getValue() {
            return value;
        }


        public void setValue(String value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:razlogPodnosenja";
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


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class Status {

        @XmlValue
        protected boolean value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


        public boolean isValue() {
            return value;
        }


        public void setValue(boolean value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:status";
            } else {
                return property;
            }
        }


        public void setProperty(String value) {
            this.property = value;
        }


        public String getDatatype() {
            if (datatype == null) {
                return "xs:boolean";
            } else {
                return datatype;
            }
        }


        public void setDatatype(String value) {
            this.datatype = value;
        }

    }

}
