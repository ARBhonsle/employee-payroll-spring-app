package com.example.employeepayrollspringapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
        ApplicationContext context = SpringApplication.run(EmployeePayrollSpringAppApplication.class, args);
        log.info("Employee Payroll Spring App Started");
        log.info("Environment",context.getEnvironment().getProperty("environment"));
        log.info("Employee DB username is {}",context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
