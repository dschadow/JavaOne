package de.bit.camel.security.beans;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import de.bit.camel.security.Employee;

/**
 * 
 * @author Dominik Schadow
 */
public class AccountingBean {
    private Logger logger = Logger.getLogger(AccountingBean.class);

    private SimpleJdbcTemplate simpleJdbcTemplate;
    private static final String QUERY_SALARY_FOR_ID = "select salary from accounting where emp_emp_id = ?";
    private static final String QUERY_ALL_SALARIES = "select sum(salary) from accounting, employees where emp_id = emp_emp_id and man_id = ? ";

    public Employee getSalaryForEmployee(Employee employee) {
        int salary = simpleJdbcTemplate
                .queryForObject(QUERY_SALARY_FOR_ID, Integer.class, new Object[] {employee.getEmpId()});

        logger.info("getSalaryForEmployee for employee id " + employee.getEmpId() + " returned " + salary);
        
        employee.setSalary(salary);

        return employee;
    }

    public Employee getTotalSalaryForManager(Employee employee) {
        int total = simpleJdbcTemplate.queryForInt(QUERY_ALL_SALARIES, new Object[] {employee.getEmpId()});

        logger.info("getTotalSalaryForManager for employee id " + employee.getEmpId() + " returned " + total);
        
        employee.setTotal(total);

        return employee;
    }

    @Required
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
