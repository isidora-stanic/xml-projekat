
package com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAdresa complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TAdresa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Ulica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Broj" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAdresa", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", propOrder = {
        "mesto",
        "ulica",
        "broj"
})
public class TAdresa {

    @XmlElement(name = "Mesto", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String mesto;
    @XmlElement(name = "Ulica", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String ulica;
    @XmlElement(name = "Broj", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat")
    protected int broj;

    public TAdresa() {
    }

    public TAdresa(String adresaMesto, String adresaUlica, Integer adresaBroj) {
        this.mesto = adresaMesto;
        this.ulica = adresaUlica;
        this.broj = adresaBroj;
    }

    /**
     * Gets the value of the mesto property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the ulica property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the broj property.
     */
    public int getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     */
    public void setBroj(int value) {
        this.broj = value;
    }

}
