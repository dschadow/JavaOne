package de.bit.camel.security.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.shiro.security.ShiroSecurityToken;
import org.apache.camel.component.shiro.security.ShiroSecurityTokenInjector;

/**
 * Dummy helper processor since Apache CXF does not transfer the Apache Shiro token beyond the endpoint (yet). This is a
 * demo implementation only, use WS-Security to secure username and password for web service request.
 * 
 * @author Dominik Schadow
 */
public class TokenHelper implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String username = (String) exchange.getIn().removeHeader("j_username");
        String password = (String) exchange.getIn().removeHeader("j_password");

        if ((username != null && !username.isEmpty()) && (password != null && !password.isEmpty())) {
            ShiroSecurityToken token = new ShiroSecurityToken(username, password);
            ShiroSecurityTokenInjector tokenInjector = new ShiroSecurityTokenInjector(token,
                    "CamelSecureRoute".getBytes());
            exchange.getIn().setHeader("SHIRO_SECURITY_TOKEN", tokenInjector.encrypt());
        }
    }
}
