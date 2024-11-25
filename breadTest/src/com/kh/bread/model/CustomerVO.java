package com.kh.bread.model;

public class CustomerVO {
	private int cNo;
	private String name;
	private int bNo;
	private int amount;

	public CustomerVO() {
	}

	public CustomerVO(int cNo, String name, int bNo, int amount) {
		super();
		this.cNo = cNo;
		this.name = name;
		this.bNo = bNo;
		this.amount = amount;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CustomerVO [cNo=" + cNo + ", name=" + name + ", bNo=" + bNo + ", amount=" + amount + "]";
	}

}
