package de.bit.camel.security.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Converter {
    public String convertToXml(Object source) {
        StringWriter sw = new StringWriter();

        try {
            JAXBContext context = JAXBContext.newInstance(source.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
            marshaller.marshal(source, sw);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return sw.toString();
    }
}
