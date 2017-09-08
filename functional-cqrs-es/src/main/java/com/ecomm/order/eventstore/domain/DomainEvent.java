package com.ecomm.order.eventstore.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity(name="domain_event")
public class DomainEvent {

	@Id
	@TableGenerator(name="event_sequence", table="event_sequence", pkColumnName="seq_gen", valueColumnName="val_gen")
	@GeneratedValue(generator="event_sequence", strategy=GenerationType.TABLE)
	@Column(name="global_index")
	private Long globalIndex;
	
	@Column(name="event_identifier", unique=true)
	private String eventIdentifier;
	
	@Column(name="pay_load")
	private String payLoad;
	
	@Column(name="payload_revision")
	private String payLoadRevision;
	
	@Column(name="payload_type")
	private String payLoadType;
	
	@Column(name="time_stamp")
	private Timestamp timeStamp;
	
	@Column(name="aggregate_identifier")
	private String aggregateIdentifier;
	
	@Column(name="sequence_number")
	private Long sequenceNumber;
	
	@Column(name="type")
	private String type;
	
	public DomainEvent(){}

	public DomainEvent(Long globalIndex, String eventIdentifier, String payLoad, String payLoadRevision,
			String payLoadType, Timestamp timeStamp, String aggregateIdentifier, Long sequenceNumber, String type) {
		super();
		this.globalIndex = globalIndex;
		this.eventIdentifier = eventIdentifier;
		this.payLoad = payLoad;
		this.payLoadRevision = payLoadRevision;
		this.payLoadType = payLoadType;
		this.timeStamp = timeStamp;
		this.aggregateIdentifier = aggregateIdentifier;
		this.sequenceNumber = sequenceNumber;
		this.type = type;
	}

	public Long getGlobalIndex() {
		return globalIndex;
	}

	public void setGlobalIndex(Long globalIndex) {
		this.globalIndex = globalIndex;
	}

	public String getEventIdentifier() {
		return eventIdentifier;
	}

	public void setEventIdentifier(String eventIdentifier) {
		this.eventIdentifier = eventIdentifier;
	}

	public String getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(String payLoad) {
		this.payLoad = payLoad;
	}

	public String getPayLoadRevision() {
		return payLoadRevision;
	}

	public void setPayLoadRevision(String payLoadRevision) {
		this.payLoadRevision = payLoadRevision;
	}

	public String getPayLoadType() {
		return payLoadType;
	}

	public void setPayLoadType(String payLoadType) {
		this.payLoadType = payLoadType;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getAggregateIdentifier() {
		return aggregateIdentifier;
	}

	public void setAggregateIdentifier(String aggregateIdentifier) {
		this.aggregateIdentifier = aggregateIdentifier;
	}

	public Long getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
