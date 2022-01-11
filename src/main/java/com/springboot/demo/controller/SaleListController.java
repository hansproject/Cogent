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
import com.springboot.demo.model.entity.SaleList;
import com.springboot.demo.model.service.DrinkService;
import com.springboot.demo.model.service.SaleListService;

@CrossOrigin("*")
@RestController
public class SaleListController {

	@Autowired
	SaleListService service;
	@Autowired
	DrinkService drinkService;

	public SaleListController() {super();}
	
	@GetMapping(value="/sales", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SaleList> getAllSaleLists(){
		List<SaleList> result= null;
		try {
			result=service.retrieveAllSales();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return result;
		}
	}
	//--------------------------------------------------------------	
//	@GetMapping(value="/sales/total/cups/{drinkType}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public int getTotalNumbOfCupSales(@PathVariable(name = "drinkType") String drinkType){
//		return service.retrieveTotalNumberOfCupUsingDrinkType(drinkType);
//	}
//	//--------------------------------------------------------------		
//	@GetMapping(value="/sales/total/cost/{drinkType}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public float getTotalCostPerDrink(@PathVariable(name = "drinkType") String drinkType){
//		int totalNumberOfCup= service.retrieveTotalNumberOfCupUsingDrinkType(drinkType);
//		float costPerDrink= drinkService.retrieveCostPerDrinkType(drinkType);
//		return costPerDrink* totalNumberOfCup;
//	}
	//----------------------Total daily cost per drink sales------------------------------	
	@GetMapping(value="/sales/daily/cost", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map getDailyDrinksTotalSales(){
		Map<String, Float> m= null;
		try {
			m= new HashMap<String, Float>();
			m.put("Tea", service.retrieveDailyTotalNumberOfCupUsingDrinkType("Tea")*drinkService.retrieveCostPerDrinkType("Tea"));
			m.put("BlackTea", service.retrieveDailyTotalNumberOfCupUsingDrinkType("Black Tea")*drinkService.retrieveCostPerDrinkType("Black Tea"));
			m.put("Coffee", service.retrieveDailyTotalNumberOfCupUsingDrinkType("Coffee")*drinkService.retrieveCostPerDrinkType("Coffee"));
			m.put("BlackCoffee", service.retrieveDailyTotalNumberOfCupUsingDrinkType("Black Coffee")*drinkService.retrieveCostPerDrinkType("Black Coffee"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return m;
		}
	}
	//----------------------------Total daily number of cups per drink sales---------------------------------	
	@GetMapping(value="/sales/daily/cups", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map getDailyDrinksNumberOfCups(){
		Map<String, Integer> m= null;
		try {
			m= new HashMap<String, Integer>();
			m.put("Tea", service.retrieveDailyTotalNumberOfCupUsingDrinkType("Tea"));
			m.put("BlackTea", service.retrieveDailyTotalNumberOfCupUsingDrinkType("Black Tea"));
			m.put("Coffee", service.retrieveDailyTotalNumberOfCupUsingDrinkType("Coffee"));
			m.put("BlackCoffee", service.retrieveDailyTotalNumberOfCupUsingDrinkType("Black Coffee"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return m;
		}
	}
	//----------------------Total Cost per drink all day sales------------------------------
	@GetMapping(value="/sales/total/cost", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map getAllDrinksTotalSales(){
		Map<String, Float> m= null;
		try {
			m= new HashMap<String, Float>();
			m.put("Tea", service.retrieveTotalNumberOfCupUsingDrinkType("Tea")*drinkService.retrieveCostPerDrinkType("Tea"));
			m.put("BlackTea", service.retrieveTotalNumberOfCupUsingDrinkType("Black Tea")*drinkService.retrieveCostPerDrinkType("Black Tea"));
			m.put("Coffee", service.retrieveTotalNumberOfCupUsingDrinkType("Coffee")*drinkService.retrieveCostPerDrinkType("Coffee"));
			m.put("BlackCoffee", service.retrieveTotalNumberOfCupUsingDrinkType("Black Coffee")*drinkService.retrieveCostPerDrinkType("Black Coffee"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return m;
		}
	}
	//----------------------------Total number of cups per drink all day sales---------------------------------	
	@GetMapping(value="/sales/total/cups", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map getAllDrinksNumberOfCups(){
		Map<String, Integer> m= null;
		try {
			m= new HashMap<String, Integer>();
			m.put("Tea", service.retrieveTotalNumberOfCupUsingDrinkType("Tea"));
			m.put("BlackTea", service.retrieveTotalNumberOfCupUsingDrinkType("Black Tea"));
			m.put("Coffee", service.retrieveTotalNumberOfCupUsingDrinkType("Coffee"));
			m.put("BlackCoffee", service.retrieveTotalNumberOfCupUsingDrinkType("Black Coffee"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return m;
		}
	}
	//--------------------------------------------------------------	
//	@GetMapping(value="/sales/daily-sales/cups/{drinkType}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public int getDailyNumbOfCupSales(@PathVariable(name = "drinkType") String drinkType){
//		return service.retrieveDailyTotalNumberOfCupUsingDrinkType(drinkType);
//	}
//	//--------------------------------------------------------------	
//	@GetMapping(value="/sales/daily-sales/cost/{drinkType}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public float getDailyTotalCostPerDrink(@PathVariable(name = "drinkType") String drinkType){
//		int totalNumberOfCup= service.retrieveDailyTotalNumberOfCupUsingDrinkType(drinkType);
//		float costPerDrink= drinkService.retrieveCostPerDrinkType(drinkType);
//		return costPerDrink* totalNumberOfCup;
//	}
	
//	@PostMapping(value="/sales")
//	public String addSaleList(@RequestBody(required = true) SaleList s) {
//		service.addSaleList(s);
//		return "SaleList successfully inserted.....";
//	}
	
	@PostMapping(value="/sales")
	public ResponseEntity<?> addSaleList(@RequestBody(required = true) SaleList s) {
		ResponseEntity<?> response=  new ResponseEntity("SaleList could not be inserted due to an exception.....", HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			service.addSaleList(s);
			response.ok("SaleList successfully inserted.....").status(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return response;
		}
	}
	
//	@DeleteMapping(value="/sales/{saleListId}")
//	public String deleteSaleListById(@PathVariable(name = "saleListId") int saleListId) {
//		service.deleteSaleList(saleListId);
//		return "SaleList successfully deleted.....";
//	}
}
