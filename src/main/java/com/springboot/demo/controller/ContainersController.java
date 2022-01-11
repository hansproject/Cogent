package com.springboot.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.Constants;
import com.springboot.demo.exceptions.ContainerNotFoundException;
import com.springboot.demo.model.service.ContainerService;

@CrossOrigin("*")
@RestController
public class ContainersController {

	@Autowired
	ContainerService service;

	public ContainersController() {super();}
	
	@GetMapping("/container/status/available-capacity/{type}")
	public float getAvailableCapacity(@PathVariable(name = "type") String type) {
		return service.retrieveContainerAvailableCapacity(type);
	}
	
	@GetMapping("/container/status/all-available-capacity/")
	public Map getAllAvailableCapacity() {
		Map<String, Float> m= new HashMap<String, Float>();
		m.put("Tea", service.retrieveContainerAvailableCapacity("Tea"));
		m.put("Coffee", service.retrieveContainerAvailableCapacity("Coffee"));
		m.put("Water", service.retrieveContainerAvailableCapacity("Water"));
		m.put("Sugar", service.retrieveContainerAvailableCapacity("Sugar"));
		m.put("Milk", service.retrieveContainerAvailableCapacity("Milk"));
		
		return m;
	}
	
	@GetMapping("/container/status/max-capacity/")
	public Map getMaxCapacity() {
		Map<String, Integer> m= new HashMap<String, Integer>();
		m.put("Tea", Constants.TEA_CONTAINER_MAX_CAPACITY);
		m.put("Coffee", Constants.COFFEE_CONTAINER_MAX_CAPACITY);
		m.put("Water", Constants.WATER_CONTAINER_MAX_CAPACITY);
		m.put("Sugar", Constants.SUGAR_CONTAINER_MAX_CAPACITY);
		m.put("Milk", Constants.MILK_CONTAINER_MAX_CAPACITY);
		return m;
	}
	
	@GetMapping("/container/status/max-capacity/{type}")
	public float getMaxCapacityPerType(@PathVariable(name = "type") String type) {
		if(type.equals("Tea")) {
			return Constants.TEA_CONTAINER_MAX_CAPACITY;
		}
		else if(type.equals("Coffee")) {
			return Constants.COFFEE_CONTAINER_MAX_CAPACITY;
		}
		else if(type.equals("Milk")) {
			return Constants.MILK_CONTAINER_MAX_CAPACITY;
		}
		else if(type.equals("Sugar")) {
			return Constants.SUGAR_CONTAINER_MAX_CAPACITY;
		}
		else if(type.equals("Water")) {
			return Constants.WATER_CONTAINER_MAX_CAPACITY;
		}
		else
			throw new ContainerNotFoundException();
	}
}
