package com.rokzasok.portal.za.imunizaciju.model.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"listaDokumenata", "query"})
@XmlRootElement(name = "DokumentiIzPretrage")
public class DokumentiIzPretrageDTO {
    @XmlElement(name = "listaDokumenata", required = true)
    private List<DokumentiKorisnikaDTO.DokumentDTO> listaDokumenata;

    @XmlElement(name = "query")
    private String query;

    public DokumentiIzPretrageDTO() {
    }

    public List<DokumentiKorisnikaDTO.DokumentDTO> getListaDokumenata() {
        return listaDokumenata;
    }

    public void setListaDokumenata(List<DokumentiKorisnikaDTO.DokumentDTO> listaDokumenata) {
        this.listaDokumenata = listaDokumenata;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
