package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.Employee;
import dmacc.repository.EmployeeRepository;
import jakarta.validation.Valid;

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
		
		model.addAttribute("Employees", repo.findAll());
		return "index";
	}
	@GetMapping("/addEmployee")
	public String AddNewForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeform";
	}
	@GetMapping("/edit/{id}")
	public String EditNewForm(@PathVariable("id") long id, Model model) {
		Employee fEmp = repo.findById(id).orElse(null);
		model.addAttribute("employee", fEmp);
		return "employeeform";
		
	}
	@PostMapping("/update")
	public String Add( @Valid Employee emp, Errors errors, Model model) {
		if(null != errors && errors.getErrorCount() > 0) return "employeeform";
		var formModel = emp;
		
		repo.save(formModel);
		model.addAttribute("Alert", "Successfully Added/Updated " + formModel.firstname + " " + formModel.lastname);
		return ViewAll(model);
	}
	
	@GetMapping("/delete/{id}")
	public String Delete(@PathVariable("id") long id, Model model) {
		Employee tdel = repo.findById(id).orElse(null);
		repo.delete(tdel);
		model.addAttribute("Alert", "Successfully deleted " + tdel.firstname + " " + tdel.lastname);
		return ViewAll(model);
	}
}
