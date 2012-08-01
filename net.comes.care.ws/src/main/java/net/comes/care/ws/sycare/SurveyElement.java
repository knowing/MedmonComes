
package net.comes.care.ws.sycare;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SurveyElement complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SurveyElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Question" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}Question"/>
 *         &lt;element name="AnswerDefault" type="{http://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl}AnswerDefault" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SurveyElement", propOrder = {
    "question",
    "answerDefault"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
public class SurveyElement {

    @XmlElement(name = "Question", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected Question question;
    @XmlElement(name = "AnswerDefault")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    protected List<AnswerDefault> answerDefault;

    /**
     * Ruft den Wert der question-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Question }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public Question getQuestion() {
        return question;
    }

    /**
     * Legt den Wert der question-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Question }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public void setQuestion(Question value) {
        this.question = value;
    }

    /**
     * Gets the value of the answerDefault property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the answerDefault property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnswerDefault().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnswerDefault }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-08-01T12:52:24+02:00", comments = "JAXB RI v2.2.5")
    public List<AnswerDefault> getAnswerDefault() {
        if (answerDefault == null) {
            answerDefault = new ArrayList<AnswerDefault>();
        }
        return this.answerDefault;
    }

}
