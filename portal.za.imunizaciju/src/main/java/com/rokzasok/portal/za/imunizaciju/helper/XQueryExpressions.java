package com.rokzasok.portal.za.imunizaciju.helper;

public class XQueryExpressions {


    //XQUERY I XUPDATE ZA IZVESTAJ

    public static final String X_QUERY_FIND_ALL_IZVESTAJI_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja\";\n" +
            "for $x in collection(\"/db/sample/iskazivanje-interesovanja\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_IZVESTAJ_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/iskazivanje-interesovanja', '%s')";

    public static final String X_QUERY_FIND_ALL_POTVRDE_O_VAKCINACIJI_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije\";\n" +
            "for $x in collection(\"/db/sample/potvrda-vakcinacije\")\n" +
            "return $x";


    public static final String X_UPDATE_REMOVE_POTVRDA_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/potvrda-vakcinacije', '%s')";


    public static final String X_QUERY_FIND_ALL_OBRAZAC_SAGLASNOSTI_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti\";\n" +
            "for $x in collection(\"/db/sample/obrazac_saglasnosti\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_OBRAZAC_SAGLASNOSTI_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/obrazac_saglasnosti', '%s')";


    public static final String X_QUERY_FIND_ALL_ZAHTEV_ZA_SERTIFIKAT_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://www.rokzasok.rs/gradjanin/zahtev-za-sertifikat\";\n" +
            "for $x in collection(\"/db/sample/zahtev_za_sertifikat\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_ZAHTEV_ZA_SERTIFIKAT_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/zahtev_za_sertifikat', '%s')";

}
