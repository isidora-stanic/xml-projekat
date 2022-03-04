package com.rokzasok.portal.za.imunizaciju.model.b2b.digitalni_sertifikat;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"gradjanin", "vakcinacija", "testovi", "infoOSertifikatu", "dokumentId"})
@XmlRootElement(name = "digitalni_sertifikat", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat")
public class DigitalniSertifikat implements Identifiable {

    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected TOsoba gradjanin;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected Vakcinacija vakcinacija;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected Testovi testovi;
    @XmlElement(name = "info_o_sertifikatu", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected InfoOSertifikatu infoOSertifikatu;
    @XmlElement(name = "dokument_id", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
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

    public DigitalniSertifikat() {
        this.testovi = new Testovi();
    }


    public TOsoba getGradjanin() {
        return gradjanin;
    }


    public void setGradjanin(TOsoba value) {
        this.gradjanin = value;
    }


    public Vakcinacija getVakcinacija() {
        return vakcinacija;
    }

    public void setVakcinacija(Vakcinacija value) {
        this.vakcinacija = value;
    }

    public void setVakcinacija(List<Vakcinacija.Doza> value) {
        this.vakcinacija = new Vakcinacija(value);
    }

    public Testovi getTestovi() {
        return testovi;
    }


    public void setTestovi(Testovi value) {
        this.testovi = value;
    }


    public InfoOSertifikatu getInfoOSertifikatu() {
        return infoOSertifikatu;
    }


    public void setInfoOSertifikatu(InfoOSertifikatu value) {
        this.infoOSertifikatu = value;
    }

    public void setInfoOSertifikatu(Long dokumentId) {
        this.infoOSertifikatu = new InfoOSertifikatu(dokumentId);
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
    @XmlType(name = "", propOrder = {"qrLink", "datum"})
    public static class InfoOSertifikatu {

        public InfoOSertifikatu() {
        }

        public InfoOSertifikatu(Long dokumentId) {
            this.qrLink = "http:IMPLEMENTIRAJ/" + dokumentId; // todo: zapravo pravi link
            this.datum = new Datum();
        }

        @XmlElement(name = "qr_link", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
        protected String qrLink;
        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
        protected Datum datum;


        public String getQrLink() {
            return qrLink;
        }


        public void setQrLink(String value) {
            this.qrLink = value;
        }


        public Datum getDatum() {
            return datum;
        }


        public void setDatum(Datum value) {
            this.datum = value;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"value"})
        public static class Datum {
            public Datum() {
                try {
                    this.value = DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDateTime.now().toString());
                } catch (DatatypeConfigurationException e) {
                    e.printStackTrace();
                }
            }

            @XmlValue
            @XmlSchemaType(name = "dateTime")
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
                    return "xs:dateTime";
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
    @XmlType(name = "", propOrder = {"test"})
    public static class Testovi {

        public Testovi() {
            TTest test1 = new TTest("SARS-COV-2 RT", "Real-time PCR");
            TTest test2 = new TTest("SARS-COV-2 Ag-RDT", "(Antigen Rapid Detection test)");
            TTest test3 = new TTest("SARS-COV-2 RBD S-Protein", "Immunoglobulin G (IgG) test");
            this.test = new ArrayList<>();
            this.test.add(test1);
            this.test.add(test2);
            this.test.add(test3);
        }

        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
        protected List<TTest> test;


        public List<TTest> getTest() {
            if (test == null) {
                test = new ArrayList<TTest>();
            }
            return this.test;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"doza"})
    public static class Vakcinacija {
        public Vakcinacija() {
        }

        public Vakcinacija(List<Doza> doza) {
            this.doza = doza;
        }

        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat")
        protected List<Doza> doza;


        public List<Doza> getDoza() {
            if (doza == null) {
                doza = new ArrayList<Doza>();
            }
            return this.doza;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Doza extends TDoza {
            public Doza() {
            }

            public Doza(String tip, String proizvodjac, XMLGregorianCalendar datum, String brojSerije, BigInteger brojDoze, String nazivUstanove, String mestoUstanove) {
                super(tip, proizvodjac, datum, brojSerije, brojDoze, nazivUstanove, mestoUstanove);
            }

            @XmlAttribute(name = "vocab")
            protected String vocab;
            @XmlAttribute(name = "about")
            protected String about;


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

        }

    }

}
