package com.babel.technical.test.employee.management.service;

import com.babel.technical.test.employee.management.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * This interface defines the methods needed to manage employees.
 *
 * @author Oscar Ramírez García.
 */
@Service
public interface EmployeeService {

    //Definition of the method to obtain all employees registered in the database.
    ResponseEntity<List<Employee>> getAllEmployees(Map<String, String> headers);

    //Definition of the method to delete an employee registered in the database, passing its ID as a parameter.
    ResponseEntity<HttpStatus> deleteEmployeeById(Map<String, String> headers, @PathVariable Long id);

    //Definition of the method to update any data of an employee registered in the database, passing their ID as a parameter.
    ResponseEntity<Employee> updateEmployee(Map<String, String> headers, @RequestBody Employee newEmployeeData, @PathVariable Long id);

    //Definition of the method for registering one or more employees in the database.
    ResponseEntity<List<Employee>> addEmployees(Map<String, String> headers, @RequestBody List<Employee> employeeList);

}
