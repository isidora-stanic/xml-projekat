
package com.rokzasok.sluzbenik.model.b2b.gradjanin.iskazivanje_interesovanja;

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

    
    public ObrazacInteresovanja createObrazacInteresovanja() {
        return new ObrazacInteresovanja();
    }

    
    public ObrazacInteresovanja.OpstiPodaci createObrazacInteresovanjaOpstiPodaci() {
        return new ObrazacInteresovanja.OpstiPodaci();
    }

    
    public ObrazacInteresovanja.PodaciOOsobi createObrazacInteresovanjaPodaciOOsobi() {
        return new ObrazacInteresovanja.PodaciOOsobi();
    }

    
    public ObrazacInteresovanja.OpstiPodaci.LokacijaOpstina createObrazacInteresovanjaOpstiPodaciLokacijaOpstina() {
        return new ObrazacInteresovanja.OpstiPodaci.LokacijaOpstina();
    }

    
    public ObrazacInteresovanja.OpstiPodaci.TipVakcine createObrazacInteresovanjaOpstiPodaciTipVakcine() {
        return new ObrazacInteresovanja.OpstiPodaci.TipVakcine();
    }

    
    public ObrazacInteresovanja.OpstiPodaci.DavalacKrvi createObrazacInteresovanjaOpstiPodaciDavalacKrvi() {
        return new ObrazacInteresovanja.OpstiPodaci.DavalacKrvi();
    }

    
    public ObrazacInteresovanja.OpstiPodaci.DatumPodnosenja createObrazacInteresovanjaOpstiPodaciDatumPodnosenja() {
        return new ObrazacInteresovanja.OpstiPodaci.DatumPodnosenja();
    }

    
    public ObrazacInteresovanja.OpstiPodaci.IdPodnosioca createObrazacInteresovanjaOpstiPodaciIdPodnosioca() {
        return new ObrazacInteresovanja.OpstiPodaci.IdPodnosioca();
    }

    
    public ObrazacInteresovanja.PodaciOOsobi.Drzavljanstvo createObrazacInteresovanjaPodaciOOsobiDrzavljanstvo() {
        return new ObrazacInteresovanja.PodaciOOsobi.Drzavljanstvo();
    }

    
    public ObrazacInteresovanja.PodaciOOsobi.Email createObrazacInteresovanjaPodaciOOsobiEmail() {
        return new ObrazacInteresovanja.PodaciOOsobi.Email();
    }

    
    public ObrazacInteresovanja.PodaciOOsobi.BrojFiksnogTelefona createObrazacInteresovanjaPodaciOOsobiBrojFiksnogTelefona() {
        return new ObrazacInteresovanja.PodaciOOsobi.BrojFiksnogTelefona();
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
