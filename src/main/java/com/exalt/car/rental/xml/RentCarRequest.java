//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.06.05 at 10:18:31 AM EET 
//


package com.exalt.car.rental.xml;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rentEndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "carId",
        "rentEndDate"
})
@XmlRootElement(name = "RentCarRequest")
public class RentCarRequest {

    protected int carId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar rentEndDate;

    /**
     * Gets the value of the carId property.
     *
     */
    public int getCarId() {
        return carId;
    }

    /**
     * Sets the value of the carId property.
     *
     */
    public void setCarId(int value) {
        this.carId = value;
    }

    /**
     * Gets the value of the rentEndDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getRentEndDate() {
        return rentEndDate;
    }

    /**
     * Sets the value of the rentEndDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setRentEndDate(XMLGregorianCalendar value) {
        this.rentEndDate = value;
    }

}
