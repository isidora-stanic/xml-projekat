package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "T_pol", namespace = "http://www.rokzasok.rs/tipovi")
@XmlEnum
public enum TPol {

    M, Z;

    public String value() {
        return name();
    }

    public static TPol fromValue(String v) {
        return valueOf(v);
    }

}
