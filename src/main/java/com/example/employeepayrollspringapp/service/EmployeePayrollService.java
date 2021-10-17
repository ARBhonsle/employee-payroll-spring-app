package com.example.employeepayrollspringapp.service;

import com.example.employeepayrollspringapp.constants.Message;
import com.example.employeepayrollspringapp.dto.EmployeeDto;
import com.example.employeepayrollspringapp.dto.ResponseDto;
import com.example.employeepayrollspringapp.exceptions.EmployeeException;
import com.example.employeepayrollspringapp.model.Employee;
import com.example.employeepayrollspringapp.repository.EmployeePayrollRepository;
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
    private EmployeePayrollRepository employeePayrollRepository;

    @Autowired
    ModelMapper modelMapper;

    public ResponseDto findEmployeePayrollData() {
        ResponseDto responseDto = new ResponseDto(Message.GET_ALL_SUCCESSFUL.getMessage(), employeePayrollRepository.findAll());
        return responseDto;
    }

    private Employee getEmployeeById(int empId) throws EmployeeException {
        return employeePayrollRepository.findById(empId).orElseThrow(() -> new EmployeeException(Message.EXCEPTION_WHILE_FINDING_ID.getMessage()));
    }

    public ResponseDto findEmployeeById(int empId) throws EmployeeException {
        Employee employee = this.getEmployeeById(empId);
        ResponseDto responseDto = new ResponseDto(Message.GET_BY_ID_SUCCESSFUL.getMessage(), employee);
        return responseDto;
    }

    public ResponseDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        modelMapper.map(employeeDto, employee);
        employeePayrollRepository.save(employee);
        ResponseDto responseDto = new ResponseDto(Message.POST_SUCCESSFUL.getMessage(), employee);
        return responseDto;
    }

    public ResponseDto updateEmployee(int empId, EmployeeDto employeeDto) throws EmployeeException {
        Employee employee = this.getEmployeeById(empId);
        modelMapper.map(employeeDto, employee);
        employeePayrollRepository.save(employee);
        ResponseDto responseDto = new ResponseDto(Message.UPDATE_BY_ID_SUCCESSFUL.getMessage(), employee);
        return responseDto;
    }

    public ResponseDto deleteEmployee(int empId) throws EmployeeException {
        Employee employee = this.getEmployeeById(empId);
        employeePayrollRepository.delete(employee);
        ResponseDto responseDto = new ResponseDto(Message.DELETE_SUCCESSFUL.getMessage(), Message.DELETE_SUCCESS_RESPONSE.getMessage());
        return responseDto;
    }

}
