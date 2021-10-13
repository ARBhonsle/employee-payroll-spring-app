package com.example.employeepayrollspringapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * EmployeeDto
 *  gives access of employee details to employee services
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
@Getter
@Setter
@Data
public class EmployeeDto {
    private String emp_name;
    private int salary;

    /* constructor to set employee dto properties */
    public EmployeeDto(String emp_name, int salary) {
        this.emp_name = emp_name;
        this.salary = salary;
    }
}
