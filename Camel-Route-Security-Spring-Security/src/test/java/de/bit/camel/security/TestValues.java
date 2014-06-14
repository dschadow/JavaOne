package de.bit.camel.security;

/**
 * 
 * @author Dominik Schadow
 */
public interface TestValues {
	String EMP_ID_ALICE = "10001";
	
	String EMP_ID_BOB = "10002";
	
    String COMPLETE_RESULT_ALICE = "empId 10001, name Alice, jobTitle Manager, department , entryDate 01.01.2008, salary 10000, total 8700";

    String COMPLETE_RESULT_BOB = "empId 10002, name Bob, jobTitle Administrator, department IT, entryDate 01.06.2005, salary 5000, total -1";
    
    String ENDPOINT = "cxf:bean:EmpInfoService";
}
