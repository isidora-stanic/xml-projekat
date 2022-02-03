
package com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.iskazivanje_interesovanja;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.rokzasok.rs/tipovi&gt;T_drzavljanstvo"&gt;
 *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" default="pred:drzavljanstvo" /&gt;
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
@XmlRootElement(name = "drzavljanstvo", namespace = "http://www.rokzasok.rs/tipovi")
public class Drzavljanstvo {

    @XmlValue
    protected TDrzavljanstvo value;
    @XmlAttribute(name = "property")
    protected String property;
    @XmlAttribute(name = "datatype")
    protected String datatype;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link TDrzavljanstvo }
     *     
     */
    public TDrzavljanstvo getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDrzavljanstvo }
     *     
     */
    public void setValue(TDrzavljanstvo value) {
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
            return "pred:drzavljanstvo";
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
