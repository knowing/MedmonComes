
package net.comes.care.ws.sycare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Scroll complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Scroll">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Direction" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}Direction"/>
 *         &lt;element name="Increment" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}Increment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Scroll", propOrder = {
    "direction",
    "increment"
})
public class Scroll {

    @XmlElement(name = "Direction", required = true)
    protected Direction direction;
    @XmlElement(name = "Increment", defaultValue = "1")
    protected Integer increment;

    /**
     * Ruft den Wert der direction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Direction }
     *     
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Legt den Wert der direction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Direction }
     *     
     */
    public void setDirection(Direction value) {
        this.direction = value;
    }

    /**
     * Ruft den Wert der increment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIncrement() {
        return increment;
    }

    /**
     * Legt den Wert der increment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIncrement(Integer value) {
        this.increment = value;
    }

}
