package com.example.backenddesign.models;

public class employee {
    private String employeeID;
    private String employeeName;
    private String employeeJob;
    private int manager;
    private String hiredate;
    private int employeeSalary;
    private int commission;
    private int departmentNumber;

    public employee(String employeeID, String employeeName, String employeeJob, int manager, String hiredate, int employeeSalary, int commission, int departmentNumber) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeJob = employeeJob;
        this.manager = manager;
        this.hiredate = hiredate;
        this.employeeSalary = employeeSalary;
        this.commission = commission;
        this.departmentNumber = departmentNumber;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public String toString() {
        return "employee{" +
                "employeeID='" + employeeID + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeJob='" + employeeJob + '\'' +
                ", manager='" + manager + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", employeeSalary='" + employeeSalary + '\'' +
                ", commission='" + commission + '\'' +
                ", departmentNumber='" + departmentNumber + '\'' +
                '}';
    }
}

