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
    private String gender;
    private String note;
    private LocalDate startDate;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    private List<String> department;

    public Employee() {
    }

    public Employee(EmployeeDto employeeDto){
        this.updateEmployee(employeeDto);
    }

    public void updateEmployee(EmployeeDto employeeDto) {
        this.emp_name = employeeDto.getEmp_name();
        this.salary = employeeDto.getSalary();
        this.department = employeeDto.getDepartment();
        this.gender = employeeDto.getGender();
        this.note = employeeDto.getNote();
        this.startDate = employeeDto.getStartDate();
        this.profilePic = employeeDto.getProfilePic();
    }
}
