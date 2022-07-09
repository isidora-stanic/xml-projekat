package com.rokzasok.sluzbenik.model.b2b.potvrda_vakcinacije;

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

    public KolekcijaPotvrdaVakcinacije createKolekcijaPotvrdaVakcinacije() {
        return new KolekcijaPotvrdaVakcinacije();
    }


    public PotvrdaVakcinacije createPotvrdaVakcinacije() {
        return new PotvrdaVakcinacije();
    }


    public TOsoba createTOsoba() {
        return new TOsoba();
    }


    public PotvrdaVakcinacije.Doze createPotvrdaVakcinacijeDoze() {
        return new PotvrdaVakcinacije.Doze();
    }


    public PotvrdaVakcinacije.DatumIzdavanja createPotvrdaVakcinacijeDatumIzdavanja() {
        return new PotvrdaVakcinacije.DatumIzdavanja();
    }


    public TDoza createTDoza() {
        return new TDoza();
    }


    public TUstanova createTUstanova() {
        return new TUstanova();
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
