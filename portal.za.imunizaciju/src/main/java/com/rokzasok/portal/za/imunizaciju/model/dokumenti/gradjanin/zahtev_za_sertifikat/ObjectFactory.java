package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat;

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

    public KolekcijaZahtevaZaSertifikat createKolekcijaZahtevaZaSertifikat() {
        return new KolekcijaZahtevaZaSertifikat();
    }


    public Zahtev createZahtev() {
        return new Zahtev();
    }


    public TOsoba createTOsoba() {
        return new TOsoba();
    }


    public Zahtev.RazlogPodnosenja createZahtevRazlogPodnosenja() {
        return new Zahtev.RazlogPodnosenja();
    }


    public Zahtev.Mesto createZahtevMesto() {
        return new Zahtev.Mesto();
    }


    public Zahtev.Datum createZahtevDatum() {
        return new Zahtev.Datum();
    }


    public Zahtev.Status createZahtevStatus() {
        return new Zahtev.Status();
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
