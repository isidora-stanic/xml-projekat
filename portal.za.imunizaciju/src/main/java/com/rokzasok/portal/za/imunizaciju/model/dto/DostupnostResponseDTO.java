package com.rokzasok.portal.za.imunizaciju.model.dto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"dostupnost"})
@XmlRootElement(name = "DozeResponse")
public class DostupnostResponseDTO {
    @XmlElement(name = "dostupnost", required = true)
    private Boolean dostupnost;

    public Boolean getDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(Boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    public DostupnostResponseDTO(Boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    public DostupnostResponseDTO() {
    }
}
