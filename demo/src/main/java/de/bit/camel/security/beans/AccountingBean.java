package de.bit.camel.security.beans;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import de.bit.camel.security.Employee;

public class AccountingBean extends AbstractBean {
    private Logger logger = Logger.getLogger(AccountingBean.class);

    private static final String QUERY_SALARY_BY_ID = "select salary from accounting where emp_id = ?";
    private static final String QUERY_SALARY = "";

    public int getSalaryById(Employee emp) {
        logger.debug("getSalaryById for empId " + emp.getEmpId());

        int salary = simpleJdbcTemplate
                .queryForObject(QUERY_SALARY_BY_ID, Integer.class, new Object[] {emp.getEmpId()});

        logger.debug("getSalaryById returned " + salary);

        return salary;
    }

    public List<Map<String, Object>> getSalary(Employee emp) {
        logger.debug("getSalary");

        List<Map<String, Object>> salaryByName = simpleJdbcTemplate.queryForList(QUERY_SALARY, new Object[] {});

        logger.debug("getSalary returned " + salaryByName.size());

        return salaryByName;
    }
}
