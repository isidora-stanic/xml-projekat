
package com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="termini" maxOccurs="unbounded" minOccurs="3"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="dan" maxOccurs="unbounded" minOccurs="3"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="maxBrojTermina" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                             &lt;element name="brojZakazanihTermina" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="datum" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="mesto" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
    "termini"
})
@XmlRootElement(name = "spisakTermina", namespace = "www.rokzasok.rs/termini")
public class SpisakTermina {

    @XmlElement(namespace = "www.rokzasok.rs/termini", required = true)
    protected List<SpisakTermina.Termini> termini;

    /**
     * Gets the value of the termini property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the termini property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTermini().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpisakTermina.Termini }
     * 
     * 
     */
    public List<SpisakTermina.Termini> getTermini() {
        if (termini == null) {
            termini = new ArrayList<SpisakTermina.Termini>();
        }
        return this.termini;
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
     *         &lt;element name="dan" maxOccurs="unbounded" minOccurs="3"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="maxBrojTermina" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *                   &lt;element name="brojZakazanihTermina" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="datum" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="mesto" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dan"
    })
    public static class Termini {

        @XmlElement(namespace = "www.rokzasok.rs/termini", required = true)
        protected List<SpisakTermina.Termini.Dan> dan;
        @XmlAttribute(name = "mesto", required = true)
        protected String mesto;

        /**
         * Gets the value of the dan property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dan property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDan().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SpisakTermina.Termini.Dan }
         * 
         * 
         */
        public List<SpisakTermina.Termini.Dan> getDan() {
            if (dan == null) {
                dan = new ArrayList<SpisakTermina.Termini.Dan>();
            }
            return this.dan;
        }

        /**
         * Gets the value of the mesto property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMesto() {
            return mesto;
        }

        /**
         * Sets the value of the mesto property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMesto(String value) {
            this.mesto = value;
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
         *         &lt;element name="maxBrojTermina" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
         *         &lt;element name="brojZakazanihTermina" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="datum" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "maxBrojTermina",
            "brojZakazanihTermina"
        })
        public static class Dan {

            @XmlElement(namespace = "www.rokzasok.rs/termini", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger maxBrojTermina;
            @XmlElement(namespace = "www.rokzasok.rs/termini", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger brojZakazanihTermina;
            @XmlAttribute(name = "datum", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar datum;

            /**
             * Gets the value of the maxBrojTermina property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMaxBrojTermina() {
                return maxBrojTermina;
            }

            /**
             * Sets the value of the maxBrojTermina property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMaxBrojTermina(BigInteger value) {
                this.maxBrojTermina = value;
            }

            /**
             * Gets the value of the brojZakazanihTermina property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getBrojZakazanihTermina() {
                return brojZakazanihTermina;
            }

            /**
             * Sets the value of the brojZakazanihTermina property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setBrojZakazanihTermina(BigInteger value) {
                this.brojZakazanihTermina = value;
            }

            /**
             * Gets the value of the datum property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDatum() {
                return datum;
            }

            /**
             * Sets the value of the datum property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDatum(XMLGregorianCalendar value) {
                this.datum = value;
            }

        }

    }

}
