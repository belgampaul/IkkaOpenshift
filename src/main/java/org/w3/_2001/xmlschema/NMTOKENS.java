//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.13 at 05:47:39 AM MSK 
//


package org.w3._2001.xmlschema;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for NMTOKENS simple type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;simpleType name="NMTOKENS">
 *   &lt;restriction>
 *     &lt;simpleType>
 *       &lt;list itemType="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *     &lt;/simpleType>
 *     &lt;minLength value="1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NMTOKENS", propOrder = {
    "value"
})
public class NMTOKENS {

    @XmlValue
    @XmlSchemaType(name = "NMTOKENS")
    protected List<NMTOKEN> value;

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NMTOKEN }
     * 
     * 
     */
    public List<NMTOKEN> getValue() {
        if (value == null) {
            value = new ArrayList<NMTOKEN>();
        }
        return this.value;
    }

}