
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
 *         &lt;element name="MessageType" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}MessageType"/>
 *         &lt;element name="MessageTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MessageData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MessageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlRootElement(name = "aMessage")
public class AMessage {

    @XmlElement(name = "MessageType", required = true)
    protected MessageType messageType;
    @XmlElement(name = "MessageTitle", required = true)
    protected String messageTitle;
    @XmlElement(name = "MessageData", required = true)
    protected String messageData;
    @XmlElement(name = "MessageId")
    protected int messageId;

    /**
     * Ruft den Wert der messageType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MessageType }
     *     
     */
    public MessageType getMessageType() {
        return messageType;
    }

    /**
     * Legt den Wert der messageType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageType }
     *     
     */
    public void setMessageType(MessageType value) {
        this.messageType = value;
    }

    /**
     * Ruft den Wert der messageTitle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     * Legt den Wert der messageTitle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageTitle(String value) {
        this.messageTitle = value;
    }

    /**
     * Ruft den Wert der messageData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageData() {
        return messageData;
    }

    /**
     * Legt den Wert der messageData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageData(String value) {
        this.messageData = value;
    }

    /**
     * Ruft den Wert der messageId-Eigenschaft ab.
     * 
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * Legt den Wert der messageId-Eigenschaft fest.
     * 
     */
    public void setMessageId(int value) {
        this.messageId = value;
    }

}
