
package net.comes.care.ws.sycare;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SurveyResult complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SurveyResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SurveyValue" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SurveyValue" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SurveyResult", propOrder = {
    "surveyValue"
})
public class SurveyResult {

    @XmlElement(name = "SurveyValue", required = true)
    protected List<SurveyValue> surveyValue;

    /**
     * Gets the value of the surveyValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surveyValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurveyValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SurveyValue }
     * 
     * 
     */
    public List<SurveyValue> getSurveyValue() {
        if (surveyValue == null) {
            surveyValue = new ArrayList<SurveyValue>();
        }
        return this.surveyValue;
    }

}
