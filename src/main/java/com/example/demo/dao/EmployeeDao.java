package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Employee;

@SuppressWarnings("deprecation")
@Repository
public class EmployeeDao
{
    private static List<Employee> employeeList = new LinkedList<>();
    
    static
    {
    	employeeList.add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com",new Date("01/06/2019"),250));
    	employeeList.add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com",new Date("01/06/2019"),100));
    	employeeList.add(new Employee(3, "David", "Kameron", "titanic@gmail.com",new Date("01/06/2019"),150));
    	employeeList.add(new Employee(4, "Akshat", "Jain", "akshat@email.com",new Date("09/06/2019"), 200));
    	employeeList.add(new Employee(5, "Krishna","Gupta","krish@email.com",new Date("02/06/2019"), 150));
    	employeeList.add(new Employee(6, "Akshat", "Goyal", "ankit@email.com",new Date("09/06/2019"), 350));
    	employeeList.add(new Employee(7, "Surbhi", "Saxena", "surbhi@email.com",new Date("09/06/2019"), 400));
    	employeeList.add(new Employee(8, "Shefali", "Jain", "shefali@email.com",new Date("09/06/2019"), 200));
    	employeeList.add(new Employee(9, "Maina","Shankar","maina@email.com",new Date("02/06/2019"), 100));
    	employeeList.add(new Employee(10,"Ashok", "Bansal", "ashok@email.com",new Date("09/06/2019"), 320));
    }
    public List<Employee> getEmployeeList() {
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
  
    @SuppressWarnings("static-access")
	public void setEmployeeList(List<Employee> employeeList) {
    	this.employeeList = employeeList;
    }
    
	public Employee getEmployeeByID(int empId) {
		return employeeList.stream().filter(emp -> emp.getId() == empId).findFirst().orElse(null);
	}
	
	public List<Employee> saveEmployee(Employee emp) {
		int nextId = 0;
		if (employeeList.size() != 0) {
			Employee lastEmp = employeeList.stream().skip(employeeList.size() - 1).findFirst().orElse(null);
			nextId = lastEmp.getId() + 1;
		}
		emp.setId(nextId);
		employeeList.add(emp);
		return employeeList;
	}
	
	public List<Employee> deleteEmployee(int id) {
		for(Iterator<Employee> itr=employeeList.iterator();itr.hasNext();)
		{
			Employee emp = itr.next();
			int inId = emp.getId();
			if(inId == (id)){
				itr.remove();
			}
		}
		return employeeList;
	}
}
