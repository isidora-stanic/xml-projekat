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
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"brojDoza"})
@XmlRootElement(name = "dostupneDoze", namespace = "www.rokzasok.rs/dostupne-doze-vakcina")
public class DostupneDoze implements Identifiable {

    @XmlElement(namespace = "www.rokzasok.rs/dostupne-doze-vakcina", required = true)
    protected List<BrojDoza> brojDoza;

    @Override
    public XMLGregorianCalendar getDatumKreiranja() {
        return null;
    }

    @Override
    public String getTipDokumenta() {
        return "Dostupne doze";
    }


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


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"value"})
    public static class BrojDoza {

        @XmlValue
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger value;
        @XmlAttribute(name = "tipVakcine", required = true)
        protected TTipVakcine tipVakcine;


        public BigInteger getValue() {
            return value;
        }


        public void setValue(BigInteger value) {
            this.value = value;
        }


        public TTipVakcine getTipVakcine() {
            return tipVakcine;
        }


        public void setTipVakcine(TTipVakcine value) {
            this.tipVakcine = value;
        }

    }

}
