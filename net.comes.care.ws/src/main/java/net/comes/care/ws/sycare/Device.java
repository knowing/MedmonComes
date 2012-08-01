
package net.comes.care.ws.sycare;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Device complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Device">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Device_ADDR" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}Device_ADDR" minOccurs="0"/>
 *         &lt;element name="BD_ADDR" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}BD_ADDR" minOccurs="0"/>
 *         &lt;element name="DeviceType" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}DeviceType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Device", propOrder = {
    "deviceADDR",
    "bdaddr",
    "deviceType"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
public class Device {

    @XmlElement(name = "Device_ADDR")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected DeviceADDR deviceADDR;
    @XmlElement(name = "BD_ADDR")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected String bdaddr;
    @XmlElement(name = "DeviceType", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected DeviceType deviceType;

    /**
     * Ruft den Wert der deviceADDR-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeviceADDR }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
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
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public void setBDADDR(String value) {
        this.bdaddr = value;
    }

    /**
     * Ruft den Wert der deviceType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeviceType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public DeviceType getDeviceType() {
        return deviceType;
    }

    /**
     * Legt den Wert der deviceType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public void setDeviceType(DeviceType value) {
        this.deviceType = value;
    }

}
