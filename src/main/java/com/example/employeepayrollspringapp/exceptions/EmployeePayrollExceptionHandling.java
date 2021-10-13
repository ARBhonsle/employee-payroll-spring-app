package com.example.employeepayrollspringapp.exceptions;

import com.example.employeepayrollspringapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * EmployeePayrollExceptionHandler handles exceptions that are thrown due to bad http client requests and gives reponse
 *
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
@ControllerAdvice
public class EmployeePayrollExceptionHandling {
    @ExceptionHandler(value = EmployeeException.class)
    public ResponseEntity<ResponseDto> payrollExceptionHandler(EmployeeException e) {
        ResponseDto responseDto = new ResponseDto(e.getMessage(), null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
