package com.ecomm.order.domain.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RemoveItemCommand implements Command {
	
	private String cartId;
	
	private String custId;
	
	private String itemId;

	private int quantity;
	
}
