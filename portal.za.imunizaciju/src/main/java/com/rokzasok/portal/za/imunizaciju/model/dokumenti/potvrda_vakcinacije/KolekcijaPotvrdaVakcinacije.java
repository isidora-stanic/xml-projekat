package com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "potvrdeVakcinacije" })
@XmlRootElement(name = "kolekcija-potvrda-vakcinacije")
public class KolekcijaPotvrdaVakcinacije {

    @XmlElement(name = "potvrda-vakcinacije")
    protected List<PotvrdaVakcinacije> potvrdeVakcinacije;

    public List<PotvrdaVakcinacije> getPotvrdeVakcinacije() {
        if (potvrdeVakcinacije == null)
            potvrdeVakcinacije = new ArrayList<>();
        return potvrdeVakcinacije;
    }

    public void setPotvrdeVakcinacije(List<PotvrdaVakcinacije> potvrdeVakcinacije) {
        this.potvrdeVakcinacije = potvrdeVakcinacije;
    }
}
