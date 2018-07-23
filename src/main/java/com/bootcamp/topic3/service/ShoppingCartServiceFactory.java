package com.bootcamp.topic3.service;

public class ShoppingCartServiceFactory {

	public static ShoppingCartService getShoppingCartService(){
		return new ShoppingCartServiceImp();
	}
	
}
