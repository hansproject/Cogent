package com.springboot.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.exceptions.SaleListNotFoundException;
import com.springboot.demo.model.entity.SaleList;
import com.springboot.demo.repository.SaleListRepository;

@Service
public class SaleListService {

	public SaleListService() {super();}
	
	@Autowired
	SaleListRepository saleListRepo;

	
	public void addSaleList(SaleList s) {
		saleListRepo.save(s);
	}
	
	public SaleList retrieveSaleListById(int saleListId) {
		return saleListRepo.findById(saleListId).orElseThrow(()->{throw new SaleListNotFoundException();});
	}
	
//	public List<Object> retrieveBlogsBasedCoures(int courseId, String authorName){
//		if(authorName==null) {
//			return blogRepo.retrieveBlogsBasedCoures(courseId);
//		}
//		return blogRepo.retrieveBlogsBasedCoures(courseId, authorName);
//	}
	public int retrieveDailyTotalNumberOfCupUsingDrinkType(String drinkType) {
		Integer result= 0;
		if(saleListRepo.retrieveDailyTotalNumberOfCupUsingDrinkType(drinkType)!=null) {
			result= saleListRepo.retrieveDailyTotalNumberOfCupUsingDrinkType(drinkType);
		}	
		return result;
	}
	
	public int retrieveTotalNumberOfCupUsingDrinkType(String drinkType) {
		Integer result= 0;
		if(saleListRepo.retrieveTotalNumberOfCupUsingDrinkType(drinkType)!=null) {
			result= saleListRepo.retrieveTotalNumberOfCupUsingDrinkType(drinkType);
		}	
		return result;
	}
	
	public List<SaleList> retrieveAllSales(){
		return saleListRepo.findAll();
	}
	
	public void updateSaleList(SaleList s) {
		saleListRepo.save(s);
	}
	
	public void deleteSaleList(int saleListId) {
		saleListRepo.deleteById(saleListId);;
	}
}
