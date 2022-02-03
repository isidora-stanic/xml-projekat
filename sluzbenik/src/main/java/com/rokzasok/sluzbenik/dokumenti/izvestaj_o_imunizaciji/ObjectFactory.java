
package com.rokzasok.sluzbenik.dokumenti.izvestaj_o_imunizaciji;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the www.rokzasok.rs.sluzbenik.izvestaj_o_imunizaciji package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: www.rokzasok.rs.sluzbenik.izvestaj_o_imunizaciji
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IzvestajOImunizaciji }
     * 
     */
    public IzvestajOImunizaciji createIzvestajOImunizaciji() {
        return new IzvestajOImunizaciji();
    }

    /**
     * Create an instance of {@link IzvestajOImunizaciji.RaspodelaPoProizvodjacima }
     * 
     */
    public IzvestajOImunizaciji.RaspodelaPoProizvodjacima createIzvestajOImunizacijiRaspodelaPoProizvodjacima() {
        return new IzvestajOImunizaciji.RaspodelaPoProizvodjacima();
    }

    /**
     * Create an instance of {@link IzvestajOImunizaciji.DozeVakcina }
     * 
     */
    public IzvestajOImunizaciji.DozeVakcina createIzvestajOImunizacijiDozeVakcina() {
        return new IzvestajOImunizaciji.DozeVakcina();
    }

    /**
     * Create an instance of {@link IzvestajOImunizaciji.PeriodIzvestaja }
     * 
     */
    public IzvestajOImunizaciji.PeriodIzvestaja createIzvestajOImunizacijiPeriodIzvestaja() {
        return new IzvestajOImunizaciji.PeriodIzvestaja();
    }

    /**
     * Create an instance of {@link IzvestajOImunizaciji.RaspodelaPoProizvodjacima.Proizvodjac }
     * 
     */
    public IzvestajOImunizaciji.RaspodelaPoProizvodjacima.Proizvodjac createIzvestajOImunizacijiRaspodelaPoProizvodjacimaProizvodjac() {
        return new IzvestajOImunizaciji.RaspodelaPoProizvodjacima.Proizvodjac();
    }

    /**
     * Create an instance of {@link IzvestajOImunizaciji.DozeVakcina.Doza }
     * 
     */
    public IzvestajOImunizaciji.DozeVakcina.Doza createIzvestajOImunizacijiDozeVakcinaDoza() {
        return new IzvestajOImunizaciji.DozeVakcina.Doza();
    }

}
