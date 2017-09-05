package com.ecomm.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ShopItem {

	private String itemId;
	
	private String name;
	
	private int quantity;
	
	private double price;
	
}
