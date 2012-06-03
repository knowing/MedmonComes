
package net.comes.care.ws.sycare;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für DeviceType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="DeviceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="BP"/>
 *     &lt;enumeration value="BS"/>
 *     &lt;enumeration value="SC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeviceType")
@XmlEnum
public enum DeviceType {

    AC,
    BP,
    BS,
    SC;

    public String value() {
        return name();
    }

    public static DeviceType fromValue(String v) {
        return valueOf(v);
    }

}
