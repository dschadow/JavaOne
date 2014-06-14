package de.bit.camel.security.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import de.bit.camel.security.Employee;

/**
 * 
 * @author Dominik Schadow
 */
@WebService(serviceName = "EmpInfoService", targetNamespace = "http://services.bit.de/")
public interface EmpInfoService {
    @WebResult(name = "employee")
    Employee getEmployeeInformation(@WebParam(name = "empId") String empId);
}
