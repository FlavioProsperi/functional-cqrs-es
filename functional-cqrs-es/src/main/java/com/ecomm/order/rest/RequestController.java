package com.ecomm.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.order.domain.command.AddItemCommand;
import com.ecomm.order.domain.command.CreateCartCommand;
import com.ecomm.order.domain.command.RemoveItemCommand;
import com.ecomm.order.service.ShoppingCartService;

@RestController
@RequestMapping("/cart")
public class RequestController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	@PostMapping("/create")
	public void createCart(@RequestBody CreateCartCommand createCartCommand){
		shoppingCartService.createCart(createCartCommand);
	}
	
	@PostMapping("/addItem")
	public void addItem(@RequestBody AddItemCommand addItemCommand){
		shoppingCartService.addItem(addItemCommand);
	}
	
	@PostMapping("/removeItem")
	public void removeItem(@RequestBody RemoveItemCommand removeItemCommand){
		shoppingCartService.removeItem(removeItemCommand);
	}
}
