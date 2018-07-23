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
	 * add a item to cart
	 */
	public void addCartItem(CartItem item) {
		items.add(item);
	}

	/**
	 * deelte a item to cart
	 */
	public boolean deleteCartItem(CartItem item) {
		return items.remove(item);
	}

	/**
	 * Returns a item from cart 
	 */
	public CartItem getCartItem(int id) {
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
	 * delete all the items from the cart
	 */
	public void clearCart() {
		items.clear();
	}

}
