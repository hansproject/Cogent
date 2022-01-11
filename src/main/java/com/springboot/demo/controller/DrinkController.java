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

import com.springboot.demo.model.entity.Drink;
import com.springboot.demo.model.service.DrinkService;

@CrossOrigin("*")
@RestController
public class DrinkController {

	@Autowired
	DrinkService service;
	
	public DrinkController() {super();}
	
	@GetMapping(value="/drinks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Drink> getAllDrinks(){
		List<Drink> result= null;
		try {
			result=service.retrieveAllDrinks();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return result;
		}
	}
	
//	@PostMapping(value="/drinks")
//	public String addDrink(@RequestBody(required = true) Drink d) {
//		service.addDrink(d);
//		return "Drink successfully inserted.....";
//	}
	
	@GetMapping(value="/drinks/set-drink-table")
	public Map isEmpty() {
		Map<String, String> m= null;
		try {
			m= new HashMap<String, String>();
			boolean response= service.isEmpty();
			if(response) {
				m.put("response", "Initial values has been inserted in the drink table.....");
			}
			else {
				m.put("response", "Drink Table had already initial values in it.....");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return m;
		}
	}
	
	@GetMapping(value="/drinks/{numberOfCup}/{drinkType}")
	public Map getDrink(@PathVariable(name = "numberOfCup") int numberOfCup, @PathVariable(name= "drinkType") String drinkType) {
		Map<String, String> m= null;
		try {
			boolean isSuccessful= service.getDrink(numberOfCup, drinkType);
			m= new HashMap<String, String>();
			if(isSuccessful) {
				m.put("response", "success");
			}
			else
				m.put("response", "failure");
		}catch(Exception e) {
			e.printStackTrace();
			m.put("response", "failure");
		}finally {
			return m;
		}
	}
	
//	@GetMapping(value="/drinks/{numberOfCup}/{drinkType}")
//	public ResponseEntity<?> getDrink(@PathVariable(name = "numberOfCup") int numberOfCup, @PathVariable(name= "drinkType") String drinkType) {
//		service.getDrink(numberOfCup, drinkType);
//		Map<String, String> m= new HashMap<String, String>();
//		m.put("response", "Drink successfully made.....");
//		return new ResponseEntity("Drink successfully made.....", HttpStatus.OK);
//	}

//	@DeleteMapping(value="/drinks/{drinkId}")
//	public String deleteDrinkById(@PathVariable(name = "drinkId") int drinkId) {
//		service.deleteDrinkById(drinkId);
//		return "Drink successfully deleted.....";
//	}
}
