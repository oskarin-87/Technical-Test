package com.babel.technical.test.employee.management.constants;

/**
 * This class defines the constants that will be used in the employee service implementation class.
 *
 * @author Oscar Ramírez García.
 */
public final class EmployeeServiceConstants {

    //Constant to define the request start message to display for all registered users.
    public static final String STARTING_REGISTER_EMPLOYEES_MESSAGE = "Starting request of get all register employees...";

    //Constant to define the request end message to display for all registered users.
    public static final String ENDING_REGISTER_EMPLOYEES_OK_MESSAGE = "Ending request of get all register employees OK.";

    //Constant to define the error message during the request to display all registered users.
    public static final String ERROR_REGISTER_EMPLOYEES_MESSAGE = "Please contact the administrator: {}";

    //Constant to define the error message during the request to display all registered users and that will be sent to the client.
    public static final String ERROR_REGISTER_EMPLOYEES_RESPONSE_MESSAGE = "Please contact the administrator.";

    //Constant to define the message when there are no users registered in the database.
    public static final String NO_REGISTER_EMPLOYEES_MESSAGE = "There are no registered employees.";

    //Constant to define the request end message to display for all registered users with no content .
    public static final String ENDING_REGISTER_EMPLOYEES_NO_CONTENT_MESSAGE = "Ending request of get all register employees with no content.";

    //Constant to define the start message for deleting an employee by id.
    public static final String STARTING_DELETE_EMPLOYEE_MESSAGE = "Starting request of delete employee by id...";

    //Constant to define the end message for deleting an employee by id.
    public static final String ENDING_DELETE_EMPLOYEE_OK_MESSAGE = "Ending request of delete employee by id OK.";

    //Constant to define the end message for deleting an employee by id when not found in database.
    public static final String ENDING_DELETE_EMPLOYEE_NOT_FOUND_MESSAGE = "Ending request of delete employee by id [{}] because not found in database.";

    //Constant to define the start message for updating an employee.
    public static final String STARTING_UPDATE_EMPLOYEE_MESSAGE = "Starting request of update employee...";

    //Constant to define the end message for updating an employee.
    public static final String ENDING_UPDATE_EMPLOYEE_OK_MESSAGE = "Ending request of update employee OK.";

    //Constant to define the message when there is no user with the data to be updated.
    public static final String NO_REGISTER_UPDATE_EMPLOYEE_MESSAGE = "Ending request of update employee because there are no registered employee with this data.";

    //Constant to define the start message for adding one or more employees.
    public static final String STARTING_ADD_EMPLOYEES_MESSAGE = "Starting request of add employee(s)...";

    //Constant to define the end message for adding one or more employees.
    public static final String ENDING_ADD_EMPLOYEES_OK_MESSAGE = "Ending request of add employee(s) OK.";

    //Constant to define the message when a user is already registered in the database in the process of adding one or more employees.
    public static final String ALREADY_REGISTERED_EMPLOYEE_MESSAGE = "An employee with this information is already registered.";

    //Constant to define the start of the message to display the request headers.
    public static final String REQUEST_HEADERS_START_MESSAGE = "Request Headers: [";

    //Constant to define the separator character between the key and the value of each header.
    public static final String HEADERS_KEY_VALUE_SEPARATOR = ": ";

    //Constant to define the separator character between each header.
    public static final String HEADERS_SEPARATOR = ", ";

    //Constant to define the end of the message to display the request headers.
    public static final String REQUEST_HEADERS_END_MESSAGE = "]";

    private EmployeeServiceConstants(){}
}
