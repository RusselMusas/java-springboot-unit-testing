package com.rmm.software.javaspringbootunittesting.model;

import lombok.Data;

@Data
public class Item {
	
	private int id;
	private String name;
	private int price;
	private int quantity;
	
	public Item() {
		super();
	}

	public Item(int id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("[%d, %s, %d, %d]", id, name, price, quantity);
	}
	
}
