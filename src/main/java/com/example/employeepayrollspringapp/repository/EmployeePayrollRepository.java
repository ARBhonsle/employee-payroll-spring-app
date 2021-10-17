package com.example.employeepayrollspringapp.repository;

import com.example.employeepayrollspringapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<Employee,Integer> {
}
