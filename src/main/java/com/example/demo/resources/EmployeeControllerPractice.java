/*package com.example.demo.resources;

import java.util.ArrayList;
import java.util.Iterator;
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
@RequestMapping(value = "/practice/employees")
public class EmployeeControllerPractice {
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	@Autowired
	private EmployeeService employeeService;
	
	EmployeeController() {
		this.employees = buildEmployees();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return this.employees;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") Long id) {
		return this.employees.stream().filter(emp -> emp.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Employee> saveEmployee(@RequestBody Employee emp) {
		Long nextId = 0L;
		if (this.employees.size() != 0) {
			Employee lastEmp = this.employees.stream().skip(this.employees.size() - 1).findFirst().orElse(null);
			nextId = lastEmp.getId() + 1;
		}
		emp.setId(nextId);
		this.employees.add(emp);
		return this.employees;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public List<Employee> deleteEmployee(@PathVariable Long id) {
		for(Iterator<Employee> itr=this.employees.iterator();itr.hasNext();)
		{
			Employee emp = itr.next();
			Long inId = emp.getId();
			if(inId == (id)){
				itr.remove();
			}
		}
		return this.employees;
	}
	
	List<Employee> buildEmployees() {
		
		List<Employee> emps = new ArrayList<>();
		emps = employeeService.getAllEmployees();
		return emps;
		
		Employee emp1 = buildEmployee(1L, "venu", 9553226588L, "venu@email.com");
		Employee emp2 = buildEmployee(2L, "krishna", 8654782255L, "krish@email.com");
		emps.add(emp1);
		emps.add(emp2);
		return emps;
	}
	
	Employee buildEmployee(Long id, String fname, Long phoneNo, String email) {
		Employee emp = new Employee(id, fname, phoneNo, email);
		return emp;
	}
	
	@GetMapping(path="/sortBySalary", produces = "application/json")
	public List<Employee1> getEmployeesSortBySalary()
	{
		return employeeService.getEmployeesSortBySalary();
	}
	
	@GetMapping(path="/sortByName", produces = "application/json")
	public List<Employee1> getEmployeesSortByName()
	{
		return employeeService.getEmployeesSortByName();
	}
	
	@GetMapping(path="/sortByDoj", produces = "application/json")
	public List<Employee1> getEmployeesSortByDateOfJoining()
	{
		return employeeService.getEmployeesSortByDateOfJoining();
	}
}*/