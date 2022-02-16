
package com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina;

import com.rokzasok.portal.za.imunizaciju.interfaces.Identifiable;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element ref="{www.rokzasok.rs/termini}termini" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "termini"
})
@XmlRootElement(name = "spisakTermina", namespace = "www.rokzasok.rs/termini")
public class SpisakTermina implements Identifiable {

    @XmlElement(namespace = "www.rokzasok.rs/termini")
    protected List<Termini> termini;

    /**
     * Gets the value of the termini property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the termini property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTermini().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Termini }
     * 
     * 
     */
    public List<Termini> getTermini() {
        if (termini == null) {
            termini = new ArrayList<Termini>();
        }
        return this.termini;
    }

    @Override
    public Long getDokumentId() {
        return 1L;
    }

    @Override
    public void setDokumentId(Long id) {

    }
}
