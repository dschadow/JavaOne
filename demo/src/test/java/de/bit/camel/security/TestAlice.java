package de.bit.camel.security;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;

public class TestAlice extends CamelSpringTestSupport {
    @Test
    public void testAlice() throws Exception {
        Processor processor = new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().setBody(10001);
                exchange.getIn().setHeader(CxfConstants.OPERATION_NAME, "getEmployeeInformation");
                exchange.getIn().setHeader("jobTitle", "Manager");
                exchange.getIn().setHeader(CxfConstants.OPERATION_NAMESPACE, "http://services.bit.de/");
            }
        };

        Exchange resultExchange = template.request("direct:EmpInfoService", processor);

        assertNotNull("result may not be null", resultExchange);
        assertNotNull("result/getIn may not be null", resultExchange.getIn());
        assertNotNull("result/getIn/getBody may not be null", resultExchange.getIn().getBody(Document.class));
        
        Document employee = resultExchange.getIn().getBody(Document.class);
        
        assertEquals(TestResults.COMPLETE_RESULT_ALICE, TestUtils.getDocumentAsString(employee));
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
    }
}
