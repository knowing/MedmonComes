
package net.comes.care.ws.sycare;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
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
 *         &lt;element name="Accepted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AvailableMessages" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AvailableSurveys" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DeviceInfo" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}DeviceInfo" maxOccurs="unbounded" minOccurs="0"/>
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
    "accepted",
    "availableMessages",
    "availableSurveys",
    "deviceInfo"
})
@XmlRootElement(name = "Status")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
public class Status {

    @XmlElement(name = "Accepted")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected Boolean accepted;
    @XmlElement(name = "AvailableMessages")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected Integer availableMessages;
    @XmlElement(name = "AvailableSurveys")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected Integer availableSurveys;
    @XmlElement(name = "DeviceInfo")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected List<DeviceInfo> deviceInfo;

    /**
     * Ruft den Wert der accepted-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public Boolean isAccepted() {
        return accepted;
    }

    /**
     * Legt den Wert der accepted-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public void setAccepted(Boolean value) {
        this.accepted = value;
    }

    /**
     * Ruft den Wert der availableMessages-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public Integer getAvailableMessages() {
        return availableMessages;
    }

    /**
     * Legt den Wert der availableMessages-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public void setAvailableMessages(Integer value) {
        this.availableMessages = value;
    }

    /**
     * Ruft den Wert der availableSurveys-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public Integer getAvailableSurveys() {
        return availableSurveys;
    }

    /**
     * Legt den Wert der availableSurveys-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public void setAvailableSurveys(Integer value) {
        this.availableSurveys = value;
    }

    /**
     * Gets the value of the deviceInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceInfo }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public List<DeviceInfo> getDeviceInfo() {
        if (deviceInfo == null) {
            deviceInfo = new ArrayList<DeviceInfo>();
        }
        return this.deviceInfo;
    }

}
