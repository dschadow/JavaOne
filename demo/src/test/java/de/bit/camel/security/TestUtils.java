package de.bit.camel.security;

import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.w3c.dom.Document;

import de.bit.camel.security.services.EmpInfoService;

public class TestUtils {
    public static EmpInfoService createClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(EmpInfoService.class);
        factory.setAddress("http://localhost:8080/demo/emp");
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());

        return (EmpInfoService) factory.create();
    }
    
    public static String getDocumentAsString(Document employee) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(employee);
        transformer.transform(source, result);
        
        return result.getWriter().toString();
    }
}