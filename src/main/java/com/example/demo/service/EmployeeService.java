package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeDao employeeDao;
     
    public List<Employee> getAllEmployees()
    {
        return employeeDao.getEmployeeList();
    }
    
    public Employee getEmployeeByID(int empId)
    {
        return employeeDao.getEmployeeByID(empId);
    }
    public void addEmployee(Employee employee) {
    	employeeDao.getEmployeeList().add(employee);
    }
    
    public List<Employee> saveEmployee(Employee emp) {
    	return employeeDao.saveEmployee(emp);
    }
    public List<Employee> deleteEmployee(int id) {
    	return employeeDao.deleteEmployee(id);
    }
}