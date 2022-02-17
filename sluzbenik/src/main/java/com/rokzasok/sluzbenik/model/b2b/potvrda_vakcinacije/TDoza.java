
package com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * <p>Java class for T_doza complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_doza"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tip"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="Pfizer-BioNtech"/&gt;
 *               &lt;enumeration value="Sputnik V (Gamaleya istraživački centar)"/&gt;
 *               &lt;enumeration value="Sinopharm"/&gt;
 *               &lt;enumeration value="AstraZeneca"/&gt;
 *               &lt;enumeration value="Moderna"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="proizvodjac"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="BioNTech Manufacturing GMBH"/&gt;
 *               &lt;enumeration value="Sinopharm"/&gt;
 *               &lt;enumeration value="Gamaleya Institute"/&gt;
 *               &lt;enumeration value="Oxford"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="broj_serije" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="broj_doze" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="ustanova" type="{http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije}T_ustanova"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_doza", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", propOrder = {
    "tip",
    "proizvodjac",
    "datum",
    "brojSerije",
    "brojDoze",
    "ustanova"
})
@XmlSeeAlso({
    PotvrdaVakcinacije.Doze.Doza.class
})
public class TDoza {

    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String tip;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String proizvodjac;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "broj_serije", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected String brojSerije;
    @XmlElement(name = "broj_doze", namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brojDoze;
    @XmlElement(namespace = "http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije", required = true)
    protected TUstanova ustanova;

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTip(String value) {
        this.tip = value;
    }

    /**
     * Gets the value of the proizvodjac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProizvodjac() {
        return proizvodjac;
    }

    /**
     * Sets the value of the proizvodjac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProizvodjac(String value) {
        this.proizvodjac = value;
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

    /**
     * Gets the value of the brojSerije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojSerije() {
        return brojSerije;
    }

    /**
     * Sets the value of the brojSerije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojSerije(String value) {
        this.brojSerije = value;
    }

    /**
     * Gets the value of the brojDoze property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDoze() {
        return brojDoze;
    }

    /**
     * Sets the value of the brojDoze property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDoze(BigInteger value) {
        this.brojDoze = value;
    }

    /**
     * Gets the value of the ustanova property.
     * 
     * @return
     *     possible object is
     *     {@link TUstanova }
     *     
     */
    public TUstanova getUstanova() {
        return ustanova;
    }

    /**
     * Sets the value of the ustanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUstanova }
     *     
     */
    public void setUstanova(TUstanova value) {
        this.ustanova = value;
    }

}
