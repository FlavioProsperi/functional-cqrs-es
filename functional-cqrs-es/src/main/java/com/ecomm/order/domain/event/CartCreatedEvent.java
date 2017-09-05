package com.ecomm.order.domain.event;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CartCreatedEvent implements EventMessage, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9122538307444916436L;

	private String cartId;
	
	private String custId;
}
