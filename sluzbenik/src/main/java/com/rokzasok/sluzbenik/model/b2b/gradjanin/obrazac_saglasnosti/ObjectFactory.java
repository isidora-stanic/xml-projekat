
package com.rokzasok.sluzbenik.model.b2b.gradjanin.obrazac_saglasnosti;

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

    public KolekcijaObrazacaSaglasnosti createKolekcijaObrazacaSaglasnosti() {
        return new KolekcijaObrazacaSaglasnosti();
    }

    
    public ObrazacSaglasnosti createObrazacSaglasnosti() {
        return new ObrazacSaglasnosti();
    }

    
    public TDoza createTDoza() {
        return new TDoza();
    }

    
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    
    public TDrzavljanstvo createTDrzavljanstvo() {
        return new TDrzavljanstvo();
    }

    
    public ObrazacSaglasnosti.DokumentInfo createObrazacSaglasnostiDokumentInfo() {
        return new ObrazacSaglasnosti.DokumentInfo();
    }

    
    public ObrazacSaglasnosti.DokumentInfo.Saglasnost createObrazacSaglasnostiDokumentInfoSaglasnost() {
        return new ObrazacSaglasnosti.DokumentInfo.Saglasnost();
    }

    
    public ObrazacSaglasnosti.EvidencijaVakcinacija createObrazacSaglasnostiEvidencijaVakcinacija() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija();
    }

    
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela createObrazacSaglasnostiEvidencijaVakcinacijaTabela() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela();
    }

    
    public ObrazacSaglasnosti.EvidencijaPacijent createObrazacSaglasnostiEvidencijaPacijent() {
        return new ObrazacSaglasnosti.EvidencijaPacijent();
    }

    
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent createObrazacSaglasnostiEvidencijaPacijentPacijent() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent();
    }

    
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita createObrazacSaglasnostiEvidencijaPacijentPacijentSocijalnaZastita() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita();
    }

    
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt createObrazacSaglasnostiEvidencijaPacijentPacijentKontakt() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt();
    }

    
    public TAdresa createTAdresa() {
        return new TAdresa();
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

    
    public TOsoba.Pol createTOsobaPol() {
        return new TOsoba.Pol();
    }

    
    public TOsoba.DatumRodjenja createTOsobaDatumRodjenja() {
        return new TOsoba.DatumRodjenja();
    }

    
    public TDrzavljanstvo.Strano createTDrzavljanstvoStrano() {
        return new TDrzavljanstvo.Strano();
    }

    
    public TDrzavljanstvo.Srpsko createTDrzavljanstvoSrpsko() {
        return new TDrzavljanstvo.Srpsko();
    }

    
    public ObrazacSaglasnosti.DokumentInfo.IdPodnosioca createObrazacSaglasnostiDokumentInfoIdPodnosioca() {
        return new ObrazacSaglasnosti.DokumentInfo.IdPodnosioca();
    }

    
    public ObrazacSaglasnosti.DokumentInfo.Saglasnost.Izjava createObrazacSaglasnostiDokumentInfoSaglasnostIzjava() {
        return new ObrazacSaglasnosti.DokumentInfo.Saglasnost.Izjava();
    }

    
    public ObrazacSaglasnosti.DokumentInfo.Saglasnost.NazivLeka createObrazacSaglasnostiDokumentInfoSaglasnostNazivLeka() {
        return new ObrazacSaglasnosti.DokumentInfo.Saglasnost.NazivLeka();
    }

    
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Ustanova createObrazacSaglasnostiEvidencijaVakcinacijaUstanova() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Ustanova();
    }

    
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Lekar createObrazacSaglasnostiEvidencijaVakcinacijaLekar() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Lekar();
    }

    
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.Doza createObrazacSaglasnostiEvidencijaVakcinacijaTabelaDoza() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.Doza();
    }

    
    public ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.PrivremeneKontraindikacije createObrazacSaglasnostiEvidencijaVakcinacijaTabelaPrivremeneKontraindikacije() {
        return new ObrazacSaglasnosti.EvidencijaVakcinacija.Tabela.PrivremeneKontraindikacije();
    }

    
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita.Sediste createObrazacSaglasnostiEvidencijaPacijentPacijentSocijalnaZastitaSediste() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.SocijalnaZastita.Sediste();
    }

    
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.TelFiksni createObrazacSaglasnostiEvidencijaPacijentPacijentKontaktTelFiksni() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.TelFiksni();
    }

    
    public ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.Email createObrazacSaglasnostiEvidencijaPacijentPacijentKontaktEmail() {
        return new ObrazacSaglasnosti.EvidencijaPacijent.Pacijent.Kontakt.Email();
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
