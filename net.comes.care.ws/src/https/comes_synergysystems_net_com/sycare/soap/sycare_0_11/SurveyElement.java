
package https.comes_synergysystems_net_com.sycare.soap.sycare_0_11;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Question" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}Question"/>
 *         &lt;element name="AnswerDefault" type="{https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl}AnswerDefault" maxOccurs="unbounded" minOccurs="0"/>
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
public class SurveyElement {

    @XmlElement(name = "Question", required = true)
    protected Question question;
    @XmlElement(name = "AnswerDefault")
    protected List<AnswerDefault> answerDefault;

    /**
     * Ruft den Wert der question-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Question }
     *     
     */
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
    public List<AnswerDefault> getAnswerDefault() {
        if (answerDefault == null) {
            answerDefault = new ArrayList<AnswerDefault>();
        }
        return this.answerDefault;
    }

}
