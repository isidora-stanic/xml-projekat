package com.rokzasok.sluzbenik.soap.dostupne_doze;

import com.rokzasok.sluzbenik.soap.dostupne_doze.model.ProveriDostupnostVakcineRequest;
import com.rokzasok.sluzbenik.soap.dostupne_doze.model.ProveriDostupnostVakcineResponse;
import com.rokzasok.sluzbenik.soap.dostupne_doze.model.UkloniJednuDozuVakcineRequest;
import com.rokzasok.sluzbenik.soap.dostupne_doze.model.UkloniJednuDozuVakcineResponse;
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "proveriDostupnostVakcineRequest")
    @ResponsePayload
    public ProveriDostupnostVakcineResponse proveriDostpunost(@RequestPayload ProveriDostupnostVakcineRequest request) {
        ProveriDostupnostVakcineResponse response = new ProveriDostupnostVakcineResponse();
        response.setUspesnost(dostupneDozeSoapRepository.proveriDostupnost(request));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ukloniJednuDozuVakcineRequest")
    @ResponsePayload
    public UkloniJednuDozuVakcineResponse ukloniJednuDozu(@RequestPayload UkloniJednuDozuVakcineRequest request) {
        UkloniJednuDozuVakcineResponse response = new UkloniJednuDozuVakcineResponse();
        response.setUspesnost(dostupneDozeSoapRepository.smanjiBrojDoza(request));
        return response;
    }

}
