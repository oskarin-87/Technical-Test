# Employee Management REST API (Technical Test)
It is a REST service that contains the following operations:

    • Endpoint that retrieves the list of all registered employees.
    • Endpoint that deletes an employee, requiring the registration ID as a parameter.
    • Endpoint that updates any employee data, requiring the registration ID as a parameter.
    • Endpoint that inserts one or more employees in a single request.

Perform validations with Spring Boot Validation.

Includes the jacoco plugin to validate unit test coverage.

It has logging and log configuration.

Validates whether the employee exists in the database before registering and updating; 
if registering, it does not insert if an employee with the same data already exists.

It has a custom class to deserialize the employee's birthdate in the format "dd-MM-yyyy"

## Prerequisites
```bash
* IntellijIDEA with Lombok pluggin.
* MySQL
* Modify the properties of the application.properties file corresponding to the user, password, 
and URL for the connection to MySQL.
* JAVA JDK 17
```

## Installation & Run
```bash
# Download this project
go https://github.com/oskarin-87/babel-technical-test.git
```

## Swagger
```bash
# View the Swagger documentation after starting the project on your local machine.
go http://localhost:9090/swagger-ui/index.html
```

## Structure
```
├── com.babel.technical.test.employee.management
│   ├── constants                       //Constants for some clases
│   ├── controller                      //My API RestController  
│   ├── deserializer                    //My custom deserializer for employee birthday
│   ├── exception                       //My custom Exception class
│   ├── model                           //My model
│   ├── repository                      //My repository with Spring Data JPA
│   ├── service                         //My service
│   ├── EmployeeManagementApplication   //Main Spring Boot Application
├── resources
│   ├── application.properties          //Properties file

```

## API

#### /getAllRegisterEmployees
* `GET` : Get all registered employees
```bash
curl --location 'localhost:9090/getAllRegisterEmployees' \
--data ''
```

#### deleteEmployeeById/{id}
* `DELETE` : Delete an employee by id
```bash
curl --location --request DELETE 'http://localhost:9090/deleteEmployeeById/{id}'
```

#### updateEmployee/{id}
* `PUT` : Update any employee's field 
```bash
curl --location --request PUT 'localhost:9090/updateEmployee/102' \
--header 'Content-Type: application/json' \
--data '{
    "firstName":"Oscar",
    "secondName":"",
    "lastName":"Ramirez",
    "maternalName":"Garcia",
    "age": 38,
    "gender":"male",
    "birthdate":"05-08-1987",
    "employment":"Java Developer Senior"
    }'
```

#### /addEmployees
* `POST` : Register one or more employees
```bash
curl --location 'localhost:9090/addEmployees' \
--header 'Content-Type: application/json' \
--data '[
    {
    "firstName":"Raul",
    "secondName":"",
    "lastName":"Jimenez",
    "maternalName":"Lopez",
    "age": 38,
    "gender":"male",
    "birthdate":"05-08-1987",
    "employment":"Java Developer"
    },
    {
    "firstName":"Gerardo",
    "secondName":"",
    "lastName":"Perez",
    "maternalName":"Rodriguez",
    "age": 25,
    "gender":"male",
    "birthdate":"22-01-2000",
    "employment":"Truck Driver"
    }
]'
```