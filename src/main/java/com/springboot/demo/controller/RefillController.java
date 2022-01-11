package com.springboot.demo.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
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
import com.springboot.demo.model.entity.Refill;
import com.springboot.demo.model.service.RefillService;

@CrossOrigin("*")
@RestController
public class RefillController {

	@Autowired
	RefillService service;

	public RefillController() {super();}
	
//	@PostMapping(value="/refills", produces = MediaType.APPLICATION_JSON_VALUE)
//	public String addRefill(@RequestBody(required = true) Refill r){
//		r.setDate(new Date(System.currentTimeMillis()));
//		service.addRefill(r);
//		return "Refill successfully made......";
//	}
	
//	@PostMapping(value="/refills/{quantity}/{containerType}")
//	public String addRefill(@PathVariable(name = "quantity") int quantity, @PathVariable(name= "containerType") String containerType) {
//		Refill r= new Refill(containerType, quantity);
//		r.setDate(new Date(System.currentTimeMillis()));
//		service.addRefill(r);
//		return "Refill successfully made.....";
//	}
//	
	@PostMapping(value="/refills/{quantity}/{containerType}")
	public ResponseEntity<?> addRefill(@PathVariable(name = "quantity") int quantity, @PathVariable(name= "containerType") String containerType) {
	//	ResponseEntity<?> response= new ResponseEntity("Refill could not be made due to an exception.....", HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseEntity<?> response= null;
		try {
//			Refill r= new Refill(containerType, quantity);//teaRefill=0, coffeeRefilll=0
			Refill r= new Refill();
			r.setRefillByContainerType(containerType, quantity);
			r.setDate(new Date(System.currentTimeMillis()));
			service.addRefill(r);
			response=new ResponseEntity("Refill successfully made from.....", HttpStatus.OK);
			//response.ok("Refill successfully made.....").status(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			response=new ResponseEntity("Refill could not be made.....", HttpStatus.BAD_REQUEST);
		}finally {
			return response;
		}
	
	}
	
	@PostMapping(value="/refills")
	public Map addRefill(@RequestBody(required = true)  Map<String, Integer> m) {
		
		boolean isBadRequest= false;
		
		int teaRefill=0, coffeeRefill=0, sugarRefill=0, waterRefill=0, milkRefill=0;
		if(m.get("teaRefill")!=null) {
			if(m.get("teaRefill")>=0) {
				teaRefill= m.get("teaRefill");
			}
			else
				isBadRequest= true;
		}
		if(m.get("coffeeRefill")!=null) {
			if(m.get("coffeeRefill")>=0) {
				coffeeRefill= m.get("coffeeRefill");
			}
			else
				isBadRequest= true;
		}
		if(m.get("sugarRefill")!=null) {
			if(m.get("sugarRefill")>=0) {
				sugarRefill= m.get("sugarRefill");
			}
			else
				isBadRequest= true;
		}
		if(m.get("waterRefill")!=null) {
			if(m.get("waterRefill")>=0) {
				waterRefill= m.get("waterRefill");
			}
			else
				isBadRequest= true;
		}
		if(m.get("milkRefill")!=null) {
			if(m.get("milkRefill")>=0) {
				milkRefill= m.get("milkRefill");
			}
			else
				isBadRequest= true;
		}
		
		Refill r= new Refill(teaRefill, coffeeRefill, sugarRefill,
				waterRefill, milkRefill, new Date(System.currentTimeMillis()));
		service.addRefill(r);
	//	JSONObject j= new JSONObject();
		//j.put("Response","Refill successfully made......");
		Map<String, String> response= new HashMap<String,String>();
		if(isBadRequest) {
			response.put("response", "Refill could not be made.....");
		}
		else
			response.put("response","Refill successfully made from.....");
		return response;
	}
	
	@GetMapping(value="/refills", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Refill> getAllDrinks(){
		return service.retrieveAllRefills();
	}
	
	@GetMapping("/refills/total/{type}")
	public int getTotalRefills(@PathVariable(name = "type") String type) {
		return service.retrieveTotalDrinkTypeCount(type);
	}
	
	@GetMapping("/refills/daily/{type}")
	public int getTotalDailyRefills(@PathVariable(name = "type") String type) {
		return service.retrieveTotalDailyDrinkTypeCount(type);
	}
	
	@GetMapping("/refills/daily/counter")
	public Map getTotalDailyRefillsCount() {
		Map<String, Integer> m= new HashMap<String, Integer>();
		m.put("Tea", service.retrieveTotalDailyDrinkTypeCount("Tea"));
		m.put("Sugar", service.retrieveTotalDailyDrinkTypeCount("Sugar"));
		m.put("Coffee", service.retrieveTotalDailyDrinkTypeCount("Coffee"));
		m.put("Water", service.retrieveTotalDailyDrinkTypeCount("Water"));
		m.put("Milk", service.retrieveTotalDailyDrinkTypeCount("Milk"));
		return m;
	}
	
	@GetMapping("/refills/total/counter")
	public Map getTotalRefillsCount() {
		Map<String, Integer> m= new HashMap<String, Integer>();
		m.put("Tea", service.retrieveTotalDrinkTypeCount("Tea"));
		m.put("Coffee", service.retrieveTotalDrinkTypeCount("Coffee"));
		m.put("Sugar", service.retrieveTotalDrinkTypeCount("Sugar"));
		m.put("Water", service.retrieveTotalDrinkTypeCount("Water"));
		m.put("Milk", service.retrieveTotalDrinkTypeCount("Milk"));
		return m;
	}
}
