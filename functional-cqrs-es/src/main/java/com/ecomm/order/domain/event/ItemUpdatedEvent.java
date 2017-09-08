package com.ecomm.order.domain.event;

import java.io.Serializable;

import com.ecomm.order.domain.ShopItem;

public class ItemUpdatedEvent implements EventMessage, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7694166920720902028L;

	private String cartId;
	
	private ShopItem shopItem;
	
	public ItemUpdatedEvent(){}
	
	public ItemUpdatedEvent(String cartId, ShopItem shopItem){
		this.cartId =cartId;
		this.shopItem = shopItem;
	}

	public String getCartId() {
		return cartId;
	}

	public ShopItem getShopItem() {
		return shopItem;
	}

	@Override
	public Object getAggregateIdentifier() {
		return cartId;
	}

}
