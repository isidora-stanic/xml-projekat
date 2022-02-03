
package com.rokzasok.portal.za.imunizaciju.dokumenti.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the www.rokzasok.rs.euprava.gradjanin.obrazac_saglasnosti package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: www.rokzasok.rs.euprava.gradjanin.obrazac_saglasnosti
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti }
     * 
     */
    public ObrazacSaglasnosti createObrazacSaglasnosti() {
        return new ObrazacSaglasnosti();
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
     * Create an instance of {@link TDrzavljanstvo }
     * 
     */
    public TDrzavljanstvo createTDrzavljanstvo() {
        return new TDrzavljanstvo();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaVakcinacija }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaVakcinacija createObrazacSaglasnostiEvidencijaVakcinacija() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela createObrazacSaglasnostiEvidencijaVakcinacijaTabela() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaPacijent }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaPacijent createObrazacSaglasnostiEvidencijaPacijent() {
        return new ObrazacSaglasnosti.EvidencijaPacijent();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaPacijent.Pacijent }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent createObrazacSaglasnostiEvidencijaPacijentPacijent() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita createObrazacSaglasnostiEvidencijaPacijentPacijentSocijalnaZastita() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt createObrazacSaglasnostiEvidencijaPacijentPacijentKontakt() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.DokumentInfo }
     * 
     */
    public ObrazacSaglasnosti.DokumentInfo createObrazacSaglasnostiDokumentInfo() {
        return new ObrazacSaglasnosti.DokumentInfo();
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
     * Create an instance of {@link TDrzavljanstvo.Strano }
     * 
     */
    public TDrzavljanstvo.Strano createTDrzavljanstvoStrano() {
        return new TDrzavljanstvo.Strano();
    }

    /**
     * Create an instance of {@link TDrzavljanstvo.Srpsko }
     * 
     */
    public TDrzavljanstvo.Srpsko createTDrzavljanstvoSrpsko() {
        return new TDrzavljanstvo.Srpsko();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaVakcinacija.Ustanova }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Ustanova createObrazacSaglasnostiEvidencijaVakcinacijaUstanova() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Ustanova();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaVakcinacija.Lekar }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Lekar createObrazacSaglasnostiEvidencijaVakcinacijaLekar() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Lekar();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.Doza }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.Doza createObrazacSaglasnostiEvidencijaVakcinacijaTabelaDoza() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.Doza();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.PrivremeneKontraindikacije }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.PrivremeneKontraindikacije createObrazacSaglasnostiEvidencijaVakcinacijaTabelaPrivremeneKontraindikacije() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.PrivremeneKontraindikacije();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaPacijent.Saglasnost }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaPacijent.Saglasnost createObrazacSaglasnostiEvidencijaPacijentSaglasnost() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Saglasnost();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita.Sediste }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita.Sediste createObrazacSaglasnostiEvidencijaPacijentPacijentSocijalnaZastitaSediste() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita.Sediste();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.TelFiksni }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.TelFiksni createObrazacSaglasnostiEvidencijaPacijentPacijentKontaktTelFiksni() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.TelFiksni();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.Email }
     * 
     */
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.Email createObrazacSaglasnostiEvidencijaPacijentPacijentKontaktEmail() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.Email();
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
