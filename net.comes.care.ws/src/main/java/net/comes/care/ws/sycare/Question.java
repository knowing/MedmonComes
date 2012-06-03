
package net.comes.care.ws.sycare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Question complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Question">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Question", propOrder = {
    "questionId",
    "position",
    "content"
})
public class Question {

    @XmlElement(name = "QuestionId")
    protected int questionId;
    @XmlElement(name = "Position")
    protected int position;
    @XmlElement(name = "Content", required = true)
    protected String content;

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
     * Ruft den Wert der position-Eigenschaft ab.
     * 
     */
    public int getPosition() {
        return position;
    }

    /**
     * Legt den Wert der position-Eigenschaft fest.
     * 
     */
    public void setPosition(int value) {
        this.position = value;
    }

    /**
     * Ruft den Wert der content-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Legt den Wert der content-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

}
