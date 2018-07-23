package com.bootcamp.topic3.cart;
import java.util.UUID;

/**
 * @author cgrod
 *
 */

public class CartItem {
	public static int idGenerator = 0;
	public int id;
	public String name;
	public double price;
	public int quantity;

	public CartItem(String name, double price, int quantitie) {

		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.price = price;
		this.quantity = quantitie;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	public static void setIdGenerator(int idGenerator) {
		CartItem.idGenerator = idGenerator;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantitie(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", price=" + price + ", quantitie=" + quantity + "]";
	}

}
