package com.example.demo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.Employee;
import com.example.demo.resources.EmployeeController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mvc;
	 
	@Test
	public void getAllEmployeesAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/")
	      .accept(MediaType.APPLICATION_JSON))
	      //.andDo(print())
	      //.andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].id").isNotEmpty());
	}
	 
	@Test
	public void getEmployeeByIdAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/employees/{id}", 1)
	      .accept(MediaType.APPLICATION_JSON))
	      /*.andDo(print())
	      .andExpect(status().isOk())*/
	      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(1));
	}
	
	@Test
	public void createEmployeeAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .post("/")
	      .content(asJsonString(new Employee(0, "firstName4", "lastName4", "email4@mail.com",new Date(), 100)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      //.andExpect(status().isCreated())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
	}
	 
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
}
