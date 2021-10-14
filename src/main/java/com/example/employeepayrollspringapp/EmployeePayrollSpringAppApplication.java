package com.example.employeepayrollspringapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * EmployeePayrollSpringAppApplication
 *  SpringBootApplication runs main method to execute all methods, accept http requests from clients and give their responses & perform respective functions
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
@Slf4j
@SpringBootApplication
public class EmployeePayrollSpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollSpringAppApplication.class, args);
        log.info("Employee Payroll Spring App Started");
    }

}
