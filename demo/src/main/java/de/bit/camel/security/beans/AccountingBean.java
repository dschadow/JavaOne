package de.bit.camel.security.beans;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class AccountingBean {
    private Logger logger = Logger.getLogger(AccountingBean.class);

    private SimpleJdbcTemplate simpleJdbcTemplate;
    private static final String QUERY_SALARY_FOR_ID = "select salary from accounting where emp_emp_id = ?";
    private static final String QUERY_ALL_SALARIES = "select sum(salary) from accounting, employees where emp_id = emp_emp_id and man_id = ? ";

    public Document getSalaryForEmployee(Document employee) {
        int empId = getEmpId(employee);
        
        if (empId == -1) {
            return employee;
        }

        int salary = simpleJdbcTemplate
                .queryForObject(QUERY_SALARY_FOR_ID, Integer.class, new Object[] {empId});

        logger.info("getSalaryForEmployee returned " + salary);
        
        employee.getElementsByTagName("salary").item(0).setTextContent(String.valueOf(salary));

        return employee;
    }

    public Document getTotalSalaryForManager(Document employee) {
        int empId = getEmpId(employee);
        
        if (empId == -1) {
            return employee;
        }

        int total = simpleJdbcTemplate.queryForInt(QUERY_ALL_SALARIES, new Object[] {empId});

        logger.debug("getTotalSalaryForManager returned " + total);
        
        employee.getElementsByTagName("total").item(0).setTextContent(String.valueOf(total));

        return employee;
    }

    private int getEmpId(Document employee) {
        NodeList empIds = employee.getDocumentElement().getElementsByTagName("empId");
        
        if (empIds.getLength() != 1) {
            return -1;
        }
        
        int empId = Integer.parseInt(empIds.item(0).getTextContent());
        
        logger.debug("using empId " + empId);
        
        return empId;
    }

    @Required
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
