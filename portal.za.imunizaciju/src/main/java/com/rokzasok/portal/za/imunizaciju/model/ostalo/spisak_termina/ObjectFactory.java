
package com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rokzasok.portal.za.imunizaciju.model.ostalo package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rokzasok.portal.za.imunizaciju.model.ostalo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SpisakTermina }
     * 
     */
    public SpisakTermina createSpisakTermina() {
        return new SpisakTermina();
    }

    /**
     * Create an instance of {@link SpisakTermina.Termini }
     * 
     */
    public SpisakTermina.Termini createSpisakTerminaTermini() {
        return new SpisakTermina.Termini();
    }

    /**
     * Create an instance of {@link SpisakTermina.Termini.Dan }
     * 
     */
    public SpisakTermina.Termini.Dan createSpisakTerminaTerminiDan() {
        return new SpisakTermina.Termini.Dan();
    }

}
