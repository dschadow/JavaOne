package de.bit.camel.security.util;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.bit.camel.security.Employee;

public class Converter {
    public String convertToXml(Object source) {
        StringWriter sw = new StringWriter();

        try {
            JAXBContext context = JAXBContext.newInstance(source.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
            marshaller.marshal(source, sw);
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }

        return sw.toString();
    }
    
    public Employee convertToEmployee(InputStream source) {
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            return (Employee) unmarshaller.unmarshal(source);
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }
}
