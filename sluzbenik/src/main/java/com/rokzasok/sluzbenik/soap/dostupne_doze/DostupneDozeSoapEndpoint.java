package com.rokzasok.sluzbenik.soap.dostupne_doze;

import com.rokzasok.sluzbenik.soap.dostupne_doze.model.DozeRequest;
import com.rokzasok.sluzbenik.soap.dostupne_doze.model.DozeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DostupneDozeSoapEndpoint {
    private static final String NAMESPACE_URI = "http://www.rokzasok.rs/soap/dostupne_doze";

    @Autowired
    private DostupneDozeSoapRepository dostupneDozeSoapRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "proveri-dostupnost")
    @ResponsePayload
    public DozeResponse proveriDostpunost(@RequestPayload DozeRequest request) {
        DozeResponse response = new DozeResponse();
        response.setUspesnost(dostupneDozeSoapRepository.proveriDostupnost(request));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ukloni-jednu-dozu")
    @ResponsePayload
    public DozeResponse ukloniJednuDozu(@RequestPayload DozeRequest request) {
        DozeResponse response = new DozeResponse();
        response.setUspesnost(dostupneDozeSoapRepository.smanjiBrojDoza(request));
        return response;
    }

}
