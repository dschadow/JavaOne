package de.bit.camel.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelSpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/camel-context.xml")
public class TestBob {
	@Produce(uri = "cxf:bean:EmpInfoService")
	protected ProducerTemplate template;
	
    @Test
    public void testBob() throws Exception {
        Employee bob = template.requestBody(TestValues.EMP_ID_BOB, Employee.class);

        assertNotNull("Bob may not be null", bob);

        assertEquals(TestValues.COMPLETE_RESULT_BOB, bob.toString());
    }
}
