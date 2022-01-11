package com.springboot.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springboot.demo.TeaCoffeeVendingMachineApplication;

@SpringBootTest(classes = TeaCoffeeVendingMachineApplication.class)
class TestCourseController {

//	@Autowired
//	CourseController courseController;
	
	MockMvc mvc;
	
	@BeforeEach
	public void setUp() {
//		mvc= MockMvcBuilders.standaloneSetup(courseController).build(); 
	}
	
	@Test
	public void getCourseByIdURL() throws Exception{
//		mvc.perform(get("/courses/1").accept(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(jsonPath("$.courseName", Matchers.is("Spring")));
	}
	
}
