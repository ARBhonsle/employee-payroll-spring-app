package com.example.employeepayrollspringapp.constants;
/**
 * Message for defining all responses for requests, exceptions and messages
 * @author Aditi
 * @version 0.0.1
 * @since 15-10-2021
 */
public enum Message {
    APP_STARTED_SUCCESSFULLY("Employee Payroll Spring App Started"),
    ENVIRONMENT("Environment"),
    EMPLOYEE_DB_USERNAME("Employee Payroll DB username is {}"),
    GET_ALL_SUCCESSFUL("GET request for employee payroll data successful"),
    GET_BY_ID_SUCCESSFUL("GET request for employee record with given id successful"),
    POST_SUCCESSFUL("POST request for employee record creation successful"),
    UPDATE_BY_ID_SUCCESSFUL("PUT request for employee record update successful"),
    DELETE_SUCCESSFUL("Delete request successful"),
    DELETE_SUCCESS_RESPONSE("Employee record with given id is deleted"),
    EXCEPTION_WHILE_FINDING_ID("Cannot find Employee with given id"),
    EXCEPTION_WHILE_REST_REQUEST("Exception while processing REST Request");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

