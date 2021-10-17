package com.example.employeepayrollspringapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

/**
 * EmployeeDto
 * gives access of employee details to employee services
 *
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
@Getter
@Setter
public @ToString
class EmployeeDto {
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z]{2,}\\S", message = "Name is invalid")
    @NotEmpty(message = "Employee name cannot be empty")
    private String emp_name;
    @Min(value = 500, message = "Min Salary should be more than 500")
    @NotEmpty(message = "Employee salary cannot be empty")
    private String salary;
    @Pattern(regexp = "male|female", message = "Gender is male or female")
    public String gender;
    @NotBlank(message = "Note cannot be empty")
    public String note;
    @NotBlank(message = "profilePic should not be empty")
    private String profilePic;
    @NotNull(message = "departmant should not be empty")
    public String department;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "start date should not be empty")
    @PastOrPresent(message = "start date cannot be future date")
    private LocalDate startDate;
}
