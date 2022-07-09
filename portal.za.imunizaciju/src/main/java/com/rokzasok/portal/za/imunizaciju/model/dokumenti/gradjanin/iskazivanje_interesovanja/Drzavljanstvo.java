package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"value"})
@XmlRootElement(name = "drzavljanstvo", namespace = "http://www.rokzasok.rs/tipovi")
public class Drzavljanstvo {

    @XmlValue
    protected TDrzavljanstvo value;
    @XmlAttribute(name = "property")
    protected String property;
    @XmlAttribute(name = "datatype")
    protected String datatype;


    public TDrzavljanstvo getValue() {
        return value;
    }


    public void setValue(TDrzavljanstvo value) {
        this.value = value;
    }


    public String getProperty() {
        if (property == null) {
            return "pred:drzavljanstvo";
        } else {
            return property;
        }
    }


    public void setProperty(String value) {
        this.property = value;
    }


    public String getDatatype() {
        if (datatype == null) {
            return "xs:string";
        } else {
            return datatype;
        }
    }


    public void setDatatype(String value) {
        this.datatype = value;
    }

}
