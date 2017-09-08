package com.ecomm.order.domain.command;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.order.domain.ShopItem;
import com.ecomm.order.domain.ShoppingCart;
import com.ecomm.order.domain.event.CartCreatedEvent;
import com.ecomm.order.domain.event.ItemAddedEvent;
import com.ecomm.order.domain.event.ItemRemovedEvent;
import com.ecomm.order.domain.event.ItemUpdatedEvent;
import com.ecomm.order.repository.EventSourcedRepository;

@Component
public class ShoppingCartCommands {

	@Autowired
	private EventSourcedRepository<ShoppingCart> shoppingCartRepository;

	public void createCart(String customerId) {
		String aggregateId = UUID.randomUUID().toString();
		shoppingCartRepository.createEvent(() -> new CartCreatedEvent(aggregateId, customerId));
	}

	public void addItem(String aggregateId, ShopItem shopItem) {
		shoppingCartRepository.createEvent(() -> new ItemAddedEvent(aggregateId, shopItem));
	}

	public void updateItem(String aggregateId, ShopItem shopItem) {
		shoppingCartRepository.createEvent(() -> new ItemUpdatedEvent(aggregateId, shopItem));
	}

	public void removeItem(String aggregateId, ShopItem shopItem) {
		shoppingCartRepository.createEvent(() -> new ItemRemovedEvent(aggregateId, shopItem));
	}
}
