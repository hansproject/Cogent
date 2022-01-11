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

@Entity
@Table(name="containers_tbl")
public class Containers {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int containersId;
	
	@Column(length = 9, precision = 3)
	private float teaContainer;
	
	@Column(length = 9, precision = 3)
	private float coffeeContainer;
	
	@Column(length = 9, precision = 3)
	private float sugarContainer;
	
	@Column(length = 9, precision = 3)
	private float waterContainer;
	
	@Column(length = 9, precision = 3)
	private float milkContainer;
	
	public Containers() {super();}

	public Containers(int containersId, float teaContainer, float coffeeContainer, float sugarContainer,
			float waterContainer, float milkContainer) {
		super();
		this.containersId = containersId;
		this.teaContainer = teaContainer;
		this.coffeeContainer = coffeeContainer;
		this.sugarContainer = sugarContainer;
		this.waterContainer = waterContainer;
		this.milkContainer = milkContainer;
	}

	public int getContainersId() {
		return containersId;
	}

	public void setContainersId(int containersId) {
		this.containersId = containersId;
	}

	public float getTeaContainer() {
		return teaContainer;
	}

	public void setTeaContainer(float teaContainer) {
		this.teaContainer = teaContainer;
	}

	public float getCoffeeContainer() {
		return coffeeContainer;
	}

	public void setCoffeeContainer(float coffeeContainer) {
		this.coffeeContainer = coffeeContainer;
	}

	public float getSugarContainer() {
		return sugarContainer;
	}

	public void setSugarContainer(float sugarContainer) {
		this.sugarContainer = sugarContainer;
	}

	public float getWaterContainer() {
		return waterContainer;
	}

	public void setWaterContainer(float waterContainer) {
		this.waterContainer = waterContainer;
	}

	public float getMilkContainer() {
		return milkContainer;
	}

	public void setMilkContainer(float milkContainer) {
		this.milkContainer = milkContainer;
	}

	@Override
	public String toString() {
		return "Containers [containersId=" + containersId + ", teaContainer=" + teaContainer + ", coffeeContainer="
				+ coffeeContainer + ", sugarContainer=" + sugarContainer + ", waterContainer=" + waterContainer
				+ ", milkContainer=" + milkContainer + "]";
	}

}
