
package https.comes_synergysystems_net_com.sycare.soap.sycare_0_11;

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
 *         &lt;element name="SessionId" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SessionId"/>
 *         &lt;element name="SurveyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SurveyResult" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SurveyResult" minOccurs="0"/>
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
public class SendSurveyDataRequest {

    @XmlElement(name = "SessionId", required = true)
    protected String sessionId;
    @XmlElement(name = "SurveyId")
    protected int surveyId;
    @XmlElement(name = "SurveyResult")
    protected SurveyResult surveyResult;

    /**
     * Ruft den Wert der sessionId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
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
    public void setSessionId(String value) {
        this.sessionId = value;
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

    /**
     * Ruft den Wert der surveyResult-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SurveyResult }
     *     
     */
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
    public void setSurveyResult(SurveyResult value) {
        this.surveyResult = value;
    }

}
