package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Mar 20, 2024
 */
@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@NotEmpty(message = "Can't be empty!")
	@Size(min = 2, message = "Must be at least 2 chars")
	public String firstname;
	@NotEmpty(message = "Can't be empty!")
	@Size(min = 2, message = "Must be at least 2 chars")
	public String lastname;
	@NotEmpty(message = "Can't be empty!")
	@Size(min = 2, message = "Must be at least 2 chars")
	public String position;
	
	public Employee(long id, String fn, String ln, String pos) {
		super();
		this.id = id;
		this.firstname = fn;
		this.lastname = ln;
		this.position = pos;
	}
	public Employee() { super();}
}
