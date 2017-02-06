package com.uni.fems.dto;

public class LctrumVO {
	private String lr_Lctrum_No;   // 강의실 번호
	private String lr_Bd_No;   // 건물 번호
	private int lr_Floor;   // 층수
	private int lr_Roomno;   // 호실
	private int lr_Accept_Nmpr;   // 수용인원
	private String lr_useyn;   // 강의실 사용유무
	public String getLr_Lctrum_No() {
		return lr_Lctrum_No;
	}
	public void setLr_Lctrum_No(String lr_Lctrum_No) {
		this.lr_Lctrum_No = lr_Lctrum_No;
	}
	public String getLr_Bd_No() {
		return lr_Bd_No;
	}
	public void setLr_Bd_No(String lr_Bd_No) {
		this.lr_Bd_No = lr_Bd_No;
	}
	public int getLr_Floor() {
		return lr_Floor;
	}
	public void setLr_Floor(int lr_Floor) {
		this.lr_Floor = lr_Floor;
	}
	public int getLr_Roomno() {
		return lr_Roomno;
	}
	public void setLr_Roomno(int lr_Roomno) {
		this.lr_Roomno = lr_Roomno;
	}
	public int getLr_Accept_Nmpr() {
		return lr_Accept_Nmpr;
	}
	public void setLr_Accept_Nmpr(int lr_Accept_Nmpr) {
		this.lr_Accept_Nmpr = lr_Accept_Nmpr;
	}
	public String getLr_useyn() {
		return lr_useyn;
	}
	public void setLr_useyn(String lr_useyn) {
		this.lr_useyn = lr_useyn;
	}
	@Override
	public String toString() {
		return "LctrumVO [lr_Lctrum_No=" + lr_Lctrum_No + ", lr_Bd_No="
				+ lr_Bd_No + ", lr_Floor=" + lr_Floor + ", lr_Roomno="
				+ lr_Roomno + ", lr_Accept_Nmpr=" + lr_Accept_Nmpr
				+ ", lr_useyn=" + lr_useyn + "]";
	}
	
	

}
