package com.rokzasok.portal.za.imunizaciju.soap.dostupne_doze;

import com.rokzasok.portal.za.imunizaciju.soap.dostupne_doze.model.ProveriDostupnostVakcineRequest;
import com.rokzasok.portal.za.imunizaciju.soap.dostupne_doze.model.ProveriDostupnostVakcineResponse;
import com.rokzasok.portal.za.imunizaciju.soap.dostupne_doze.model.TTipVakcine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class DostupneDozeClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(DostupneDozeClient.class);

    public ProveriDostupnostVakcineResponse proveriDostupnostVakcine(String tipVakcine) {
        ProveriDostupnostVakcineRequest request = new ProveriDostupnostVakcineRequest();
        request.setTipVakcine(TTipVakcine.valueOf(tipVakcine));

        log.info("Provera dostupnosti vakcine tipa: " + tipVakcine);

        ProveriDostupnostVakcineResponse response = (ProveriDostupnostVakcineResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:9090/ws/dostupneDoze", request,
                        new SoapActionCallback("http://www.rokzasok.rs/soap/dostupne_doze/proveriDostupnostVakcineRequest"));

        return response;
    }
}
