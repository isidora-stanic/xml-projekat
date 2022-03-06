package com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"termini"})
@XmlRootElement(name = "spisakTermina", namespace = "www.rokzasok.rs/termini")
public class SpisakTermina implements Identifiable {

    @XmlElement(namespace = "www.rokzasok.rs/termini")
    protected List<Termini> termini;


    public List<Termini> getTermini() {
        if (termini == null) {
            termini = new ArrayList<Termini>();
        }
        return this.termini;
    }

    @Override
    public Long getDokumentId() {
        return 1L;
    }

    @Override
    public void setDokumentId(Long id) {

    }

    @Override
    public XMLGregorianCalendar getDatumKreiranja() {
        return null;
    }

    @Override
    public String getTipDokumenta() {
        return "Spisak termina";
    }
}
