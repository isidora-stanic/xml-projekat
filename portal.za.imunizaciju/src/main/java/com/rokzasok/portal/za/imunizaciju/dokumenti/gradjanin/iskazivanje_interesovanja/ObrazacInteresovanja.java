
package com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


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
 *         &lt;element name="podaci_o_osobi"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="drzavljanstvo"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja&gt;T_drzavljanstvo"&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:drzavljanstvo" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element ref="{http://www.rokzasok.rs/tipovi}JMBG"/&gt;
 *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="email"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_email"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:email" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="broj_mobilnog_telefona" type="{http://www.rokzasok.rs/tipovi}T_mobilni"/&gt;
 *                   &lt;element name="broj_fiksnog_telefona"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_fiksni"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:brojFiksnogTelefona" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="opsti_podaci"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="lokacija_opstina"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:lokacijaOpstina" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="tip_vakcine"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;simpleContent&gt;
 *                           &lt;extension base="&lt;http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja&gt;T_tip_vakcine"&gt;
 *                             &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:tipVakcine" /&gt;
 *                             &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/simpleContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;element name="davalac_krvi"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:davalacKrvi" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:boolean" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="datum_podnosenja"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:datumPodnosenja" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:date" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:kreiranOdStrane" /&gt;
 *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
    "podaciOOsobi",
    "opstiPodaci",
    "dokumentId"
})
@XmlRootElement(name = "obrazac_interesovanja", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja")
public class ObrazacInteresovanja {

    @XmlElement(name = "podaci_o_osobi", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
    protected PodaciOOsobi podaciOOsobi;
    @XmlElement(name = "opsti_podaci", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
    protected OpstiPodaci opstiPodaci;
    @XmlElement(name = "dokument_id", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger dokumentId;

    /**
     * Gets the value of the podaciOOsobi property.
     * 
     * @return
     *     possible object is
     *     {@link PodaciOOsobi }
     *     
     */
    public PodaciOOsobi getPodaciOOsobi() {
        return podaciOOsobi;
    }

    /**
     * Sets the value of the podaciOOsobi property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodaciOOsobi }
     *     
     */
    public void setPodaciOOsobi(PodaciOOsobi value) {
        this.podaciOOsobi = value;
    }

    /**
     * Gets the value of the opstiPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link OpstiPodaci }
     *     
     */
    public OpstiPodaci getOpstiPodaci() {
        return opstiPodaci;
    }

    /**
     * Sets the value of the opstiPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpstiPodaci }
     *     
     */
    public void setOpstiPodaci(OpstiPodaci value) {
        this.opstiPodaci = value;
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
     *         &lt;element name="lokacija_opstina"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:lokacijaOpstina" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;sequence&gt;
     *           &lt;element name="tip_vakcine"&gt;
     *             &lt;complexType&gt;
     *               &lt;simpleContent&gt;
     *                 &lt;extension base="&lt;http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja&gt;T_tip_vakcine"&gt;
     *                   &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:tipVakcine" /&gt;
     *                   &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *                 &lt;/extension&gt;
     *               &lt;/simpleContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *         &lt;/sequence&gt;
     *         &lt;element name="davalac_krvi"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:davalacKrvi" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:boolean" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="datum_podnosenja"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:datumPodnosenja" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:date" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
     *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:kreiranOdStrane" /&gt;
     *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "lokacijaOpstina",
        "tipVakcine",
        "davalacKrvi",
        "datumPodnosenja"
    })
    public static class OpstiPodaci {

        @XmlElement(name = "lokacija_opstina", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected LokacijaOpstina lokacijaOpstina;
        @XmlElement(name = "tip_vakcine", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected TipVakcine tipVakcine;
        @XmlElement(name = "davalac_krvi", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected DavalacKrvi davalacKrvi;
        @XmlElement(name = "datum_podnosenja", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja", required = true)
        protected DatumPodnosenja datumPodnosenja;
        @XmlAttribute(name = "vocab")
        protected String vocab;
        @XmlAttribute(name = "about")
        protected String about;
        @XmlAttribute(name = "rel")
        protected String rel;
        @XmlAttribute(name = "href")
        protected String href;

        /**
         * Gets the value of the lokacijaOpstina property.
         * 
         * @return
         *     possible object is
         *     {@link LokacijaOpstina }
         *     
         */
        public LokacijaOpstina getLokacijaOpstina() {
            return lokacijaOpstina;
        }

        /**
         * Sets the value of the lokacijaOpstina property.
         * 
         * @param value
         *     allowed object is
         *     {@link LokacijaOpstina }
         *     
         */
        public void setLokacijaOpstina(LokacijaOpstina value) {
            this.lokacijaOpstina = value;
        }

        /**
         * Gets the value of the tipVakcine property.
         * 
         * @return
         *     possible object is
         *     {@link TipVakcine }
         *     
         */
        public TipVakcine getTipVakcine() {
            return tipVakcine;
        }

        /**
         * Sets the value of the tipVakcine property.
         * 
         * @param value
         *     allowed object is
         *     {@link TipVakcine }
         *     
         */
        public void setTipVakcine(TipVakcine value) {
            this.tipVakcine = value;
        }

        /**
         * Gets the value of the davalacKrvi property.
         * 
         * @return
         *     possible object is
         *     {@link DavalacKrvi }
         *     
         */
        public DavalacKrvi getDavalacKrvi() {
            return davalacKrvi;
        }

        /**
         * Sets the value of the davalacKrvi property.
         * 
         * @param value
         *     allowed object is
         *     {@link DavalacKrvi }
         *     
         */
        public void setDavalacKrvi(DavalacKrvi value) {
            this.davalacKrvi = value;
        }

        /**
         * Gets the value of the datumPodnosenja property.
         * 
         * @return
         *     possible object is
         *     {@link DatumPodnosenja }
         *     
         */
        public DatumPodnosenja getDatumPodnosenja() {
            return datumPodnosenja;
        }

        /**
         * Sets the value of the datumPodnosenja property.
         * 
         * @param value
         *     allowed object is
         *     {@link DatumPodnosenja }
         *     
         */
        public void setDatumPodnosenja(DatumPodnosenja value) {
            this.datumPodnosenja = value;
        }

        /**
         * Gets the value of the vocab property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVocab() {
            if (vocab == null) {
                return "http://www.rokzasok.rs/rdf/database/predicate";
            } else {
                return vocab;
            }
        }

        /**
         * Sets the value of the vocab property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVocab(String value) {
            this.vocab = value;
        }

        /**
         * Gets the value of the about property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAbout() {
            return about;
        }

        /**
         * Sets the value of the about property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAbout(String value) {
            this.about = value;
        }

        /**
         * Gets the value of the rel property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRel() {
            if (rel == null) {
                return "pred:kreiranOdStrane";
            } else {
                return rel;
            }
        }

        /**
         * Sets the value of the rel property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRel(String value) {
            this.rel = value;
        }

        /**
         * Gets the value of the href property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHref() {
            return href;
        }

        /**
         * Sets the value of the href property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHref(String value) {
            this.href = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:datumPodnosenja" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:date" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class DatumPodnosenja {

            @XmlValue
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar value;
            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setValue(XMLGregorianCalendar value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:datumPodnosenja";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:date";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:davalacKrvi" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:boolean" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class DavalacKrvi {

            @XmlValue
            protected boolean value;
            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             */
            public boolean isValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             */
            public void setValue(boolean value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:davalacKrvi";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:boolean";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:lokacijaOpstina" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class LokacijaOpstina {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:lokacijaOpstina";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:string";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja&gt;T_tip_vakcine"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:tipVakcine" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class TipVakcine {

            @XmlValue
            protected TTipVakcine value;
            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link TTipVakcine }
             *     
             */
            public TTipVakcine getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link TTipVakcine }
             *     
             */
            public void setValue(TTipVakcine value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:tipVakcine";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:string";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
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
     *         &lt;element name="drzavljanstvo"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja&gt;T_drzavljanstvo"&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:drzavljanstvo" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://www.rokzasok.rs/tipovi}JMBG"/&gt;
     *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="email"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_email"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:email" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="broj_mobilnog_telefona" type="{http://www.rokzasok.rs/tipovi}T_mobilni"/&gt;
     *         &lt;element name="broj_fiksnog_telefona"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_fiksni"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:brojFiksnogTelefona" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
     *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "drzavljanstvo",
        "jmbg",
        "ime",
        "prezime",
        "email",
        "brojMobilnogTelefona",
        "brojFiksnogTelefona"
    })
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

        /**
         * Gets the value of the drzavljanstvo property.
         * 
         * @return
         *     possible object is
         *     {@link Drzavljanstvo }
         *     
         */
        public Drzavljanstvo getDrzavljanstvo() {
            return drzavljanstvo;
        }

        /**
         * Sets the value of the drzavljanstvo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Drzavljanstvo }
         *     
         */
        public void setDrzavljanstvo(Drzavljanstvo value) {
            this.drzavljanstvo = value;
        }

        /**
         * Gets the value of the jmbg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJMBG() {
            return jmbg;
        }

        /**
         * Sets the value of the jmbg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJMBG(String value) {
            this.jmbg = value;
        }

        /**
         * Gets the value of the ime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIme() {
            return ime;
        }

        /**
         * Sets the value of the ime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIme(String value) {
            this.ime = value;
        }

        /**
         * Gets the value of the prezime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrezime() {
            return prezime;
        }

        /**
         * Sets the value of the prezime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrezime(String value) {
            this.prezime = value;
        }

        /**
         * Gets the value of the email property.
         * 
         * @return
         *     possible object is
         *     {@link Email }
         *     
         */
        public Email getEmail() {
            return email;
        }

        /**
         * Sets the value of the email property.
         * 
         * @param value
         *     allowed object is
         *     {@link Email }
         *     
         */
        public void setEmail(Email value) {
            this.email = value;
        }

        /**
         * Gets the value of the brojMobilnogTelefona property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrojMobilnogTelefona() {
            return brojMobilnogTelefona;
        }

        /**
         * Sets the value of the brojMobilnogTelefona property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrojMobilnogTelefona(String value) {
            this.brojMobilnogTelefona = value;
        }

        /**
         * Gets the value of the brojFiksnogTelefona property.
         * 
         * @return
         *     possible object is
         *     {@link BrojFiksnogTelefona }
         *     
         */
        public BrojFiksnogTelefona getBrojFiksnogTelefona() {
            return brojFiksnogTelefona;
        }

        /**
         * Sets the value of the brojFiksnogTelefona property.
         * 
         * @param value
         *     allowed object is
         *     {@link BrojFiksnogTelefona }
         *     
         */
        public void setBrojFiksnogTelefona(BrojFiksnogTelefona value) {
            this.brojFiksnogTelefona = value;
        }

        /**
         * Gets the value of the vocab property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVocab() {
            if (vocab == null) {
                return "http://www.rokzasok.rs/rdf/database/predicate";
            } else {
                return vocab;
            }
        }

        /**
         * Sets the value of the vocab property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVocab(String value) {
            this.vocab = value;
        }

        /**
         * Gets the value of the about property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAbout() {
            return about;
        }

        /**
         * Sets the value of the about property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAbout(String value) {
            this.about = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_fiksni"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:brojFiksnogTelefona" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class BrojFiksnogTelefona {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "property")
            protected String property;
            @XmlAttribute(name = "datatype")
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:brojFiksnogTelefona";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:string";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja&gt;T_drzavljanstvo"&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:drzavljanstvo" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Drzavljanstvo {

            @XmlValue
            protected TDrzavljanstvo value;
            @XmlAttribute(name = "datatype")
            protected String datatype;
            @XmlAttribute(name = "property")
            protected String property;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link TDrzavljanstvo }
             *     
             */
            public TDrzavljanstvo getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link TDrzavljanstvo }
             *     
             */
            public void setValue(TDrzavljanstvo value) {
                this.value = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:string";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:drzavljanstvo";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_email"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:email" /&gt;
         *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
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

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:email";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:string";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }

    }

}
