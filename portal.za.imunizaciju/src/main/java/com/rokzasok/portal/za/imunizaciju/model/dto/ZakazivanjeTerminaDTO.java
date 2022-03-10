package com.rokzasok.portal.za.imunizaciju.model.dto;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder = {"mesto", "datum", "tipVakcine"})
@XmlRootElement(name="ZakazivanjeTerminaDTO")
public class ZakazivanjeTerminaDTO {
    @XmlElement(name="mesto", required = true)
    private String mesto;
    @XmlElement(name="datum", required = true)
    private XMLGregorianCalendar datum;
    @XmlElement(name="tipVakcine", required = true)
    private String tipVakcine;

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public LocalDate getDatum() {
        return LocalDate.of(datum.getYear(), datum.getMonth(), datum.getDay());
    }

    public void setDatum(XMLGregorianCalendar datum) {
        this.datum = datum;
    }

    public String getTipVakcine() {
        return tipVakcine;
    }

    public void setTipVakcine(String tipVakcine) {
        this.tipVakcine = tipVakcine;
    }

    public Integer getUnapred() {
        return 5;
    }
}
