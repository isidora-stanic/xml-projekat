package com.rokzasok.portal.za.imunizaciju.exist;

public class XmlDatabaseException extends RuntimeException {

    private String text;

    public XmlDatabaseException() {
    }

    public XmlDatabaseException(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
