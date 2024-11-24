package com.kh.movie.model;

public class MovieVO {
	private int m_id;		// 영화 ID pk
	private String title;	// 영화 제목 uk
	private String genre;	// 장르
	private int duration;	// 상영 시간 (분 단위)
	private int c_id;		// 영화관 ID fk
	
	public MovieVO() {}

	public MovieVO(int m_id, String title, String genre, int duration, int c_id) {
		super();
		this.m_id = m_id;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.c_id = c_id;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	@Override
	public String toString() {
		return "MovieVO [m_id=" + m_id + ", title=" + title + ", genre=" + genre + ", duration=" + duration + ", c_id="
				+ c_id + "]";
	}
	
	
}

