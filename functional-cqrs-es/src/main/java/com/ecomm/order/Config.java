package com.ecomm.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecomm.order.domain.ShoppingCart;
import com.ecomm.order.eventstore.EventSerializer;
import com.ecomm.order.eventstore.EventStore;
import com.ecomm.order.repository.EventSourcedRepository;

@Configuration
public class Config {

	@Autowired
	private EventStore eventStore;
	
	@Autowired
	private EventSerializer eventSerializer;
	
	@Bean
	public EventSourcedRepository<ShoppingCart> eventSourcedShoppingCartRepository(){
		return new EventSourcedRepository<ShoppingCart>(ShoppingCart.class, eventStore, eventSerializer);
	}
}
