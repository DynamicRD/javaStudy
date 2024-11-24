package com.kh.movie.model;

public class CinemaVO {
    private int c_id;              	//영화관 ID pk
    private String name;           	//영화관 이름
    private String location;       	//영화관 위치
    private int ad_num; 			//수용 가능 인원 
    
	public CinemaVO() {}

	public CinemaVO(int c_id, String name, String location, int ad_num) {
		super();
		this.c_id = c_id;
		this.name = name;
		this.location = location;
		this.ad_num = ad_num;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAd_num() {
		return ad_num;
	}

	public void setAd_num(int ad_num) {
		this.ad_num = ad_num;
	}

	@Override
	public String toString() {
		return "CinemaVO [c_id=" + c_id + ", name=" + name + ", location=" + location + ", ad_num=" + ad_num + "]";
	}
	
    
    
}
