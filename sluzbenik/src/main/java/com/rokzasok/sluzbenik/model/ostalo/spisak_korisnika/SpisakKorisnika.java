
package com.rokzasok.sluzbenik.model.ostalo.spisak_korisnika;

import javax.xml.bind.annotation.*;
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
 *         &lt;element name="korisnik" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="lozinka" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="uloge"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="uloga" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="gradjanin"/&gt;
 *                                   &lt;enumeration value="zdravstveni_radnik"/&gt;
 *                                   &lt;enumeration value="sluzbenik"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="korisnickoIme" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
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
    "korisnik"
})
@XmlRootElement(name = "spisakKorisnika", namespace = "www.rokzasok.rs/korisnici")
public class SpisakKorisnika {

    @XmlElement(namespace = "www.rokzasok.rs/korisnici")
    protected List<Korisnik> korisnik;

    /**
     * Gets the value of the korisnik property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the korisnik property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKorisnik().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Korisnik }
     * 
     * 
     */
    public List<Korisnik> getKorisnik() {
        if (korisnik == null) {
            korisnik = new ArrayList<Korisnik>();
        }
        return this.korisnik;
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
     *         &lt;element name="lozinka" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="uloge"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="uloga" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="gradjanin"/&gt;
     *                         &lt;enumeration value="zdravstveni_radnik"/&gt;
     *                         &lt;enumeration value="sluzbenik"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="korisnickoIme" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "lozinka",
        "uloge"
    })
    public static class Korisnik {

        @XmlElement(namespace = "www.rokzasok.rs/korisnici", required = true)
        protected String lozinka;
        @XmlElement(namespace = "www.rokzasok.rs/korisnici", required = true)
        protected Uloge uloge;
        @XmlAttribute(name = "korisnickoIme", required = true)
        protected String korisnickoIme;
        @XmlAttribute(name = "id", required = true)
        protected long id;

        /**
         * Gets the value of the lozinka property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLozinka() {
            return lozinka;
        }

        /**
         * Sets the value of the lozinka property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLozinka(String value) {
            this.lozinka = value;
        }

        /**
         * Gets the value of the uloge property.
         * 
         * @return
         *     possible object is
         *     {@link Uloge }
         *     
         */
        public Uloge getUloge() {
            return uloge;
        }

        /**
         * Sets the value of the uloge property.
         * 
         * @param value
         *     allowed object is
         *     {@link Uloge }
         *     
         */
        public void setUloge(Uloge value) {
            this.uloge = value;
        }

        /**
         * Gets the value of the korisnickoIme property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKorisnickoIme() {
            return korisnickoIme;
        }

        /**
         * Sets the value of the korisnickoIme property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKorisnickoIme(String value) {
            this.korisnickoIme = value;
        }

        /**
         * Gets the value of the id property.
         * 
         */
        public long getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         */
        public void setId(long value) {
            this.id = value;
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
         *         &lt;element name="uloga" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="gradjanin"/&gt;
         *               &lt;enumeration value="zdravstveni_radnik"/&gt;
         *               &lt;enumeration value="sluzbenik"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
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
            "uloga"
        })
        public static class Uloge {

            @XmlElement(namespace = "www.rokzasok.rs/korisnici")
            protected List<String> uloga;

            /**
             * Gets the value of the uloga property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the uloga property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getUloga().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getUloga() {
                if (uloga == null) {
                    uloga = new ArrayList<String>();
                }
                return this.uloga;
            }

        }

    }

}
