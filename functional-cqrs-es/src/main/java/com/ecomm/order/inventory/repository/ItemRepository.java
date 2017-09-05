package com.ecomm.order.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.order.inventory.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>  {

	public Item findById(String itemId);
}
