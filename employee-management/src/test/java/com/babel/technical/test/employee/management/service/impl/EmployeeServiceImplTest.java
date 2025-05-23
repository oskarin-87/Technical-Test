package com.babel.technical.test.employee.management.service.impl;

import com.babel.technical.test.employee.management.Data;
import com.babel.technical.test.employee.management.constants.EmployeeServiceConstants;
import com.babel.technical.test.employee.management.exception.EmployeeException;
import com.babel.technical.test.employee.management.model.Employee;
import com.babel.technical.test.employee.management.repository.EmployeeRepository;
import com.babel.technical.test.employee.management.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * This class performs unit tests of the EmployeeService interface.
 *
 * @author Oscar Ramírez García.
 */
@SpringBootTest
class EmployeeServiceImplTest {

    @MockitoBean
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    Map<String, String> headers;

    List<Employee> employeeListResponse;

    List<Employee> employeeListRequest;

    Employee employee1;

    Employee employee2;

    /**
     * Method to initialize data before each test.
     *
     */
    @BeforeEach
    void setUp() {
        Data data = new Data();
        headers = data.getHeaders();
        employee1 = data.getEmployee1();
        employee2 = data.getEmployee2();
        employeeListResponse = data.getEmployeeListResponse();
        employeeListRequest = data.getEmployeeListRequest();
    }

    /**
     * Test the getAllEmployees method when it returns OK response.
     *
     */
    @Test
    void getAllEmployeesTestOK() {
        ResponseEntity<List<Employee>> listResponseEntity = new ResponseEntity<>(employeeListResponse, HttpStatus.OK);
        when(employeeRepository.findAll()).thenReturn(employeeListResponse);
        assertEquals(listResponseEntity,employeeService.getAllEmployees(headers));
    }

    /**
     * Test the getAllEmployees method when it returns NO_CONTENT response.
     *
     */
    @Test
    void getAllEmployeesTestNoContent() {
        employeeListResponse = new ArrayList<>();
        ResponseEntity<List<Employee>> listResponseEntity = new ResponseEntity<>(employeeListResponse, HttpStatus.NO_CONTENT);
        when(employeeRepository.findAll()).thenReturn(employeeListResponse);
        assertEquals(listResponseEntity,employeeService.getAllEmployees(null));
    }

    /**
     * Test the getAllEmployees method when it returns INTERNAL_SERVER_ERROR response.
     *
     */
    @Test
    void getAllEmployeesInternalServerErrorTest() {
        ResponseEntity<List<Employee>> listResponseEntity = new ResponseEntity<>(
                new EmployeeException(EmployeeServiceConstants.ERROR_REGISTER_EMPLOYEES_RESPONSE_MESSAGE,HttpStatus.INTERNAL_SERVER_ERROR).getHttpStatus());
        when(employeeRepository.findAll()).thenThrow(new RuntimeException());
        assertEquals(listResponseEntity,employeeService.getAllEmployees(headers));
    }

    /**
     * Test the deleteEmployeeById method when it returns OK response.
     *
     */
    @Test
    void deleteEmployeeByIdOKTest() {
        ResponseEntity<HttpStatus> responseEntityOk = new ResponseEntity<>(HttpStatus.OK);
        Optional<Employee> employeeWillBeDeleted = Optional.of(employee1);
        when(employeeRepository.findById(1L)).thenReturn(employeeWillBeDeleted);
        assertEquals(responseEntityOk,employeeService.deleteEmployeeById(headers,1L)) ;
    }

    /**
     * Test the deleteEmployeeById method when it returns NOT_FOUND response.
     *
     */
    @Test
    void deleteEmployeeByIdNotFoundTest() {
        ResponseEntity<HttpStatus> responseEntityNotFound = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Optional<Employee> employeeWillBeDeleted = Optional.empty();
        when(employeeRepository.findById(1L)).thenReturn(employeeWillBeDeleted);
        assertEquals(responseEntityNotFound,employeeService.deleteEmployeeById(headers,1L)) ;
    }

    /**
     * Test the updateEmployee method when it returns OK response.
     *
     */
    @Test
    void updateEmployeeOKTest() {
        ResponseEntity<Employee> responseEntityOk = new ResponseEntity<>(employee1, HttpStatus.OK);
        Optional<Employee> employeeWillBeUpdated = Optional.of(employee1);
        when(employeeRepository.findById(1L)).thenReturn(employeeWillBeUpdated);
        when(employeeRepository.save(employee1)).thenReturn(employee1);
        assertEquals(responseEntityOk,employeeService.updateEmployee(headers,employee1,1L));
    }

    /**
     * Test the updateEmployee method when it returns NOT_FOUND response.
     *
     */
    @Test
    void updateEmployeeNotFoundTest() {
        ResponseEntity<Employee> responseEntityNotFound = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Optional<Employee> employeeWillBeUpdated = Optional.empty();
        when(employeeRepository.findById(1L)).thenReturn(employeeWillBeUpdated);
        assertEquals(responseEntityNotFound,employeeService.updateEmployee(headers,employee1,1L));
    }

    /**
     * Test the addEmployees method when an employee is already registered in the database.
     *
     */
    @Test
    void addEmployeesAlreadyRegisteredTest() {
        ResponseEntity<List<Employee>> responseEntityOk = new ResponseEntity<>(employeeListRequest, HttpStatus.OK);
        Optional<Employee> oldEmployeeData = Optional.of(employee1);
        when(employeeRepository.findOne(Mockito.any(Example.class))).thenReturn(oldEmployeeData);
        employeeListRequest.remove(0);
        employeeListRequest.remove(0);
        assertEquals(responseEntityOk,employeeService.addEmployees(headers,employeeListRequest));
    }

    /**
     * Test the addEmployees method when an employee isn't registered in the database.
     *
     */
    @Test
    void addEmployeesNoRegisteredTest() {
        ResponseEntity<List<Employee>> responseEntityOk = new ResponseEntity<>(employeeListRequest, HttpStatus.OK);
        Optional<Employee> oldEmployeeData = Optional.empty();
        Example<Employee> example = Example.of(employee1);
        when(employeeRepository.findOne(example)).thenReturn(oldEmployeeData);
        when(employeeRepository.save(employee1)).thenReturn(employee1);
        employeeListRequest.remove(0);
        employeeListRequest.remove(0);
        assertEquals(responseEntityOk,employeeService.addEmployees(headers,employeeListRequest));
    }
}