package com.uni.fems.dto;

public class MenuVO {
	private int mn_No;   // 메뉴번호
	private String mn_Se_Code;   // 구분코드
	private String mn_Cours;   // 경로
	public int getMn_No() {
		return mn_No;
	}
	public void setMn_No(int mn_No) {
		this.mn_No = mn_No;
	}
	public String getMn_Se_Code() {
		return mn_Se_Code;
	}
	public void setMn_Se_Code(String mn_Se_Code) {
		this.mn_Se_Code = mn_Se_Code;
	}
	public String getMn_Cours() {
		return mn_Cours;
	}
	public void setMn_Cours(String mn_Cours) {
		this.mn_Cours = mn_Cours;
	}
	@Override
	public String toString() {
		return "MenuVO [mn_No=" + mn_No + ", mn_Se_Code=" + mn_Se_Code
				+ ", mn_Cours=" + mn_Cours + "]";
	}

}
