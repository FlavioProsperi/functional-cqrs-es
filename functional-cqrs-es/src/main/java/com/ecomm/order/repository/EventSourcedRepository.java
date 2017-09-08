package com.ecomm.order.repository;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ecomm.order.domain.event.EventMessage;
import com.ecomm.order.eventstore.EventSerializer;
import com.ecomm.order.eventstore.EventStore;
import com.ecomm.order.eventstore.domain.DomainEvent;

public class EventSourcedRepository<T> implements Repository<T> {

	private Class<T> type;
	
	private EventStore eventStore;

	private EventSerializer eventSerializer;

	public EventSourcedRepository(Class<T> classType, EventStore eventStore, EventSerializer eventSerializer){
		this.eventSerializer = eventSerializer;
		this.eventStore = eventStore;
		this.type = classType;
	}
	
	/**
	 * Recreates the aggregate if exist, if user queries for it. Throws
	 * exception if aggregate(related events) doesn't exist.
	 **/
	@Override
	public T findById(String cartId) throws Exception {
		Stream<DomainEvent> domainEvents = findEventsByUUID(cartId);
		List<EventMessage> eventMessages = deserialize(domainEvents);
		if (eventMessages.isEmpty()) {
			throw new Exception("Aggregate not found");
		}
		return null;
	}

	private Stream<DomainEvent> findEventsByUUID(String uuid) {
		return eventStore.findByAggregateIdentifier(uuid).stream();
	}

	private List<EventMessage> deserialize(Stream<DomainEvent> domainEvents) {
		return domainEvents.map(eventSerializer::deserialize).collect(Collectors.toList());
	}

	/**
	 * Saves event corresponding to command received by service supplied by Supplier Function.
	 **/
	@Override
	public void createEvent(Supplier<EventMessage> eventSupplier) {
		EventMessage eventMessage = eventSupplier.get();
		Stream<DomainEvent> domainEvents = this.findEventsByUUID((String)eventMessage.getAggregateIdentifier());
		List<EventMessage> eventMessages = domainEvents.sorted(Comparator.comparing(DomainEvent::getSequenceNumber)).map(eventSerializer::deserialize).collect(Collectors.toList());
		Long sequenceNumber = 0l;
		if (!eventMessages.isEmpty()) {
			sequenceNumber = (long) eventMessages.size();
		}
		DomainEvent domainEvent = new DomainEvent(null, UUID.randomUUID().toString(),
				eventSerializer.serialize(eventMessage), null, eventMessage.getClass().getName(),
				new Timestamp(System.currentTimeMillis()), (String)eventMessage.getAggregateIdentifier(), sequenceNumber,
				type.getName());
		eventStore.save(domainEvent);
	}
}
