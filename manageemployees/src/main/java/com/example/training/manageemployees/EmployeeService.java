package com.example.training.manageemployees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Is to tell spring that EmployeeService is a controller
public class EmployeeService {
	
	@Autowired //Requesting for EmployeeRepository object to be injected
	private EmployeeRepository repository;
	
	//POST + http://.../employees
	@PostMapping(path = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity createEmployee(Employee emp) {
		ResponseEntity response = null;
		boolean createResult = repository.createEmployee(emp);
		if(createResult == true) {
			response = new ResponseEntity("Create successful", HttpStatus.CREATED); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Response Failed", HttpStatus.BAD_REQUEST); //returning string + 400
			return response;			
		}
	}
	
	@GetMapping(path="/employees/{empId}")
	
	public ResponseEntity getEmployee(@PathVariable("empId")Integer empId) {
		ResponseEntity response = null;
		Employee emp = repository.findEmployeeById(empId);
		if(emp != null) {
			response = new ResponseEntity(emp, HttpStatus.FOUND); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}
}
