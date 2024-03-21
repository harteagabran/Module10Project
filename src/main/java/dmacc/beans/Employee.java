package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Mar 20, 2024
 */
@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String firstname;
	private String lastname;
	private String position;
	
	public Employee(int id, String fn, String ln, String pos) {
		super();
		this.id = id;
		this.firstname = fn;
		this.lastname = ln;
		this.position = pos;
	}

	/**
	 * 
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
		super();
	}
}
