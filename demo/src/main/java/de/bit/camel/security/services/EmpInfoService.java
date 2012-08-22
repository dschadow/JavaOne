package de.bit.camel.security.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "EmpInfoService", targetNamespace = "http://services.bit.de/")
public interface EmpInfoService {
    @WebResult(name = "employee")
    String getEmployeeInformation(@WebParam(name = "empId") int empId);
}
