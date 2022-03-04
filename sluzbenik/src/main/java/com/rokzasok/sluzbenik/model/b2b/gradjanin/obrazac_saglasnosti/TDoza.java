
package com.rokzasok.sluzbenik.model.b2b.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_doza", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", propOrder = {
        "tip",
        "proizvodjac",
        "datum",
        "brojSerije",
        "brojDoze",
        "nezeljeneReakcije"
})
@XmlSeeAlso({
        ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.Doza.class
})
public class TDoza {

    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected Tip tip;
    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected Proizvodjac proizvodjac;
    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected Datum datum;
    @XmlElement(name = "broj_serije", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected BrojSerije brojSerije;
    @XmlElement(name = "broj_doze", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected BrojDoze brojDoze;
    @XmlElement(name = "nezeljene_reakcije", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
    protected String nezeljeneReakcije;


    public Tip getTip() {
        return tip;
    }


    public void setTip(Tip value) {
        this.tip = value;
    }


    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }


    public void setProizvodjac(Proizvodjac value) {
        this.proizvodjac = value;
    }


    public Datum getDatum() {
        return datum;
    }


    public void setDatum(Datum value) {
        this.datum = value;
    }


    public BrojSerije getBrojSerije() {
        return brojSerije;
    }


    public void setBrojSerije(BrojSerije value) {
        this.brojSerije = value;
    }


    public BrojDoze getBrojDoze() {
        return brojDoze;
    }


    public void setBrojDoze(BrojDoze value) {
        this.brojDoze = value;
    }


    public String getNezeljeneReakcije() {
        return nezeljeneReakcije;
    }


    public void setNezeljeneReakcije(String value) {
        this.nezeljeneReakcije = value;
    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class BrojDoze {

        @XmlValue
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


        public BigInteger getValue() {
            return value;
        }


        public void setValue(BigInteger value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:brojDoze";
            } else {
                return property;
            }
        }


        public void setProperty(String value) {
            this.property = value;
        }


        public String getDatatype() {
            if (datatype == null) {
                return "xs:positiveInteger";
            } else {
                return datatype;
            }
        }


        public void setDatatype(String value) {
            this.datatype = value;
        }

    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class BrojSerije {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


        public String getValue() {
            return value;
        }


        public void setValue(String value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:brojSerije";
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



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Datum {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


        public XMLGregorianCalendar getValue() {
            return value;
        }


        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:datumPrimanja";
            } else {
                return property;
            }
        }


        public void setProperty(String value) {
            this.property = value;
        }


        public String getDatatype() {
            if (datatype == null) {
                return "xs:date";
            } else {
                return datatype;
            }
        }


        public void setDatatype(String value) {
            this.datatype = value;
        }

    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Proizvodjac {

        @XmlValue
        protected TProizvodjacVakcine value;
        @XmlAttribute(name = "property")
        protected String property;


        public TProizvodjacVakcine getValue() {
            return value;
        }


        public void setValue(TProizvodjacVakcine value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:proizvodjacVakcine";
            } else {
                return property;
            }
        }


        public void setProperty(String value) {
            this.property = value;
        }

    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Tip {

        @XmlValue
        protected TTipVakcine value;
        @XmlAttribute(name = "property")
        protected String property;
        @XmlAttribute(name = "datatype")
        protected String datatype;


        public TTipVakcine getValue() {
            return value;
        }


        public void setValue(TTipVakcine value) {
            this.value = value;
        }


        public String getProperty() {
            if (property == null) {
                return "pred:tipVakcine";
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

}
