package com.example.employeepayrollspringapp.controller;

import com.example.employeepayrollspringapp.constants.Message;
import com.example.employeepayrollspringapp.dto.EmployeeDto;
import com.example.employeepayrollspringapp.dto.ResponseDto;
import com.example.employeepayrollspringapp.exceptions.EmployeeException;
import com.example.employeepayrollspringapp.model.Employee;
import com.example.employeepayrollspringapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Employee Controller
 * receives http requests from client and responds to server accordingly
 *
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */

@RestController
@RequestMapping("/payroll-service")
public class EmployeeController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /* method to display payroll data when client sends GET request
     * @return ResponseEntity
     * */

    @RequestMapping(value = {"", "/", "/get"}, method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> getEmployeePayrollData() {
        List<Employee> employeeList = employeePayrollService.findEmployeePayrollData();
        ResponseDto responseDto = new ResponseDto(Message.GET_ALL_SUCCESSFUL.getMessage(), employeeList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /* method to display payroll data when client sends GET request with empId in url path
     *  @param empId
     *  @return ResponseEntity
     * */

    @GetMapping(value = {"/get/{empId}"})
    public ResponseEntity<ResponseDto> getEmployeePayrollId(@PathVariable int empId) throws EmployeeException {
        Employee employeeDto = employeePayrollService.findEmployeeById(empId);
        ResponseDto responseDto = new ResponseDto(Message.GET_BY_ID_SUCCESSFUL.getMessage(), employeeDto);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /* method to store payroll data when client sends POST request with employeeDto in request body
     *  @param employeeDto
     *  @return ResponseEntity
     * */

    @PostMapping(value = {"/create"})
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeePayrollService.addEmployee(employeeDto);
        ResponseDto responseDto = new ResponseDto(Message.POST_SUCCESSFUL.getMessage(), employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /* method to update payroll data when client sends POST request with empId in url path and employeeDto in request body
     *  @param employeeDto
     *  @return ResponseEntity
     * */

    @PutMapping(value = "/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable int empId, @Valid @RequestBody EmployeeDto employeeDto) throws EmployeeException {
        Employee employee = employeePayrollService.updateEmployee(empId, employeeDto);
        ResponseDto responseDto = new ResponseDto(Message.UPDATE_BY_ID_SUCCESSFUL.getMessage(), employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /* method to delete payroll data when client sends DELETE request with empId in url path
     *  @param empId
     *  @return ResponseEntity
     * */

    @DeleteMapping(value = "/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollId(@PathVariable int empId) throws EmployeeException {
        String result = employeePayrollService.deleteEmployee(empId);
        ResponseDto responseDto = new ResponseDto(Message.DELETE_SUCCESSFUL.getMessage(), result);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
