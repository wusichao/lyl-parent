package org.lyl.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LocGoodsOrder implements Serializable{
	private Long id;
	private Long orderId;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
