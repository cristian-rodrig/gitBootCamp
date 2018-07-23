package com.bootcamp.topic3.cart;

import java.util.ArrayList;

public class ShoppingCart {
	
	private ArrayList<CartItem> items;
	private double total; 
	
	public ShoppingCart(ArrayList<CartItem> items) {
		this.items = items;
		this.total = 0;
		this.calculateTotal();
	}
	
	private void calculateTotal() {
		for (CartItem cartItem : items) {
			total += cartItem.getPrice()*cartItem.getQuantity();
		}
	}

	public double getTotal(){
		return total;
	}
	
	public ArrayList<CartItem> getItems(){
		return items;
	}

}
