package com.ecomm.order.domain.event;

import java.io.Serializable;

import com.ecomm.order.domain.ShopItem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemRemovedEvent implements EventMessage, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5057743903662251460L;

	private String cartId;
	
	private String customerId;
	
	private ShopItem shopItem;
	
}
