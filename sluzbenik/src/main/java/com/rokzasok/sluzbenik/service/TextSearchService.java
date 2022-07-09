package com.rokzasok.sluzbenik.service;

import com.rokzasok.sluzbenik.interfaces.Identifiable;
import com.rokzasok.sluzbenik.model.dokumenti.digitalni_sertifikat.DigitalniSertifikat;
import com.rokzasok.sluzbenik.model.dto.DokumentiIzPretrageDTO;
import com.rokzasok.sluzbenik.model.dto.DokumentiKorisnikaDTO;
import com.rokzasok.sluzbenik.model.dto.MetadataQueryDTO;
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
    private DigitalniSertifikatService digitalniSertifikatService;

    @Autowired
    private B2BService b2bService;

    public DokumentiIzPretrageDTO searchAll(String searchQuery) {
        List<Identifiable> sertifikati = searchAllDigitalniSertifikat(searchQuery);

        DokumentiIzPretrageDTO dokumentiDTO = new DokumentiIzPretrageDTO();
        dokumentiDTO.setListaDokumenata(new ArrayList<>());

        dokumentiDTO.setQuery(searchQuery);

        convertAndAddToDTO(dokumentiDTO, sertifikati);

        // dodavanje dokumenata sa portala
        DokumentiIzPretrageDTO dokumentiSaPortala = b2bService.pretraziDokumenteSaPortala(searchQuery);
        if (dokumentiSaPortala != null && dokumentiSaPortala.getListaDokumenata() != null && dokumentiSaPortala.getListaDokumenata().size() > 0){
            dokumentiDTO.getListaDokumenata().addAll(dokumentiSaPortala.getListaDokumenata());
        }

        return dokumentiDTO;
    }

    public void convertAndAddToDTO(DokumentiIzPretrageDTO dokumentiDTO, List<Identifiable> dokumenti) {
        for (Identifiable dokument : dokumenti) {
            // todo: trenutno vracamo samo polu-URI (npr: iskazivanje-interesovanja/123456), ispravi?

            String dokumentURI = dokument.getTipDokumenta().toLowerCase().replaceAll(" ", "-").replaceAll("š", "s") + "/" + dokument.getDokumentId();
            dokumentiDTO.getListaDokumenata().add(new DokumentiKorisnikaDTO.DokumentDTO(dokumentURI, dokument.getTipDokumenta(), dokument.getDatumKreiranja()));
        }
    }


    public List<Identifiable> searchAllDigitalniSertifikat(String searchQuery) {
        List<DigitalniSertifikat> sertifikati = digitalniSertifikatService.findAll();
        List<Identifiable> rezultati = new ArrayList<>();
        for (DigitalniSertifikat sertifikat : sertifikati) {
            Document doc = digitalniSertifikatService.getDocument(sertifikat.getDokumentId());
            boolean pronadjeno = searchOne(searchQuery, doc);
            if (pronadjeno) {
                rezultati.add(sertifikat);
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
