package org.lyl.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Goods implements Serializable {
	/**
	 * <p>Discription:[]</p>
	 */
	private Long id;
	private String name;
	private Long price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
}
