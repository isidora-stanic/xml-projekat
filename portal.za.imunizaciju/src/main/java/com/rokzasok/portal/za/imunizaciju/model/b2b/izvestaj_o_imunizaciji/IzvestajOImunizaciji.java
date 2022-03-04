
package com.rokzasok.portal.za.imunizaciju.model.b2b.izvestaj_o_imunizaciji;

import com.rokzasok.sluzbenik.interfaces.Identifiable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "brInteresovanja",
        "brPrimljenihZahtevaZaSertifikat",
        "brIzdatihZahtevaZaSertifikat",
        "dozeVakcina",
        "raspodelaPoProizvodjacima",
        "datumIzdavanja",
        "periodIzvestaja",
        "dokumentId"
})
@XmlRootElement(name = "izvestaj_o_imunizaciji", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji")
public class IzvestajOImunizaciji implements Identifiable {

    @XmlElement(name = "br_interesovanja", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Long brInteresovanja;
    @XmlElement(name = "br_primljenih_zahteva_za_sertifikat", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Long brPrimljenihZahtevaZaSertifikat;
    @XmlElement(name = "br_izdatih_zahteva_za_sertifikat", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Long brIzdatihZahtevaZaSertifikat;
    @XmlElement(name = "doze_vakcina", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    protected DozeVakcina dozeVakcina;
    @XmlElement(name = "raspodela_po_proizvodjacima", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    protected RaspodelaPoProizvodjacima raspodelaPoProizvodjacima;
    @XmlElement(name = "datum_izdavanja", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzdavanja;
    @XmlElement(name = "period_izvestaja", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    protected PeriodIzvestaja periodIzvestaja;
    @XmlElement(name = "dokument_id", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Long dokumentId;


    public Long getBrInteresovanja() {
        return brInteresovanja;
    }


    public void setBrInteresovanja(Long value) {
        this.brInteresovanja = value;
    }


    public Long getBrPrimljenihZahtevaZaSertifikat() {
        return brPrimljenihZahtevaZaSertifikat;
    }


    public void setBrPrimljenihZahtevaZaSertifikat(Long value) {
        this.brPrimljenihZahtevaZaSertifikat = value;
    }


    public Long getBrIzdatihZahtevaZaSertifikat() {
        return brIzdatihZahtevaZaSertifikat;
    }


    public void setBrIzdatihZahtevaZaSertifikat(Long value) {
        this.brIzdatihZahtevaZaSertifikat = value;
    }


    public DozeVakcina getDozeVakcina() {
        return dozeVakcina;
    }


    public void setDozeVakcina(DozeVakcina value) {
        this.dozeVakcina = value;
    }


    public RaspodelaPoProizvodjacima getRaspodelaPoProizvodjacima() {
        return raspodelaPoProizvodjacima;
    }


    public void setRaspodelaPoProizvodjacima(RaspodelaPoProizvodjacima value) {
        this.raspodelaPoProizvodjacima = value;
    }


    public XMLGregorianCalendar getDatumIzdavanja() {
        return datumIzdavanja;
    }


    public void setDatumIzdavanja(XMLGregorianCalendar value) {
        this.datumIzdavanja = value;
    }


    public PeriodIzvestaja getPeriodIzvestaja() {
        return periodIzvestaja;
    }


    public void setPeriodIzvestaja(PeriodIzvestaja value) {
        this.periodIzvestaja = value;
    }


    public Long getDokumentId() {
        return dokumentId;
    }


    public void setDokumentId(Long value) {
        this.dokumentId = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "doza"
    })
    public static class DozeVakcina {

        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
        protected List<Doza> doza;


        public List<Doza> getDoza() {
            if (doza == null) {
                doza = new ArrayList<Doza>();
            }
            return this.doza;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "redniBrojDoze",
                "brojDatih"
        })
        public static class Doza {

            @XmlElement(name = "redni_broj_doze", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected Long redniBrojDoze;
            @XmlElement(name = "broj_datih", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected Long brojDatih;


            public Long getRedniBrojDoze() {
                return redniBrojDoze;
            }


            public void setRedniBrojDoze(Long value) {
                this.redniBrojDoze = value;
            }


            public Long getBrojDatih() {
                return brojDatih;
            }


            public void setBrojDatih(Long value) {
                this.brojDatih = value;
            }

        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "od",
            "_do"
    })
    public static class PeriodIzvestaja {

        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar od;
        @XmlElement(name = "do", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar _do;


        public XMLGregorianCalendar getOd() {
            return od;
        }


        public void setOd(XMLGregorianCalendar value) {
            this.od = value;
        }


        public XMLGregorianCalendar getDo() {
            return _do;
        }


        public void setDo(XMLGregorianCalendar value) {
            this._do = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "proizvodjac"
    })
    public static class RaspodelaPoProizvodjacima {

        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
        protected List<Proizvodjac> proizvodjac;


        public List<Proizvodjac> getProizvodjac() {
            if (proizvodjac == null) {
                proizvodjac = new ArrayList<Proizvodjac>();
            }
            return this.proizvodjac;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "naziv",
                "brojPrimljenihDoza"
        })
        public static class Proizvodjac {

            @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
            protected String naziv;
            @XmlElement(name = "broj_primljenih_doza", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected Long brojPrimljenihDoza;


            public String getNaziv() {
                return naziv;
            }


            public void setNaziv(String value) {
                this.naziv = value;
            }


            public Long getBrojPrimljenihDoza() {
                return brojPrimljenihDoza;
            }


            public void setBrojPrimljenihDoza(Long value) {
                this.brojPrimljenihDoza = value;
            }

        }

    }

}
