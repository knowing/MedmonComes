
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
 *         &lt;element name="DeviceManufacturer" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    "deviceManufacturer"
})
@XmlRootElement(name = "DeviceManufacturers")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
public class DeviceManufacturers {

    @XmlElement(name = "DeviceManufacturer")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected List<String> deviceManufacturer;

    /**
     * Gets the value of the deviceManufacturer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceManufacturer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceManufacturer().add(newItem);
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
    public List<String> getDeviceManufacturer() {
        if (deviceManufacturer == null) {
            deviceManufacturer = new ArrayList<String>();
        }
        return this.deviceManufacturer;
    }

}
