package com.ecomm.order.domain.event;

import java.io.Serializable;


public class CartCreatedEvent implements EventMessage, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9122538307444916436L;

	private String cartId;
	
	private String custId;
	
	public CartCreatedEvent(){}

	public CartCreatedEvent(String cartId, String custId) {
		super();
		this.cartId = cartId;
		this.custId = custId;
	}

	public String getCartId() {
		return cartId;
	}

	public String getCustId() {
		return custId;
	}

	@Override
	public Object getAggregateIdentifier() {
		return cartId;
	}
	
}
