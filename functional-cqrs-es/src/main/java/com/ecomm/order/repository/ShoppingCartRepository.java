package com.ecomm.order.repository;

import java.util.function.Supplier;

import com.ecomm.order.domain.ShoppingCart;
import com.ecomm.order.domain.event.EventMessage;

public interface ShoppingCartRepository {

	public ShoppingCart findById(String cartId) throws Exception;
	
	public void save(String aggregateId, Supplier<EventMessage> function1);
	
}
