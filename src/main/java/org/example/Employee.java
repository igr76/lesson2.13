package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {
    private int id;
    @JsonProperty
    private String name;
    private int department;
    private static double salary;
    private int counter;

    public Employee(String name, int department,double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = ++counter;


    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        Employee.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }


}

