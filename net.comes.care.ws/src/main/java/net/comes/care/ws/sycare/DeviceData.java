
package net.comes.care.ws.sycare;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java-Klasse für DeviceData complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DeviceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Device_ADDR" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}Device_ADDR" minOccurs="0"/>
 *         &lt;element name="BD_ADDR" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}BD_ADDR" minOccurs="0"/>
 *         &lt;element name="ACData" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}ACData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BPData" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}BPData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BSData" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}BSData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SCData" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}SCData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceData", propOrder = {
    "deviceADDR",
    "bdaddr",
    "acData",
    "bpData",
    "bsData",
    "scData"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
public class DeviceData {

    @XmlElement(name = "Device_ADDR")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected DeviceADDR deviceADDR;
    @XmlElement(name = "BD_ADDR")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected String bdaddr;
    @XmlElement(name = "ACData")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected List<String> acData;
    @XmlElement(name = "BPData")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected List<String> bpData;
    @XmlElement(name = "BSData")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected List<String> bsData;
    @XmlElement(name = "SCData")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected List<String> scData;

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
     * Gets the value of the acData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getACData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public List<String> getACData() {
        if (acData == null) {
            acData = new ArrayList<String>();
        }
        return this.acData;
    }

    /**
     * Gets the value of the bpData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bpData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBPData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public List<String> getBPData() {
        if (bpData == null) {
            bpData = new ArrayList<String>();
        }
        return this.bpData;
    }

    /**
     * Gets the value of the bsData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bsData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBSData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public List<String> getBSData() {
        if (bsData == null) {
            bsData = new ArrayList<String>();
        }
        return this.bsData;
    }

    /**
     * Gets the value of the scData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSCData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public List<String> getSCData() {
        if (scData == null) {
            scData = new ArrayList<String>();
        }
        return this.scData;
    }

}
