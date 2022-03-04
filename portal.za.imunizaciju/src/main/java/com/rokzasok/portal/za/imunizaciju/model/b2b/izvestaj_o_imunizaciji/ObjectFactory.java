
package com.rokzasok.portal.za.imunizaciju.model.b2b.izvestaj_o_imunizaciji;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }


    public KolekcijaIzvestaja createKolekcijaIzvestaja() {
        return new KolekcijaIzvestaja();
    }


    public IzvestajOImunizaciji createIzvestajOImunizaciji() {
        return new IzvestajOImunizaciji();
    }


    public IzvestajOImunizaciji.RaspodelaPoProizvodjacima createIzvestajOImunizacijiRaspodelaPoProizvodjacima() {
        return new IzvestajOImunizaciji.RaspodelaPoProizvodjacima();
    }


    public IzvestajOImunizaciji.DozeVakcina createIzvestajOImunizacijiDozeVakcina() {
        return new IzvestajOImunizaciji.DozeVakcina();
    }


    public IzvestajOImunizaciji.PeriodIzvestaja createIzvestajOImunizacijiPeriodIzvestaja() {
        return new IzvestajOImunizaciji.PeriodIzvestaja();
    }


    public IzvestajOImunizaciji.RaspodelaPoProizvodjacima.Proizvodjac createIzvestajOImunizacijiRaspodelaPoProizvodjacimaProizvodjac() {
        return new IzvestajOImunizaciji.RaspodelaPoProizvodjacima.Proizvodjac();
    }


    public IzvestajOImunizaciji.DozeVakcina.Doza createIzvestajOImunizacijiDozeVakcinaDoza() {
        return new IzvestajOImunizaciji.DozeVakcina.Doza();
    }

}
