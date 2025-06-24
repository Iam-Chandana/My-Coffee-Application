package com.scratch.coffeeapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "Coffee_data")
public class Coffee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coffee_id;
	private String coffee_name;
	double price;
	
	public Coffee() {
		super();
 	}

	public Coffee(int coffee_id, String coffee_name, double price) {
		super();
		this.coffee_id = coffee_id;;
		this.coffee_name = coffee_name;
		this.price = price;
	}

	public int getCoffee_id() {
		return coffee_id;
	}

	public void setCoffee_id(int coffee_id) {
		this.coffee_id = coffee_id;
	}

	public String getCoffee_name() {
		return coffee_name;
	}

	public void setCoffee_name(String coffee_name) {
		this.coffee_name = coffee_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Coffee [coffee_id=" + coffee_id + ", coffee_name=" + coffee_name + ", price=" + price + "]";
	}
 
	

}
