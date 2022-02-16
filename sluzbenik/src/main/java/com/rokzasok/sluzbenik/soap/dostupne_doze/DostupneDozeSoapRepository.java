package com.rokzasok.sluzbenik.soap.dostupne_doze;

import com.rokzasok.sluzbenik.model.ostalo.dostupne_doze.DostupneDoze;
import com.rokzasok.sluzbenik.service.DostupneDozeService;
import com.rokzasok.sluzbenik.soap.dostupne_doze.model.DozeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class DostupneDozeSoapRepository {

    @Autowired
    private DostupneDozeService dostupneDozeService;

    public boolean proveriDostupnost(DozeRequest request) {
        DostupneDoze.BrojDoza dostupnostDoza = dostupneDozeService.findByTipVakcine(request.getTipVakcine().value());

        return dostupnostDoza != null && (dostupnostDoza.getValue().compareTo(BigInteger.ZERO) != 0);

    }

    public boolean smanjiBrojDoza(DozeRequest request) {
        if (proveriDostupnost(request)) {
            try {
                dostupneDozeService.removeDoze(request.getTipVakcine().value(), BigInteger.ONE);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }
}
