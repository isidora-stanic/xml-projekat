package com.rokzasok.sluzbenik.model.dokumenti.izvestaj_o_imunizaciji;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"izvestaj"})
@XmlRootElement(name = "kolekcija-izvestaja")
public class KolekcijaIzvestaja {
    @XmlElement(name = "izvestaj")
    protected List<IzvestajOImunizaciji> izvestaj;

    public List<IzvestajOImunizaciji> getIzvestaj() {
        if (izvestaj == null) {
            izvestaj = new ArrayList<>();
        }
        return izvestaj;
    }

    public void setIzvestaj(List<IzvestajOImunizaciji> izvestaj) {
        this.izvestaj = izvestaj;
    }
}
