package com.rokzasok.sluzbenik.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid Xml Exception - JAXB Unmarshaling")
public class InvalidXmlException extends RuntimeException {

    private Class classObject;
    private String text;

    public InvalidXmlException() {
    }

    public InvalidXmlException(Class classObject, String text) {
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
