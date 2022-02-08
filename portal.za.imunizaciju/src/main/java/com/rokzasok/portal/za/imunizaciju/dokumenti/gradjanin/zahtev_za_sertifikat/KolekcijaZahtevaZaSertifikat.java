package com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.zahtev_za_sertifikat;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"zahteviZaSertifikat"})
@XmlRootElement(name = "kolekcija-zahteva-za-sertifikat")
public class KolekcijaZahtevaZaSertifikat {
    @XmlElement(name = "zahtev-za-sertifikat")
    protected List<Zahtev> zahteviZaSertifikat;

    public List<Zahtev> getZahteviZaSertifikat() {
        if (zahteviZaSertifikat == null) {
            zahteviZaSertifikat = new ArrayList<>();
        }
        return zahteviZaSertifikat;
    }

    public void setZahteviZaSertifikat(List<Zahtev> zahteviZaSertifikat) {
        this.zahteviZaSertifikat = zahteviZaSertifikat;
    }
}
