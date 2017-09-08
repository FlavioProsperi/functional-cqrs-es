package com.ecomm.order.domain;

import java.util.ArrayList;
import java.util.List;

import com.ecomm.order.domain.event.CartCreatedEvent;
import com.ecomm.order.domain.event.EventMessage;
import com.ecomm.order.domain.event.ItemAddedEvent;
import com.ecomm.order.domain.event.ItemRemovedEvent;
import com.ecomm.order.domain.event.ItemUpdatedEvent;

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
		if(shopItems!=null && !shopItems.stream().anyMatch(item -> item.getItemId().equals(itemAddedEvent.getShopItem().getItemId()))){
			shopItems.add(itemAddedEvent.getShopItem());
		} else {
			shopItems = new ArrayList<ShopItem>();
			shopItems.add(itemAddedEvent.getShopItem());
		}
		System.out.println("+++++++++++++ Items in cart at source "+shopItems);
	}
	
	/* EVENT SOURCING HANDLER */
	public void handle(ItemRemovedEvent itemRemovedEvent){
		this.cartId = itemRemovedEvent.getCartId();
		if(shopItems!=null){
			shopItems.removeIf(item -> item.getItemId().equals(itemRemovedEvent.getShopItem().getItemId()));
		}	 
		System.out.println("+++++++++++++ Items in cart at source "+shopItems);
	}
	
	public void handle(ItemUpdatedEvent itemUpdatedEvent){
		this.cartId = itemUpdatedEvent.getCartId();
		if(shopItems!=null && shopItems.removeIf(item -> item.getItemId().equals(itemUpdatedEvent.getShopItem().getItemId()))){
			shopItems.add(itemUpdatedEvent.getShopItem());
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
				if(eventMessage instanceof ItemAddedEvent){
					ItemAddedEvent itemAddedEvent = (ItemAddedEvent) eventMessage;
					shoppingCart.handle(itemAddedEvent);
				}
				if(eventMessage instanceof ItemUpdatedEvent){
					ItemUpdatedEvent itemUpdatedEvent = (ItemUpdatedEvent) eventMessage;
					shoppingCart.handle(itemUpdatedEvent);
				}
				if(eventMessage instanceof ItemRemovedEvent){
					ItemRemovedEvent itemRemovedEvent = (ItemRemovedEvent) eventMessage;
					shoppingCart.handle(itemRemovedEvent);
				}
			}
		}
		return shoppingCart;
	}

	public String getCartId() {
		return cartId;
	}

	public String getCustId() {
		return custId;
	}

	public List<ShopItem> getShopItems() {
		return shopItems;
	}
	
}
