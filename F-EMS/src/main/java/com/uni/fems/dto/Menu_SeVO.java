package com.uni.fems.dto;

public class Menu_SeVO {
	private String ms_Se_Code;   // 구분코드
	private String ms_Type;   // 유형
	public String getMs_Se_Code() {
		return ms_Se_Code;
	}
	public void setMs_Se_Code(String ms_Se_Code) {
		this.ms_Se_Code = ms_Se_Code;
	}
	public String getMs_Type() {
		return ms_Type;
	}
	public void setMs_Type(String ms_Type) {
		this.ms_Type = ms_Type;
	}
	@Override
	public String toString() {
		return "Menu_SeVO [ms_Se_Code=" + ms_Se_Code + ", ms_Type=" + ms_Type
				+ "]";
	}

}
