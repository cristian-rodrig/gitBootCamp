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
	 * agrega un item al carro
	 */
	public void addCartItem(CartItem item) {
		items.add(item);
	}

	/**
	 * borra un item del carro
	 */
	public boolean deleteCartItem(CartItem item) {
		return items.remove(item);
	}

	/**
	 * Devuelve un item del carro dado un ID
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
	 * crea un carrito de compras con los items agregados
	 */
	public ShoppingCart createShoppingCart() {
		return new ShoppingCart(items);
	}

	/**
	 * Borra todos los items del carro
	 */
	public void clearCart() {
		items.clear();
	}

}
