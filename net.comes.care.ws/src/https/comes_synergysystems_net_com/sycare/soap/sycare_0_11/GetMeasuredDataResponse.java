
package https.comes_synergysystems_net_com.sycare.soap.sycare_0_11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACData" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}ACData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BPData" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}BPData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BSData" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}BSData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SCData" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SCData" maxOccurs="unbounded" minOccurs="0"/>
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
    "acData",
    "bpData",
    "bsData",
    "scData"
})
@XmlRootElement(name = "getMeasuredDataResponse")
public class GetMeasuredDataResponse {

    @XmlElement(name = "ACData")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected List<String> acData;
    @XmlElement(name = "BPData")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected List<String> bpData;
    @XmlElement(name = "BSData")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected List<String> bsData;
    @XmlElement(name = "SCData")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected List<String> scData;

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
    public List<String> getSCData() {
        if (scData == null) {
            scData = new ArrayList<String>();
        }
        return this.scData;
    }

}
