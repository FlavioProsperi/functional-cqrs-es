package com.ecomm.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.order.domain.command.ShoppingCartCommands;
import com.ecomm.order.dto.CartDTO;

@RestController
@RequestMapping("/cart")
public class RequestController {
	
	@Autowired
	private ShoppingCartCommands shoppingCartCommands;

	@PostMapping("/create")
	public void createCart(@RequestParam String custId){
		shoppingCartCommands.createCart(custId);
	}
	
	/* CartDTO is used just to get cartId(aggregate identifier)   */
	@PostMapping("/addItem")
	public void addItem(@RequestBody CartDTO cartDTO){
		shoppingCartCommands.addItem(cartDTO.getCartId(), cartDTO.getShopItem());
	}
	
	/* CartDTO is used just to get cartId(aggregate identifier)   */
	@PostMapping("/removeItem")
	public void removeItem(@RequestBody CartDTO cartDTO){
		shoppingCartCommands.removeItem(cartDTO.getCartId(), cartDTO.getShopItem());
	}
	
	/* CartDTO is used just to get cartId(aggregate identifier)   */
	@PostMapping("/updateItem")
	public void updateItem(@RequestBody CartDTO cartDTO){
		shoppingCartCommands.updateItem(cartDTO.getCartId(), cartDTO.getShopItem());
	}
}
