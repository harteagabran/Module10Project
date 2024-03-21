package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Employee;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Mar 20, 2024
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
