//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.13 at 05:47:39 AM MSK 
//


package org.w3._2001.xmlschema;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}keybase">
 *       &lt;attribute name="refer" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "keyref")
public class Keyref
    extends Keybase
{

    @XmlAttribute(name = "refer", required = true)
    protected QName refer;

    /**
     * Gets the value of the refer property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRefer() {
        return refer;
    }

    /**
     * Sets the value of the refer property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setRefer(QName value) {
        this.refer = value;
    }

}
