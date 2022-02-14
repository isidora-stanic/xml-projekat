
package com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for T_drzavljanstvo.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="T_drzavljanstvo"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Državljanin Republike Srbije"/&gt;
 *     &lt;enumeration value="Strani državljanin sa boravkom u RS"/&gt;
 *     &lt;enumeration value="Strani državljanin bez boravka u RS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "T_drzavljanstvo", namespace = "http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja")
@XmlEnum
public enum TDrzavljanstvo {

    @XmlEnumValue("Dr\u017eavljanin Republike Srbije")
    DRŽAVLJANIN_REPUBLIKE_SRBIJE("Dr\u017eavljanin Republike Srbije"),
    @XmlEnumValue("Strani dr\u017eavljanin sa boravkom u RS")
    STRANI_DRŽAVLJANIN_SA_BORAVKOM_U_RS("Strani dr\u017eavljanin sa boravkom u RS"),
    @XmlEnumValue("Strani dr\u017eavljanin bez boravka u RS")
    STRANI_DRŽAVLJANIN_BEZ_BORAVKA_U_RS("Strani dr\u017eavljanin bez boravka u RS");
    private final String value;

    TDrzavljanstvo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TDrzavljanstvo fromValue(String v) {
        for (TDrzavljanstvo c: TDrzavljanstvo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
