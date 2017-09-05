package com.ecomm.order.eventstore;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.ecomm.order.domain.event.EventMessage;
import com.ecomm.order.eventstore.domain.DomainEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class EventSerializer {

	private final ObjectMapper objectMapper;

	EventSerializer() {
		this.objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	public String serialize(EventMessage event) {
		try {
			return objectMapper.writeValueAsString(event);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public EventMessage deserialize(DomainEvent domainEvent) {
		try {
			return (EventMessage) objectMapper.readValue(domainEvent.getPayLoad(), Class.forName(domainEvent.getPayLoadType()));
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
