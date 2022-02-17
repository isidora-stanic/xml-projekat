package com.rokzasok.portal.za.imunizaciju.soap.dostupne_doze;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class DostupneDozeConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.rokzasok.portal.za.imunizaciju.soap.dostupne_doze");
        return marshaller;
    }

    @Bean
    public DostupneDozeClient dostupneDozeClient(Jaxb2Marshaller marshaller) {
        DostupneDozeClient client = new DostupneDozeClient();
        client.setDefaultUri("hhtp://localhost:9090/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
