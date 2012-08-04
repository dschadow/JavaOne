package de.bit.camel.security.beans;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import de.bit.camel.security.Employee;

public class AccountingBean {
    private Logger logger = Logger.getLogger(AccountingBean.class);

    private SimpleJdbcTemplate simpleJdbcTemplate;
    private static final String QUERY_SALARY_FOR_ID = "select salary from accounting where emp_emp_id = ?";
    private static final String QUERY_ALL_SALARIES = "select sum(salary) from accounting, employees where emp_id = emp_emp_id and man_id = ? ";

    public Employee getSalaryForEmployee(Employee emp) {
        logger.debug("getSalaryForEmployee for empId " + emp.getEmpId());

        int salary = simpleJdbcTemplate
                .queryForObject(QUERY_SALARY_FOR_ID, Integer.class, new Object[] {emp.getEmpId()});

        logger.debug("getSalaryForEmployee returned " + salary);
        
        emp.setSalary(salary);

        return emp;
    }

    public Employee getTotalSalaryForManager(Employee emp) {
        logger.debug("getTotalSalaryForManager for empId " + emp.getEmpId());

        int total = simpleJdbcTemplate.queryForInt(QUERY_ALL_SALARIES, new Object[] {emp.getEmpId()});

        logger.debug("getTotalSalaryForManager returned " + total);
        
        emp.setTotal(total);

        return emp;
    }

    @Required
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
