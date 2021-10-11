package com.example.employeepayrollspringapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private String emp_name;
    private int salary;

    public EmployeeDto(String emp_name, int salary) {
        this.emp_name = emp_name;
        this.salary = salary;
    }
}
