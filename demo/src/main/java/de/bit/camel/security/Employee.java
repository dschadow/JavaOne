package de.bit.camel.security;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    private int empId;
    private String name;
    private String jobTitle;
    private String department;
    private String entryDate;
    private int salary;
    private int total;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder emp = new StringBuilder();
        emp.append("empId ").append(empId).append(", ");
        emp.append("name ").append(name).append(", ");
        emp.append("jobTitle ").append(jobTitle).append(", ");
        emp.append("department ").append(department).append(", ");
        emp.append("entryDate ").append(entryDate).append(", ");
        emp.append("salary ").append(salary).append(", ");
        emp.append("total ").append(total);
        
        return emp.toString();
    }
}
