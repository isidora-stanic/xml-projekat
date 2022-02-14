
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije package. 
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

    private final static QName _JMBG_QNAME = new QName("http://www.rokzasok.rs/tipovi", "JMBG");
    private final static QName _Pol_QNAME = new QName("http://www.rokzasok.rs/tipovi", "pol");
    private final static QName _BrojPasosa_QNAME = new QName("http://www.rokzasok.rs/tipovi", "broj_pasosa");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rokzasok.portal.za.imunizaciju.dokumenti.potvrda_vakcinacije
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PotvrdaVakcinacije }
     * 
     */
    public PotvrdaVakcinacije createPotvrdaVakcinacije() {
        return new PotvrdaVakcinacije();
    }

    /**
     * Create an instance of {@link PotvrdaVakcinacije.Doze }
     * 
     */
    public PotvrdaVakcinacije.Doze createPotvrdaVakcinacijeDoze() {
        return new PotvrdaVakcinacije.Doze();
    }

    /**
     * Create an instance of {@link PotvrdaVakcinacije.Osoba }
     * 
     */
    public PotvrdaVakcinacije.Osoba createPotvrdaVakcinacijeOsoba() {
        return new PotvrdaVakcinacije.Osoba();
    }

    /**
     * Create an instance of {@link PotvrdaVakcinacije.RazlogIzdavanja }
     * 
     */
    public PotvrdaVakcinacije.RazlogIzdavanja createPotvrdaVakcinacijeRazlogIzdavanja() {
        return new PotvrdaVakcinacije.RazlogIzdavanja();
    }

    /**
     * Create an instance of {@link PotvrdaVakcinacije.DatumIzdavanja }
     * 
     */
    public PotvrdaVakcinacije.DatumIzdavanja createPotvrdaVakcinacijeDatumIzdavanja() {
        return new PotvrdaVakcinacije.DatumIzdavanja();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TDoza }
     * 
     */
    public TDoza createTDoza() {
        return new TDoza();
    }

    /**
     * Create an instance of {@link TUstanova }
     * 
     */
    public TUstanova createTUstanova() {
        return new TUstanova();
    }

    /**
     * Create an instance of {@link PotvrdaVakcinacije.Doze.Doza }
     * 
     */
    public PotvrdaVakcinacije.Doze.Doza createPotvrdaVakcinacijeDozeDoza() {
        return new PotvrdaVakcinacije.Doze.Doza();
    }

    /**
     * Create an instance of {@link PotvrdaVakcinacije.Osoba.Pol }
     * 
     */
    public PotvrdaVakcinacije.Osoba.Pol createPotvrdaVakcinacijeOsobaPol() {
        return new PotvrdaVakcinacije.Osoba.Pol();
    }

    /**
     * Create an instance of {@link PotvrdaVakcinacije.Osoba.DatumRodjenja }
     * 
     */
    public PotvrdaVakcinacije.Osoba.DatumRodjenja createPotvrdaVakcinacijeOsobaDatumRodjenja() {
        return new PotvrdaVakcinacije.Osoba.DatumRodjenja();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.rokzasok.rs/tipovi", name = "JMBG")
    public JAXBElement<String> createJMBG(String value) {
        return new JAXBElement<String>(_JMBG_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPol }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TPol }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.rokzasok.rs/tipovi", name = "pol")
    public JAXBElement<TPol> createPol(TPol value) {
        return new JAXBElement<TPol>(_Pol_QNAME, TPol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.rokzasok.rs/tipovi", name = "broj_pasosa")
    public JAXBElement<String> createBrojPasosa(String value) {
        return new JAXBElement<String>(_BrojPasosa_QNAME, String.class, null, value);
    }

}
