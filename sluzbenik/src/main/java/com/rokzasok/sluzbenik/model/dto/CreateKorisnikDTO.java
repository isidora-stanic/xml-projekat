package com.rokzasok.sluzbenik.model.dto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder = {"korisnickoIme", "lozinka"})
@XmlRootElement(name="CreateKorisnikDTO")
public class CreateKorisnikDTO {
    @XmlElement(name="korisnickoIme", required = true)
    private String korisnickoIme;
    @XmlElement(name="lozinka", required = true)
    private String lozinka;

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
