package com.example.employeepayrollspringapp.service;

import com.example.employeepayrollspringapp.dto.EmployeeDto;
import com.example.employeepayrollspringapp.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {

    List<Employee> findEmployeePayrollData();

    Employee findEmployeeById(int empId);

    Employee addEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(int empId, EmployeeDto employeeDto);

    String deleteEmployee(int empId);
}
