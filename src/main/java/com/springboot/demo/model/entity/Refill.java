package com.springboot.demo.model.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.springboot.demo.exceptions.ContainerNotFoundException;

@Entity
@Table(name="refill_tbl")
public class Refill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int refillId;
	
	private int teaRefill;
	
	private int coffeeRefill;
	
	private int sugarRefill;
	
	private int waterRefill;
	
	private int milkRefill;
	
	private Date date;
	
	public Refill() {super();}

	public Refill(String s, int quantity) {
		if(s.equals("Tea")) {
			this.teaRefill= quantity;
		}
		if(s.equals("Coffee")) {
			this.coffeeRefill= quantity;
		}
		if(s.equals("Water")) {
			this.waterRefill= quantity;
		}
		if(s.equals("Sugar")) {
			this.sugarRefill= quantity;
		}
		if(s.equals("Milk")) {
			this.milkRefill= quantity;
		}
	}
	
	public Refill(int teaRefill, int coffeeRefill, int sugarRefill, int waterRefill, int milkRefill, Date date) {
		super();
		this.teaRefill = teaRefill;
		this.coffeeRefill = coffeeRefill;
		this.sugarRefill = sugarRefill;
		this.waterRefill = waterRefill;
		this.milkRefill = milkRefill;
		this.date = date;
	}

	public Refill(int refillId, int teaRefill, int coffeeRefill, int sugarRefill, int waterRefill, int milkRefill,
			Date date) {
		super();
		this.refillId = refillId;
		this.teaRefill = teaRefill;
		this.coffeeRefill = coffeeRefill;
		this.sugarRefill = sugarRefill;
		this.waterRefill = waterRefill;
		this.milkRefill = milkRefill;
		this.date = date;
	}

	public void setRefillByContainerType(String s, int quantity) throws RuntimeException,ContainerNotFoundException{
		
		if(quantity <0) {
			throw new RuntimeException("Negative quantity not allowed!");
		}
		
		if(s.equals("Tea")) {
			this.teaRefill= quantity;
		}
		else if(s.equals("Coffee")) {
			this.coffeeRefill= quantity;
		}
		else if(s.equals("Water")) {
			this.waterRefill= quantity;
		}
		else if(s.equals("Sugar")) {
			this.sugarRefill= quantity;
		}
		else if(s.equals("Milk")) {
			this.milkRefill= quantity;
		}
		else
			throw new ContainerNotFoundException();
		
	}
	public int getRefillId() {
		return refillId;
	}

	public void setRefillId(int refillId) {
		this.refillId = refillId;
	}

	public int getTeaRefill() {
		return teaRefill;
	}

	public void setTeaRefill(int teaRefill) {
		this.teaRefill = teaRefill;
	}

	public int getCoffeeRefill() {
		return coffeeRefill;
	}

	public void setCoffeeRefill(int coffeeRefill) {
		this.coffeeRefill = coffeeRefill;
	}

	public int getSugarRefill() {
		return sugarRefill;
	}

	public void setSugarRefill(int sugarRefill) {
		this.sugarRefill = sugarRefill;
	}

	public int getWaterRefill() {
		return waterRefill;
	}

	public void setWaterRefill(int waterRefill) {
		this.waterRefill = waterRefill;
	}

	public int getMilkRefill() {
		return milkRefill;
	}

	public void setMilkRefill(int milkRefill) {
		this.milkRefill = milkRefill;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Refill [refillId=" + refillId + ", teaRefill=" + teaRefill + ", coffeeRefill=" + coffeeRefill
				+ ", sugarRefill=" + sugarRefill + ", waterRefill=" + waterRefill + ", milkRefill=" + milkRefill
				+ ", date=" + date + "]";
	}

}
