package com.example.employeepayrollspringapp.service;

import com.example.employeepayrollspringapp.dto.EmployeeDto;
import com.example.employeepayrollspringapp.exceptions.EmployeeException;
import com.example.employeepayrollspringapp.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee Payroll Service
 * services which manages employee payroll data
 *
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    ModelMapper modelMapper;

    // list of employees
    private static List<Employee> employeeList = new ArrayList<>();

    public List<Employee> findEmployeePayrollData() {
        return employeeList;
    }

    public Employee findEmployeeById(int empId) {
        Employee employee = employeeList.get(empId - 1);
        return employee;
    }

    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeList.size() + 1, employeeDto);
        employeeList.add(employee);
        return employee;
    }

    public Employee updateEmployee(int empId, EmployeeDto employeeDto) {
        Employee employee = this.findEmployeeById(empId);
        modelMapper.map(employeeDto, employee);
        employeeList.set(empId - 1, employee);
        return employee;
    }

    public String deleteEmployee(int empId) {
        employeeList.remove(empId - 1);
        return "Employee record with id: " + empId + " is deleted";
    }

}
