package de.bit.camel.security;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser extends CamelSpringTestSupport {
    
    private static final String ECHO_REQUEST = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
        + "<soap:Body><ns1:echo xmlns:ns1=\"http://cxf.component.camel.apache.org/\">"
        + "<arg0 xmlns=\"http://cxf.component.camel.apache.org/\">10001</arg0></ns1:echo></soap:Body></soap:Envelope>";
    @Test
    public void testAlice() throws Exception {
        Exchange senderExchange = new DefaultExchange(context, ExchangePattern.InOut);
        senderExchange.getIn().setBody(10001);
        senderExchange.getIn().setHeader(CxfConstants.OPERATION_NAME, "getEmployeeInformation");

        String result = template.requestBody("cxf:bean:EmpInfoService", ECHO_REQUEST, String.class);
        
        Thread.sleep(2000);

        assertNotNull("result may not be null", result);
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
    }
}
