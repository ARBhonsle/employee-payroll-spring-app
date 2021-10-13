package com.example.employeepayrollspringapp.service;

import com.example.employeepayrollspringapp.dto.EmployeeDto;
import com.example.employeepayrollspringapp.exceptions.EmployeeException;
import com.example.employeepayrollspringapp.model.Employee;
import com.example.employeepayrollspringapp.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Employee> findEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(int empId) throws EmployeeException {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new EmployeeException("Cannot find employee payroll record with id: " + empId));
        return employee;
    }

    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        modelMapper.map(employeeDto,employee);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(int empId, EmployeeDto employeeDto) throws EmployeeException {
        Employee employee = this.findEmployeeById(empId);
        modelMapper.map(employeeDto, employee);
        employeeRepository.save(employee);
        return employee;
    }

    public String deleteEmployee(int empId) throws EmployeeException {
        Employee employee = this.findEmployeeById(empId);
        employeeRepository.delete(employee);
        return "Employee record with id: " + empId + " is deleted";
    }

}
