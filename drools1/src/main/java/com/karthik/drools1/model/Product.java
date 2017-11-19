package com.karthik.drools1.model;

import java.math.BigDecimal;

public class Product {

	private String type;
	private int discount;
	private BigDecimal ltv;
	private boolean within;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public BigDecimal getLtv() {
		return ltv;
	}

	public void setLtv(BigDecimal ltv) {
		this.ltv = ltv;
	}

	public boolean isWithin() {
		return within;
	}

	public void setWithin(boolean within) {
		this.within = within;
	}
	
	
}
