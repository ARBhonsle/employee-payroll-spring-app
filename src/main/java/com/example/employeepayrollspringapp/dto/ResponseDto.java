package com.example.employeepayrollspringapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
