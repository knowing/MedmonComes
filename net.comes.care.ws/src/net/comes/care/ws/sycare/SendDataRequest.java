
package net.comes.care.ws.sycare;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="DataType" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}DataType"/>
 *         &lt;element name="DeviceType" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}DeviceType"/>
 *         &lt;element name="DeviceData" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}DeviceData" maxOccurs="unbounded"/>
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
    "dataType",
    "deviceType",
    "deviceData"
})
@XmlRootElement(name = "sendDataRequest")
public class SendDataRequest {

    @XmlElement(name = "SessionId", required = true)
    protected String sessionId;
    @XmlElement(name = "DataType", required = true)
    protected DataType dataType;
    @XmlElement(name = "DeviceType", required = true)
    protected DeviceType deviceType;
    @XmlElement(name = "DeviceData", required = true)
    protected List<DeviceData> deviceData;

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
     * Ruft den Wert der dataType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DataType }
     *     
     */
    public DataType getDataType() {
        return dataType;
    }

    /**
     * Legt den Wert der dataType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DataType }
     *     
     */
    public void setDataType(DataType value) {
        this.dataType = value;
    }

    /**
     * Ruft den Wert der deviceType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeviceType }
     *     
     */
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
    public void setDeviceType(DeviceType value) {
        this.deviceType = value;
    }

    /**
     * Gets the value of the deviceData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceData }
     * 
     * 
     */
    public List<DeviceData> getDeviceData() {
        if (deviceData == null) {
            deviceData = new ArrayList<DeviceData>();
        }
        return this.deviceData;
    }

}
