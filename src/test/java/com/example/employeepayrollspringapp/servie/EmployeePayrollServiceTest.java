package com.example.employeepayrollspringapp.servie;

import com.example.employeepayrollspringapp.constants.Message;
import com.example.employeepayrollspringapp.dto.EmployeeDto;
import com.example.employeepayrollspringapp.dto.ResponseDto;
import com.example.employeepayrollspringapp.exceptions.EmployeeException;
import com.example.employeepayrollspringapp.model.Employee;
import com.example.employeepayrollspringapp.repository.EmployeePayrollRepository;
import com.example.employeepayrollspringapp.service.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeePayrollServiceTest {
    @InjectMocks
    EmployeePayrollService employeePayrollService;

    @Mock
    EmployeePayrollRepository employeePayrollRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private List<Employee> employeeList;

    @BeforeEach
    void setUp() {
        employeeList = new ArrayList<>();
    }

    @Test
    public void findEmployeePayrollData_shouldReturnListInResponseDto() {
        Employee employee = new Employee();
        employee.setEmp_name("Terissa");
        Employee employee1 = new Employee();
        employee.setEmp_name("Simpson");
        employeeList.add(employee);
        employeeList.add(employee1);
        Mockito.when(employeePayrollRepository.findAll()).thenReturn(employeeList);
        ResponseDto responseDto = employeePayrollService.findEmployeePayrollData();
        Assertions.assertEquals(employeeList, responseDto.getData());
    }

    @Test
    public void findEmployeeById_shouldReturnEmployeeInResponseDto() throws EmployeeException {
        Employee employee = new Employee();
        employee.setEmp_name("Terissa");
        employeeList.add(employee);
        Mockito.when(employeePayrollRepository.findById(1)).thenReturn(Optional.of(employee));
        ResponseDto responseDto = employeePayrollService.findEmployeeById(1);
        Assertions.assertNotNull(responseDto.getData());
        Mockito.verify(employeePayrollRepository, Mockito.times(1)).findById(1);
    }

    @Test
    public void findEmployeeById_shouldThrowException() {
        Mockito.when(employeePayrollRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertNotNull(Assertions.assertThrows(EmployeeException.class, () -> employeePayrollService.findEmployeeById(1)));
        Mockito.verify(employeePayrollRepository, Mockito.times(1)).findById(1);
    }

    @Test
    public void addEmployee_shouldAddEmployeeAndReturnResponseDto() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmp_name("Terissa");
        Employee employee = new Employee();
        employee.setEmp_name(employeeDto.getEmp_name());
        Mockito.when(employeePayrollRepository.save(employee)).thenReturn(employee);
        ResponseDto responseDto = employeePayrollService.addEmployee(employeeDto);
        Assertions.assertNotNull(responseDto.getData());
        Assertions.assertEquals(employee, responseDto.getData());
        Mockito.verify(employeePayrollRepository, Mockito.times(1)).save(employee);
    }

    @Test
    public void updateEmployee_shouldReturnUpdatedEmployeeInResponseDto() throws EmployeeException {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmp_name("Terissa");
        Employee employee = new Employee();
        employee.setEmp_name("Tabby");
        Mockito.when(employeePayrollRepository.findById(1)).thenReturn(Optional.of(employee));
        employee.setEmp_name(employeeDto.getEmp_name());
        Mockito.when(employeePayrollRepository.save(employee)).thenReturn(employee);
        ResponseDto responseDto = employeePayrollService.updateEmployee(1, employeeDto);
        Assertions.assertNotNull(responseDto.getData());
        Assertions.assertEquals(employee, responseDto.getData());
        Mockito.verify(employeePayrollRepository, Mockito.times(1)).save(employee);
    }

    @Test
    public void updateEmployee_shouldThrowException() {
        Mockito.when(employeePayrollRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertNotNull(Assertions.assertThrows(EmployeeException.class, () -> employeePayrollService.findEmployeeById(1)));
        Mockito.verify(employeePayrollRepository, Mockito.times(1)).findById(1);
    }

    @Test
    public void deleteEmployee_shouldReturnStringMessageInResponseDto() throws EmployeeException {
        Employee employee = new Employee();
        employee.setEmp_name("Terissa");
        Mockito.when(employeePayrollRepository.findById(1)).thenReturn(Optional.of(employee));
        Assertions.assertNotNull(employee);
        ResponseDto responseDto = employeePayrollService.deleteEmployee(1);
        Assertions.assertEquals(Message.DELETE_SUCCESS_RESPONSE.getMessage(),responseDto.getData());
    }

    @Test
    public void deleteEmployee_shouldThrowException(){
        Mockito.when(employeePayrollRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertNotNull(Assertions.assertThrows(EmployeeException.class, () -> employeePayrollService.findEmployeeById(1)));
        Mockito.verify(employeePayrollRepository, Mockito.times(1)).findById(1);
    }
}
