
package net.comes.care.ws.sycare;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SurveyData complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SurveyData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SurveyElement" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}SurveyElement" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SurveyData", propOrder = {
    "surveyElement"
})
public class SurveyData {

    @XmlElement(name = "SurveyElement", required = true)
    protected List<SurveyElement> surveyElement;

    /**
     * Gets the value of the surveyElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surveyElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurveyElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SurveyElement }
     * 
     * 
     */
    public List<SurveyElement> getSurveyElement() {
        if (surveyElement == null) {
            surveyElement = new ArrayList<SurveyElement>();
        }
        return this.surveyElement;
    }

}
