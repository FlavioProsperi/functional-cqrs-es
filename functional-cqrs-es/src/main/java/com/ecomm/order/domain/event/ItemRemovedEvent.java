package com.ecomm.order.domain.event;

import java.io.Serializable;

import com.ecomm.order.domain.ShopItem;


public class ItemRemovedEvent implements EventMessage, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5057743903662251460L;

	private String cartId;
	
	private ShopItem shopItem;

	public ItemRemovedEvent(){}
	
	public ItemRemovedEvent(String cartId, ShopItem shopItem) {
		super();
		this.cartId = cartId;
		this.shopItem = shopItem;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public ShopItem getShopItem() {
		return shopItem;
	}

	public void setShopItem(ShopItem shopItem) {
		this.shopItem = shopItem;
	}

	@Override
	public Object getAggregateIdentifier() {
		return cartId;
	}
	
}
