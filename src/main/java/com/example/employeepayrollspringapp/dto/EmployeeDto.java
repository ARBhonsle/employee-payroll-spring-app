package com.example.employeepayrollspringapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDto {
    private String emp_name;
    private int salary;
}
