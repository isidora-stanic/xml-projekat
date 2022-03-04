
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDrzavljanstvo", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", propOrder = {
        "strano",
        "srpsko"
})
public class TDrzavljanstvo {

    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
    protected Strano strano;
    @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
    protected Srpsko srpsko;


    public Strano getStrano() {
        return strano;
    }


    public void setStrano(Strano value) {
        this.strano = value;
    }


    public Srpsko getSrpsko() {
        return srpsko;
    }


    public void setSrpsko(Srpsko value) {
        this.srpsko = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "jmbg"
    })
    public static class Srpsko {

        @XmlElement(name = "JMBG", namespace = "http://www.rokzasok.rs/tipovi", required = true)
        protected String jmbg;


        public String getJMBG() {
            return jmbg;
        }


        public void setJMBG(String value) {
            this.jmbg = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "drzava",
            "brojPasosa"
    })
    public static class Strano {

        @XmlElement(namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti", required = true)
        protected String drzava;
        @XmlElement(name = "broj_pasosa", namespace = "http://www.rokzasok.rs/tipovi", required = true)
        protected String brojPasosa;


        public String getDrzava() {
            return drzava;
        }


        public void setDrzava(String value) {
            this.drzava = value;
        }


        public String getBrojPasosa() {
            return brojPasosa;
        }


        public void setBrojPasosa(String value) {
            this.brojPasosa = value;
        }

    }

}
