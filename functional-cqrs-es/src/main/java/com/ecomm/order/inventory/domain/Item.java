package com.ecomm.order.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity(name="items")
@AllArgsConstructor
@Getter
public class Item {

	@Id
	private String id;
	
	private String name;
	
	private int quantity;
	
	private double price;

	public Item(){
	}

}