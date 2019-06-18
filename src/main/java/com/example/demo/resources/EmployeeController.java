package com.example.demo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	EmployeeController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int id) {
		return employeeService.getEmployeeByID(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Employee> saveEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public List<Employee> deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}
}