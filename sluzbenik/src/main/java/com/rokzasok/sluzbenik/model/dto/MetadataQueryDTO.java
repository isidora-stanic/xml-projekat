package com.rokzasok.sluzbenik.model.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class MetadataQueryDTO {
    private Map<String, String> metadataMap = new HashMap<String, String>();

    public Map<String, String> getAddressMap() {
        return metadataMap;
    }

    public void setAddressMap(Map<String, String> metadataMap) {
        this.metadataMap = metadataMap;
    }
}
