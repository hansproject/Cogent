package com.springboot.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.Constants;
import com.springboot.demo.exceptions.ContainerNotFoundException;
import com.springboot.demo.exceptions.RefillNotFoundException;
import com.springboot.demo.model.entity.Refill;
import com.springboot.demo.model.entity.Containers;
import com.springboot.demo.repository.RefillRepository;

@Service
public class RefillService {

	public RefillService() {super();}
	
	@Autowired
	RefillRepository refillRepo;
	@Autowired
	ContainerService containerService;
	
	public void addRefill(Refill r) {
		refillRepo.save(r);
		if(containerService.retrieveAllContainers().isEmpty()) {
			containerService.addContainer(new Containers(Constants.CONTAINERS_ID, Constants.COFFEE_CONTAINER_MAX_CAPACITY,
					Constants.MILK_CONTAINER_MAX_CAPACITY, Constants.SUGAR_CONTAINER_MAX_CAPACITY,
					Constants.TEA_CONTAINER_MAX_CAPACITY, Constants.WATER_CONTAINER_MAX_CAPACITY));
		}
	
		Containers c= containerService.retrieveAllContainers().get(0);
		Containers updatedContainer= new Containers();
		updatedContainer.setContainersId(Constants.CONTAINERS_ID);

		// -----------------Coffee Refill----------------
		if(c.getCoffeeContainer()+ r.getCoffeeRefill() > Constants.COFFEE_CONTAINER_MAX_CAPACITY) {
			updatedContainer.setCoffeeContainer(Constants.COFFEE_CONTAINER_MAX_CAPACITY);
		}
		else {
			updatedContainer.setCoffeeContainer(r.getCoffeeRefill()+ c.getCoffeeContainer());
		}
		// -----------------Tea Refill----------------
		if(c.getTeaContainer()+ r.getTeaRefill() > Constants.TEA_CONTAINER_MAX_CAPACITY) {
			updatedContainer.setTeaContainer(Constants.TEA_CONTAINER_MAX_CAPACITY);
		}
		else {
			updatedContainer.setTeaContainer(r.getTeaRefill()+ c.getTeaContainer());
		}
		// -----------------Water Refill----------------
		if(c.getWaterContainer()+ r.getWaterRefill() > Constants.WATER_CONTAINER_MAX_CAPACITY) {
			updatedContainer.setWaterContainer(Constants.WATER_CONTAINER_MAX_CAPACITY);
		}
		else {
			updatedContainer.setWaterContainer(r.getWaterRefill()+ c.getWaterContainer());
		}
		// -----------------Sugar Refill----------------
		if(c.getSugarContainer()+ r.getSugarRefill() > Constants.SUGAR_CONTAINER_MAX_CAPACITY) {
			updatedContainer.setSugarContainer(Constants.SUGAR_CONTAINER_MAX_CAPACITY);
		}
		else {
			updatedContainer.setSugarContainer(r.getSugarRefill()+ c.getSugarContainer());
		}
		// -----------------Milk Refill----------------
		if(c.getMilkContainer()+ r.getMilkRefill() > Constants.MILK_CONTAINER_MAX_CAPACITY) {
			updatedContainer.setMilkContainer(Constants.MILK_CONTAINER_MAX_CAPACITY);
		}
		else {
			updatedContainer.setMilkContainer(r.getMilkRefill()+ c.getMilkContainer());
		}
		
		containerService.updateContainer(updatedContainer);
		
	}
	
	public Refill retrieveRefillById(int refillId) {
		return refillRepo.findById(refillId).orElseThrow(()->{throw new RefillNotFoundException();});
	}
	
//	public List<Object> retrieveBlogsBasedCoures(int courseId, String authorName){
//		if(authorName==null) {
//			return blogRepo.retrieveBlogsBasedCoures(courseId);
//		}
//		return blogRepo.retrieveBlogsBasedCoures(courseId, authorName);
//	}
	public int retrieveTotalDrinkTypeCount(String containerName) throws ContainerNotFoundException{
		Integer result=0;
		if(containerName.equals("Tea")) {
			if( refillRepo.retrieveTeaTotalCount()!=null) {
				result=  refillRepo.retrieveTeaTotalCount();
			}	
		}
		else if(containerName.equals("Coffee")) {
			if( refillRepo.retrieveCoffeeTotalCount()!=null) {
				result=  refillRepo.retrieveCoffeeTotalCount();
			}	
		}
		else if(containerName.equals("Milk")) {
			if(refillRepo.retrieveMilkTotalCount()!=null) {
				result=  refillRepo.retrieveMilkTotalCount();
			}	
		}
		else if(containerName.equals("Sugar")) {
			if(refillRepo.retrieveSugarTotalCount()!=null) {
				result=  refillRepo.retrieveSugarTotalCount();
			}	
		}
		else if(containerName.equals("Water")) {
			if(refillRepo.retrieveWaterTotalCount()!=null) {
				result= refillRepo.retrieveWaterTotalCount();
			}	
		}
		else
			throw new ContainerNotFoundException();
		return result;
	}
	
	public int retrieveTotalDailyDrinkTypeCount(String containerName) throws ContainerNotFoundException{
		if(containerName.equals("Tea")) {
			return refillRepo.retrieveTeaTotalDailyCount();
		}
		else if(containerName.equals("Coffee")) {
			return refillRepo.retrieveCoffeeTotalDailyCount();
		}
		else if(containerName.equals("Milk")) {
			return refillRepo.retrieveMilkTotalDailyCount();
		}
		else if(containerName.equals("Sugar")) {
			return refillRepo.retrieveSugarTotalDailyCount();
		}
		else if(containerName.equals("Water")) {
			return refillRepo.retrieveWaterTotalDailyCount();
		}
		else
			throw new ContainerNotFoundException();
	}
	
	public List<Refill> retrieveAllRefills(){
		return refillRepo.findAll();
	}
	
	public void updateRefill(Refill r) {
		refillRepo.save(r);
	}
	
	public void deleteRefill(int refillId) {
		refillRepo.deleteById(refillId);;
	}
}
