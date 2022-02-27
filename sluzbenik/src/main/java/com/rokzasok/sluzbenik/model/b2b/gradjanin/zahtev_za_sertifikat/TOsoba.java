
package com.rokzasok.sluzbenik.model.b2b.gradjanin.zahtev_za_sertifikat;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for T_osoba complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_osoba"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="jmbg" type="{http://www.rokzasok.rs/tipovi}T_JMBG"/&gt;
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pol" type="{http://www.rokzasok.rs/tipovi}T_pol"/&gt;
 *         &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="broj_pasosa" type="{http://www.rokzasok.rs/tipovi}T_broj_pasosa"/&gt;
 *         &lt;element name="id"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;long"&gt;
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:kreiranOdStrane" /&gt;
 *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:long" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
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
@XmlType(name = "T_osoba", namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", propOrder = {
    "jmbg",
    "ime",
    "prezime",
    "pol",
    "datumRodjenja",
    "brojPasosa",
    "id"
})
public class TOsoba {

    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected String jmbg;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected String ime;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected String prezime;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    @XmlSchemaType(name = "string")
    protected TPol pol;
    @XmlElement(name = "datum_rodjenja", namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(name = "broj_pasosa", namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected String brojPasosa;
    @XmlElement(namespace = "www.rokzasok.rs/gradjanin/zahtev-za-sertifikat", required = true)
    protected Id id;

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
     *     {@link TPol }
     *     
     */
    public TPol getPol() {
        return pol;
    }

    /**
     * Sets the value of the pol property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPol }
     *     
     */
    public void setPol(TPol value) {
        this.pol = value;
    }

    /**
     * Gets the value of the datumRodjenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumRodjenja() {
        return datumRodjenja;
    }

    /**
     * Sets the value of the datumRodjenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumRodjenja(XMLGregorianCalendar value) {
        this.datumRodjenja = value;
    }

    /**
     * Gets the value of the brojPasosa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojPasosa() {
        return brojPasosa;
    }

    /**
     * Sets the value of the brojPasosa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojPasosa(String value) {
        this.brojPasosa = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setId(Id value) {
        this.id = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;long"&gt;
     *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:kreiranOdStrane" /&gt;
     *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:long" /&gt;
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
    public static class Id {

        @XmlValue
        protected long value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;

        /**
         * Gets the value of the value property.
         * 
         */
        public long getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(long value) {
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
                return "pred:kreiranOdStrane";
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
                return "xs:long";
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
