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
public class TestAlice {
    @Produce
    protected ProducerTemplate template;

    @Test
    public void testAlice() throws Exception {
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("j_username", "alice");
        headers.put("j_password", "alice");
        
        Employee alice = template.requestBodyAndHeaders(TestValues.ENDPOINT, TestValues.EMP_ID_ALICE, headers, Employee.class);

        assertNotNull("Alice may not be null", alice);

        assertEquals(TestValues.COMPLETE_RESULT_ALICE, alice.toString());
    }
}
