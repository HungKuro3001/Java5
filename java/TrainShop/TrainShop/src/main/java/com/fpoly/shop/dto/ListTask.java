package com.fpoly.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ListTask {

	private int newOrder; // số đơn hàng mới
	private int orderWaitting; // số đơn hàng chờ duyệt
	public int getNewOrder() {
		return newOrder;
	}
	public void setNewOrder(int newOrder) {
		this.newOrder = newOrder;
	}
	public int getOrderWaitting() {
		return orderWaitting;
	}
	public void setOrderWaitting(int orderWaitting) {
		this.orderWaitting = orderWaitting;
	}
	
	
}
