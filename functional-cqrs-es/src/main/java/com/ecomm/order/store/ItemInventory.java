package com.ecomm.order.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.order.inventory.domain.Item;
import com.ecomm.order.inventory.repository.ItemRepository;

@Component
public class ItemInventory {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item getItem(String itemId){
		return itemRepository.findById(itemId);
	}
	
	public void updateItem(Item item){
		itemRepository.save(item);
	}

	@Override
	public String toString() {
		List<Item> list = itemRepository.findAll();
		return "ItemStore [items=" + list + "]";
	}
	
}
