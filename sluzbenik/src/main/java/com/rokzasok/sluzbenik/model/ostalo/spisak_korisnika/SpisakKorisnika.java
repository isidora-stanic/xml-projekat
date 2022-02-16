
package com.rokzasok.sluzbenik.model.ostalo.spisak_korisnika;

import com.rokzasok.sluzbenik.interfaces.Identifiable;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{www.rokzasok.rs/korisnici}korisnik" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "korisnik"
})
@XmlRootElement(name = "spisakKorisnika", namespace = "www.rokzasok.rs/korisnici")
public class SpisakKorisnika implements Identifiable {

    @XmlElement(namespace = "www.rokzasok.rs/korisnici", required = true)
    protected List<Korisnik> korisnik;

    /**
     * Gets the value of the korisnik property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the korisnik property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKorisnik().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Korisnik }
     * 
     * 
     */
    public List<Korisnik> getKorisnik() {
        if (korisnik == null) {
            korisnik = new ArrayList<Korisnik>();
        }
        return this.korisnik;
    }

    @Override
    public Long getDokumentId() {
        return 1L;
    }

    @Override
    public void setDokumentId(Long id) {

    }
}
