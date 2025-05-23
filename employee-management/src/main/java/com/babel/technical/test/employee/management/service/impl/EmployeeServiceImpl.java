package com.babel.technical.test.employee.management.service.impl;

import com.babel.technical.test.employee.management.constants.EmployeeServiceConstants;
import com.babel.technical.test.employee.management.exception.EmployeeException;
import com.babel.technical.test.employee.management.model.Employee;
import com.babel.technical.test.employee.management.repository.EmployeeRepository;
import com.babel.technical.test.employee.management.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This class implements the methods needed to manage employees.
 *
 * @author Oscar Ramírez García.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    //Dependency injection by constructor.
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     *
     * This method implements the business logic to obtain the list of registered users in the database.
     *
     * @param headers contains the request headers.
     * @return a list of Employee objects with the employees registered in the database.
     */
    @Override
    public ResponseEntity<List<Employee>> getAllEmployees(Map<String, String> headers) {
        logger.debug(EmployeeServiceConstants.STARTING_REGISTER_EMPLOYEES_MESSAGE);
        logger.info(getHeaders(headers));
        try {
            List<Employee> employeeList = new ArrayList<>();
            employeeRepository.findAll().forEach(employeeList::add);

            if(employeeList.isEmpty()) {

                logger.debug(EmployeeServiceConstants.NO_REGISTER_EMPLOYEES_MESSAGE);
                logger.debug(EmployeeServiceConstants.ENDING_REGISTER_EMPLOYEES_NO_CONTENT_MESSAGE);
                return new ResponseEntity<>(employeeList, HttpStatus.NO_CONTENT);
            }
            logger.debug(EmployeeServiceConstants.ENDING_REGISTER_EMPLOYEES_OK_MESSAGE);
            return new ResponseEntity<>(employeeList, HttpStatus.OK);

        } catch( Exception  e) {
            logger.error(EmployeeServiceConstants.ERROR_REGISTER_EMPLOYEES_MESSAGE,e);
            return new ResponseEntity<>(new EmployeeException(EmployeeServiceConstants.ERROR_REGISTER_EMPLOYEES_RESPONSE_MESSAGE,HttpStatus.INTERNAL_SERVER_ERROR).getHttpStatus());
        }
    }

    /**
     *
     * This method deletes an employee from the database using their id.
     *
     * @param headers contains the request headers.
     * @param id contains the Employee´s id that will be deleted.
     * @return
     */
    @Override
    public ResponseEntity<HttpStatus> deleteEmployeeById(Map<String, String> headers, Long id) {
        logger.debug(EmployeeServiceConstants.STARTING_DELETE_EMPLOYEE_MESSAGE);
        logger.info(getHeaders(headers));
        Optional<Employee> employeeToBeDeleted = employeeRepository.findById(id);
        if(employeeToBeDeleted.isPresent()){
            employeeRepository.deleteById(id);
            logger.debug(EmployeeServiceConstants.ENDING_DELETE_EMPLOYEE_OK_MESSAGE);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            logger.debug(EmployeeServiceConstants.ENDING_DELETE_EMPLOYEE_NOT_FOUND_MESSAGE,id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * This method updates an employee's data in the database.
     *
     * @param headers contains the request headers.
     * @param newEmployeeData contains the Employee`s data that will be updated.
     * @param id contains the Employee´s id that will be deleted.
     * @return the Employee object with the updated data.
     */
    @Override
    public ResponseEntity<Employee> updateEmployee(Map<String, String> headers, Employee newEmployeeData, Long id) {
        logger.debug(EmployeeServiceConstants.STARTING_UPDATE_EMPLOYEE_MESSAGE);
        logger.info(getHeaders(headers));

        Optional<Employee> oldEmployeeData = employeeRepository.findById(id);

        if(oldEmployeeData.isPresent()) {
            Employee updatedEmployeeData = oldEmployeeData.get();
            updatedEmployeeData.setFirstName(newEmployeeData.getFirstName());
            updatedEmployeeData.setSecondName(newEmployeeData.getSecondName());
            updatedEmployeeData.setLastName(newEmployeeData.getLastName());
            updatedEmployeeData.setMaternalName(newEmployeeData.getMaternalName());
            updatedEmployeeData.setAge(newEmployeeData.getAge());
            updatedEmployeeData.setGender(newEmployeeData.getGender());
            updatedEmployeeData.setBirthdate(newEmployeeData.getBirthdate());
            updatedEmployeeData.setEmployment(newEmployeeData.getEmployment());

            Employee employeeObj = employeeRepository.save(updatedEmployeeData);
            logger.debug(EmployeeServiceConstants.ENDING_UPDATE_EMPLOYEE_OK_MESSAGE);
            return new ResponseEntity<>(employeeObj, HttpStatus.OK);

        }
        logger.debug(EmployeeServiceConstants.NO_REGISTER_UPDATE_EMPLOYEE_MESSAGE);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     *
     * This method inserts one or more employees into the database.
     *
     * @param headers contains the request headers.
     * @param newEmployeeList List of one or more employees who will be registered in the database.
     * @return List of one or more employees registered in the database.
     */
    @Override
    public ResponseEntity<List<Employee>> addEmployees(Map<String, String> headers, List<Employee> newEmployeeList) {
        logger.debug(EmployeeServiceConstants.STARTING_ADD_EMPLOYEES_MESSAGE);
        logger.info(getHeaders(headers));
        List<Employee> resultEmployeeList = new ArrayList<>();
        newEmployeeList.forEach( (e) -> {
                Example<Employee> example = Example.of(e);
                Optional<Employee> oldEmployeeData = employeeRepository.findOne(example);
                if(oldEmployeeData.isPresent()) {
                    logger.info(EmployeeServiceConstants.ALREADY_REGISTERED_EMPLOYEE_MESSAGE);

                }else{
                    resultEmployeeList.add(employeeRepository.save(e));
                }
            }
        );
        logger.debug(EmployeeServiceConstants.ENDING_ADD_EMPLOYEES_OK_MESSAGE);
        return new ResponseEntity<>(resultEmployeeList, HttpStatus.OK);
    }

    /**
     *
     * This method constructs a String with the key:value pair from the request headers.
     *
     * @param headers contains the request headers.
     * @return a String with the key:value pair from the request headers.
     */
    public String getHeaders(Map<String, String> headers){
        StringBuilder result = new StringBuilder(EmployeeServiceConstants.REQUEST_HEADERS_START_MESSAGE);
        if(headers != null){
            headers.forEach((key, value) -> {
                result.append(key);
                result.append(EmployeeServiceConstants.HEADERS_KEY_VALUE_SEPARATOR);
                result.append(value);
                result.append(EmployeeServiceConstants.HEADERS_SEPARATOR);
            });
            result.delete(result.length()-2,result.length());
        }
        result.append(EmployeeServiceConstants.REQUEST_HEADERS_END_MESSAGE);
        return result.toString();
    }

}
