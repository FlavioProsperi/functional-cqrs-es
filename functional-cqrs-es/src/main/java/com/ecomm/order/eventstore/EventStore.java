/**
 * 
 */
package com.ecomm.order.eventstore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.order.eventstore.domain.DomainEvent;

/**
 * @author Ashutosh.Jadhav
 *
 */
public interface EventStore extends JpaRepository<DomainEvent, Long> {

	public List<DomainEvent> findByAggregateIdentifier(String aggregateIdentifier);
	
	default void save(List<DomainEvent> domainEvents){
		save(domainEvents);
	}
}
