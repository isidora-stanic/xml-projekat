
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "T_proizvodjac_vakcine", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
@XmlEnum
public enum TProizvodjacVakcine {

    @XmlEnumValue("BioNTech Manufacturing GMBH")
    BIO_N_TECH_MANUFACTURING_GMBH("BioNTech Manufacturing GMBH"),
    @XmlEnumValue("Sinopharm")
    SINOPHARM("Sinopharm"),
    @XmlEnumValue("Gamaleya Institute")
    GAMALEYA_INSTITUTE("Gamaleya Institute"),
    @XmlEnumValue("Oxford")
    OXFORD("Oxford");
    private final String value;

    TProizvodjacVakcine(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TProizvodjacVakcine fromValue(String v) {
        for (TProizvodjacVakcine c: TProizvodjacVakcine.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
