package de.bit.camel.security.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import de.bit.camel.security.Employee;

@WebService(serviceName = "EmpInfoService", targetNamespace = "http://services.bit.de/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface EmpInfoService {
    @WebResult(name = "employee")
    Employee getEmployeeInformation(@WebParam(name = "empId") int empId);
}
