package de.bit.camel.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelSpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

/**
 * 
 * @author Dominik Schadow
 */
@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/camel-context.xml")
public class TestBob {
    @Produce
    protected ProducerTemplate template;

    @Test
    public void testBob() throws Exception {
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("j_username", "bob");
        headers.put("j_password", "bob");
        
        Employee alice = template.requestBodyAndHeaders(TestValues.ENDPOINT, TestValues.EMP_ID_BOB, headers, Employee.class);

        assertNotNull("Bob may not be null", alice);

        assertEquals(TestValues.COMPLETE_RESULT_BOB, alice.toString());
    }
}
