package com.kh.bread.model;

public class MenuTableVO {
	private int bNo;
	private String name;
	private int price;

	public MenuTableVO() {
	}

	public MenuTableVO(int bNo, String name, int price, int stock) {
		super();
		this.bNo = bNo;
		this.name = name;
		this.price = price;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "MenuTableVO [bNo=" + bNo + ", name=" + name + ", price=" + price + "]";
	}

}
