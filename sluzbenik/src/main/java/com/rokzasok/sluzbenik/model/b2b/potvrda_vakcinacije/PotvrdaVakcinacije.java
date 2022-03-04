package com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije;

import com.rokzasok.sluzbenik.interfaces.Identifiable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"osoba", "doze", "qrLink", "datumIzdavanja", "dokumentId"})
@XmlRootElement(name = "potvrda-vakcinacije", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije")
public class PotvrdaVakcinacije implements Identifiable {

    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected TOsoba osoba;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected Doze doze;
    @XmlElement(name = "qr_link", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String qrLink;
    @XmlElement(name = "datum_izdavanja", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected DatumIzdavanja datumIzdavanja;
    @XmlElement(name = "dokument_id", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Long dokumentId;
    @XmlAttribute(name = "vocab")
    protected String vocab;
    @XmlAttribute(name = "about")
    protected String about;
    @XmlAttribute(name = "rel")
    protected String rel;
    @XmlAttribute(name = "href")
    protected String href;

    public PotvrdaVakcinacije() {
        this.osoba = new TOsoba();
        this.doze = new Doze();
        this.datumIzdavanja = new DatumIzdavanja();
    }

    public TOsoba getOsoba() {
        return osoba;
    }


    public void setOsoba(TOsoba value) {
        this.osoba = value;
    }


    public Doze getDoze() {
        return doze;
    }


    public void setDoze(Doze value) {
        this.doze = value;
    }


    public String getQrLink() {
        return qrLink;
    }


    public void setQrLink(String value) {
        this.qrLink = value;
    }


    public DatumIzdavanja getDatumIzdavanja() {
        return datumIzdavanja;
    }


    public void setDatumIzdavanja(LocalDate datum) {
        this.datumIzdavanja = new DatumIzdavanja();
        this.datumIzdavanja.setValue(datum);
    }

    public void setDatumIzdavanja(DatumIzdavanja value) {
        this.datumIzdavanja = value;
    }


    public Long getDokumentId() {
        return dokumentId;
    }


    public void setDokumentId(Long value) {
        this.dokumentId = value;
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


    public String getRel() {
        if (rel == null) {
            return "pred:prethodniDokument";
        } else {
            return rel;
        }
    }


    public void setRel(String value) {
        this.rel = value;
    }


    public String getHref() {
        if (href == null) {
            return "xs:string";
        } else {
            return href;
        }
    }


    public void setHref(String value) {
        this.href = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class DatumIzdavanja {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;

        public void setValue(LocalDate date) {
            try {
                this.value = DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
        }

        public XMLGregorianCalendar getValue() {
            return value;
        }


        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:datumKreiranja";
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
    @XmlType(name = "", propOrder = {"doza"})
    public static class Doze {

        @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
        protected List<TDoza> doza;

        public Doze() {
        }

        public Doze(List<TDoza> doza) {
            this.doza = doza;
        }

        public List<TDoza> getDoza() {
            if (doza == null) {
                doza = new ArrayList<TDoza>();
            }
            return this.doza;
        }

    }

}
