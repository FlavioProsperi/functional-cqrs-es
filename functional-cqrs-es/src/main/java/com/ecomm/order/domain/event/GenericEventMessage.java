/*package com.ecomm.order.domain.event;

import java.time.Instant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericEventMessage<T> implements EventMessage<T> {

	private Instant timeStamp;
	
	private Long sequence;
	
	private Object aggregateIdentifier;
	
	private Class aggregateType;
	
	private T payLoad;
	
	@Override
	public Instant getTimeStamp() {
		return this.timeStamp;
	}

	@Override
	public Long getSequence() {
		return this.sequence;
	}

	@Override
	public Object getAggregateIdentifier() {
		return this.aggregateIdentifier;
	}

	@Override
	public Class getAggregateType() {
		return this.aggregateType;
	}

	@Override
	public T getPayLoad() {
		return this.payLoad;
	}

}
*/