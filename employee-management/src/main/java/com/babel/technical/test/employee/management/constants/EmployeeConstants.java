package com.babel.technical.test.employee.management.constants;

/**
 * This class defines the constants that will be used in the employee class model.
 *
 * @author Oscar Ramírez García.
 */
public final class EmployeeConstants {
    //Constant to define the message to be displayed when the first name is not sent in the request.
    public static final String FIRST_NAME_MANDATORY_MESSAGE = "First Name is mandatory.";

    //Constant to define the message to be displayed when the last name is not sent in the request.
    public static final String LAST_NAME_MANDATORY_MESSAGE = "Last Name is mandatory.";

    //Constant to define the message to be displayed when the employment is not sent in the request.
    public static final String EMPLOYMENT_MANDATORY_MESSAGE = "Employment is mandatory.";

    //Constant to define the pattern used in the birthdate.
    public static final String BIRTH_DATE_PATTERN = "dd-MM-yyyy";

    //Constant to define the minimum age of an employee.
    public static final int MIN_AGE = 18;


    private EmployeeConstants() {}
}
