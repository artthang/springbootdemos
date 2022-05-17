package com.example.training.manageemployees;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component

public class EmployeeRepository {
	private static List<Employee> employeeData = new ArrayList<>();
	
	static {
		Employee james = new Employee(100, "James Cooper", 12345.0);
		Employee steven = new Employee(200, "Steven King", 2345.0);
		Employee neena = new Employee(300, "Neena Kocchar", 3456.0);
		employeeData.add(james);
		employeeData.add(steven);
		employeeData.add(neena);
	}
	
	public boolean createEmployee(Employee newEmp) {
		//Check if the employee is already present in memory array
		for(Employee emp:employeeData) {
			if(emp.getEmpId() == newEmp.getEmpId())
				return false;//if present then return false
		}
		//if not present then add employee to memory & return true
		employeeData.add(newEmp);
		return true;
	}
	
	public Employee findEmployeeById(Integer empId) {
		for(Employee emp:employeeData) {
			if(emp.getEmpId().equals(empId))
				return emp;
		}		
		return null;
	}
}
