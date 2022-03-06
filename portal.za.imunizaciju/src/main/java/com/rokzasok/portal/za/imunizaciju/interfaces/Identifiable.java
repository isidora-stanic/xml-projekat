package com.rokzasok.portal.za.imunizaciju.interfaces;

import javax.xml.datatype.XMLGregorianCalendar;

public interface Identifiable {

    Long getDokumentId();

    void setDokumentId(Long id);

    XMLGregorianCalendar getDatumKreiranja();

    String getTipDokumenta();
}
