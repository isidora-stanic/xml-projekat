package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"podaciOOsobi", "opstiPodaci", "dokumentId"})
@XmlRootElement(name = "obrazac_interesovanja", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja")
public class ObrazacInteresovanja implements Identifiable {

    @XmlElement(name = "podaci_o_osobi", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
    protected PodaciOOsobi podaciOOsobi;
    @XmlElement(name = "opsti_podaci", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
    protected OpstiPodaci opstiPodaci;
    @XmlElement(name = "dokument_id", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Long dokumentId;


    public PodaciOOsobi getPodaciOOsobi() {
        return podaciOOsobi;
    }


    public void setPodaciOOsobi(PodaciOOsobi value) {
        this.podaciOOsobi = value;
    }


    public OpstiPodaci getOpstiPodaci() {
        return opstiPodaci;
    }


    public void setOpstiPodaci(OpstiPodaci value) {
        this.opstiPodaci = value;
    }


    public Long getDokumentId() {
        return dokumentId;
    }


    public void setDokumentId(Long value) {
        this.dokumentId = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"lokacijaOpstina", "tipVakcine", "davalacKrvi", "datumPodnosenja", "idPodnosioca"})
    public static class OpstiPodaci {

        @XmlElement(name = "lokacija_opstina", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected LokacijaOpstina lokacijaOpstina;
        @XmlElement(name = "tip_vakcine", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected TipVakcine tipVakcine;
        @XmlElement(name = "davalac_krvi", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected DavalacKrvi davalacKrvi;
        @XmlElement(name = "datum_podnosenja", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected DatumPodnosenja datumPodnosenja;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected IdPodnosioca idPodnosioca;
        @XmlAttribute(name = "vocab")
        protected String vocab;
        @XmlAttribute(name = "about")
        protected String about;


        public LokacijaOpstina getLokacijaOpstina() {
            return lokacijaOpstina;
        }


        public void setLokacijaOpstina(LokacijaOpstina value) {
            this.lokacijaOpstina = value;
        }


        public TipVakcine getTipVakcine() {
            return tipVakcine;
        }


        public void setTipVakcine(TipVakcine value) {
            this.tipVakcine = value;
        }


        public DavalacKrvi getDavalacKrvi() {
            return davalacKrvi;
        }


        public void setDavalacKrvi(DavalacKrvi value) {
            this.davalacKrvi = value;
        }


        public DatumPodnosenja getDatumPodnosenja() {
            return datumPodnosenja;
        }


        public void setDatumPodnosenja(DatumPodnosenja value) {
            this.datumPodnosenja = value;
        }


        public IdPodnosioca getIdPodnosioca() {
            return idPodnosioca;
        }


        public void setIdPodnosioca(IdPodnosioca value) {
            this.idPodnosioca = value;
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
        public static class DatumPodnosenja {

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
        public static class DavalacKrvi {

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
                    return "pred:davalacKrvi";
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


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"value"})
        public static class IdPodnosioca {

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


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"value"})
        public static class LokacijaOpstina {

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
                    return "pred:lokacijaOpstina";
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
        public static class TipVakcine {

            @XmlValue
            protected TTipVakcine value;
            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;


            public TTipVakcine getValue() {
                return value;
            }


            public void setValue(TTipVakcine value) {
                this.value = value;
            }


            public String getProperty() {
                if (property == null) {
                    return "pred:tipVakcine";
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


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"drzavljanstvo", "jmbg", "ime", "prezime", "email", "brojMobilnogTelefona", "brojFiksnogTelefona"})
    public static class PodaciOOsobi {

        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected Drzavljanstvo drzavljanstvo;
        @XmlElement(name = "JMBG", namespace = "http://www.rokzasok.rs/tipovi", required = true)
        protected String jmbg;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected String ime;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected String prezime;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected Email email;
        @XmlElement(name = "broj_mobilnog_telefona", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected String brojMobilnogTelefona;
        @XmlElement(name = "broj_fiksnog_telefona", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected BrojFiksnogTelefona brojFiksnogTelefona;
        @XmlAttribute(name = "vocab")
        protected String vocab;
        @XmlAttribute(name = "about")
        protected String about;


        public Drzavljanstvo getDrzavljanstvo() {
            return drzavljanstvo;
        }


        public void setDrzavljanstvo(Drzavljanstvo value) {
            this.drzavljanstvo = value;
        }


        public String getJMBG() {
            return jmbg;
        }


        public void setJMBG(String value) {
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


        public Email getEmail() {
            return email;
        }


        public void setEmail(Email value) {
            this.email = value;
        }


        public String getBrojMobilnogTelefona() {
            return brojMobilnogTelefona;
        }


        public void setBrojMobilnogTelefona(String value) {
            this.brojMobilnogTelefona = value;
        }


        public BrojFiksnogTelefona getBrojFiksnogTelefona() {
            return brojFiksnogTelefona;
        }


        public void setBrojFiksnogTelefona(BrojFiksnogTelefona value) {
            this.brojFiksnogTelefona = value;
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
        public static class BrojFiksnogTelefona {

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
                    return "pred:brojFiksnogTelefona";
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
        public static class Drzavljanstvo {

            @XmlValue
            protected TDrzavljanstvo value;
            @XmlAttribute(name = "datatype")
            protected String datatype;
            @XmlAttribute(name = "property")
            protected String property;


            public TDrzavljanstvo getValue() {
                return value;
            }


            public void setValue(TDrzavljanstvo value) {
                this.value = value;
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


            public String getProperty() {
                if (property == null) {
                    return "pred:drzavljanstvo";
                } else {
                    return property;
                }
            }


            public void setProperty(String value) {
                this.property = value;
            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"value"})
        public static class Email {

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
                    return "pred:email";
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

}
