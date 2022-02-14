
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="osoba"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="jmbg" type="{http://www.rokzasok.rs/tipovi}T_JMBG"/&gt;
 *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="pol"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_pol"&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="datum_rodjenja"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="idOsobe" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="doze"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="2"&gt;
 *                   &lt;element name="doza"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije}T_doza"&gt;
 *                           &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *                           &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="razlog_izdavanja"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:razlogIzdavanja" /&gt;
 *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="datum_izdavanja"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:datumIzdavanja" /&gt;
 *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:date" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dokument_id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:kreiranOdStrane" /&gt;
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "osoba",
    "doze",
    "razlogIzdavanja",
    "datumIzdavanja",
    "dokumentId"
})
@XmlRootElement(name = "potvrda-vakcinacije", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije")
public class PotvrdaVakcinacije implements Identifiable {

    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected Osoba osoba;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected Doze doze;
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

    /**
     * Gets the value of the osoba property.
     * 
     * @return
     *     possible object is
     *     {@link Osoba }
     *     
     */
    public Osoba getOsoba() {
        return osoba;
    }

    /**
     * Sets the value of the osoba property.
     * 
     * @param value
     *     allowed object is
     *     {@link Osoba }
     *     
     */
    public void setOsoba(Osoba value) {
        this.osoba = value;
    }

    /**
     * Gets the value of the doze property.
     * 
     * @return
     *     possible object is
     *     {@link Doze }
     *     
     */
    public Doze getDoze() {
        return doze;
    }

    /**
     * Sets the value of the doze property.
     * 
     * @param value
     *     allowed object is
     *     {@link Doze }
     *     
     */
    public void setDoze(Doze value) {
        this.doze = value;
    }

    /**
     * Gets the value of the razlogIzdavanja property.
     * 
     * @return
     *     possible object is
     *     {@link RazlogIzdavanja }
     *     
     */
    public RazlogIzdavanja getRazlogIzdavanja() {
        return razlogIzdavanja;
    }

    /**
     * Sets the value of the razlogIzdavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link RazlogIzdavanja }
     *     
     */
    public void setRazlogIzdavanja(RazlogIzdavanja value) {
        this.razlogIzdavanja = value;
    }

    /**
     * Gets the value of the datumIzdavanja property.
     * 
     * @return
     *     possible object is
     *     {@link DatumIzdavanja }
     *     
     */
    public DatumIzdavanja getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Sets the value of the datumIzdavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatumIzdavanja }
     *     
     */
    public void setDatumIzdavanja(DatumIzdavanja value) {
        this.datumIzdavanja = value;
    }

    /**
     * Gets the value of the dokumentId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDokumentId() {
        return dokumentId;
    }

    /**
     * Sets the value of the dokumentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDokumentId(Long value) {
        this.dokumentId = value;
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
        if (href == null) {
            return "xs:string";
        } else {
            return href;
        }
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
     *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:datumIzdavanja" /&gt;
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
    public static class DatumIzdavanja {

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
                return "pred:datumIzdavanja";
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
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="unbounded" minOccurs="2"&gt;
     *         &lt;element name="doza"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije}T_doza"&gt;
     *                 &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
     *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *               &lt;/extension&gt;
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
    public static class Doze {

        @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
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
         *     &lt;extension base="{http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije}T_doza"&gt;
         *       &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
         *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Doza
            extends TDoza
        {

            @XmlAttribute(name = "vocab")
            protected String vocab;
            @XmlAttribute(name = "about")
            protected String about;

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
                if (about == null) {
                    return "xs:string";
                } else {
                    return about;
                }
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
     *         &lt;element name="jmbg" type="{http://www.rokzasok.rs/tipovi}T_JMBG"/&gt;
     *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="pol"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_pol"&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="datum_rodjenja"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
     *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="idOsobe" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "jmbg",
        "ime",
        "prezime",
        "pol",
        "datumRodjenja"
    })
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
        @XmlAttribute(name = "vocab")
        protected String vocab;
        @XmlAttribute(name = "about")
        protected String about;
        @XmlAttribute(name = "idOsobe", required = true)
        protected long idOsobe;

        /**
         * Gets the value of the jmbg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJmbg() {
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
        public void setJmbg(String value) {
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
         * Gets the value of the pol property.
         * 
         * @return
         *     possible object is
         *     {@link Pol }
         *     
         */
        public Pol getPol() {
            return pol;
        }

        /**
         * Sets the value of the pol property.
         * 
         * @param value
         *     allowed object is
         *     {@link Pol }
         *     
         */
        public void setPol(Pol value) {
            this.pol = value;
        }

        /**
         * Gets the value of the datumRodjenja property.
         * 
         * @return
         *     possible object is
         *     {@link DatumRodjenja }
         *     
         */
        public DatumRodjenja getDatumRodjenja() {
            return datumRodjenja;
        }

        /**
         * Sets the value of the datumRodjenja property.
         * 
         * @param value
         *     allowed object is
         *     {@link DatumRodjenja }
         *     
         */
        public void setDatumRodjenja(DatumRodjenja value) {
            this.datumRodjenja = value;
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
         * Gets the value of the idOsobe property.
         * 
         */
        public long getIdOsobe() {
            return idOsobe;
        }

        /**
         * Sets the value of the idOsobe property.
         * 
         */
        public void setIdOsobe(long value) {
            this.idOsobe = value;
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
        public static class DatumRodjenja {

            @XmlValue
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar value;

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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_pol"&gt;
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
        public static class Pol {

            @XmlValue
            protected TPol value;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link TPol }
             *     
             */
            public TPol getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link TPol }
             *     
             */
            public void setValue(TPol value) {
                this.value = value;
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
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:razlogIzdavanja" /&gt;
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
    public static class RazlogIzdavanja {

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
                return "pred:razlogIzdavanja";
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
