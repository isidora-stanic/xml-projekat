package com.rokzasok.sluzbenik.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Xml DB Exception - Bad Properties")
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
