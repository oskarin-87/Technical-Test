package com.babel.technical.test.employee.management.repository;

import com.babel.technical.test.employee.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class implements the CRUD operations defined in the Spring Data JPA API.
 *
 * @author Oscar Ramírez García.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
