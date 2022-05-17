package com.example.training.manageemployees;

public class Employee {
	private Integer empId;
	private String empName;
	private Double salary;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Employee() {		
	}
	public Employee(Integer eid, String eName, Double salary) {
		this.empId = eid;
		this.empName = eName;
		this.salary = salary;
	}
}
