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
}
