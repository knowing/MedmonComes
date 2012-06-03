
package net.comes.care.ws.sycare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für MessageOption complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MessageOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "MessageOption", propOrder = {
    "messageId",
    "scroll"
})
public class MessageOption {

    @XmlElement(name = "MessageId")
    protected int messageId;
    @XmlElement(name = "Scroll")
    protected Scroll scroll;

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
