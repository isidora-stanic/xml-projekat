
package com.rokzasok.portal.za.imunizaciju.model.b2b.digitalni_sertifikat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rokzasok.sluzbenik.dokumenti.digitalni_sertifikat package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rokzasok.sluzbenik.dokumenti.digitalni_sertifikat
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DigitalniSertifikat }
     * 
     */
    public DigitalniSertifikat createDigitalniSertifikat() {
        return new DigitalniSertifikat();
    }

    /**
     * Create an instance of {@link TDoza }
     * 
     */
    public TDoza createTDoza() {
        return new TDoza();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link DigitalniSertifikat.InfoOSertifikatu }
     * 
     */
    public DigitalniSertifikat.InfoOSertifikatu createDigitalniSertifikatInfoOSertifikatu() {
        return new DigitalniSertifikat.InfoOSertifikatu();
    }

    /**
     * Create an instance of {@link DigitalniSertifikat.Vakcinacija }
     * 
     */
    public DigitalniSertifikat.Vakcinacija createDigitalniSertifikatVakcinacija() {
        return new DigitalniSertifikat.Vakcinacija();
    }

    /**
     * Create an instance of {@link DigitalniSertifikat.Gradjanin }
     * 
     */
    public DigitalniSertifikat.Gradjanin createDigitalniSertifikatGradjanin() {
        return new DigitalniSertifikat.Gradjanin();
    }

    /**
     * Create an instance of {@link DigitalniSertifikat.Testovi }
     * 
     */
    public DigitalniSertifikat.Testovi createDigitalniSertifikatTestovi() {
        return new DigitalniSertifikat.Testovi();
    }

    /**
     * Create an instance of {@link TTest }
     * 
     */
    public TTest createTTest() {
        return new TTest();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
    }

    /**
     * Create an instance of {@link TUstanova }
     * 
     */
    public TUstanova createTUstanova() {
        return new TUstanova();
    }

    /**
     * Create an instance of {@link TDoza.Tip }
     * 
     */
    public TDoza.Tip createTDozaTip() {
        return new TDoza.Tip();
    }

    /**
     * Create an instance of {@link TDoza.Proizvodjac }
     * 
     */
    public TDoza.Proizvodjac createTDozaProizvodjac() {
        return new TDoza.Proizvodjac();
    }

    /**
     * Create an instance of {@link TDoza.Datum }
     * 
     */
    public TDoza.Datum createTDozaDatum() {
        return new TDoza.Datum();
    }

    /**
     * Create an instance of {@link TDoza.BrojSerije }
     * 
     */
    public TDoza.BrojSerije createTDozaBrojSerije() {
        return new TDoza.BrojSerije();
    }

    /**
     * Create an instance of {@link TDoza.BrojDoze }
     * 
     */
    public TDoza.BrojDoze createTDozaBrojDoze() {
        return new TDoza.BrojDoze();
    }

    /**
     * Create an instance of {@link TOsoba.Pol }
     * 
     */
    public TOsoba.Pol createTOsobaPol() {
        return new TOsoba.Pol();
    }

    /**
     * Create an instance of {@link TOsoba.DatumRodjenja }
     * 
     */
    public TOsoba.DatumRodjenja createTOsobaDatumRodjenja() {
        return new TOsoba.DatumRodjenja();
    }

    /**
     * Create an instance of {@link TOsoba.BrojPasosa }
     * 
     */
    public TOsoba.BrojPasosa createTOsobaBrojPasosa() {
        return new TOsoba.BrojPasosa();
    }

    /**
     * Create an instance of {@link DigitalniSertifikat.InfoOSertifikatu.QrLink }
     * 
     */
    public DigitalniSertifikat.InfoOSertifikatu.QrLink createDigitalniSertifikatInfoOSertifikatuQrLink() {
        return new DigitalniSertifikat.InfoOSertifikatu.QrLink();
    }

    /**
     * Create an instance of {@link DigitalniSertifikat.InfoOSertifikatu.Datum }
     * 
     */
    public DigitalniSertifikat.InfoOSertifikatu.Datum createDigitalniSertifikatInfoOSertifikatuDatum() {
        return new DigitalniSertifikat.InfoOSertifikatu.Datum();
    }

    /**
     * Create an instance of {@link DigitalniSertifikat.Vakcinacija.Doza }
     * 
     */
    public DigitalniSertifikat.Vakcinacija.Doza createDigitalniSertifikatVakcinacijaDoza() {
        return new DigitalniSertifikat.Vakcinacija.Doza();
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
