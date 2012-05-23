
package net.comes.care.ws.sycare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SurveyValue complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SurveyValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AnswerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AnswerContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SurveyValue", propOrder = {
    "questionId",
    "answerId",
    "answerContent"
})
public class SurveyValue {

    @XmlElement(name = "QuestionId")
    protected int questionId;
    @XmlElement(name = "AnswerId")
    protected Integer answerId;
    @XmlElement(name = "AnswerContent")
    protected String answerContent;

    /**
     * Ruft den Wert der questionId-Eigenschaft ab.
     * 
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Legt den Wert der questionId-Eigenschaft fest.
     * 
     */
    public void setQuestionId(int value) {
        this.questionId = value;
    }

    /**
     * Ruft den Wert der answerId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAnswerId() {
        return answerId;
    }

    /**
     * Legt den Wert der answerId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAnswerId(Integer value) {
        this.answerId = value;
    }

    /**
     * Ruft den Wert der answerContent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     * Legt den Wert der answerContent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswerContent(String value) {
        this.answerContent = value;
    }

}
