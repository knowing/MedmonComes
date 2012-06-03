
package net.comes.care.ws.sycare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="SurveyTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SurveyData" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SurveyData"/>
 *         &lt;element name="SurveyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "aSurvey")
public class ASurvey {

    @XmlElement(name = "SurveyTitle", required = true)
    protected String surveyTitle;
    @XmlElement(name = "SurveyData", required = true)
    protected SurveyData surveyData;
    @XmlElement(name = "SurveyId")
    protected int surveyId;

    /**
     * Ruft den Wert der surveyTitle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurveyTitle() {
        return surveyTitle;
    }

    /**
     * Legt den Wert der surveyTitle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurveyTitle(String value) {
        this.surveyTitle = value;
    }

    /**
     * Ruft den Wert der surveyData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SurveyData }
     *     
     */
    public SurveyData getSurveyData() {
        return surveyData;
    }

    /**
     * Legt den Wert der surveyData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SurveyData }
     *     
     */
    public void setSurveyData(SurveyData value) {
        this.surveyData = value;
    }

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

}
