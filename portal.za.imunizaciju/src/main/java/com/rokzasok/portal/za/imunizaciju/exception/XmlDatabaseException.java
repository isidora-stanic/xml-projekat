package com.rokzasok.portal.za.imunizaciju.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
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
