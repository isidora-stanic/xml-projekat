
package com.rokzasok.sluzbenik.model.ostalo.dostupne_doze;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for T_tip_vakcine.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="T_tip_vakcine"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Pfizer-BioNtech"/&gt;
 *     &lt;enumeration value="Sputnik V (Gamaleya istraživački centar)"/&gt;
 *     &lt;enumeration value="Sinopharm"/&gt;
 *     &lt;enumeration value="AstraZeneca"/&gt;
 *     &lt;enumeration value="Moderna"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "T_tip_vakcine", namespace = "www.rokzasok.rs/dostupne-doze-vakcina")
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
