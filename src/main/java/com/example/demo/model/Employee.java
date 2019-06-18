package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Comparable<Employee> , Serializable{
	private static final long serialVersionUID = -8809089768201955649L;
	private int id;
	private String firstName;
	private String email;
	private String lastName;
	private int salary;
	//private Date dateOfJoining;
	private String name;
	
	public Employee(int id, String firstName, String lastName, String email, Date hireDate, int salary){
		super();
		this.id = id;
		this.firstName = firstName;
		this.email = email;
		this.lastName = lastName;
		//this.dateOfJoining = hireDate;
		this.salary = salary;
	}
	
    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.salary != other.salary) {
            return false;
        }
        /*if (this.dateOfJoining != other.dateOfJoining && (this.dateOfJoining == null || !this.dateOfJoining.equals(other.dateOfJoining))) {

            return false;
        }*/
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 47 * hash + this.salary;
        //hash = 47 * hash + (this.dateOfJoining != null ? this.dateOfJoining.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ",lastName=" + lastName + ", email=" + email + ", salary=" + salary +"]";
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/*public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}