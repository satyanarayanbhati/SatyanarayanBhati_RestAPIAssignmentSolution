package com.greatlearning.employee.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.management.entity.Employee;
import com.greatlearning.employee.management.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
		
	@ApiOperation(value = "Add Single Employee", notes = "This API allows you to add a single Employee to Employee table")
	@PostMapping("/add")
	public Employee addOrUpdateEmployee(@RequestBody Employee employee) {
		return employeeService.addOrUpdateEmployee(employee);
	}
		
	@ApiOperation(value = "List All Employees ", notes = "This API allows you get all employees from Employee table")
	@GetMapping("/list")
	public List<Employee> getAllEmployee(Employee employee) {
		return employeeService.getAllEmployee();
	}
	
	@ApiOperation(value = "Get Employee By id ", notes = "This API allows you get employee by id from Employee table")
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) throws Exception {
		
		Optional<Employee> optionalSingleEmployee =employeeService.getAEmployeeById(id);
		
		if (optionalSingleEmployee.isPresent()) {
			return  optionalSingleEmployee.get();
		} else {
			throw new Exception("employee not present");
		}
		
	}
	
	@ApiOperation(value = "Delete Employee By id ", notes = "This API allows you delete employee by id from Employee table")
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable Integer id) throws Exception {
		
		return employeeService.deleteById(id);
	
		
	}
	
	
	@ApiOperation(value = "List Employees custom sorted based on input", notes = "This API allows you list all employee records sorted in either ascending order or descending order ")
	@GetMapping("/sort")
	public List<Employee> getAllEmployeesSortedByName(@RequestParam String order) {
		return employeeService.getEmployeesCustomSortedByName(order);
	}
	
	@ApiOperation(value = "search Employees based on first name", notes = "This API allows to search employee records based on first name")
	@GetMapping("/search/{name}")
	public List<Employee> searchEmployeeByName(@PathVariable String name) {
		return employeeService.searchEmployeeByName(name);
	}
}



