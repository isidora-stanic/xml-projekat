
package com.rokzasok.sluzbenik.dokumenti.izvestaj_o_imunizaciji;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="br_interesovanja" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="br_primljenih_zahteva_za_sertifikat" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="br_izdatih_zahteva_za_sertifikat" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="doze_vakcina"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="doza" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="redni_broj_doze" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                             &lt;element name="broj_datih" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="raspodela_po_proizvodjacima"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="proizvodjac" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="naziv"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="Pfizer, BioNTech"/&gt;
 *                                   &lt;enumeration value="Sinopharm"/&gt;
 *                                   &lt;enumeration value="Sputnik V"/&gt;
 *                                   &lt;enumeration value="AstraZeneca, Oxford"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="broj_primljenih_doza" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="datum_izdavanja" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="period_izvestaja"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="od" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="do" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dokument_id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
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
public class IzvestajOImunizaciji {

    @XmlElement(name = "br_interesovanja", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brInteresovanja;
    @XmlElement(name = "br_primljenih_zahteva_za_sertifikat", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brPrimljenihZahtevaZaSertifikat;
    @XmlElement(name = "br_izdatih_zahteva_za_sertifikat", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brIzdatihZahtevaZaSertifikat;
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
    protected BigInteger dokumentId;

    /**
     * Gets the value of the brInteresovanja property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrInteresovanja() {
        return brInteresovanja;
    }

    /**
     * Sets the value of the brInteresovanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrInteresovanja(BigInteger value) {
        this.brInteresovanja = value;
    }

    /**
     * Gets the value of the brPrimljenihZahtevaZaSertifikat property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrPrimljenihZahtevaZaSertifikat() {
        return brPrimljenihZahtevaZaSertifikat;
    }

    /**
     * Sets the value of the brPrimljenihZahtevaZaSertifikat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrPrimljenihZahtevaZaSertifikat(BigInteger value) {
        this.brPrimljenihZahtevaZaSertifikat = value;
    }

    /**
     * Gets the value of the brIzdatihZahtevaZaSertifikat property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrIzdatihZahtevaZaSertifikat() {
        return brIzdatihZahtevaZaSertifikat;
    }

    /**
     * Sets the value of the brIzdatihZahtevaZaSertifikat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrIzdatihZahtevaZaSertifikat(BigInteger value) {
        this.brIzdatihZahtevaZaSertifikat = value;
    }

    /**
     * Gets the value of the dozeVakcina property.
     * 
     * @return
     *     possible object is
     *     {@link DozeVakcina }
     *     
     */
    public DozeVakcina getDozeVakcina() {
        return dozeVakcina;
    }

    /**
     * Sets the value of the dozeVakcina property.
     * 
     * @param value
     *     allowed object is
     *     {@link DozeVakcina }
     *     
     */
    public void setDozeVakcina(DozeVakcina value) {
        this.dozeVakcina = value;
    }

    /**
     * Gets the value of the raspodelaPoProizvodjacima property.
     * 
     * @return
     *     possible object is
     *     {@link RaspodelaPoProizvodjacima }
     *     
     */
    public RaspodelaPoProizvodjacima getRaspodelaPoProizvodjacima() {
        return raspodelaPoProizvodjacima;
    }

    /**
     * Sets the value of the raspodelaPoProizvodjacima property.
     * 
     * @param value
     *     allowed object is
     *     {@link RaspodelaPoProizvodjacima }
     *     
     */
    public void setRaspodelaPoProizvodjacima(RaspodelaPoProizvodjacima value) {
        this.raspodelaPoProizvodjacima = value;
    }

    /**
     * Gets the value of the datumIzdavanja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Sets the value of the datumIzdavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumIzdavanja(XMLGregorianCalendar value) {
        this.datumIzdavanja = value;
    }

    /**
     * Gets the value of the periodIzvestaja property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodIzvestaja }
     *     
     */
    public PeriodIzvestaja getPeriodIzvestaja() {
        return periodIzvestaja;
    }

    /**
     * Sets the value of the periodIzvestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodIzvestaja }
     *     
     */
    public void setPeriodIzvestaja(PeriodIzvestaja value) {
        this.periodIzvestaja = value;
    }

    /**
     * Gets the value of the dokumentId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDokumentId() {
        return dokumentId;
    }

    /**
     * Sets the value of the dokumentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDokumentId(BigInteger value) {
        this.dokumentId = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="doza" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="redni_broj_doze" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *                   &lt;element name="broj_datih" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "doza"
    })
    public static class DozeVakcina {

        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
        protected List<Doza> doza;

        /**
         * Gets the value of the doza property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the doza property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDoza().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Doza }
         * 
         * 
         */
        public List<Doza> getDoza() {
            if (doza == null) {
                doza = new ArrayList<Doza>();
            }
            return this.doza;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="redni_broj_doze" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
         *         &lt;element name="broj_datih" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "redniBrojDoze",
            "brojDatih"
        })
        public static class Doza {

            @XmlElement(name = "redni_broj_doze", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger redniBrojDoze;
            @XmlElement(name = "broj_datih", namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger brojDatih;

            /**
             * Gets the value of the redniBrojDoze property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getRedniBrojDoze() {
                return redniBrojDoze;
            }

            /**
             * Sets the value of the redniBrojDoze property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setRedniBrojDoze(BigInteger value) {
                this.redniBrojDoze = value;
            }

            /**
             * Gets the value of the brojDatih property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getBrojDatih() {
                return brojDatih;
            }

            /**
             * Sets the value of the brojDatih property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setBrojDatih(BigInteger value) {
                this.brojDatih = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="od" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="do" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
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

        /**
         * Gets the value of the od property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getOd() {
            return od;
        }

        /**
         * Sets the value of the od property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setOd(XMLGregorianCalendar value) {
            this.od = value;
        }

        /**
         * Gets the value of the do property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDo() {
            return _do;
        }

        /**
         * Sets the value of the do property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDo(XMLGregorianCalendar value) {
            this._do = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="proizvodjac" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="naziv"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="Pfizer, BioNTech"/&gt;
     *                         &lt;enumeration value="Sinopharm"/&gt;
     *                         &lt;enumeration value="Sputnik V"/&gt;
     *                         &lt;enumeration value="AstraZeneca, Oxford"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="broj_primljenih_doza" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "proizvodjac"
    })
    public static class RaspodelaPoProizvodjacima {

        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji", required = true)
        protected List<Proizvodjac> proizvodjac;

        /**
         * Gets the value of the proizvodjac property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the proizvodjac property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProizvodjac().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Proizvodjac }
         * 
         * 
         */
        public List<Proizvodjac> getProizvodjac() {
            if (proizvodjac == null) {
                proizvodjac = new ArrayList<Proizvodjac>();
            }
            return this.proizvodjac;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="naziv"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="Pfizer, BioNTech"/&gt;
         *               &lt;enumeration value="Sinopharm"/&gt;
         *               &lt;enumeration value="Sputnik V"/&gt;
         *               &lt;enumeration value="AstraZeneca, Oxford"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="broj_primljenih_doza" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
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
            protected BigInteger brojPrimljenihDoza;

            /**
             * Gets the value of the naziv property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNaziv() {
                return naziv;
            }

            /**
             * Sets the value of the naziv property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNaziv(String value) {
                this.naziv = value;
            }

            /**
             * Gets the value of the brojPrimljenihDoza property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getBrojPrimljenihDoza() {
                return brojPrimljenihDoza;
            }

            /**
             * Sets the value of the brojPrimljenihDoza property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setBrojPrimljenihDoza(BigInteger value) {
                this.brojPrimljenihDoza = value;
            }

        }

    }

}
