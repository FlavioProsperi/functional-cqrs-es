package com.ecomm.order.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.order.domain.ShoppingCart;
import com.ecomm.order.domain.event.EventMessage;
import com.ecomm.order.eventstore.EventSerializer;
import com.ecomm.order.eventstore.EventStore;
import com.ecomm.order.eventstore.domain.DomainEvent;

@Component
public class EventSourcedShoppingCartRepository implements ShoppingCartRepository {

	@Autowired
	private EventStore eventStore;
	
	@Autowired
	private EventSerializer eventSerializer;
	
	@Override
	public ShoppingCart findById(String cartId) throws Exception {
		Stream<DomainEvent> domainEvents = findEventsByUUID(cartId);
		List<EventMessage> eventMessages = deserialize(domainEvents);
		if(eventMessages.isEmpty()){
			throw new Exception("Aggregate not found");
		}
		return ShoppingCart.reBuild(eventMessages);
	}
	
	@Override
	public void save(String aggregateId, Supplier<EventMessage> function1) {
		Stream<DomainEvent> domainEvents = this.findEventsByUUID(aggregateId);
		List<EventMessage> eventMessages = deserialize(domainEvents);
		Long sequenceNumber = 0l;
		if(!eventMessages.isEmpty()){
			sequenceNumber = (long)eventMessages.size();
		}
		ShoppingCart shoppingCart = ShoppingCart.reBuild(eventMessages);
		EventMessage eventMessage = function1.get();
		DomainEvent domainEvent = new DomainEvent(null, UUID.randomUUID().toString(), eventSerializer.serialize(eventMessage), null, eventMessage.getClass().getName(), new Timestamp(System.currentTimeMillis()), aggregateId, sequenceNumber, shoppingCart.getClass().getName()); 
		eventStore.save(domainEvent);
	}

	private Stream<DomainEvent> findEventsByUUID(String uuid){
		return eventStore.findByAggregateIdentifier(uuid).stream();
	}
	
	private ShoppingCart findAggregate(String uuid){
		return ShoppingCart.reBuild(deserialize(this.findEventsByUUID(uuid)));
	}
	
	private List<EventMessage> deserialize(Stream<DomainEvent> domainEvents){
		return domainEvents.map(eventSerializer::deserialize).collect(Collectors.toList());
	}
}
