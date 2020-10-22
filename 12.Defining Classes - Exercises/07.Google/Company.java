package com.company;

public class Company {
    private String name;
    private String department;
    private Double salary;

    public Company(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }
}
