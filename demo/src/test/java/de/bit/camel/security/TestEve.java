package de.bit.camel.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelSpringJUnit4ClassRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/camel-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TestEve {
	@Produce(uri = "cxf:bean:EmpInfoService")
	protected ProducerTemplate template;
	
    @Test
    public void testBobAndAlice() throws Exception {
        Processor processor = new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().setBody(TestValues.EMP_ID_BOB);
            }
        };

        Exchange result = template.send(processor);

        assertNotNull("result may not be null", result);
        assertNotNull("message may not be null", result.getOut());
        assertNotNull("body may not be null", result.getOut().getBody(Employee.class));

        Employee bob = result.getOut().getBody(Employee.class);

        assertEquals(TestValues.COMPLETE_RESULT_BOB, bob.toString());
        
        processor = new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().setBody(TestValues.EMP_ID_ALICE);
            }
        };

        result = template.send(processor);

        assertNotNull("result may not be null", result);
        assertNotNull("out may not be null", result.getOut());
        assertNotNull("body may not be null", result.getOut().getBody());

        Employee alice = result.getOut().getBody(Employee.class);

        assertEquals(TestValues.COMPLETE_RESULT_ALICE, alice.toString());
    }
    
    @BeforeClass
    public static void setup() throws Exception {
		Thread.sleep(5000);
    }
}
