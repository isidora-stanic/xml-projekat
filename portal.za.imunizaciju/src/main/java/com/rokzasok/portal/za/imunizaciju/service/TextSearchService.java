package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.obrazac_saglasnosti.ObrazacSaglasnosti;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.zahtev_za_sertifikat.Zahtev;
import com.rokzasok.portal.za.imunizaciju.model.dokumenti.potvrda_vakcinacije.PotvrdaVakcinacije;
import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiIzPretrageDTO;
import com.rokzasok.portal.za.imunizaciju.model.dto.DokumentiKorisnikaDTO;
import com.rokzasok.portal.za.imunizaciju.model.dto.MetadataQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class TextSearchService {

    @Autowired
    private IskazivanjeInteresovanjaService iskazivanjeInteresovanjaService;
    @Autowired
    private ObrazacSaglasnostiService obrazacSaglasnostiService;
    @Autowired
    private PotvrdaVakcinacijeService potvrdaVakcinacijeService;
    @Autowired
    private ZahtevZaSertifikatService zahtevZaSertifikatService;

    public DokumentiIzPretrageDTO searchAll(String searchQuery) throws XPathExpressionException, JAXBException, ParserConfigurationException {
        List<Identifiable> interesovanja = searchAllIskazivanjeInteresovanja(searchQuery);
        List<Identifiable> saglasnosti = searchAllObrazacSaglasnosti(searchQuery);
        List<Identifiable> potvrde = searchAllPotvrdaVakcinacije(searchQuery);
        List<Identifiable> zahtevi = searchAllZahtevZaSertifikat(searchQuery);

        DokumentiIzPretrageDTO dokumentiDTO = new DokumentiIzPretrageDTO();
        dokumentiDTO.setListaDokumenata(new ArrayList<>());

        convertAndAddToDTO(dokumentiDTO, interesovanja);
        convertAndAddToDTO(dokumentiDTO, saglasnosti);
        convertAndAddToDTO(dokumentiDTO, potvrde);
        convertAndAddToDTO(dokumentiDTO, zahtevi);

        return dokumentiDTO;
    }

    public void convertAndAddToDTO(DokumentiIzPretrageDTO dokumentiDTO, List<Identifiable> dokumenti) {
        for (Identifiable dokument : dokumenti) {
            // todo: pravljenje linka(uria) za front???

            String dokumentURI = dokument.getTipDokumenta().toLowerCase().replaceAll(" ", "-").replaceAll("š", "s") + "/" + dokument.getDokumentId();
            dokumentiDTO.getListaDokumenata().add(new DokumentiKorisnikaDTO.DokumentDTO(dokumentURI, dokument.getTipDokumenta(), dokument.getDatumKreiranja()));
        }
    }

    public List<Identifiable> searchAllIskazivanjeInteresovanja(String searchQuery) {
        List<ObrazacInteresovanja> isteresovanja = iskazivanjeInteresovanjaService.findAll();
        List<Identifiable> rezultati = new ArrayList<>();
        for (ObrazacInteresovanja interesovanje : isteresovanja) {
            Document doc = iskazivanjeInteresovanjaService.getDocument(interesovanje.getDokumentId());
            boolean pronadjeno = searchOne(searchQuery, doc);
            if (pronadjeno) {
                rezultati.add(interesovanje);
            }
        }
        return rezultati;
    }

    public List<Identifiable> searchAllObrazacSaglasnosti(String searchQuery) {
        List<ObrazacSaglasnosti> isteresovanja = obrazacSaglasnostiService.findAll();
        List<Identifiable> rezultati = new ArrayList<>();
        for (ObrazacSaglasnosti interesovanje : isteresovanja) {
            Document doc = obrazacSaglasnostiService.getDocument(interesovanje.getDokumentId());
            boolean pronadjeno = searchOne(searchQuery, doc);
            if (pronadjeno) {
                rezultati.add(interesovanje);
            }
        }
        return rezultati;
    }

    public List<Identifiable> searchAllPotvrdaVakcinacije(String searchQuery) {
        List<PotvrdaVakcinacije> isteresovanja = potvrdaVakcinacijeService.findAll();
        List<Identifiable> rezultati = new ArrayList<>();
        for (PotvrdaVakcinacije interesovanje : isteresovanja) {
            Document doc = potvrdaVakcinacijeService.getDocument(interesovanje.getDokumentId());
            boolean pronadjeno = searchOne(searchQuery, doc);
            if (pronadjeno) {
                rezultati.add(interesovanje);
            }
        }
        return rezultati;
    }

    public List<Identifiable> searchAllZahtevZaSertifikat(String searchQuery) {
        List<Zahtev> isteresovanja = zahtevZaSertifikatService.findAll();
        List<Identifiable> rezultati = new ArrayList<>();
        for (Zahtev interesovanje : isteresovanja) {
            Document doc = zahtevZaSertifikatService.getDocument(interesovanje.getDokumentId());
            boolean pronadjeno = searchOne(searchQuery, doc);
            if (pronadjeno) {
                rezultati.add(interesovanje);
            }
        }
        return rezultati;
    }

    public boolean searchOne(String searchQuery, Document doc) {
        XPath xPath = XPathFactory.newInstance().newXPath();

        String formattedQuery = String.format("\"%s\"", searchQuery);
        String expression = "//text()[\n" +
                "  contains(\n" +
                "    translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),\n" +
                "    " + formattedQuery.toLowerCase() + "\n" +
                "  )\n" +
                "]";
        System.out.println(expression);
        NodeList list = null;
        try {
            list = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        if (list == null) {
            return false;
        }

        for (int i = 0; i < list.getLength(); i++)  // print list of results...
            System.out.println(list.item(i).getTextContent());

        return list.getLength() > 0;
    }

    //todo implementiraj u novom servisu
    public List<Identifiable> searchMetadata(MetadataQueryDTO metadata) {
        return null;
    }
}
