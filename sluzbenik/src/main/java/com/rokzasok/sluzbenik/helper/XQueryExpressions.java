package com.rokzasok.sluzbenik.helper;

public class XQueryExpressions {


    //XQUERY I XUPDATE ZA ZAHTEV

    public static final String X_QUERY_FIND_ALL_ZAHTEVI_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://ftn.uns.ac.rs/tim5/model/zahtev\";\n" +
            "for $x in collection(\"/db/sample/zahtev\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_ZAHTEV_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/zahtev', '%s')";

    public static final String SEARCH_ZAHTEVI = "xquery version \"3.1\";\n"
            + "declare default element namespace \"http://ftn.uns.ac.rs/tim5/model/zahtev\";\n"
            + "for $x in collection(\"/db/sample/zahtev\")\n"
            + "where $x//*/text()[contains(lower-case(.) ,\"%s\")]\n" + "return $x";


    //XQUERY I XUPDATE ZA OBAVESTENJE

    public static final String X_QUERY_FIND_ALL_OBAVESTENJA_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://ftn.uns.ac.rs/tim5/model/obavestenje\";\n" +
            "for $x in collection(\"/db/sample/obavestenje\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_OBAVESTENJE_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/obavestenje', '%s')";

    public static final String X_QUERY_FIND_OBAVESTENJE_BY_ID_ZAHTEVA_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://ftn.uns.ac.rs/tim5/model/obavestenje\";\n" +
            "for $x in collection(\"/db/sample/obavestenje\")/Obavestenje[@id_zahteva=%d]\n" +
            "return $x";


    //XQUERY I XUPDATE ZA RESENJE

    public static final String X_QUERY_FIND_ALL_RESENJA_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://ftn.uns.ac.rs/tim5/model/resenje\";\n" +
            "for $x in collection(\"/db/sample/resenja\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_RESENJE_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/resenja', '%s')";

    public static final String X_QUERY_FIND_RESENJE_BY_ID_ZALBE_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://ftn.uns.ac.rs/tim5/model/resenje\";\n" +
            "for $x in collection(\"/db/sample/resenja\")/Resenje[@id_zalbe=%d]\n" +
            "return $x";

    public static final String SEARCH_RESENJE= "xquery version \"3.1\";\n"
            + "declare default element namespace \"http://ftn.uns.ac.rs/tim5/model/resenje\";\n"
            + "for $x in collection(\"/db/sample/resenja\")\n"
            + "where $x//*/text()[contains(lower-case(.) ,\"%s\")]\n" + "return $x";


    //XQUERY I XUPDATE ZA IZVESTAJ

    public static final String X_QUERY_FIND_ALL_IZVESTAJI_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji\";\n" +
            "for $x in collection(\"/db/sample/izvestaj-o-imunizaciji\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_IZVESTAJ_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/izvestaj-o-imunizaciji', '%s')";



    public static final String X_QUERY_FIND_ALL_DIGITALNI_SERTIFIKAT_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat\";\n" +
            "for $x in collection(\"/db/sample/digitalni_sertifikat\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_DIGITALNI_SERTIFIKAT_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/digitalni_sertifikat', '%s')";

    public static final String SEARCH_IZVESTAJI = "xquery version \"3.1\";\n"
            + "declare default element namespace \"http://www.rokzasok.rs/sluzbenik/izvestaj-o-imunizaciji\";\n"
            + "for $x in collection(\"/db/sample/izvestaj-o-imunizaciji\")\n"
            + "where $x//*/text()[contains(lower-case(.) ,\"%s\")]\n" + "return $x";


    // XQUERY I XUPDATE ZA DOSTUPNE DOZE

    public static final String X_QUERY_FIND_ALL_DOSTUPNE_DOZE_EXPRESSION = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://www.rokzasok.rs/dostupne-doze-vakcina\";\n" +
            "for $x in collection(\"/db/sample/dostupne-doze\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_DOSTUPNE_DOZE_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/dostupne-doze', '%s')";

    public static final String X_QUERY_FIND_ALL_SPISAK_KORISNIKA = "xquery version \"3.1\";\n" +
            "declare default element namespace \"http://www.rokzasok.rs/korisnici\";\n" +
            "for $x in collection(\"/db/sample/korisnici\")\n" +
            "return $x";

    public static final String X_UPDATE_REMOVE_SPISAK_KORISNIKA_BY_ID_EXPRESSION =
            "xquery version \"3.1\";\n" +
                    "xmldb:remove('/db/sample/korisnici', '%s')";
}
