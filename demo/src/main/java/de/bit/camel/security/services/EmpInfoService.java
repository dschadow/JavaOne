package de.bit.camel.security.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import de.bit.camel.security.Employee;

@WebService
public interface EmpInfoService {
    @WebResult(name = "employee")
    Employee getEmployeeInformation(@WebParam(name = "empId", targetNamespace = "") int empId);
}
