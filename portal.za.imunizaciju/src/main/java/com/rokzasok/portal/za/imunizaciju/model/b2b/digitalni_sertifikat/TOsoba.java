
package com.rokzasok.portal.za.imunizaciju.model.b2b.digitalni_sertifikat;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TOsoba complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TOsoba"&gt;
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
 *         &lt;element name="adresa" type="{http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat}TAdresa"/&gt;
 *         &lt;element name="broj_pasosa"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_broj_pasosa"&gt;
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
@XmlType(name = "TOsoba", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", propOrder = {
    "jmbg",
    "ime",
    "prezime",
    "pol",
    "datumRodjenja",
    "adresa",
    "brojPasosa"
})
@XmlSeeAlso({
    DigitalniSertifikat.Gradjanin.class
})
public class TOsoba {

    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String jmbg;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String ime;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String prezime;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected Pol pol;
    @XmlElement(name = "datum_rodjenja", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected DatumRodjenja datumRodjenja;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected TAdresa adresa;
    @XmlElement(name = "broj_pasosa", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected BrojPasosa brojPasosa;

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
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link TAdresa }
     *     
     */
    public TAdresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAdresa }
     *     
     */
    public void setAdresa(TAdresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the brojPasosa property.
     * 
     * @return
     *     possible object is
     *     {@link BrojPasosa }
     *     
     */
    public BrojPasosa getBrojPasosa() {
        return brojPasosa;
    }

    /**
     * Sets the value of the brojPasosa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrojPasosa }
     *     
     */
    public void setBrojPasosa(BrojPasosa value) {
        this.brojPasosa = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_broj_pasosa"&gt;
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
    public static class BrojPasosa {

        @XmlValue
        protected String value;

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
