
package net.comes.care.ws.sycare;

import javax.annotation.Generated;
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
 *         &lt;element name="Scroll" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}Scroll" minOccurs="0"/>
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
@Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
public class SurveyOption {

    @XmlElement(name = "SurveyId")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected int surveyId;
    @XmlElement(name = "Scroll")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected Scroll scroll;

    /**
     * Ruft den Wert der surveyId-Eigenschaft ab.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public int getSurveyId() {
        return surveyId;
    }

    /**
     * Legt den Wert der surveyId-Eigenschaft fest.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public void setScroll(Scroll value) {
        this.scroll = value;
    }

}
