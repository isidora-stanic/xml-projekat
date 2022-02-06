
package com.rokzasok.sluzbenik.dokumenti.digitalni_sertifikat;

import com.rokzasok.sluzbenik.interfaces.Identifiable;

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
 *         &lt;element name="gradjanin"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat}TOsoba"&gt;
 *                 &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="vakcinacija"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="doza" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat}TDoza"&gt;
 *                           &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *                           &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="testovi"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="test" type="{http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat}TTest" maxOccurs="3" minOccurs="3"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="info_o_sertifikatu"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="qr_link"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:qrLink" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="datum"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:datumIzdavanja" /&gt;
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="broj_sertifikata" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
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
    "gradjanin",
    "vakcinacija",
    "testovi",
    "infoOSertifikatu",
    "dokumentId"
})
@XmlRootElement(name = "digitalni_sertifikat", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat")
public class DigitalniSertifikat implements Identifiable {

    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected Gradjanin gradjanin;
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

    /**
     * Gets the value of the gradjanin property.
     * 
     * @return
     *     possible object is
     *     {@link Gradjanin }
     *     
     */
    public Gradjanin getGradjanin() {
        return gradjanin;
    }

    /**
     * Sets the value of the gradjanin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gradjanin }
     *     
     */
    public void setGradjanin(Gradjanin value) {
        this.gradjanin = value;
    }

    /**
     * Gets the value of the vakcinacija property.
     * 
     * @return
     *     possible object is
     *     {@link Vakcinacija }
     *     
     */
    public Vakcinacija getVakcinacija() {
        return vakcinacija;
    }

    /**
     * Sets the value of the vakcinacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vakcinacija }
     *     
     */
    public void setVakcinacija(Vakcinacija value) {
        this.vakcinacija = value;
    }

    /**
     * Gets the value of the testovi property.
     * 
     * @return
     *     possible object is
     *     {@link Testovi }
     *     
     */
    public Testovi getTestovi() {
        return testovi;
    }

    /**
     * Sets the value of the testovi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Testovi }
     *     
     */
    public void setTestovi(Testovi value) {
        this.testovi = value;
    }

    /**
     * Gets the value of the infoOSertifikatu property.
     * 
     * @return
     *     possible object is
     *     {@link InfoOSertifikatu }
     *     
     */
    public InfoOSertifikatu getInfoOSertifikatu() {
        return infoOSertifikatu;
    }

    /**
     * Sets the value of the infoOSertifikatu property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoOSertifikatu }
     *     
     */
    public void setInfoOSertifikatu(InfoOSertifikatu value) {
        this.infoOSertifikatu = value;
    }

    /**
     * Gets the value of the dokumentId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
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
     *     {@link BigInteger }
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
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat}TOsoba"&gt;
     *       &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
     *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Gradjanin
        extends TOsoba
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
     *         &lt;element name="qr_link"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:qrLink" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="datum"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:datumIzdavanja" /&gt;
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="broj_sertifikata" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
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
        "qrLink",
        "datum",
        "brojSertifikata"
    })
    public static class InfoOSertifikatu {

        @XmlElement(name = "qr_link", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
        protected QrLink qrLink;
        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
        protected Datum datum;
        @XmlElement(name = "broj_sertifikata", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger brojSertifikata;

        /**
         * Gets the value of the qrLink property.
         * 
         * @return
         *     possible object is
         *     {@link QrLink }
         *     
         */
        public QrLink getQrLink() {
            return qrLink;
        }

        /**
         * Sets the value of the qrLink property.
         * 
         * @param value
         *     allowed object is
         *     {@link QrLink }
         *     
         */
        public void setQrLink(QrLink value) {
            this.qrLink = value;
        }

        /**
         * Gets the value of the datum property.
         * 
         * @return
         *     possible object is
         *     {@link Datum }
         *     
         */
        public Datum getDatum() {
            return datum;
        }

        /**
         * Sets the value of the datum property.
         * 
         * @param value
         *     allowed object is
         *     {@link Datum }
         *     
         */
        public void setDatum(Datum value) {
            this.datum = value;
        }

        /**
         * Gets the value of the brojSertifikata property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBrojSertifikata() {
            return brojSertifikata;
        }

        /**
         * Sets the value of the brojSertifikata property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBrojSertifikata(BigInteger value) {
            this.brojSertifikata = value;
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
        public static class Datum {

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
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:qrLink" /&gt;
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
        public static class QrLink {

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
                    return "pred:qrLink";
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
     *         &lt;element name="test" type="{http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat}TTest" maxOccurs="3" minOccurs="3"/&gt;
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
        "test"
    })
    public static class Testovi {

        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
        protected List<TTest> test;

        /**
         * Gets the value of the test property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the test property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTest().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TTest }
         * 
         * 
         */
        public List<TTest> getTest() {
            if (test == null) {
                test = new ArrayList<TTest>();
            }
            return this.test;
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
     *         &lt;element name="doza" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat}TDoza"&gt;
     *                 &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
     *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
    public static class Vakcinacija {

        @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat")
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
         *     &lt;extension base="{http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat}TDoza"&gt;
         *       &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
         *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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

        }

    }

}
