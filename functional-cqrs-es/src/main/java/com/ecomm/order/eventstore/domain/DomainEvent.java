package com.ecomm.order.eventstore.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name="domain_event")
public class DomainEvent {

	@Id
	@TableGenerator(name="event_sequence", table="event_sequence", pkColumnName="seq_gen", valueColumnName="val_gen")
	@GeneratedValue(generator="event_sequence", strategy=GenerationType.TABLE)
	@Column(name="global_index")
	private Long globalIndex;
	
//	@Id
	@Column(name="event_identifier", unique=true)
	/*@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator="hibernate-uuid",strategy=GenerationType.IDENTITY)*/
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

}
