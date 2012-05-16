
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
 *       &lt;all>
 *         &lt;element name="SessionId" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SessionId"/>
 *         &lt;element name="SurveyOption" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SurveyOption" minOccurs="0"/>
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
@XmlRootElement(name = "getSurveyRequest")
public class GetSurveyRequest {

    @XmlElement(name = "SessionId", required = true)
    protected String sessionId;
    @XmlElement(name = "SurveyOption")
    protected SurveyOption surveyOption;

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
     * Ruft den Wert der surveyOption-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SurveyOption }
     *     
     */
    public SurveyOption getSurveyOption() {
        return surveyOption;
    }

    /**
     * Legt den Wert der surveyOption-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SurveyOption }
     *     
     */
    public void setSurveyOption(SurveyOption value) {
        this.surveyOption = value;
    }

}
