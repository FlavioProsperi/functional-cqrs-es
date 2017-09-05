package com.ecomm.order.domain;

import java.util.ArrayList;
import java.util.List;

import com.ecomm.order.domain.event.CartCreatedEvent;
import com.ecomm.order.domain.event.EventMessage;
import com.ecomm.order.domain.event.ItemAddedEvent;
import com.ecomm.order.domain.event.ItemRemovedEvent;

import lombok.Getter;

@Getter 
public class ShoppingCart {

	private String cartId;
	
	private String custId;
	
	private List<ShopItem> shopItems;
	
	public ShoppingCart(){
	}
	
	/* EVENT SOURCING HANDLER */
	public void handle(CartCreatedEvent cartCreatedEvent){
		this.cartId = cartCreatedEvent.getCartId();
		this.custId = cartCreatedEvent.getCustId();
	}
	
	/* EVENT SOURCING HANDLER */
	public void handle(ItemAddedEvent itemAddedEvent){
		this.cartId = itemAddedEvent.getCartId();
		this.custId = itemAddedEvent.getCustomerId();
		ShopItem items1 = null;
		if(shopItems!=null){
			for (ShopItem items2 : shopItems) {
				if(items2.getItemId().equals(itemAddedEvent.getShopItem().getItemId())){
					items1 = items2;
				}
			}	
		} else {
			shopItems = new ArrayList<ShopItem>();
		}
		
		if(items1!=null){
			items1.setQuantity(items1.getQuantity() +  itemAddedEvent.getShopItem().getQuantity());
		} else {
			items1 = new ShopItem(itemAddedEvent.getShopItem().getItemId(), itemAddedEvent.getShopItem().getName(), itemAddedEvent.getShopItem().getQuantity(), itemAddedEvent.getShopItem().getPrice());
			shopItems.add(items1);
		}
		System.out.println("+++++++++++++ Items in cart at source "+shopItems);
	}
	
	/* EVENT SOURCING HANDLER */
	public void handle(ItemRemovedEvent itemRemovedEvent){
		this.cartId = itemRemovedEvent.getCartId();
		this.custId = itemRemovedEvent.getCustomerId();
		ShopItem items1 = null;
		if(shopItems!=null){
			for (ShopItem items2 : shopItems) {
				if(items2.getItemId().equals(itemRemovedEvent.getShopItem().getItemId())){
					items1 = items2;
				}
			}	
		}	
		if(items1!=null){
			if(items1.getQuantity() -  itemRemovedEvent.getShopItem().getQuantity()<=0){
				shopItems.remove(items1);
			} else {
				items1.setQuantity(items1.getQuantity() -  itemRemovedEvent.getShopItem().getQuantity());				
			}
		}
		System.out.println("+++++++++++++ Items in cart at source "+shopItems);
	}
	
	/* REBUILD AGGREGATE STATE */
	public static ShoppingCart reBuild(List<EventMessage> events){
		ShoppingCart shoppingCart = new ShoppingCart();
		if(!events.isEmpty()){
			for (EventMessage eventMessage : events) {
				if(eventMessage instanceof CartCreatedEvent){
					CartCreatedEvent cartCreatedEvent = (CartCreatedEvent) eventMessage;
					shoppingCart.handle(cartCreatedEvent);
				}
			}
		}
		return shoppingCart;
	}
}
