package com.babel.technical.test.employee.management.controller;

import com.babel.technical.test.employee.management.constants.EmployeeControllerConstants;
import com.babel.technical.test.employee.management.model.Employee;
import com.babel.technical.test.employee.management.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * This class exposes endpoints to the client, with the operations of
 * getting all registered employees, deleting an employee by ID, updating an employee's data,
 * and adding one or more employees to the database.
 *
 * @author Oscar Ramírez García.
 */
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = EmployeeControllerConstants.SUMMARY_GET_ALL_REGISTER_EMPLOYEES_MESSAGE ,description = EmployeeControllerConstants.DESCRIPTION_GET_ALL_REGISTER_EMPLOYEES_MESSAGE)
    @GetMapping("/getAllRegisterEmployees")
    public ResponseEntity<List<Employee>> getAllRegisterEmployees(@RequestHeader Map<String, String> headers) {
        return employeeService.getAllEmployees(headers);
    }

    @Operation(summary = EmployeeControllerConstants.SUMMARY_DELETE_EMPLOYEES_BY_ID_MESSAGE,description = EmployeeControllerConstants.DESCRIPTION_DELETE_EMPLOYEES_BY_ID_MESSAGE)
    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@RequestHeader Map<String, String> headers,
                                                         @Parameter(name = EmployeeControllerConstants.ID_PARAMETER, description = EmployeeControllerConstants.DESCRIPTION_ID_PARAMETER_EMPLOYEE_DELETED)
                                                         @PathVariable Long id){
        return employeeService.deleteEmployeeById(headers, id);

    }

    @Operation(summary = EmployeeControllerConstants.SUMMARY_UPDATE_EMPLOYEE_MESSAGE,description = EmployeeControllerConstants.DESCRIPTION_UPDATE_EMPLOYEE_MESSAGE)
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestHeader Map<String, String> headers,
                                                   @Parameter(name = EmployeeControllerConstants.NAME_NEW_EMPLOYEE_DATA, description = EmployeeControllerConstants.DESCRIPTION_NEW_EMPLOYEE_DATA)
                                                   @Valid @RequestBody Employee newEmployeeData,
                                                   @Parameter(name = EmployeeControllerConstants.ID_PARAMETER, description = EmployeeControllerConstants.DESCRIPTION_ID_PARAMETER_EMPLOYEE_UPDATED) @PathVariable Long id){
        return employeeService.updateEmployee(headers, newEmployeeData,id);
    }

    @Operation(summary = EmployeeControllerConstants.SUMMARY_ADD_EMPLOYEES_MESSAGE,description = EmployeeControllerConstants.DESCRIPTION_ADD_EMPLOYEES_MESSAGE)
    @PostMapping("/addEmployees")
    public ResponseEntity<List<Employee>> addEmployees(@RequestHeader Map<String, String> headers,
                                                       @Parameter(name = EmployeeControllerConstants.NAME_NEW_EMPLOYEE_LIST, description = EmployeeControllerConstants.DESCRIPTION_NEW_EMPLOYEE_LIST)
                                                       @Valid @RequestBody List<Employee> newEmployeeList){
        return employeeService.addEmployees(headers, newEmployeeList);
    }
}
