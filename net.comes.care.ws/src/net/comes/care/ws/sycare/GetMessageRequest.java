
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
 *         &lt;element name="SessionId" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SessionId"/>
 *         &lt;element name="MessageOption" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}MessageOption" minOccurs="0"/>
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
@XmlRootElement(name = "getMessageRequest")
public class GetMessageRequest {

    @XmlElement(name = "SessionId", required = true)
    protected String sessionId;
    @XmlElement(name = "MessageOption")
    protected MessageOption messageOption;

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
     * Ruft den Wert der messageOption-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MessageOption }
     *     
     */
    public MessageOption getMessageOption() {
        return messageOption;
    }

    /**
     * Legt den Wert der messageOption-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageOption }
     *     
     */
    public void setMessageOption(MessageOption value) {
        this.messageOption = value;
    }

}
