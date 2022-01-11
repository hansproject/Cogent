package com.springboot.demo.model.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.exceptions.DrinkCantBeMadeException;
import com.springboot.demo.model.entity.Containers;
import com.springboot.demo.model.entity.Drink;
import com.springboot.demo.model.entity.SaleList;
import com.springboot.demo.Constants;
import com.springboot.demo.repository.ContainerRepository;
import com.springboot.demo.repository.DrinkRepository;
import com.springboot.demo.repository.SaleListRepository;

@Service
public class DrinkService {

	public DrinkService() {super();}
	
	@Autowired
	SaleListService saleListService;
	@Autowired
	DrinkRepository drinkRepo;
	@Autowired
	ContainerService containerService;
	
	public void addDrink(Drink d) {
		drinkRepo.save(d);
	}
	
	public boolean isEmpty() {
		if(drinkRepo.findAll().isEmpty()) {
			// Add 4 drinks 
			drinkRepo.save(new Drink(1, "Tea",10.0f ));
			drinkRepo.save(new Drink(2, "Black Tea",5.0f ));
			drinkRepo.save(new Drink(3, "Coffee",15.0f ));
			drinkRepo.save(new Drink(4, "Black Coffee",15.0f ));
			return true;
		}
		else
			return false;
	}
	
	public boolean getDrink(int numberOfCup, String drinkType){
		
		if(containerService.retrieveAllContainers().isEmpty()) {
			containerService.addContainer(new Containers(Constants.CONTAINERS_ID, Constants.COFFEE_CONTAINER_MAX_CAPACITY,
					Constants.MILK_CONTAINER_MAX_CAPACITY, Constants.SUGAR_CONTAINER_MAX_CAPACITY,
					Constants.TEA_CONTAINER_MAX_CAPACITY, Constants.WATER_CONTAINER_MAX_CAPACITY));
		}
	
		Containers c= containerService.retrieveAllContainers().get(0);// 1st step, the assumption is this list should have only 1 value
		boolean isSuccessful= false;
		SaleList saleList= null;
		try {
			switch(drinkType){
				case "Tea":
					if(c.getTeaContainer() > 0.006* numberOfCup 
							&& c.getWaterContainer() > 0.065* numberOfCup
							&& c.getMilkContainer()> 0.044*numberOfCup
							&& c.getSugarContainer()> 0.017*numberOfCup) {
						isSuccessful= true;
						saleList= new SaleList(new Drink(retrieveDrinkId("Tea")), numberOfCup, new Date(System.currentTimeMillis()));
						saleListService.addSaleList(saleList);
						Containers updatedContainer= new Containers(1, c.getTeaContainer()- 0.006f* numberOfCup,
								c.getCoffeeContainer(), c.getSugarContainer()- 0.017f*numberOfCup,
								c.getWaterContainer()-0.065f* numberOfCup, c.getMilkContainer()-0.044f*numberOfCup);
						containerService.updateContainer(updatedContainer);
					}
					else
						throw new DrinkCantBeMadeException();
					break;
					
				case "Black Tea":
					if(c.getTeaContainer() > 0.006* numberOfCup 
							&& c.getWaterContainer() > 0.065* numberOfCup
							&& c.getSugarContainer()> 0.017*numberOfCup) {
						isSuccessful= true;
						saleList= new SaleList(new Drink(retrieveDrinkId("Black Tea")), numberOfCup, new Date(System.currentTimeMillis()));
						saleListService.addSaleList(saleList);
						Containers updatedContainer= new Containers(1, c.getTeaContainer()- 0.006f* numberOfCup,
								c.getCoffeeContainer(), c.getSugarContainer()- 0.017f*numberOfCup,
								c.getWaterContainer()-0.065f* numberOfCup, c.getMilkContainer());
						containerService.updateContainer(updatedContainer);
					}
					else
						throw new DrinkCantBeMadeException();
					break;
				case "Coffee":
					if(c.getCoffeeContainer() > 0.006* numberOfCup 
							&& c.getWaterContainer() > 0.065* numberOfCup
							&& c.getMilkContainer() > 0.044* numberOfCup
							&& c.getSugarContainer()> 0.017*numberOfCup) {
						isSuccessful= true;
						saleList= new SaleList(new Drink(retrieveDrinkId("Coffee")), numberOfCup, new Date(System.currentTimeMillis()));
						saleListService.addSaleList(saleList);
						Containers updatedContainer= new Containers(1, c.getTeaContainer(),
								c.getCoffeeContainer()-0.006f* numberOfCup, c.getSugarContainer()- 0.017f*numberOfCup,
								c.getWaterContainer()-0.065f* numberOfCup, c.getMilkContainer()-0.044f* numberOfCup);
						containerService.updateContainer(updatedContainer);
					}
					else
						throw new DrinkCantBeMadeException();
					break;
				case "Black Coffee":
					if(c.getCoffeeContainer() > 0.006* numberOfCup 
							&& c.getWaterContainer() > 0.065* numberOfCup
							&& c.getSugarContainer()> 0.017*numberOfCup) {
						isSuccessful= true;
						saleList= new SaleList(new Drink(retrieveDrinkId("Black Coffee")), numberOfCup, new Date(System.currentTimeMillis()));
						saleListService.addSaleList(saleList);
						Containers updatedContainer= new Containers(1, c.getTeaContainer(),
								c.getCoffeeContainer()-0.006f* numberOfCup, c.getSugarContainer()- 0.017f*numberOfCup,
								c.getWaterContainer()-0.065f* numberOfCup, c.getMilkContainer());
						containerService.updateContainer(updatedContainer);
					}
					else
						throw new DrinkCantBeMadeException();
					break;
				default: 
					throw new DrinkCantBeMadeException();
			}
		}catch(DrinkCantBeMadeException d) {
			d.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			return isSuccessful;
		}
	}
	
	public float retrieveCostPerDrinkType(String drinkType) {
		Float result= 0.0f;
		if(drinkRepo.retrieveCostPerDrinkType(drinkType)!=null) {
			result= drinkRepo.retrieveCostPerDrinkType(drinkType);
		}	
		return result;
	}
	
	public int retrieveDrinkId(String drinkType) {
		return drinkRepo.retrieveDrinkId(drinkType);
	}
	
	public Drink retrieveDrinkById(int drinkId) {
		return drinkRepo.findById(drinkId).orElseThrow(()->{throw new DrinkCantBeMadeException();});
	}
	
//	public List<Object> retrieveDrinksBasedCoures(int courseId, String authorName){
//		if(authorName==null) {
//			return drinkRepo.retrieveDrinksBasedCoures(courseId);
//		}
//		return drinkRepo.retrieveDrinksBasedCoures(courseId, authorName);
//	}
	
	public List<Drink> retrieveAllDrinks(){
		return drinkRepo.findAll();
	}
	
	public void updateDrink(Drink d) {
		drinkRepo.save(d);
	}
	
	public void deleteDrinkById(int drinkId) {
		saleListService.deleteSaleList(drinkId);
		drinkRepo.deleteById(drinkId);
	}
}
