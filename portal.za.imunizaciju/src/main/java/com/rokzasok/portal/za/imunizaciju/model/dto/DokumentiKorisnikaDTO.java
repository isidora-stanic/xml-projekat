package com.rokzasok.portal.za.imunizaciju.model.dto;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"listaDokumenata", "idKorisnika"})
@XmlRootElement(name = "DokumentiKorisnika")
public class DokumentiKorisnikaDTO {
    @XmlElement(name = "listaDokumenata", required = true)
    private List<DokumentDTO> listaDokumenata;

    @XmlElement(name = "idKorisnika")
    private Long idKorisnika;

    public DokumentiKorisnikaDTO() {
    }

    public List<DokumentDTO> getListaDokumenata() {
        return listaDokumenata;
    }

    public void setListaDokumenata(List<DokumentDTO> listaDokumenata) {
        this.listaDokumenata = listaDokumenata;
    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "dokument", propOrder = {"documentURI", "tipDokumenta", "datumKreiranja"})
    public static class DokumentDTO {
        @XmlElement(name="documentURI")
        private String documentURI;

        @XmlElement(name="tipDokumenta")
        private String tipDokumenta;

        @XmlElement(name="datumKreiranja")
        private XMLGregorianCalendar datumKreiranja;

        public DokumentDTO() {
        }

        public DokumentDTO(String documentURI, String tipDokumenta, XMLGregorianCalendar datumKreiranja) {
            this.documentURI = documentURI;
            this.tipDokumenta = tipDokumenta;
            this.datumKreiranja = datumKreiranja;
        }

        public String getDocumentURI() {
            return documentURI;
        }

        public void setDocumentURI(String documentURI) {
            this.documentURI = documentURI;
        }

        public String getTipDokumenta() {
            return tipDokumenta;
        }

        public void setTipDokumenta(String tipDokumenta) {
            this.tipDokumenta = tipDokumenta;
        }

        public XMLGregorianCalendar getDatumKreiranja() {
            return datumKreiranja;
        }

        public void setDatumKreiranja(XMLGregorianCalendar datumKreiranja) {
            this.datumKreiranja = datumKreiranja;
        }
    }
}

/*
<DokumentiKorisnika>
    <ListaDokumenata>
        <dokument>
 */