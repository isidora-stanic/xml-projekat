package com.rokzasok.portal.za.imunizaciju.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid XML DB Exception - JAXB Saving to DB")
public class InvalidXmlDatabaseException extends RuntimeException {

    private Class classObject;
    private String text;

    public InvalidXmlDatabaseException() {
    }

    public InvalidXmlDatabaseException(Class classObject, String text) {
        this.classObject = classObject;
        this.text = text;
    }

    public Class getClassObject() {
        return classObject;
    }

    public void setClassObject(Class classObject) {
        this.classObject = classObject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
