package com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"osoba", "doze", "qrLink", "razlogIzdavanja", "datumIzdavanja", "dokumentId"})
@XmlRootElement(name = "potvrda-vakcinacije", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije")
public class PotvrdaVakcinacije implements Identifiable {

    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected Osoba osoba;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected Doze doze;
    @XmlElement(name = "qr_link", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String qrLink;
    @XmlElement(name = "razlog_izdavanja", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected RazlogIzdavanja razlogIzdavanja;
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
        this.osoba = new Osoba();
        this.doze = new Doze();
        this.razlogIzdavanja = new RazlogIzdavanja();
        this.datumIzdavanja = new DatumIzdavanja();
    }

    public Osoba getOsoba() {
        return osoba;
    }


    public void setOsoba(Osoba value) {
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


    public RazlogIzdavanja getRazlogIzdavanja() {
        return razlogIzdavanja;
    }


    public void setRazlogIzdavanja(RazlogIzdavanja value) {
        this.razlogIzdavanja = value;
    }

    public void setRazlogIzdavanja(String razlogIzdavanja) {
        this.razlogIzdavanja = new RazlogIzdavanja(razlogIzdavanja);
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
                return "pred:datumIzdavanja";
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


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"jmbg", "ime", "prezime", "pol", "datumRodjenja", "id"})
    public static class Osoba {

        @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
        protected String jmbg;
        @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
        protected String ime;
        @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
        protected String prezime;
        @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
        protected Pol pol;
        @XmlElement(name = "datum_rodjenja", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
        protected DatumRodjenja datumRodjenja;
        @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
        protected Id id;

        public Osoba() {
            this.id = new Id();
        }

        public Osoba(String jmbg, String ime, String prezime, Pol pol, DatumRodjenja datumRodjenja, Long id) {
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


        public Id getId() {
            return id;
        }


        public void setId(Id value) {
            this.id = value;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"value"})
        public static class DatumRodjenja {

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
        @XmlType(name = "", propOrder = {"value"})
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


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class RazlogIzdavanja {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;

        public RazlogIzdavanja() {
        }

        public RazlogIzdavanja(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }


        public void setValue(String value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:razlogIzdavanja";
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
