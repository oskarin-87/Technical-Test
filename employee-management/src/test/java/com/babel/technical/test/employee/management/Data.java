package com.babel.technical.test.employee.management;

import com.babel.technical.test.employee.management.model.Employee;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class initializes the data that will be used by the EmployeeServiceImplTest class.
 *
 * @author Oscar Ramírez García.
 */
@Getter
public class Data {
    private final Map<String, String> headers;

    private final List<Employee> employeeListResponse;

    private final List<Employee> employeeListRequest;

    private final Employee employee1;

    private final Employee employee2;

    public Data(){
        headers = new HashMap<>();
        headers.put("user-agent", "PostmanRuntime/7.44.0");
        headers.put("accept", "*/*");
        headers.put("postman-token", "481056de-0e24-4c77-b368-611bc3832be3");
        headers.put("host", "localhost:9090");
        headers.put("accept-encoding", "gzip, deflate, br");
        headers.put("connection", "keep-alive");
        headers.put("Content-Type", "application/json;charset=UTF-8");

        employee1 = new Employee(1L,"Oscar","", "Ramirez","Garcia",38, "male",parseLocalDatetoSpecifcFormat(LocalDate.of(1987,8,5),"dd-MM-yyyy") ,"Java Senior Backend Developer");
        employee2 = new Employee(2L,"Gerardo","", "Perez","Gomez",25, "male", parseLocalDatetoSpecifcFormat(LocalDate.of(2000,1,15),"dd-MM-yyyy"),"Truck Driver");

        employeeListResponse = new ArrayList<>();
        employeeListRequest = new ArrayList<>();

        employeeListResponse.add(employee1);
        employeeListResponse.add(employee2);

        employee1.setId(null);
        employee2.setId(null);
        employeeListRequest.add(employee1);
        employeeListRequest.add(employee2);
    }

    /**
     *
     * This method formats a LocalDate according to the specified pattern.
     *
     * @param localDate that will be formatting
     * @param patternFormat specified to format the LocalDate.
     * @return the formatted LocalDate.
     */
    public LocalDate parseLocalDatetoSpecifcFormat(LocalDate localDate, String patternFormat){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternFormat);
        String formattedDate = localDate.format(formatter);
        return LocalDate.parse(formattedDate, formatter);
    }
}
