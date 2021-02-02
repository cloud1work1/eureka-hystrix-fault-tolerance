package com.techlabs.shristi.model;

import java.util.List;

public class Order {

	private int orderId;
	private List<Product> items;
	private double total;
	public Order() {
		super();
	}
	public Order(int orderId, List<Product> items, double total) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.total = total;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Product> getItems() {
		return items;
	}
	public void setItems(List<Product> items) {
		this.items = items;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
