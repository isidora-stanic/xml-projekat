
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "evidencijaPacijent",
        "evidencijaVakcinacija",
        "dokumentInfo"
})
@XmlRootElement(name = "obrazac_saglasnosti", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
public class ObrazacSaglasnosti implements Identifiable {

    @XmlElement(name = "evidencija_pacijent", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected EvidencijaPacijent evidencijaPacijent;
    @XmlElement(name = "evidencija_vakcinacija", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected EvidencijaVakcinacija evidencijaVakcinacija;
    @XmlElement(name = "dokument_info", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected DokumentInfo dokumentInfo;


    public EvidencijaPacijent getEvidencijaPacijent() {
        return evidencijaPacijent;
    }


    public void setEvidencijaPacijent(EvidencijaPacijent value) {
        this.evidencijaPacijent = value;
    }


    public EvidencijaVakcinacija getEvidencijaVakcinacija() {
        return evidencijaVakcinacija;
    }


    public void setEvidencijaVakcinacija(EvidencijaVakcinacija value) {
        this.evidencijaVakcinacija = value;
    }


    public DokumentInfo getDokumentInfo() {
        return dokumentInfo;
    }


    public void setDokumentInfo(DokumentInfo value) {
        this.dokumentInfo = value;
    }

    @Override
    public Long getDokumentId() {
        return this.dokumentInfo.dokumentId;
    }

    @Override
    public void setDokumentId(Long id) {
        this.dokumentInfo.dokumentId = id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "dokumentId",
            "saglasnost",
            "idPodnosioca"
    })
    public static class DokumentInfo {

        @XmlElement(name = "dokument_id", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected Long dokumentId;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Saglasnost saglasnost;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected IdPodnosioca idPodnosioca;
        @XmlAttribute(name = "vocab")
        protected String vocab;
        @XmlAttribute(name = "about")
        protected String about;


        public Long getDokumentId() {
            return dokumentId;
        }


        public void setDokumentId(Long value) {
            this.dokumentId = value;
        }


        public Saglasnost getSaglasnost() {
            return saglasnost;
        }


        public void setSaglasnost(Saglasnost value) {
            this.saglasnost = value;
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
        @XmlType(name = "", propOrder = {
                "value"
        })
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
        @XmlType(name = "", propOrder = {
                "izjava",
                "nazivLeka"
        })
        public static class Saglasnost {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected Izjava izjava;
            @XmlElement(name = "naziv_leka", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected NazivLeka nazivLeka;


            public Izjava getIzjava() {
                return izjava;
            }


            public void setIzjava(Izjava value) {
                this.izjava = value;
            }


            public NazivLeka getNazivLeka() {
                return nazivLeka;
            }


            public void setNazivLeka(NazivLeka value) {
                this.nazivLeka = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "value"
            })
            public static class Izjava {

                @XmlValue
                protected boolean value;
                @XmlAttribute(name = "datatype")
                protected String datatype;
                @XmlAttribute(name = "property")
                protected String property;


                public boolean isValue() {
                    return value;
                }


                public void setValue(boolean value) {
                    this.value = value;
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


                public String getProperty() {
                    if (property == null) {
                        return "pred:izjava";
                    } else {
                        return property;
                    }
                }


                public void setProperty(String value) {
                    this.property = value;
                }

            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "value"
            })
            public static class NazivLeka {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "datatype")
                protected String datatype;
                @XmlAttribute(name = "property")
                protected String property;


                public String getValue() {
                    return value;
                }


                public void setValue(String value) {
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
                        return "pred:nazivLeka";
                    } else {
                        return property;
                    }
                }


                public void setProperty(String value) {
                    this.property = value;
                }

            }

        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "pacijent"
    })
    public static class EvidencijaPacijent {

        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Pacijent pacijent;


        public Pacijent getPacijent() {
            return pacijent;
        }


        public void setPacijent(Pacijent value) {
            this.pacijent = value;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "drzavljanstvo",
                "pacijentInfo",
                "kontakt",
                "radniStatus",
                "zanimanje",
                "socijalnaZastita",
                "imeRoditelja",
                "mestoRodjenja"
        })
        public static class Pacijent {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected TDrzavljanstvo drzavljanstvo;
            @XmlElement(name = "pacijent_info", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected TOsoba pacijentInfo;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected Kontakt kontakt;
            @XmlElement(name = "radni_status", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String radniStatus;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String zanimanje;
            @XmlElement(name = "socijalna_zastita", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected SocijalnaZastita socijalnaZastita;
            @XmlElement(name = "ime_roditelja", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String imeRoditelja;
            @XmlElement(name = "mesto_rodjenja", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String mestoRodjenja;
            @XmlAttribute(name = "vocab")
            protected String vocab;
            @XmlAttribute(name = "about")
            protected String about;

            public String getJMBG() {
                String jmbg;
                try {
                    jmbg = this.getDrzavljanstvo().getSrpsko().getJMBG();
                } catch (Exception e) {
                    return null;
                }
                return jmbg;
            }

            public String getBrojPasosa() {
                String brojPasosa;
                try {
                    brojPasosa = this.getDrzavljanstvo().getStrano().getBrojPasosa();
                } catch (Exception e) {
                    return null;
                }
                return brojPasosa;
            }


            public TDrzavljanstvo getDrzavljanstvo() {
                return drzavljanstvo;
            }


            public void setDrzavljanstvo(TDrzavljanstvo value) {
                this.drzavljanstvo = value;
            }


            public TOsoba getPacijentInfo() {
                return pacijentInfo;
            }


            public void setPacijentInfo(TOsoba value) {
                this.pacijentInfo = value;
            }


            public Kontakt getKontakt() {
                return kontakt;
            }


            public void setKontakt(Kontakt value) {
                this.kontakt = value;
            }


            public String getRadniStatus() {
                return radniStatus;
            }


            public void setRadniStatus(String value) {
                this.radniStatus = value;
            }


            public String getZanimanje() {
                return zanimanje;
            }


            public void setZanimanje(String value) {
                this.zanimanje = value;
            }


            public SocijalnaZastita getSocijalnaZastita() {
                return socijalnaZastita;
            }


            public void setSocijalnaZastita(SocijalnaZastita value) {
                this.socijalnaZastita = value;
            }


            public String getImeRoditelja() {
                return imeRoditelja;
            }


            public void setImeRoditelja(String value) {
                this.imeRoditelja = value;
            }


            public String getMestoRodjenja() {
                return mestoRodjenja;
            }


            public void setMestoRodjenja(String value) {
                this.mestoRodjenja = value;
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
            @XmlType(name = "", propOrder = {
                    "telFiksni",
                    "telMobilni",
                    "email"
            })
            public static class Kontakt {

                @XmlElement(name = "tel_fiksni", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected TelFiksni telFiksni;
                @XmlElement(name = "tel_mobilni", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected String telMobilni;
                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected Email email;


                public TelFiksni getTelFiksni() {
                    return telFiksni;
                }


                public void setTelFiksni(TelFiksni value) {
                    this.telFiksni = value;
                }


                public String getTelMobilni() {
                    return telMobilni;
                }


                public void setTelMobilni(String value) {
                    this.telMobilni = value;
                }


                public Email getEmail() {
                    return email;
                }


                public void setEmail(Email value) {
                    this.email = value;
                }


                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "value"
                })
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


                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "value"
                })
                public static class TelFiksni {

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

            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "korisnik",
                    "sediste"
            })
            public static class SocijalnaZastita {

                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
                protected boolean korisnik;
                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected Sediste sediste;


                public boolean isKorisnik() {
                    return korisnik;
                }


                public void setKorisnik(boolean value) {
                    this.korisnik = value;
                }


                public Sediste getSediste() {
                    return sediste;
                }


                public void setSediste(Sediste value) {
                    this.sediste = value;
                }


                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "naziv",
                        "opstina"
                })
                public static class Sediste {

                    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                    protected String naziv;
                    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                    protected String opstina;


                    public String getNaziv() {
                        return naziv;
                    }


                    public void setNaziv(String value) {
                        this.naziv = value;
                    }


                    public String getOpstina() {
                        return opstina;
                    }


                    public void setOpstina(String value) {
                        this.opstina = value;
                    }

                }

            }

        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "ustanova",
            "lekar",
            "tabela"
    })
    public static class EvidencijaVakcinacija {

        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Ustanova ustanova;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Lekar lekar;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Tabela tabela;


        public Ustanova getUstanova() {
            return ustanova;
        }


        public void setUstanova(Ustanova value) {
            this.ustanova = value;
        }


        public Lekar getLekar() {
            return lekar;
        }


        public void setLekar(Lekar value) {
            this.lekar = value;
        }


        public Tabela getTabela() {
            return tabela;
        }


        public void setTabela(Tabela value) {
            this.tabela = value;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "fax",
                "ime",
                "prezime",
                "telefon"
        })
        public static class Lekar {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String fax;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String ime;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String prezime;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String telefon;


            public String getFax() {
                return fax;
            }


            public void setFax(String value) {
                this.fax = value;
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


            public String getTelefon() {
                return telefon;
            }


            public void setTelefon(String value) {
                this.telefon = value;
            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "doza",
                "privremeneKontraindikacije",
                "odlukaKomisije"
        })
        public static class Tabela {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected List<Doza> doza;
            @XmlElement(name = "privremene_kontraindikacije", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected PrivremeneKontraindikacije privremeneKontraindikacije;
            @XmlElement(name = "odluka_komisije", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
            protected boolean odlukaKomisije;


            public List<Doza> getDoza() {
                if (doza == null) {
                    doza = new ArrayList<Doza>();
                }
                return this.doza;
            }


            public PrivremeneKontraindikacije getPrivremeneKontraindikacije() {
                return privremeneKontraindikacije;
            }


            public void setPrivremeneKontraindikacije(PrivremeneKontraindikacije value) {
                this.privremeneKontraindikacije = value;
            }


            public boolean isOdlukaKomisije() {
                return odlukaKomisije;
            }


            public void setOdlukaKomisije(boolean value) {
                this.odlukaKomisije = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Doza
                    extends TDoza {

                @XmlAttribute(name = "vocab")
                protected String vocab;
                @XmlAttribute(name = "about")
                protected String about;
                @XmlAttribute(name = "rel")
                protected String rel;
                @XmlAttribute(name = "href")
                protected String href;


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
                        return "pred:saglasnost";
                    } else {
                        return rel;
                    }
                }


                public void setRel(String value) {
                    this.rel = value;
                }


                public String getHref() {
                    return href;
                }


                public void setHref(String value) {
                    this.href = value;
                }

            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "datum",
                    "dijagnoza"
            })
            public static class PrivremeneKontraindikacije {

                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar datum;
                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected String dijagnoza;


                public XMLGregorianCalendar getDatum() {
                    return datum;
                }


                public void setDatum(XMLGregorianCalendar value) {
                    this.datum = value;
                }


                public String getDijagnoza() {
                    return dijagnoza;
                }


                public void setDijagnoza(String value) {
                    this.dijagnoza = value;
                }

            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "naziv",
                "punkt"
        })
        public static class Ustanova {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String naziv;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String punkt;


            public String getNaziv() {
                return naziv;
            }


            public void setNaziv(String value) {
                this.naziv = value;
            }


            public String getPunkt() {
                return punkt;
            }


            public void setPunkt(String value) {
                this.punkt = value;
            }

        }

    }

}
