
package net.comes.care.ws.sycare;

import javax.annotation.Generated;
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
 *       &lt;sequence>
 *         &lt;element name="SessionId" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}SessionId"/>
 *         &lt;element name="SurveyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SurveyResult" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}SurveyResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sessionId",
    "surveyId",
    "surveyResult"
})
@XmlRootElement(name = "sendSurveyDataRequest")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
public class SendSurveyDataRequest {

    @XmlElement(name = "SessionId", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected String sessionId;
    @XmlElement(name = "SurveyId")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected int surveyId;
    @XmlElement(name = "SurveyResult")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected SurveyResult surveyResult;

    /**
     * Ruft den Wert der sessionId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Legt den Wert der sessionId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public void setSessionId(String value) {
        this.sessionId = value;
    }

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
     * Ruft den Wert der surveyResult-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SurveyResult }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public SurveyResult getSurveyResult() {
        return surveyResult;
    }

    /**
     * Legt den Wert der surveyResult-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SurveyResult }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public void setSurveyResult(SurveyResult value) {
        this.surveyResult = value;
    }

}
