package com.ecomm.order.repository;

import java.util.function.Supplier;

import com.ecomm.order.domain.event.EventMessage;

public interface Repository<T> {

	public T findById(String cartId) throws Exception;
	
	public void createEvent(Supplier<EventMessage> supplier);
}
