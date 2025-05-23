package com.babel.technical.test.employee.management.model;

import com.babel.technical.test.employee.management.constants.EmployeeConstants;
import com.babel.technical.test.employee.management.deserializer.MyLocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


/**
 * This class represents an employee record in the database.
 *
 * @author Oscar Ramírez García.
 */
@Entity
@Table(name="Employee")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = EmployeeConstants.FIRST_NAME_MANDATORY_MESSAGE)
    private String firstName;

    private String secondName;

    @NotBlank(message = EmployeeConstants.LAST_NAME_MANDATORY_MESSAGE)
    private String lastName;

    private String maternalName;

    @Min(EmployeeConstants.MIN_AGE)
    @Positive
    private int age;

    private String gender;

    @Past
    @JsonDeserialize(using = MyLocalDateDeserializer.class)
    private LocalDate birthdate;

    @NotBlank(message = EmployeeConstants.EMPLOYMENT_MANDATORY_MESSAGE)
    private String employment;
}
