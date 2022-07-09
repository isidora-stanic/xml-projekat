
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "T_tip_vakcine", namespace = "http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti")
@XmlEnum
public enum TTipVakcine {

    @XmlEnumValue("Pfizer-BioNtech")
    PFIZER_BIO_NTECH("Pfizer-BioNtech"),
    @XmlEnumValue("Sputnik V (Gamaleya istra\u017eiva\u010dki centar)")
    SPUTNIK_V_GAMALEYA_ISTRAŽIVAČKI_CENTAR("Sputnik V (Gamaleya istra\u017eiva\u010dki centar)"),
    @XmlEnumValue("Sinopharm")
    SINOPHARM("Sinopharm"),
    @XmlEnumValue("AstraZeneca")
    ASTRA_ZENECA("AstraZeneca"),
    @XmlEnumValue("Moderna")
    MODERNA("Moderna");
    private final String value;

    TTipVakcine(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTipVakcine fromValue(String v) {
        for (TTipVakcine c: TTipVakcine.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
