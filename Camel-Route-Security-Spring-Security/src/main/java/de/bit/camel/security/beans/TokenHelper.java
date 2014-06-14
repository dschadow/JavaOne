package de.bit.camel.security.beans;

import javax.security.auth.Subject;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Dummy helper processor since Apache CXF does not transfer the Spring Security token beyond the endpoint (yet). This
 * is a demo implementation only, use WS-Security to secure username and password for web service request.
 * 
 * @author Dominik Schadow
 */
public class TokenHelper implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String username = (String) exchange.getIn().removeHeader("j_username");
        String password = (String) exchange.getIn().removeHeader("j_password");

        if ((username != null && !username.isEmpty()) && (password != null && !password.isEmpty())) {
            Subject subject = new Subject();
            subject.getPrincipals().add(new UsernamePasswordAuthenticationToken(username, password));
            exchange.getIn().setHeader(Exchange.AUTHENTICATION, subject);
        }
    }
}
