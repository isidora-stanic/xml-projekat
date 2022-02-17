
package com.rokzasok.portal.za.imunizaciju.model.b2b.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TTest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TTest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="vrsta_uzorka" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="proizvodjac" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="datum_i_vreme_uzorkovanja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="datum_i_vreme_rezultata" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="rezultat" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="laboratorija" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TTest", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", propOrder = {
    "naziv",
    "opis",
    "vrstaUzorka",
    "proizvodjac",
    "datumIVremeUzorkovanja",
    "datumIVremeRezultata",
    "rezultat",
    "laboratorija"
})
public class TTest {

    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String naziv;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String opis;
    @XmlElement(name = "vrsta_uzorka", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true, defaultValue = "N/A")
    protected String vrstaUzorka;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true, defaultValue = "N/A")
    protected String proizvodjac;
    @XmlElement(name = "datum_i_vreme_uzorkovanja", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String datumIVremeUzorkovanja;
    @XmlElement(name = "datum_i_vreme_rezultata", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true)
    protected String datumIVremeRezultata;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true, defaultValue = "N/A")
    protected String rezultat;
    @XmlElement(namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat", required = true, defaultValue = "N/A")
    protected String laboratorija;

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the opis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Sets the value of the opis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpis(String value) {
        this.opis = value;
    }

    /**
     * Gets the value of the vrstaUzorka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrstaUzorka() {
        return vrstaUzorka;
    }

    /**
     * Sets the value of the vrstaUzorka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrstaUzorka(String value) {
        this.vrstaUzorka = value;
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
     * Gets the value of the datumIVremeUzorkovanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumIVremeUzorkovanja() {
        return datumIVremeUzorkovanja;
    }

    /**
     * Sets the value of the datumIVremeUzorkovanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumIVremeUzorkovanja(String value) {
        this.datumIVremeUzorkovanja = value;
    }

    /**
     * Gets the value of the datumIVremeRezultata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumIVremeRezultata() {
        return datumIVremeRezultata;
    }

    /**
     * Sets the value of the datumIVremeRezultata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumIVremeRezultata(String value) {
        this.datumIVremeRezultata = value;
    }

    /**
     * Gets the value of the rezultat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRezultat() {
        return rezultat;
    }

    /**
     * Sets the value of the rezultat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRezultat(String value) {
        this.rezultat = value;
    }

    /**
     * Gets the value of the laboratorija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaboratorija() {
        return laboratorija;
    }

    /**
     * Sets the value of the laboratorija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaboratorija(String value) {
        this.laboratorija = value;
    }

}
