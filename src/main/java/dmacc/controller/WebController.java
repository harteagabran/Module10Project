package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Employee;
import dmacc.repository.EmployeeRepository;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Mar 20, 2024
 */
@Controller
public class WebController {
	@Autowired
	EmployeeRepository repo;
	
	
	@GetMapping({"/", "/all" })
	public String ViewAll(Model model) {
		
		if(repo.findAll().isEmpty()) {
			return AddNewForm(model);
		}
		
		model.addAttribute("employees", repo.findAll());
		return "all";
	}
	@GetMapping("/addEmployee")
	public String AddNewForm(Model model) {
		model.addAttribute("newEmployee", new Employee());
		return "add";
	}
	@PostMapping("/update")
	public String Add(Employee e, Model model) {
		System.out.println(e);
		repo.save(e);
		return ViewAll(model);
	}
}
