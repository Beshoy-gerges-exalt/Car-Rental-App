//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.05.25 at 10:32:32 PM EET 
//


package com.exalt.car.rental.xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.exalt.car.rental.xml package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.exalt.car.rental.xml
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RentCarResponse }
     *
     */
    public RentCarResponse createRentCarResponse() {
        return new RentCarResponse();
    }

    /**
     * Create an instance of {@link RentCarRequest }
     *
     */
    public RentCarRequest createRentCarRequest() {
        return new RentCarRequest();
    }

    /**
     * Create an instance of {@link GetAvailableCarsRequest }
     *
     */
    public GetAvailableCarsRequest createGetAvailableCarsRequest() {
        return new GetAvailableCarsRequest();
    }

    /**
     * Create an instance of {@link GetAvailableCarsResponse }
     *
     */
    public GetAvailableCarsResponse createGetAvailableCarsResponse() {
        return new GetAvailableCarsResponse();
    }

    /**
     * Create an instance of {@link Car }
     *
     */
    public Car createCar() {
        return new Car();
    }

}
