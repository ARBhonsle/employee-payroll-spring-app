package com.example.employeepayrollspringapp.service;

import com.example.employeepayrollspringapp.dto.EmployeeDto;
import com.example.employeepayrollspringapp.dto.ResponseDto;
import com.example.employeepayrollspringapp.exceptions.EmployeeException;
import com.example.employeepayrollspringapp.model.Employee;

import java.util.List;

/**
 *  Interface of Employee Payroll Service
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
public interface IEmployeePayrollService {

    /* method to display payroll data
     *  @return employeeList
     * */
    ResponseDto findEmployeePayrollData();

    /* method to display payroll data for given empId
     *  @param empId
     *  @return employee
     * */
    ResponseDto findEmployeeById(int empId) throws EmployeeException;

    /* method to add payroll data for given employeeDto
     *  @param employeeDto
     *  @return employee
     * */
    ResponseDto addEmployee(EmployeeDto employeeDto);

    /* method to update payroll data for given empID in employeeDto
     *  @param empId, employeeDto
     *  @return employee
     * */
    ResponseDto updateEmployee(int empId, EmployeeDto employeeDto) throws EmployeeException;

    /* method to delete payroll data for given empID
     *  @param empId
     *  @return String
     * */
    ResponseDto deleteEmployee(int empId) throws EmployeeException;
}
