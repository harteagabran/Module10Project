package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Mar 20, 2024
 */
@Entity
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	public long id;
	@Getter
	@Setter
	public String firstname;
	@Getter
	@Setter
	public String lastname;
	@Getter
	@Setter
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
