package com.ecomm.order.domain.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCartCommand implements Command{

	private String cartId;
	
	private String custId;
	
}
