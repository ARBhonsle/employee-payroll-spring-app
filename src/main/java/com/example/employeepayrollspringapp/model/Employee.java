package com.example.employeepayrollspringapp.model;

import com.example.employeepayrollspringapp.dto.EmployeeDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private int emp_id;
    private String emp_name;
    private int salary;

    public Employee() {}

    public Employee(int emp_id, EmployeeDto employeeDto){
        this.emp_id=emp_id;
        this.emp_name=employeeDto.getEmp_name();
        this.salary=employeeDto.getSalary();
    }
}
