package com.babel.technical.test.employee.management.constants;

/**
 * This class defines the constants that will be used in the employee controller class.
 *
 * @author Oscar Ramírez García.
 */
public final class EmployeeControllerConstants {

    //CDefines the message displayed in the summary of the getAllRegisterEmployees method.
    public static final String SUMMARY_GET_ALL_REGISTER_EMPLOYEES_MESSAGE = "Get all registered employees.";

    //Defines the message displayed in the description of the getAllRegisterEmployees method.
    public static final String DESCRIPTION_GET_ALL_REGISTER_EMPLOYEES_MESSAGE = "This method returns a list of all employees registered in the database.";

    //Defines the message displayed in the summary of the deleteEmployeeById method.
    public static final String SUMMARY_DELETE_EMPLOYEES_BY_ID_MESSAGE = "Delete an employee by id.";

    //Defines the message displayed in the description of the deleteEmployeeById method.
    public static final String DESCRIPTION_DELETE_EMPLOYEES_BY_ID_MESSAGE = "This method deletes an employee from the database using their id.";

    //Defines the message displayed in the summary of the updateEmployee method.
    public static final String SUMMARY_UPDATE_EMPLOYEE_MESSAGE = "Update an employee.";

    //Defines the message displayed in the description of the updateEmployee method.
    public static final String DESCRIPTION_UPDATE_EMPLOYEE_MESSAGE = "This method updates an employee's data in the database.";

    //Defines the message displayed in the summary of the addEmployees method.
    public static final String SUMMARY_ADD_EMPLOYEES_MESSAGE = "Insert one or more employees.";

    //Defines the message displayed in the description of the addEmployees method.
    public static final String DESCRIPTION_ADD_EMPLOYEES_MESSAGE = "This method inserts one or more employees into the database.";

    //Defines the name of the id parameter.
    public static final String ID_PARAMETER = "id";

    //Defines the description of the id parameter of the employee to be deleted.
    public static final String DESCRIPTION_ID_PARAMETER_EMPLOYEE_DELETED = "Employee ID that will be deleted.";

    //Defines the name of the newEmployeeData parameter.
    public static final String NAME_NEW_EMPLOYEE_DATA = "newEmployeeData";

    //Defines the description of the newEmployeeData parameter.
    public static final String DESCRIPTION_NEW_EMPLOYEE_DATA = "New employee data that will be updated.";

    //Defines the description of the id parameter of the employee to be updated.
    public static final String DESCRIPTION_ID_PARAMETER_EMPLOYEE_UPDATED = "Employee ID that will be updated.";

    //Defines the name of the newEmployeeList parameter.
    public static final String NAME_NEW_EMPLOYEE_LIST = "newEmployeeList";

    //Defines the description of the newEmployeeList parameter.
    public static final String DESCRIPTION_NEW_EMPLOYEE_LIST = "List of one or more employees who will be registered in the database.";

    private EmployeeControllerConstants(){}
}
