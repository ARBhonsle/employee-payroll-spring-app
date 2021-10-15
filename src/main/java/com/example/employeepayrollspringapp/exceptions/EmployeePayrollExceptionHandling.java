package com.example.employeepayrollspringapp.exceptions;

import com.example.employeepayrollspringapp.constants.Message;
import com.example.employeepayrollspringapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<ResponseDto> payrollExceptionHandler(EmployeeException employeeException) {
        ResponseDto responseDto = new ResponseDto(Message.EXCEPTION_WHILE_REST_REQUEST.getMessage(), employeeException.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> methodArgNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException){
        List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
        List<String> errMsg =errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto(Message.EXCEPTION_WHILE_REST_REQUEST.getMessage(), errMsg);
        return new ResponseEntity<>(responseDto,HttpStatus.BAD_REQUEST);
    }
}
