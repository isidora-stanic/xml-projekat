
package com.rokzasok.sluzbenik.model.ostalo.dostupne_doze;

import com.rokzasok.sluzbenik.interfaces.Identifiable;

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
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="brojDoza" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;positiveInteger"&gt;
 *                 &lt;attribute name="tipVakcine" use="required" type="{www.rokzasok.rs/dostupne-doze-vakcina}T_tip_vakcine" /&gt;
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
    "brojDoza"
})
@XmlRootElement(name = "dostupneDoze", namespace = "www.rokzasok.rs/dostupne-doze-vakcina")
public class DostupneDoze implements Identifiable {

    @XmlElement(namespace = "www.rokzasok.rs/dostupne-doze-vakcina", required = true)
    protected List<BrojDoza> brojDoza;

    /**
     * Gets the value of the brojDoza property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the brojDoza property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBrojDoza().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BrojDoza }
     *
     *
     */
    public List<BrojDoza> getBrojDoza() {
        if (brojDoza == null) {
            brojDoza = new ArrayList<BrojDoza>();
        }
        return this.brojDoza;
    }

    @Override
    public Long getDokumentId() {
        return 1L;
    }

    @Override
    public void setDokumentId(Long id) {
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;positiveInteger"&gt;
     *       &lt;attribute name="tipVakcine" use="required" type="{www.rokzasok.rs/dostupne-doze-vakcina}T_tip_vakcine" /&gt;
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
    public static class BrojDoza {

        @XmlValue
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger value;
        @XmlAttribute(name = "tipVakcine", required = true)
        protected TTipVakcine tipVakcine;

        /**
         * Gets the value of the value property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setValue(BigInteger value) {
            this.value = value;
        }

        /**
         * Gets the value of the tipVakcine property.
         *
         * @return
         *     possible object is
         *     {@link TTipVakcine }
         *
         */
        public TTipVakcine getTipVakcine() {
            return tipVakcine;
        }

        /**
         * Sets the value of the tipVakcine property.
         *
         * @param value
         *     allowed object is
         *     {@link TTipVakcine }
         *
         */
        public void setTipVakcine(TTipVakcine value) {
            this.tipVakcine = value;
        }

    }

}
