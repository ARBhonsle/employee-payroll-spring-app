package com.example.employeepayrollspringapp.model;

import com.example.employeepayrollspringapp.dto.EmployeeDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

/**
 * Employee
 * stores employee details
 *
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
@Getter
@Setter
public class Employee {
    private int emp_id;
    private String emp_name;
    private String salary;

    public Employee() {
    }

    /* constructor to define employee details */
    public Employee(int emp_id, EmployeeDto employeeDto) {
        this.emp_id = emp_id;
        this.emp_name = employeeDto.getEmp_name();
        this.salary = employeeDto.getSalary();
    }
}
