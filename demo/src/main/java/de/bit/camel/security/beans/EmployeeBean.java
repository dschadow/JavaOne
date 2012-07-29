package de.bit.camel.security.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.bit.camel.security.Employee;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeBean extends AbstractBean {
    private Logger logger = Logger.getLogger(EmployeeBean.class);
    
    private static final String QUERY_FOR_EMP = "select name, job_title, department, entry_date from employees where emp_id = ?";

    public Employee getEmployeeData(final int empId) {
        logger.debug("getEmployeeData for empId " + empId);
        
        Employee emp = simpleJdbcTemplate.queryForObject(QUERY_FOR_EMP, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee emp = new Employee();
                emp.setEmpId(empId);
                emp.setName(rs.getString("name"));
                emp.setJobTitle(rs.getString("job_title"));
                emp.setDepartment(rs.getString("department"));
                emp.setEntryDate(rs.getString("entry_date"));

                return emp;
            }

        }, new Object[] {empId});
        
        logger.debug("getEmployeeData returned " + emp.toString());

        return emp;
    }
}
