
package com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.obrazac_saglasnosti;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
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
 *         &lt;element name="evidencija_pacijent"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="pacijent"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="drzavljanstvo" type="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}TDrzavljanstvo"/&gt;
 *                             &lt;element name="pacijent_info" type="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}T_osoba"/&gt;
 *                             &lt;element name="kontakt"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="tel_fiksni"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_fiksni"&gt;
 *                                               &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:brojFiksnogTelefona" /&gt;
 *                                               &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                                             &lt;/extension&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="tel_mobilni" type="{http://www.rokzasok.rs/tipovi}T_mobilni"/&gt;
 *                                       &lt;element name="email"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_email"&gt;
 *                                               &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:email" /&gt;
 *                                               &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                                             &lt;/extension&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="radni_status"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="zaposlen"/&gt;
 *                                   &lt;enumeration value="nezaposlen"/&gt;
 *                                   &lt;enumeration value="penzioner"/&gt;
 *                                   &lt;enumeration value="ucenik"/&gt;
 *                                   &lt;enumeration value="student"/&gt;
 *                                   &lt;enumeration value="dete"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="zanimanje"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="zdravstvena zastita"/&gt;
 *                                   &lt;enumeration value="socijalna zastita"/&gt;
 *                                   &lt;enumeration value="prosveta"/&gt;
 *                                   &lt;enumeration value="mup"/&gt;
 *                                   &lt;enumeration value="vojska rs"/&gt;
 *                                   &lt;enumeration value="drugo"/&gt;
 *                                   &lt;enumeration value="nista"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="socijalna_zastita"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="korisnik" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                       &lt;element name="sediste"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                                 &lt;element name="opstina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ime_roditelja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="mesto_rodjenja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *                           &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="idPacijenta" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="evidencija_vakcinacija" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ustanova"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="punkt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="lekar"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="fax" type="{http://www.rokzasok.rs/tipovi}T_fiksni"/&gt;
 *                             &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="telefon" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tabela"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="doza" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;extension base="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}T_doza"&gt;
 *                                     &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *                                     &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                     &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:saglasnost" /&gt;
 *                                     &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="privremene_kontraindikacije"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                       &lt;element name="dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="odluka_komisije" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dokument_info"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="dokument_id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                   &lt;element name="saglasnost"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="izjava"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
 *                                     &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:boolean" /&gt;
 *                                     &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:izjava" /&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="naziv_leka"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                     &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
 *                                     &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:nazivLeka" /&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
 *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:kreiranOdStrane" /&gt;
 *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
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
    "evidencijaPacijent",
    "evidencijaVakcinacija",
    "dokumentInfo"
})
@XmlRootElement(name = "obrazac_saglasnosti", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
public class ObrazacSaglasnosti implements Identifiable {

    @XmlElement(name = "evidencija_pacijent", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected EvidencijaPacijent evidencijaPacijent;
    @XmlElement(name = "evidencija_vakcinacija", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
    protected EvidencijaVakcinacija evidencijaVakcinacija;
    @XmlElement(name = "dokument_info", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected DokumentInfo dokumentInfo;

    /**
     * Gets the value of the evidencijaPacijent property.
     *
     * @return
     *     possible object is
     *     {@link EvidencijaPacijent }
     *
     */
    public EvidencijaPacijent getEvidencijaPacijent() {
        return evidencijaPacijent;
    }

    /**
     * Sets the value of the evidencijaPacijent property.
     *
     * @param value
     *     allowed object is
     *     {@link EvidencijaPacijent }
     *
     */
    public void setEvidencijaPacijent(EvidencijaPacijent value) {
        this.evidencijaPacijent = value;
    }

    /**
     * Gets the value of the evidencijaVakcinacija property.
     *
     * @return
     *     possible object is
     *     {@link EvidencijaVakcinacija }
     *
     */
    public EvidencijaVakcinacija getEvidencijaVakcinacija() {
        return evidencijaVakcinacija;
    }

    /**
     * Sets the value of the evidencijaVakcinacija property.
     *
     * @param value
     *     allowed object is
     *     {@link EvidencijaVakcinacija }
     *
     */
    public void setEvidencijaVakcinacija(EvidencijaVakcinacija value) {
        this.evidencijaVakcinacija = value;
    }

    /**
     * Gets the value of the dokumentInfo property.
     *
     * @return
     *     possible object is
     *     {@link DokumentInfo }
     *
     */
    public DokumentInfo getDokumentInfo() {
        return dokumentInfo;
    }

    /**
     * Sets the value of the dokumentInfo property.
     *
     * @param value
     *     allowed object is
     *     {@link DokumentInfo }
     *
     */
    public void setDokumentInfo(DokumentInfo value) {
        this.dokumentInfo = value;
    }

    @Override
    public Long getDokumentId() {
        return dokumentInfo.getDokumentId();
    }

    @Override
    public void setDokumentId(Long id) {
        dokumentInfo.setDokumentId(id);
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
     *         &lt;element name="dokument_id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *         &lt;element name="saglasnost"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="izjava"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
     *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:boolean" /&gt;
     *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:izjava" /&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="naziv_leka"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:nazivLeka" /&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "dokumentId",
        "saglasnost"
    })
    public static class DokumentInfo {

        @XmlElement(name = "dokument_id", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected Long dokumentId;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Saglasnost saglasnost;
        @XmlAttribute(name = "vocab")
        protected String vocab;
        @XmlAttribute(name = "about")
        protected String about;
        @XmlAttribute(name = "rel")
        protected String rel;
        @XmlAttribute(name = "href")
        protected String href;

        /**
         * Gets the value of the dokumentId property.
         *
         * @return
         *     possible object is
         *     {@link Long }
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
         *     {@link Long }
         *
         */
        public void setDokumentId(Long value) {
            this.dokumentId = value;
        }

        /**
         * Gets the value of the saglasnost property.
         *
         * @return
         *     possible object is
         *     {@link Saglasnost }
         *
         */
        public Saglasnost getSaglasnost() {
            return saglasnost;
        }

        /**
         * Sets the value of the saglasnost property.
         *
         * @param value
         *     allowed object is
         *     {@link Saglasnost }
         *
         */
        public void setSaglasnost(Saglasnost value) {
            this.saglasnost = value;
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
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="izjava"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
         *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:boolean" /&gt;
         *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:izjava" /&gt;
         *               &lt;/extension&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="naziv_leka"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
         *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:nazivLeka" /&gt;
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
        @XmlType(name = "", propOrder = {
            "izjava",
            "nazivLeka"
        })
        public static class Saglasnost {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected Izjava izjava;
            @XmlElement(name = "naziv_leka", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected NazivLeka nazivLeka;

            /**
             * Gets the value of the izjava property.
             *
             * @return
             *     possible object is
             *     {@link Izjava }
             *
             */
            public Izjava getIzjava() {
                return izjava;
            }

            /**
             * Sets the value of the izjava property.
             *
             * @param value
             *     allowed object is
             *     {@link Izjava }
             *
             */
            public void setIzjava(Izjava value) {
                this.izjava = value;
            }

            /**
             * Gets the value of the nazivLeka property.
             *
             * @return
             *     possible object is
             *     {@link NazivLeka }
             *
             */
            public NazivLeka getNazivLeka() {
                return nazivLeka;
            }

            /**
             * Sets the value of the nazivLeka property.
             *
             * @param value
             *     allowed object is
             *     {@link NazivLeka }
             *
             */
            public void setNazivLeka(NazivLeka value) {
                this.nazivLeka = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
             *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:boolean" /&gt;
             *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:izjava" /&gt;
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
            public static class Izjava {

                @XmlValue
                protected boolean value;
                @XmlAttribute(name = "datatype")
                protected String datatype;
                @XmlAttribute(name = "property")
                protected String property;

                /**
                 * Gets the value of the value property.
                 *
                 */
                public boolean isValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 *
                 */
                public void setValue(boolean value) {
                    this.value = value;
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
                        return "xs:boolean";
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
                        return "pred:izjava";
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
             *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
             *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:nazivLeka" /&gt;
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
            public static class NazivLeka {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "datatype")
                protected String datatype;
                @XmlAttribute(name = "property")
                protected String property;

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
                        return "pred:nazivLeka";
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
     *         &lt;element name="pacijent"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="drzavljanstvo" type="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}TDrzavljanstvo"/&gt;
     *                   &lt;element name="pacijent_info" type="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}T_osoba"/&gt;
     *                   &lt;element name="kontakt"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="tel_fiksni"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_fiksni"&gt;
     *                                     &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:brojFiksnogTelefona" /&gt;
     *                                     &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *                                   &lt;/extension&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="tel_mobilni" type="{http://www.rokzasok.rs/tipovi}T_mobilni"/&gt;
     *                             &lt;element name="email"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_email"&gt;
     *                                     &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:email" /&gt;
     *                                     &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
     *                                   &lt;/extension&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="radni_status"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="zaposlen"/&gt;
     *                         &lt;enumeration value="nezaposlen"/&gt;
     *                         &lt;enumeration value="penzioner"/&gt;
     *                         &lt;enumeration value="ucenik"/&gt;
     *                         &lt;enumeration value="student"/&gt;
     *                         &lt;enumeration value="dete"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="zanimanje"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="zdravstvena zastita"/&gt;
     *                         &lt;enumeration value="socijalna zastita"/&gt;
     *                         &lt;enumeration value="prosveta"/&gt;
     *                         &lt;enumeration value="mup"/&gt;
     *                         &lt;enumeration value="vojska rs"/&gt;
     *                         &lt;enumeration value="drugo"/&gt;
     *                         &lt;enumeration value="nista"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="socijalna_zastita"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="korisnik" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                             &lt;element name="sediste"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                                       &lt;element name="opstina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ime_roditelja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="mesto_rodjenja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
     *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="idPacijenta" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
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
        "pacijent"
    })
    public static class EvidencijaPacijent {

        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Pacijent pacijent;

        /**
         * Gets the value of the pacijent property.
         *
         * @return
         *     possible object is
         *     {@link Pacijent }
         *
         */
        public Pacijent getPacijent() {
            return pacijent;
        }

        /**
         * Sets the value of the pacijent property.
         *
         * @param value
         *     allowed object is
         *     {@link Pacijent }
         *
         */
        public void setPacijent(Pacijent value) {
            this.pacijent = value;
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
         *         &lt;element name="drzavljanstvo" type="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}TDrzavljanstvo"/&gt;
         *         &lt;element name="pacijent_info" type="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}T_osoba"/&gt;
         *         &lt;element name="kontakt"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="tel_fiksni"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_fiksni"&gt;
         *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:brojFiksnogTelefona" /&gt;
         *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
         *                         &lt;/extension&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="tel_mobilni" type="{http://www.rokzasok.rs/tipovi}T_mobilni"/&gt;
         *                   &lt;element name="email"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_email"&gt;
         *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:email" /&gt;
         *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
         *                         &lt;/extension&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="radni_status"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="zaposlen"/&gt;
         *               &lt;enumeration value="nezaposlen"/&gt;
         *               &lt;enumeration value="penzioner"/&gt;
         *               &lt;enumeration value="ucenik"/&gt;
         *               &lt;enumeration value="student"/&gt;
         *               &lt;enumeration value="dete"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="zanimanje"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="zdravstvena zastita"/&gt;
         *               &lt;enumeration value="socijalna zastita"/&gt;
         *               &lt;enumeration value="prosveta"/&gt;
         *               &lt;enumeration value="mup"/&gt;
         *               &lt;enumeration value="vojska rs"/&gt;
         *               &lt;enumeration value="drugo"/&gt;
         *               &lt;enumeration value="nista"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="socijalna_zastita"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="korisnik" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                   &lt;element name="sediste"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                             &lt;element name="opstina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ime_roditelja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="mesto_rodjenja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
         *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="idPacijenta" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long"&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "drzavljanstvo",
            "pacijentInfo",
            "kontakt",
            "radniStatus",
            "zanimanje",
            "socijalnaZastita",
            "imeRoditelja",
            "mestoRodjenja"
        })
        public static class Pacijent {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected TDrzavljanstvo drzavljanstvo;
            @XmlElement(name = "pacijent_info", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected TOsoba pacijentInfo;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected Kontakt kontakt;
            @XmlElement(name = "radni_status", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String radniStatus;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String zanimanje;
            @XmlElement(name = "socijalna_zastita", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected SocijalnaZastita socijalnaZastita;
            @XmlElement(name = "ime_roditelja", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String imeRoditelja;
            @XmlElement(name = "mesto_rodjenja", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String mestoRodjenja;
            @XmlAttribute(name = "vocab")
            protected String vocab;
            @XmlAttribute(name = "about")
            protected String about;
            @XmlAttribute(name = "idPacijenta", required = true)
            protected long idPacijenta;

            /**
             * Gets the value of the drzavljanstvo property.
             *
             * @return
             *     possible object is
             *     {@link TDrzavljanstvo }
             *
             */
            public TDrzavljanstvo getDrzavljanstvo() {
                return drzavljanstvo;
            }

            /**
             * Sets the value of the drzavljanstvo property.
             *
             * @param value
             *     allowed object is
             *     {@link TDrzavljanstvo }
             *
             */
            public void setDrzavljanstvo(TDrzavljanstvo value) {
                this.drzavljanstvo = value;
            }

            /**
             * Gets the value of the pacijentInfo property.
             *
             * @return
             *     possible object is
             *     {@link TOsoba }
             *
             */
            public TOsoba getPacijentInfo() {
                return pacijentInfo;
            }

            /**
             * Sets the value of the pacijentInfo property.
             *
             * @param value
             *     allowed object is
             *     {@link TOsoba }
             *
             */
            public void setPacijentInfo(TOsoba value) {
                this.pacijentInfo = value;
            }

            /**
             * Gets the value of the kontakt property.
             *
             * @return
             *     possible object is
             *     {@link Kontakt }
             *
             */
            public Kontakt getKontakt() {
                return kontakt;
            }

            /**
             * Sets the value of the kontakt property.
             *
             * @param value
             *     allowed object is
             *     {@link Kontakt }
             *
             */
            public void setKontakt(Kontakt value) {
                this.kontakt = value;
            }

            /**
             * Gets the value of the radniStatus property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getRadniStatus() {
                return radniStatus;
            }

            /**
             * Sets the value of the radniStatus property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setRadniStatus(String value) {
                this.radniStatus = value;
            }

            /**
             * Gets the value of the zanimanje property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getZanimanje() {
                return zanimanje;
            }

            /**
             * Sets the value of the zanimanje property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setZanimanje(String value) {
                this.zanimanje = value;
            }

            /**
             * Gets the value of the socijalnaZastita property.
             *
             * @return
             *     possible object is
             *     {@link SocijalnaZastita }
             *
             */
            public SocijalnaZastita getSocijalnaZastita() {
                return socijalnaZastita;
            }

            /**
             * Sets the value of the socijalnaZastita property.
             *
             * @param value
             *     allowed object is
             *     {@link SocijalnaZastita }
             *
             */
            public void setSocijalnaZastita(SocijalnaZastita value) {
                this.socijalnaZastita = value;
            }

            /**
             * Gets the value of the imeRoditelja property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getImeRoditelja() {
                return imeRoditelja;
            }

            /**
             * Sets the value of the imeRoditelja property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setImeRoditelja(String value) {
                this.imeRoditelja = value;
            }

            /**
             * Gets the value of the mestoRodjenja property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getMestoRodjenja() {
                return mestoRodjenja;
            }

            /**
             * Sets the value of the mestoRodjenja property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setMestoRodjenja(String value) {
                this.mestoRodjenja = value;
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
             * Gets the value of the idPacijenta property.
             *
             */
            public long getIdPacijenta() {
                return idPacijenta;
            }

            /**
             * Sets the value of the idPacijenta property.
             *
             */
            public void setIdPacijenta(long value) {
                this.idPacijenta = value;
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
             *         &lt;element name="tel_fiksni"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_fiksni"&gt;
             *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:brojFiksnogTelefona" /&gt;
             *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
             *               &lt;/extension&gt;
             *             &lt;/simpleContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="tel_mobilni" type="{http://www.rokzasok.rs/tipovi}T_mobilni"/&gt;
             *         &lt;element name="email"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_email"&gt;
             *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:email" /&gt;
             *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}string" default="xs:string" /&gt;
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
            @XmlType(name = "", propOrder = {
                "telFiksni",
                "telMobilni",
                "email"
            })
            public static class Kontakt {

                @XmlElement(name = "tel_fiksni", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected TelFiksni telFiksni;
                @XmlElement(name = "tel_mobilni", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected String telMobilni;
                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected Email email;

                /**
                 * Gets the value of the telFiksni property.
                 *
                 * @return
                 *     possible object is
                 *     {@link TelFiksni }
                 *
                 */
                public TelFiksni getTelFiksni() {
                    return telFiksni;
                }

                /**
                 * Sets the value of the telFiksni property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link TelFiksni }
                 *
                 */
                public void setTelFiksni(TelFiksni value) {
                    this.telFiksni = value;
                }

                /**
                 * Gets the value of the telMobilni property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getTelMobilni() {
                    return telMobilni;
                }

                /**
                 * Sets the value of the telMobilni property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setTelMobilni(String value) {
                    this.telMobilni = value;
                }

                /**
                 * Gets the value of the email property.
                 *
                 * @return
                 *     possible object is
                 *     {@link Email }
                 *
                 */
                public Email getEmail() {
                    return email;
                }

                /**
                 * Sets the value of the email property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link Email }
                 *
                 */
                public void setEmail(Email value) {
                    this.email = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 *
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 *
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_email"&gt;
                 *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:email" /&gt;
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
                public static class Email {

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
                            return "pred:email";
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
                 *     &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_fiksni"&gt;
                 *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:brojFiksnogTelefona" /&gt;
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
                public static class TelFiksni {

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
                            return "pred:brojFiksnogTelefona";
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
             *         &lt;element name="korisnik" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *         &lt;element name="sediste"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *                   &lt;element name="opstina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *                 &lt;/sequence&gt;
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
                "korisnik",
                "sediste"
            })
            public static class SocijalnaZastita {

                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
                protected boolean korisnik;
                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected Sediste sediste;

                /**
                 * Gets the value of the korisnik property.
                 *
                 */
                public boolean isKorisnik() {
                    return korisnik;
                }

                /**
                 * Sets the value of the korisnik property.
                 *
                 */
                public void setKorisnik(boolean value) {
                    this.korisnik = value;
                }

                /**
                 * Gets the value of the sediste property.
                 *
                 * @return
                 *     possible object is
                 *     {@link Sediste }
                 *
                 */
                public Sediste getSediste() {
                    return sediste;
                }

                /**
                 * Sets the value of the sediste property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link Sediste }
                 *
                 */
                public void setSediste(Sediste value) {
                    this.sediste = value;
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
                 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                 *         &lt;element name="opstina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
                    "naziv",
                    "opstina"
                })
                public static class Sediste {

                    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                    protected String naziv;
                    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                    protected String opstina;

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
                     * Gets the value of the opstina property.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getOpstina() {
                        return opstina;
                    }

                    /**
                     * Sets the value of the opstina property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setOpstina(String value) {
                        this.opstina = value;
                    }

                }

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
     *         &lt;element name="ustanova"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="punkt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="lekar"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="fax" type="{http://www.rokzasok.rs/tipovi}T_fiksni"/&gt;
     *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="telefon" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="tabela"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="doza" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;extension base="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}T_doza"&gt;
     *                           &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
     *                           &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                           &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:saglasnost" /&gt;
     *                           &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="privremene_kontraindikacije"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                             &lt;element name="dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="odluka_komisije" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                 &lt;/sequence&gt;
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
        "ustanova",
        "lekar",
        "tabela"
    })
    public static class EvidencijaVakcinacija {

        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Ustanova ustanova;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Lekar lekar;
        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected Tabela tabela;

        /**
         * Gets the value of the ustanova property.
         *
         * @return
         *     possible object is
         *     {@link Ustanova }
         *
         */
        public Ustanova getUstanova() {
            return ustanova;
        }

        /**
         * Sets the value of the ustanova property.
         *
         * @param value
         *     allowed object is
         *     {@link Ustanova }
         *
         */
        public void setUstanova(Ustanova value) {
            this.ustanova = value;
        }

        /**
         * Gets the value of the lekar property.
         *
         * @return
         *     possible object is
         *     {@link Lekar }
         *
         */
        public Lekar getLekar() {
            return lekar;
        }

        /**
         * Sets the value of the lekar property.
         *
         * @param value
         *     allowed object is
         *     {@link Lekar }
         *
         */
        public void setLekar(Lekar value) {
            this.lekar = value;
        }

        /**
         * Gets the value of the tabela property.
         *
         * @return
         *     possible object is
         *     {@link Tabela }
         *
         */
        public Tabela getTabela() {
            return tabela;
        }

        /**
         * Sets the value of the tabela property.
         *
         * @param value
         *     allowed object is
         *     {@link Tabela }
         *
         */
        public void setTabela(Tabela value) {
            this.tabela = value;
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
         *         &lt;element name="fax" type="{http://www.rokzasok.rs/tipovi}T_fiksni"/&gt;
         *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="telefon" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "fax",
            "ime",
            "prezime",
            "telefon"
        })
        public static class Lekar {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String fax;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String ime;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String prezime;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String telefon;

            /**
             * Gets the value of the fax property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getFax() {
                return fax;
            }

            /**
             * Sets the value of the fax property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setFax(String value) {
                this.fax = value;
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
             * Gets the value of the telefon property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getTelefon() {
                return telefon;
            }

            /**
             * Sets the value of the telefon property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setTelefon(String value) {
                this.telefon = value;
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
         *         &lt;element name="doza" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}T_doza"&gt;
         *                 &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
         *                 &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                 &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:saglasnost" /&gt;
         *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *               &lt;/extension&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="privremene_kontraindikacije"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="odluka_komisije" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
            "doza",
            "privremeneKontraindikacije",
            "odlukaKomisije"
        })
        public static class Tabela {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected List<Doza> doza;
            @XmlElement(name = "privremene_kontraindikacije", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected PrivremeneKontraindikacije privremeneKontraindikacije;
            @XmlElement(name = "odluka_komisije", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
            protected boolean odlukaKomisije;

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
             * Gets the value of the privremeneKontraindikacije property.
             *
             * @return
             *     possible object is
             *     {@link PrivremeneKontraindikacije }
             *
             */
            public PrivremeneKontraindikacije getPrivremeneKontraindikacije() {
                return privremeneKontraindikacije;
            }

            /**
             * Sets the value of the privremeneKontraindikacije property.
             *
             * @param value
             *     allowed object is
             *     {@link PrivremeneKontraindikacije }
             *
             */
            public void setPrivremeneKontraindikacije(PrivremeneKontraindikacije value) {
                this.privremeneKontraindikacije = value;
            }

            /**
             * Gets the value of the odlukaKomisije property.
             *
             */
            public boolean isOdlukaKomisije() {
                return odlukaKomisije;
            }

            /**
             * Sets the value of the odlukaKomisije property.
             *
             */
            public void setOdlukaKomisije(boolean value) {
                this.odlukaKomisije = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti}T_doza"&gt;
             *       &lt;attribute name="vocab" type="{http://www.w3.org/2001/XMLSchema}string" fixed="http://www.rokzasok.rs/rdf/database/predicate" /&gt;
             *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:saglasnost" /&gt;
             *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
                @XmlAttribute(name = "rel")
                protected String rel;
                @XmlAttribute(name = "href")
                protected String href;

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
                        return "pred:saglasnost";
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
                    return href;
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
             *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
                "datum",
                "dijagnoza"
            })
            public static class PrivremeneKontraindikacije {

                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar datum;
                @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
                protected String dijagnoza;

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
                 * Gets the value of the dijagnoza property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getDijagnoza() {
                    return dijagnoza;
                }

                /**
                 * Sets the value of the dijagnoza property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setDijagnoza(String value) {
                    this.dijagnoza = value;
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
         *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="punkt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "naziv",
            "punkt"
        })
        public static class Ustanova {

            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String naziv;
            @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
            protected String punkt;

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
             * Gets the value of the punkt property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getPunkt() {
                return punkt;
            }

            /**
             * Sets the value of the punkt property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setPunkt(String value) {
                this.punkt = value;
            }

        }

    }

}
