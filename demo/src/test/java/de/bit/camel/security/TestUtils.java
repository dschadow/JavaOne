package de.bit.camel.security;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import de.bit.camel.security.services.EmpInfoService;

public class TestUtils {
    public static EmpInfoService createClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(EmpInfoService.class);
        factory.setAddress("http://localhost:8080/demo/emp");
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());

        return (EmpInfoService) factory.create();
    }
}