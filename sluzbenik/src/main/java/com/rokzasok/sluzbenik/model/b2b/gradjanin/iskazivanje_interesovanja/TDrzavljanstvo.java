
package com.rokzasok.sluzbenik.model.b2b.gradjanin.iskazivanje_interesovanja;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


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
        for (TDrzavljanstvo c : TDrzavljanstvo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
