package com.bootcamp.topic3.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bootcamp.topic3.cart.CartItem;
import com.bootcamp.topic3.service.ShoppingCartService;
import com.bootcamp.topic3.service.ShoppingCartServiceFactory;

public class ShoppingCartServiceTest {
	
	private ShoppingCartService service;
	private CartItem c2;
	private CartItem c1;
	
	@Before
	public void setUp(){
		service = ShoppingCartServiceFactory.getShoppingCartService();

		c1 = new CartItem("p1", 10, 2);
		c2 = new CartItem("p2", 40, 3);
	
		service.addCartItem(c1);
		service.addCartItem(c2);
	}
	
	@After
	public void after(){
		service.clearCart();
	}

	@Test
	public void addCartItemTest() {
		assertNotNull(service.getCartItem(c1.getId()));
	}
	
	@Test
	public void deleteItemTest(){
		assertTrue(service.deleteCartItem(c2));
	}
	
	@Test
	public void getItemTest(){
		assertNotNull(service.getCartItem(c1.getId()));
	}
	
	@Test
	public void createShoppingCartTest(){
		Double expectedTotal = (double) 140;
		double actualTotal = service.createShoppingCart().getTotal();
		assertTrue(expectedTotal == actualTotal);
	}
	
	
	@Test
+	public void addNullItemTest() {
+		service.addCartItem(null);
		int cantItems=service.createShoppingCart().getItems().size();
		AssertTrue(cantItems==0);
	}
	
	@Test
+	public void deleteNullItemTest() {
+		AssertFalse(service.deleteCartItem(null));
	}
