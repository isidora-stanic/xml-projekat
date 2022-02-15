package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.model.ostalo.spisak_korisnika.Korisnik;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService implements AbstractXmlService<Korisnik> {

    private final String jaxbContextPath = "com.rokzasok.sluzbenik.model.ostalo.spisak_korisnika";

    @Override
    public List<Korisnik> findAll() {
        return null;
    }

    @Override
    public Korisnik findById(Long entityId) {
        return null;
    }

    @Override
    public Korisnik create(String entityXml) {
        return null;
    }

    @Override
    public Korisnik update(String entityXml) {
        return null;
    }

    @Override
    public boolean deleteById(Long entityId) {
        return false;
    }
}
