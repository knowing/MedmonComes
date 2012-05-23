
package net.comes.care.ws.sycare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Device_ADDR complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Device_ADDR">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DeviceManufacturer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Device_ADDR", propOrder = {
    "deviceManufacturer",
    "serialNumber"
})
public class DeviceADDR {

    @XmlElement(name = "DeviceManufacturer", required = true)
    protected String deviceManufacturer;
    @XmlElement(name = "SerialNumber", required = true)
    protected String serialNumber;

    /**
     * Ruft den Wert der deviceManufacturer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceManufacturer() {
        return deviceManufacturer;
    }

    /**
     * Legt den Wert der deviceManufacturer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceManufacturer(String value) {
        this.deviceManufacturer = value;
    }

    /**
     * Ruft den Wert der serialNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Legt den Wert der serialNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

}
