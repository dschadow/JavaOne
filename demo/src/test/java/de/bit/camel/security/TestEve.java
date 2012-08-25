package de.bit.camel.security;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.apache.cxf.binding.soap.SoapFault;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

public class TestEve extends CamelSpringTestSupport {
    @Test
    @DirtiesContext
    public void testEve() throws Exception {
        Processor processor = new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().setBody(12345);
                exchange.getIn().setHeader(CxfConstants.OPERATION_NAME, "getEmployeeInformation");
                exchange.getIn().setHeader(CxfConstants.OPERATION_NAMESPACE, "http://services.bit.de/");
            }
        };
    
        Exchange resultExchange = template.request("cxf:bean:EmpInfoService", processor);
    
        assertNotNull("result may not be null", resultExchange);
        assertNotNull("exception may not be null", resultExchange.getException());
        
        assertTrue(resultExchange.getException().getClass().equals(SoapFault.class));
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
    }
}
