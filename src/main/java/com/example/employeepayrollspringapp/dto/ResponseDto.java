package com.example.employeepayrollspringapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * ResponseDto
 *  stores response of every http method
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
@Getter
@Setter
public class ResponseDto {
    String message;
    Object data;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
