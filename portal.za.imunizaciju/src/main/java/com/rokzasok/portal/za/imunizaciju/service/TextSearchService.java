package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class TextSearchService {
    private static IskazivanjeInteresovanjaService iskazivanjeInteresovanjaService;

    public static void main() throws JAXBException, ParserConfigurationException, XPathExpressionException {
        // todo trazicemo "BioNtech"
        ObrazacInteresovanja interesovanje = iskazivanjeInteresovanjaService.findById(1L); // TODO STAVI NEKI PRAVI ID

        // podesava parser
        JAXBContext ctx = JAXBContext.newInstance(ObrazacInteresovanja.class); // TODO OVO KORISTI SVUDA, BOLJE NEGO ONAJ STRING STO STALNO MORAMO DA MENJAMO
        Marshaller marshaller = ctx.createMarshaller();

        // konvertuje jaxb u dom
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
        Document doc = domBuilder.newDocument();
        marshaller.marshal(interesovanje, doc);

        // todo postoji i jxpath (apache)
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        NodeList list = (NodeList) xpath.evaluate(
                "//*[contains(translate(//*[text()], 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," +
                        "'abcdefghijklmnopqrstuvwxyz'), " +
                        "translate(\"BioNtech\", 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," +
                        "'abcdefghijklmnopqrstuvwxyz'))]",
                // todo PROVERI DA LI OVO GORE RADI
                //  - translate je umesto lower-case
                //  - jer ne postoji ta fja (bljak)

                // todo "//*[contains(lower-case(title/text(),lower-case(\"BioNtech\"))]",
                // todo "//*[text() = \"BioNtech\"]",
                doc, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++)  // print list of results...
            System.out.println(list.item(i).getTextContent());
    }
}
