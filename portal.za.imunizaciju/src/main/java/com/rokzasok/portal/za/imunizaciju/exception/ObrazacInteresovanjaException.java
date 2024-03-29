package com.rokzasok.portal.za.imunizaciju.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ObrazacInteresovanjaException extends RuntimeException {

    private String text;

    public ObrazacInteresovanjaException() {
    }

    public ObrazacInteresovanjaException(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}