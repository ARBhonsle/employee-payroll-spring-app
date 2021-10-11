package com.example.employeepayrollspringapp.controller;

import com.example.employeepayrollspringapp.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll-service")
public class EmployeeController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("GET request for employee payroll data successful", HttpStatus.OK);
    }

    @GetMapping(value = {"/get/{empId}"})
    public ResponseEntity<String> getEmployeePayrollId(@PathVariable int empId) {
        return new ResponseEntity<String>("GET request for employee record with id " + empId + " successful", HttpStatus.OK);
    }

    @PostMapping(value = {"/create"})
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<String>("POST request for employee record creation successful", HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<String>("PUT request for employee record update successful", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollId(@PathVariable int empId) {
        return new ResponseEntity<String>("Delete request for employee id " + empId + " request successful", HttpStatus.OK);
    }
}
