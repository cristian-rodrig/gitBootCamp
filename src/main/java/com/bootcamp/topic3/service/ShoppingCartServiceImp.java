package com.bootcamp.topic3.service;

import java.util.ArrayList;

import com.bootcamp.topic3.cart.CartItem;
import com.bootcamp.topic3.cart.ShoppingCart;

public class ShoppingCartServiceImp implements ShoppingCartService {
	
	private ArrayList<CartItem> items;
	
	
	public ShoppingCartServiceImp() {
		items = new ArrayList<CartItem>();
	}

	/**
	 * add a item from the cart
	 */
	public void addCartItem(CartItem item) {
		items.add(item);
	}

	/**
	 * delete a item from the cart
	 */
	public boolean deleteCartItem(CartItem item) {
		return items.remove(item);
	}

	/**
	 * Returns a item from the cart 
	 */
	public CartItem getCartItem(String id) {
		CartItem resutl;
		for (CartItem cartItem : items) {
			if (cartItem.getId() == id) {
				return cartItem;
			}
		}
		
		return null;
	}

	/**
	 * create a cart with the items added
	 */
	public ShoppingCart createShoppingCart() {
		return new ShoppingCart(items);
	}

	/**
	 * the cart is empty 
	 */
	public void clearCart() {
		items.clear();
	}

	

}
