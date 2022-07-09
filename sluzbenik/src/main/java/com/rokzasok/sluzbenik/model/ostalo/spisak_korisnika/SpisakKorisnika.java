package com.rokzasok.sluzbenik.model.ostalo.spisak_korisnika;

import com.rokzasok.sluzbenik.interfaces.Identifiable;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"korisnik"})
@XmlRootElement(name = "spisakKorisnika", namespace = "www.rokzasok.rs/korisnici")
public class SpisakKorisnika implements Identifiable {

    @XmlElement(namespace = "www.rokzasok.rs/korisnici", required = true)
    protected List<Korisnik> korisnik;


    public List<Korisnik> getKorisnik() {
        if (korisnik == null) {
            korisnik = new ArrayList<Korisnik>();
        }
        return this.korisnik;
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
        return "Spisak korisnika";
    }
}
