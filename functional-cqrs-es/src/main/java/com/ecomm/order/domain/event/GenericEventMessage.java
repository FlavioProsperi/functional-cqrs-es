/*package com.ecomm.order.domain.event;

import java.sql.Timestamp;

public class GenericEventMessage<T> implements EventMessage<T> {

	private Timestamp timeStamp;
	
	private Long sequence;
	
	private Object aggregateIdentifier;
	
	private Class<T> type;
	
	private T payLoad;
	
	public GenericEventMessage(Timestamp timeStamp, Long sequence, Object aggregateIdentifier, Class<T> type,
			T payLoad) {
		super();
		this.timeStamp = timeStamp;
		this.sequence = sequence;
		this.aggregateIdentifier = aggregateIdentifier;
		this.type = type;
		this.payLoad = payLoad;
	}

	@Override
	public Timestamp getTimeStamp() {
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
	public Class<T> getType() {
		return this.type;
	}

	@Override
	public T getPayLoad() {
		return this.payLoad;
	}

}
*/