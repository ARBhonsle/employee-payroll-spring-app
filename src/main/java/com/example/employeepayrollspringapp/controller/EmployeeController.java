package com.example.employeepayrollspringapp.controller;

import com.example.employeepayrollspringapp.dto.EmployeeDto;
import com.example.employeepayrollspringapp.dto.ResponseDto;
import com.example.employeepayrollspringapp.model.Employee;
import com.example.employeepayrollspringapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll-service")
public class EmployeeController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"", "/", "/get"}, method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> getEmployeePayrollData() {
        List<Employee> employeeList = employeePayrollService.findEmployeePayrollData();
        ResponseDto responseDto = new ResponseDto("GET request for employee payroll data successful", employeeList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{empId}"})
    public ResponseEntity<ResponseDto> getEmployeePayrollId(@PathVariable int empId) {
        Employee employeeDto = employeePayrollService.findEmployeeById(empId);
        ResponseDto responseDto = new ResponseDto("GET request for employee record with id " + empId + " successful", employeeDto);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PostMapping(value = {"/create"})
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeePayrollService.addEmployee(employeeDto);
        ResponseDto responseDto = new ResponseDto("POST request for employee record creation successful", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable int empId, @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeePayrollService.updateEmployee(empId, employeeDto);
        ResponseDto responseDto = new ResponseDto("PUT request for employee record update successful", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollId(@PathVariable int empId) {
        String result = employeePayrollService.deleteEmployee(empId);
        ResponseDto responseDto = new ResponseDto("Delete request for employee id " + empId + " request successful", result);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
