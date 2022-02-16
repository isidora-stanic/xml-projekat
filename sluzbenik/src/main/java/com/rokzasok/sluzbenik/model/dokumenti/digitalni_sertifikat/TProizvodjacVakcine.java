
package com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for T_proizvodjac_vakcine.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="T_proizvodjac_vakcine"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BioNTech Manufacturing GMBH"/&gt;
 *     &lt;enumeration value="Sinopharm"/&gt;
 *     &lt;enumeration value="Gamaleya Institute"/&gt;
 *     &lt;enumeration value="Oxford"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "T_proizvodjac_vakcine", namespace = "http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat")
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
