//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.16 at 04:41:49 PM CET 
//


package com.rokzasok.sluzbenik.soap.dostupne_doze.model;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="tipVakcine" type="{http://www.rokzasok.rs/soap/dostupne_doze}T_tip_vakcine"/&gt;
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
    "tipVakcine"
})
@XmlRootElement(name = "dozeRequest")
public class DozeRequest {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TTipVakcine tipVakcine;

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
