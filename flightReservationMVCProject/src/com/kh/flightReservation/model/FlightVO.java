package com.kh.flightReservation.model;

import java.sql.Date;

public class FlightVO {
	private int no;
	private int aNo;
    private Date departmentDate;
    private String departmentAirport;
    private String arrivalAirport;
    private int price;
    private String seat;
	public FlightVO() {}
	public FlightVO(int no, int aNo, Date departmentDate, String departmentAirport, String arrivalAirport, int price,
			String seat) {
		super();
		this.no = no;
		this.aNo = aNo;
		this.departmentDate = departmentDate;
		this.departmentAirport = departmentAirport;
		this.arrivalAirport = arrivalAirport;
		this.price = price;
		this.seat = seat;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public Date getDepartmentDate() {
		return departmentDate;
	}
	public void setDepartmentDate(Date departmentDate) {
		this.departmentDate = departmentDate;
	}
	public String getDepartmentAirport() {
		return departmentAirport;
	}
	public void setDepartmentAirport(String departmentAirport) {
		this.departmentAirport = departmentAirport;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "FlightVO [no=" + no + ", aNo=" + aNo + ", departmentDate=" + departmentDate + ", departmentAirport="
				+ departmentAirport + ", arrivalAirport=" + arrivalAirport + ", price=" + price + ", seat=" + seat
				+ "]";
	}
	
    
    
}