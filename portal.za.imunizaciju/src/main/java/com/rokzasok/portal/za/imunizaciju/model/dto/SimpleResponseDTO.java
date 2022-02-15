package com.rokzasok.portal.za.imunizaciju.model.dto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"response"})
@XmlRootElement(name="SimpleResponseDTO")
public class SimpleResponseDTO<T> {

    public SimpleResponseDTO() {
    }

    public SimpleResponseDTO(T response) {
        this.response = response;
    }

    @XmlAnyElement()
    private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
