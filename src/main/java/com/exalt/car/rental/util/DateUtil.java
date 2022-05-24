package com.exalt.car.rental.util;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class DateUtil {

    public static LocalDate convert(XMLGregorianCalendar gregorianCalendar) {
        return gregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }

    public static XMLGregorianCalendar convert(LocalDate localDate) throws DatatypeConfigurationException {
        GregorianCalendar gcal = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
    }
}
