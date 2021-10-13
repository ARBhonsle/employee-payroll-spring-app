package com.example.employeepayrollspringapp.repository;

import com.example.employeepayrollspringapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Employee
 * stores employee details
 * @author Aditi
 * @version 0.0.1
 * @since 11-10-2021
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
