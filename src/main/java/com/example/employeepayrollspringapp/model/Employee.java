package com.example.employeepayrollspringapp.model;

import com.example.employeepayrollspringapp.dto.EmployeeDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Employee
 * stores employee details
 *
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
@Getter
@Setter
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;
    private String emp_name;
    private String salary;
    public String gender;
    public String note;
    private LocalDate startDate;
    private String profilePic;
    public String department;

}
