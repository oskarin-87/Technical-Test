package com.babel.technical.test.employee.management.deserializer;

import com.babel.technical.test.employee.management.constants.EmployeeConstants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 * This class is used to deserialize the employee's birthdate according to the dd-MM-yyyy format,
 * if it does not comply with the format it displays an error.
 *
 * @author Oscar Ramírez García.
 */
public class MyLocalDateDeserializer extends JsonDeserializer<LocalDate>{

    /**
     *
     * This method overrides the default method so that the employee's birthdate is found according to the dd-MM-yyyy format,
     * if it does not comply with the format it displays an error.
     *
     */
    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext c) throws IOException {
        String dateString = p.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(EmployeeConstants.BIRTH_DATE_PATTERN, Locale.getDefault());
        return LocalDate.parse(dateString, formatter);
    }
}
