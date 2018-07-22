package com.bootcamp.topic3.service;

import com.bootcamp.topic3.cart.CartItem;
import com.bootcamp.topic3.cart.ShoppingCart;

public interface ShoppingCartService {
	
	public void addCartItem(CartItem item);
	public boolean deleteCartItem (CartItem item);
	public CartItem getCartItem (int id);
	public ShoppingCart createShoppingCart ();
	public void clearCart();

}
