package com.ecommerce.dto;

import java.util.List;

public class CartDto {
	private List<CartItemDto> cartItems;
	private double totalCost;

	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDto(List<CartItemDto> cartItems, double totalCost) {
		super();
		this.cartItems = cartItems;
		this.totalCost = totalCost;
	}

	public List<CartItemDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
