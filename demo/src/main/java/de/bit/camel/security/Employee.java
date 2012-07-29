package de.bit.camel.security;

public class Employee {
    private int empId;
    private String name;
    private String jobTitle;
    private String department;
    private String entryDate;
    private int salary;

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
    
    @Override
    public String toString() {
        StringBuilder emp = new StringBuilder();
        emp.append("empId ").append(empId);
        emp.append("name ").append(name);
        emp.append("jobTitle ").append(jobTitle);
        emp.append("department ").append(department);
        emp.append("entryDate ").append(entryDate);
        emp.append("salary ").append(salary);
        
        return emp.toString();
    }
}
