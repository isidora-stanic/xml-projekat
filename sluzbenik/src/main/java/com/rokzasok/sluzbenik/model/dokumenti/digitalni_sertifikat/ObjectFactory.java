package com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _JMBG_QNAME = new QName("http://www.rokzasok.rs/tipovi", "JMBG");
    private final static QName _Pol_QNAME = new QName("http://www.rokzasok.rs/tipovi", "pol");
    private final static QName _BrojPasosa_QNAME = new QName("http://www.rokzasok.rs/tipovi", "broj_pasosa");


    public ObjectFactory() {
    }


    public DigitalniSertifikat createDigitalniSertifikat() {
        return new DigitalniSertifikat();
    }


    public TDoza createTDoza() {
        return new TDoza();
    }


    public DigitalniSertifikat.InfoOSertifikatu createDigitalniSertifikatInfoOSertifikatu() {
        return new DigitalniSertifikat.InfoOSertifikatu();
    }


    public DigitalniSertifikat.Vakcinacija createDigitalniSertifikatVakcinacija() {
        return new DigitalniSertifikat.Vakcinacija();
    }


    public TOsoba createTOsoba() {
        return new TOsoba();
    }


    public DigitalniSertifikat.Testovi createDigitalniSertifikatTestovi() {
        return new DigitalniSertifikat.Testovi();
    }


    public TTest createTTest() {
        return new TTest();
    }


    public TAdresa createTAdresa() {
        return new TAdresa();
    }


    public TUstanova createTUstanova() {
        return new TUstanova();
    }


    public TDoza.Tip createTDozaTip() {
        return new TDoza.Tip();
    }


    public TDoza.Proizvodjac createTDozaProizvodjac() {
        return new TDoza.Proizvodjac();
    }


    public TDoza.Datum createTDozaDatum() {
        return new TDoza.Datum();
    }


    public TDoza.BrojSerije createTDozaBrojSerije() {
        return new TDoza.BrojSerije();
    }


    public TDoza.BrojDoze createTDozaBrojDoze() {
        return new TDoza.BrojDoze();
    }


    public DigitalniSertifikat.InfoOSertifikatu.Datum createDigitalniSertifikatInfoOSertifikatuDatum() {
        return new DigitalniSertifikat.InfoOSertifikatu.Datum();
    }


    public DigitalniSertifikat.Vakcinacija.Doza createDigitalniSertifikatVakcinacijaDoza() {
        return new DigitalniSertifikat.Vakcinacija.Doza();
    }


    public TOsoba.Pol createTOsobaPol() {
        return new TOsoba.Pol();
    }


    public TOsoba.DatumRodjenja createTOsobaDatumRodjenja() {
        return new TOsoba.DatumRodjenja();
    }


    public TOsoba.BrojPasosa createTOsobaBrojPasosa() {
        return new TOsoba.BrojPasosa();
    }


    public TOsoba.Id createTOsobaId() {
        return new TOsoba.Id();
    }


    @XmlElementDecl(namespace = "http://www.rokzasok.rs/tipovi", name = "JMBG")
    public JAXBElement<String> createJMBG(String value) {
        return new JAXBElement<String>(_JMBG_QNAME, String.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.rokzasok.rs/tipovi", name = "pol")
    public JAXBElement<TPol> createPol(TPol value) {
        return new JAXBElement<TPol>(_Pol_QNAME, TPol.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.rokzasok.rs/tipovi", name = "broj_pasosa")
    public JAXBElement<String> createBrojPasosa(String value) {
        return new JAXBElement<String>(_BrojPasosa_QNAME, String.class, null, value);
    }

}
