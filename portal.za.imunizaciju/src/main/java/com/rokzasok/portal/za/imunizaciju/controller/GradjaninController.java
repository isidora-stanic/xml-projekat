package com.rokzasok.portal.za.imunizaciju.controller;

public class GradjaninController {

    public void registracija(){

    }

    public void interesovanjeZaPrijemVakcine(){
        //post
        //TODO:podnosi se samo prije prve doze, salje mu se mejl da je uspjesno podnio zahtjev, dodjeljuje mu se termin
    }

    public void dokumentSaglasnosti(){
        //post
        //TODO:samo se salje dokument saglasnosti za prijem vakcine na bek
    }

    public void zahtjevZaIzdavanjeZelenogSertifikata(){
        //post
        //TODO:samo se salje zahtjev za zeleni sertifikat na bek
    }

    public void pregledDokumenata(){
        //get
        //TODO: kao query param se salje koji tip dokumenta zeli da vidi: bilo koji kojeg je sam poslao ili koji mu je izdat
        //TODO: omoguciti i dobavljanje u pdf ili xhtml formatu(to negdje drugo treba, nego samo napomena ovde)
    }
}
