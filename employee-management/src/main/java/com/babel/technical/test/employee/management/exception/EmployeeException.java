package com.babel.technical.test.employee.management.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * This class is used to deserialize the employee's birthdate according to the dd-MM-yyyy format,
 * if it does not comply with the format it displays an error.
 *
 * @author Oscar Ramírez García.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;
}
