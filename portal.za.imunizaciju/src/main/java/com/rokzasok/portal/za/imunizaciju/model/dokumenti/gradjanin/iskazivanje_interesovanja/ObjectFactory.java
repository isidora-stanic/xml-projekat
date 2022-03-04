
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja }
     * 
     */
    public ObrazacInteresovanja createObrazacInteresovanja() {
        return new ObrazacInteresovanja();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.OpstiPodaci }
     * 
     */
    public ObrazacInteresovanja.OpstiPodaci createObrazacInteresovanjaOpstiPodaci() {
        return new ObrazacInteresovanja.OpstiPodaci();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.PodaciOOsobi }
     * 
     */
    public ObrazacInteresovanja.PodaciOOsobi createObrazacInteresovanjaPodaciOOsobi() {
        return new ObrazacInteresovanja.PodaciOOsobi();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.OpstiPodaci.LokacijaOpstina }
     * 
     */
    public ObrazacInteresovanja.OpstiPodaci.LokacijaOpstina createObrazacInteresovanjaOpstiPodaciLokacijaOpstina() {
        return new ObrazacInteresovanja.OpstiPodaci.LokacijaOpstina();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.OpstiPodaci.TipVakcine }
     * 
     */
    public ObrazacInteresovanja.OpstiPodaci.TipVakcine createObrazacInteresovanjaOpstiPodaciTipVakcine() {
        return new ObrazacInteresovanja.OpstiPodaci.TipVakcine();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.OpstiPodaci.DavalacKrvi }
     * 
     */
    public ObrazacInteresovanja.OpstiPodaci.DavalacKrvi createObrazacInteresovanjaOpstiPodaciDavalacKrvi() {
        return new ObrazacInteresovanja.OpstiPodaci.DavalacKrvi();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.OpstiPodaci.DatumPodnosenja }
     * 
     */
    public ObrazacInteresovanja.OpstiPodaci.DatumPodnosenja createObrazacInteresovanjaOpstiPodaciDatumPodnosenja() {
        return new ObrazacInteresovanja.OpstiPodaci.DatumPodnosenja();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.OpstiPodaci.IdPodnosioca }
     * 
     */
    public ObrazacInteresovanja.OpstiPodaci.IdPodnosioca createObrazacInteresovanjaOpstiPodaciIdPodnosioca() {
        return new ObrazacInteresovanja.OpstiPodaci.IdPodnosioca();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.PodaciOOsobi.Drzavljanstvo }
     * 
     */
    public ObrazacInteresovanja.PodaciOOsobi.Drzavljanstvo createObrazacInteresovanjaPodaciOOsobiDrzavljanstvo() {
        return new ObrazacInteresovanja.PodaciOOsobi.Drzavljanstvo();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.PodaciOOsobi.Email }
     * 
     */
    public ObrazacInteresovanja.PodaciOOsobi.Email createObrazacInteresovanjaPodaciOOsobiEmail() {
        return new ObrazacInteresovanja.PodaciOOsobi.Email();
    }

    /**
     * Create an instance of {@link ObrazacInteresovanja.PodaciOOsobi.BrojFiksnogTelefona }
     * 
     */
    public ObrazacInteresovanja.PodaciOOsobi.BrojFiksnogTelefona createObrazacInteresovanjaPodaciOOsobiBrojFiksnogTelefona() {
        return new ObrazacInteresovanja.PodaciOOsobi.BrojFiksnogTelefona();
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
