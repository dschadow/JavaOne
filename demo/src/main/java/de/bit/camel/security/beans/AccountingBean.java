package de.bit.camel.security.beans;

import org.apache.log4j.Logger;

import de.bit.camel.security.Employee;

public class AccountingBean extends AbstractBean {
    private Logger logger = Logger.getLogger(AccountingBean.class);

    private static final String QUERY_SALARY_FOR_ID = "select salary from accounting where emp_id = ?";
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
}
