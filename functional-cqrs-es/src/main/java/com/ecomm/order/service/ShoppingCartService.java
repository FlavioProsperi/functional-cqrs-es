package com.ecomm.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.order.domain.ShopItem;
import com.ecomm.order.domain.command.AddItemCommand;
import com.ecomm.order.domain.command.CreateCartCommand;
import com.ecomm.order.domain.command.RemoveItemCommand;
import com.ecomm.order.domain.event.CartCreatedEvent;
import com.ecomm.order.domain.event.ItemAddedEvent;
import com.ecomm.order.domain.event.ItemRemovedEvent;
import com.ecomm.order.inventory.domain.Item;
import com.ecomm.order.repository.ShoppingCartRepository;
import com.ecomm.order.store.ItemInventory;

@Component
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ItemInventory itemInventory;

	public void createCart(CreateCartCommand cartCommand){
		shoppingCartRepository.save(cartCommand.getCartId(),
				() -> new CartCreatedEvent(cartCommand.getCartId(), cartCommand.getCustId()));
	}
	
	public void addItem(AddItemCommand addItemCommand){
		Item item = itemInventory.getItem(addItemCommand.getItemId());
		ShopItem shopItem = new ShopItem(item.getId(), item.getName(), addItemCommand.getQuantity(), item.getPrice());
		shoppingCartRepository.save(addItemCommand.getCartId(),
				() -> new ItemAddedEvent(addItemCommand.getCartId(), addItemCommand.getCustId(), shopItem));
	}
	
	public void removeItem(RemoveItemCommand removeItemCommand){
		Item item = itemInventory.getItem(removeItemCommand.getItemId());
		ShopItem shopItem = new ShopItem(item.getId(), item.getName(), removeItemCommand.getQuantity(), item.getPrice());
		shoppingCartRepository.save(removeItemCommand.getCartId(),
				() -> new ItemRemovedEvent(removeItemCommand.getCartId(), removeItemCommand.getCustId(), shopItem));
	}
}
