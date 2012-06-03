
package net.comes.care.ws.sycare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SurveyOption complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SurveyOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SurveyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Scroll" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}Scroll" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SurveyOption", propOrder = {
    "surveyId",
    "scroll"
})
public class SurveyOption {

    @XmlElement(name = "SurveyId")
    protected int surveyId;
    @XmlElement(name = "Scroll")
    protected Scroll scroll;

    /**
     * Ruft den Wert der surveyId-Eigenschaft ab.
     * 
     */
    public int getSurveyId() {
        return surveyId;
    }

    /**
     * Legt den Wert der surveyId-Eigenschaft fest.
     * 
     */
    public void setSurveyId(int value) {
        this.surveyId = value;
    }

    /**
     * Ruft den Wert der scroll-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Scroll }
     *     
     */
    public Scroll getScroll() {
        return scroll;
    }

    /**
     * Legt den Wert der scroll-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Scroll }
     *     
     */
    public void setScroll(Scroll value) {
        this.scroll = value;
    }

}
