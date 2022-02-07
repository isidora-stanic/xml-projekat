package com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "obrasciSaglasnosti" })
@XmlRootElement(name = "kolekcija-obrazaca-saglasnosti")
public class KolekcijaObrazacaSaglasnosti {
    @XmlElement(name = "obrazac-saglasnosti")
    protected List<ObrazacSaglasnosti> obrasciSaglasnosti;

    public List<ObrazacSaglasnosti> getObrasciSaglasnosti() {
        if (obrasciSaglasnosti == null)
            obrasciSaglasnosti = new ArrayList<>();
        return obrasciSaglasnosti;
    }

    public void setObrasciSaglasnosti(List<ObrazacSaglasnosti> obrasciSaglasnosti) {
        this.obrasciSaglasnosti = obrasciSaglasnosti;
    }
}