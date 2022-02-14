
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TDrzavljanstvo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TDrzavljanstvo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="strano"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="drzava" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element ref="{http://www.rokzasok.rs/tipovi}broj_pasosa"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="srpsko"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.rokzasok.rs/tipovi}JMBG"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDrzavljanstvo", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", propOrder = {
    "strano",
    "srpsko"
})
public class TDrzavljanstvo {

    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
    protected Strano strano;
    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
    protected Srpsko srpsko;

    /**
     * Gets the value of the strano property.
     * 
     * @return
     *     possible object is
     *     {@link Strano }
     *     
     */
    public Strano getStrano() {
        return strano;
    }

    /**
     * Sets the value of the strano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Strano }
     *     
     */
    public void setStrano(Strano value) {
        this.strano = value;
    }

    /**
     * Gets the value of the srpsko property.
     * 
     * @return
     *     possible object is
     *     {@link Srpsko }
     *     
     */
    public Srpsko getSrpsko() {
        return srpsko;
    }

    /**
     * Sets the value of the srpsko property.
     * 
     * @param value
     *     allowed object is
     *     {@link Srpsko }
     *     
     */
    public void setSrpsko(Srpsko value) {
        this.srpsko = value;
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
     *         &lt;element ref="{http://www.rokzasok.rs/tipovi}JMBG"/&gt;
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
        "jmbg"
    })
    public static class Srpsko {

        @XmlElement(name = "JMBG", namespace = "http://www.rokzasok.rs/tipovi", required = true)
        protected String jmbg;

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
     *         &lt;element name="drzava" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element ref="{http://www.rokzasok.rs/tipovi}broj_pasosa"/&gt;
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
        "drzava",
        "brojPasosa"
    })
    public static class Strano {

        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected String drzava;
        @XmlElement(name = "broj_pasosa", namespace = "http://www.rokzasok.rs/tipovi", required = true)
        protected String brojPasosa;

        /**
         * Gets the value of the drzava property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDrzava() {
            return drzava;
        }

        /**
         * Sets the value of the drzava property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDrzava(String value) {
            this.drzava = value;
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

    }

}
