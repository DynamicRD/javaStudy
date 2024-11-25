package com.kh.bread.model;

public class ShopVO {
	private int no;
	private int bNo;
	private int income;

	public ShopVO() {
	}

	public ShopVO(int no, int bNo, int income) {
		super();
		this.no = no;
		this.bNo = bNo;
		this.income = income;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "ShopVO [no=" + no + ", bNo=" + bNo + ", income=" + income + "]";
	}

}
