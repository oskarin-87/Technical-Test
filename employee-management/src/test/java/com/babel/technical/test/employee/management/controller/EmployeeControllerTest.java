package com.babel.technical.test.employee.management.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * This class performs unit tests of the EmployeeController class.
 *
 * @author Oscar Ramírez García.
 */
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test the getAllRegisterEmployees method.
     *
     * @throws Exception in case of any error.
     */
    @Test
    void getAllRegisterEmployeesOKTest1() throws Exception {
        mockMvc.perform(get("/getAllRegisterEmployees"))
                .andExpect(status().isOk());
    }

    /**
     * Test the deleteEmployeeById method.
     *
     * @throws Exception in case of any error.
     */
    @Test
    void deleteEmployeeByIdNotFoundTest() throws Exception {
        mockMvc.perform(delete("/deleteEmployeeById/1"))
                .andExpect(status().isNotFound());
    }

    /**
     * Test the updateEmployee method.
     *
     * @throws Exception in case of any error.
     */
    @Test
    void updateEmployeeNotFoundTest() throws Exception {
        String jsonRequest = """
                      {\
                          "firstName":"Oscar",\
                          "secondName":"",\
                          "lastName":"Ramirez",\
                          "maternalName":"Garcia",\
                          "age": 38,\
                          "gender":"male",\
                          "birthdate":"05-08-1987",\
                          "employment":"Java Developer Senior"\
                          }
                      """;
        mockMvc.perform(put("/updateEmployee/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest.replace("    ", "")))

                .andExpect(status().isNotFound());
    }

    /**
     * Test the addEmployees method.
     *
     * @throws Exception in case of any error.
     */
    @Test
    void addEmployeesTest() throws Exception {
        String jsonRequest = """
                      [{\
                          "firstName":"Oscar",\
                          "secondName":"",\
                          "lastName":"Ramirez",\
                          "maternalName":"Garcia",\
                          "age": 38,\
                          "gender":"male",\
                          "birthdate":"05-08-1987",\
                          "employment":"Java Developer Senior"\
                          }]
                      """;
        mockMvc.perform(post("/addEmployees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest.replace("    ", "")))

                .andExpect(status().isOk());
    }
}
