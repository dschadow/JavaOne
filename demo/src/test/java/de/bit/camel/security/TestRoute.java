package de.bit.camel.security;

import java.util.List;

import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRoute extends CamelSpringTestSupport {
    @Test
    @SuppressWarnings("unchecked")
    public void testUsersRoute() throws Exception {
        List<Employee> users = template.requestBody("seda:users", "users", List.class);

        assertNotNull(users);
        assertTrue(users.size() == 2);
        
        users = template.requestBody("seda:users", "editors", List.class);

        assertNotNull(users);
        assertTrue(users.size() == 2);
        
        users = template.requestBody("seda:users", "admins", List.class);

        assertNotNull(users);
        assertTrue(users.size() == 1);
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
    }
}
