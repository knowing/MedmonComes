
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
 *       &lt;sequence>
 *         &lt;element name="SessionId" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SessionId"/>
 *         &lt;element name="StatusScope" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}StatusScope"/>
 *         &lt;element name="Device_ADDR" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}Device_ADDR" minOccurs="0"/>
 *         &lt;element name="BD_ADDR" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}BD_ADDR" minOccurs="0"/>
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
    "statusScope",
    "deviceADDR",
    "bdaddr"
})
@XmlRootElement(name = "getStatusRequest")
public class GetStatusRequest {

    @XmlElement(name = "SessionId", required = true)
    protected String sessionId;
    @XmlElement(name = "StatusScope", defaultValue = "7")
    protected int statusScope;
    @XmlElement(name = "Device_ADDR")
    protected DeviceADDR deviceADDR;
    @XmlElement(name = "BD_ADDR")
    protected String bdaddr;

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
     * Ruft den Wert der statusScope-Eigenschaft ab.
     * 
     */
    public int getStatusScope() {
        return statusScope;
    }

    /**
     * Legt den Wert der statusScope-Eigenschaft fest.
     * 
     */
    public void setStatusScope(int value) {
        this.statusScope = value;
    }

    /**
     * Ruft den Wert der deviceADDR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeviceADDR }
     *     
     */
    public DeviceADDR getDeviceADDR() {
        return deviceADDR;
    }

    /**
     * Legt den Wert der deviceADDR-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceADDR }
     *     
     */
    public void setDeviceADDR(DeviceADDR value) {
        this.deviceADDR = value;
    }

    /**
     * Ruft den Wert der bdaddr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBDADDR() {
        return bdaddr;
    }

    /**
     * Legt den Wert der bdaddr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBDADDR(String value) {
        this.bdaddr = value;
    }

}
