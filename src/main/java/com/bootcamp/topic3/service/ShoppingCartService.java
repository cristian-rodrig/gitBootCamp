package com.bootcamp.topic3.service;

import com.bootcamp.topic3.cart.CartItem;
import com.bootcamp.topic3.cart.ShoppingCart;

public interface ShoppingCartService {
	
	/**
	 * 
	 * @param CartItem. Item that will be added to cart.
	 */
	public void addCartItem(CartItem item);
	
	/**
	 * 
	 * @param CartItem. Item that will be delete from the cart.
	 */
	public boolean deleteCartItem (CartItem item);
	
	
	/**
	 * 
	 * @param int id. Item that will be get it from the cart.
	 */
	public CartItem getCartItem (int id);
	
	/**
	 * 
	 * @param create a shopping cart.
	 */
	public ShoppingCart createShoppingCart ();
	
	/**
	 * 
	 * @param clear the cart.
	 */
	public void clearCart();

}
