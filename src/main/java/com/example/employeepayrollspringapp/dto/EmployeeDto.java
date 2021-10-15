package com.example.employeepayrollspringapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * EmployeeDto
 * gives access of employee details to employee services
 *
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
@Getter
@Setter
public class EmployeeDto {
    @Pattern(regexp = "[A-Z][a-zA-Z]{2,}", message = "Name is invalid")
    @NotEmpty(message = "Employee name cannot be empty")
    private String emp_name;
    @Min(value = 500, message = "Min Salary should be more than 500")
    @NotEmpty(message = "Employee salary cannot be empty")
    private String salary;

    /* constructor to set employee dto properties */
    public EmployeeDto(String emp_name, String salary) {
        this.emp_name = emp_name;
        this.salary = salary;
    }
}
