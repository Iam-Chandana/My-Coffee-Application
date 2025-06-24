package com.scratch.coffeeapplication.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders_data")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;
	private String order_name;
	@OneToMany(cascade = CascadeType.ALL)
	List<Coffee> coffees;
	double total_price;
	public Order() {
		super();
 	}
	
	
	
	public Order(long order_id, String order_name, List<Coffee> coffees, double total_price) {
		super();
		this.order_id = order_id;
		this.order_name = order_name;
		this.coffees = coffees;
		this.total_price = total_price;
	}
	
	
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public List<Coffee> getCoffees() {
		return coffees;
	}
	public void setCoffees(List<Coffee> coffees) {
		this.coffees = coffees;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_name=" + order_name + ", coffees=" + coffees + ", total_price="
				+ total_price + "]";
	}
	
	
	
}
