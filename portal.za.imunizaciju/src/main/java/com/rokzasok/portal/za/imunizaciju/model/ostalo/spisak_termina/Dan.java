
package com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina;

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
@XmlRootElement(name = "dan", namespace = "www.rokzasok.rs/termini")
public class Dan {

    @XmlElement(namespace = "www.rokzasok.rs/termini", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxBrojTermina;
    @XmlElement(namespace = "www.rokzasok.rs/termini", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
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
