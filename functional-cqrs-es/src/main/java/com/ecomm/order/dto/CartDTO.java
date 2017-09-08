package com.ecomm.order.dto;

import com.ecomm.order.domain.ShopItem;

public class CartDTO {
	
	private String custId;
	
	private String cartId;
	
	private ShopItem shopItem;

	public CartDTO(){}

	public String getCustId() {
		return custId;
	}

	public String getCartId() {
		return cartId;
	}

	public ShopItem getShopItem() {
		return shopItem;
	}

}
