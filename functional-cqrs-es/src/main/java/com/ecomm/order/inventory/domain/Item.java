package com.ecomm.order.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="items")
public class Item {

	@Id
	private String id;
	
	private String name;
	
	private int quantity;
	
	private double price;

	public Item(){
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}