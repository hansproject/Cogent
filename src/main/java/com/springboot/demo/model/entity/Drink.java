package com.springboot.demo.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="drink_tbl")
public class Drink {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int drinkId;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 9, precision = 3)
	private float cost;
	
	public Drink() {super();}
	
	public Drink(int drinkId) {
		super();
		this.drinkId = drinkId;
	}

	public Drink(int drinkId, String name, float cost) {
		super();
		this.drinkId = drinkId;
		this.name = name;
		this.cost = cost;
	}

	public int getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(int drinkId) {
		this.drinkId = drinkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Drink [drinkId=" + drinkId + ", name=" + name + ", cost=" + cost + "]";
	}

}
