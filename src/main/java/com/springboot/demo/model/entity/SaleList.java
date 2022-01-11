package com.springboot.demo.model.entity;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

@Entity
@Table(name="salelist_tbl")
public class SaleList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int saleListId;
	
	
	@ManyToOne
	@JoinColumn(name = "drinkId", nullable = false)
	private Drink drink;
	
	private int numberOfCup;
	
	private Date date;
	
	public SaleList() {super();}

	public SaleList(int saleListId, Drink drink, int numberOfCup, Date date) {
		super();
		this.saleListId = saleListId;
		this.drink = drink;
		this.numberOfCup = numberOfCup;
		this.date = date;
	}

	public SaleList(Drink drink, int numberOfCup, Date date) {
		super();
		this.drink = drink;
		this.numberOfCup = numberOfCup;
		this.date = date;
	}

	public int getsaleListId() {
		return saleListId;
	}

	public void setsaleListId(int saleListId) {
		this.saleListId = saleListId;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public int getNumberOfCup() {
		return numberOfCup;
	}

	public void setNumberOfCup(int numberOfCup) {
		this.numberOfCup = numberOfCup;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SaleList [saleListId=" + saleListId + ", drink=" + drink + ", numberOfCup=" + numberOfCup + ", date=" + date
				+ "]";
	}

}
