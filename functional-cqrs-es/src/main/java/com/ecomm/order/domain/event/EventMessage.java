package com.ecomm.order.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface EventMessage {
	
	@JsonIgnore
	public Object getAggregateIdentifier();
	/*
	
	public Timestamp getTimeStamp();
	
	public Long getSequence();
	
	public Object getAggregateIdentifier();
	
	public Class<T> getType();
	
	public T getPayLoad();
*/}
