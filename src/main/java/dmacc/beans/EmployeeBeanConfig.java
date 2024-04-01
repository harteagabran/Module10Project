package dmacc.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Mar 26, 2024
 */
@Configuration
public class EmployeeBeanConfig {
	@Bean
	public Employee employee() {
		Employee e = new Employee();
		return e;
	}
}
