package com.kh.movie.model;

public class AudienceVO {
	private int a_id;		//관객 ID pk
	private String name;	//관객 이름
	private int phone;		//전화 번호 uk
	private int c_id;		//영화관 ID fk
	
	public AudienceVO() {}
	public AudienceVO(int a_id, String name, int phone, int c_id) {
		super();
		this.a_id = a_id;
		this.name = name;
		this.phone = phone;
		this.c_id = c_id;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	@Override
	public String toString() {
		return "Audience [a_id=" + a_id + ", name=" + name + ", phone=" + phone + ", c_id=" + c_id + "]";
	};	
	
	
	
}
