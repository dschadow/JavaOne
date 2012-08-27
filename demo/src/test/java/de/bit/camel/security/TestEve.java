package de.bit.camel.security;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEve extends CamelSpringTestSupport {
    @Test
    public void testEve() throws Exception {
        Processor processor = new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().setBody(TestValues.EMP_ID_ALICE);
                exchange.getIn().setHeader(CxfConstants.OPERATION_NAME, "getEmployeeInformation");
                exchange.getIn().setHeader(CxfConstants.OPERATION_NAMESPACE, "http://services.bit.de/");
            }
        };

        Exchange resultExchange = template.request("cxf:bean:EmpInfoService", processor);

        assertNotNull("result may not be null", resultExchange);
        assertNotNull("out may not be null", resultExchange.getOut());
        assertNotNull("body may not be null", resultExchange.getOut().getBody(Employee.class));

        Employee employee = resultExchange.getOut().getBody(Employee.class);

        assertEquals(TestValues.COMPLETE_RESULT_ALICE, employee.toString());
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
    }
}
