package com.uni.fems.dto;

public class AtrtyVO {
	private String au_User_No;   // 사용자번호
	private String au_Atrty;   // 권한
	public String getAu_User_No() {
		return au_User_No;
	}
	public void setAu_User_No(String au_User_No) {
		this.au_User_No = au_User_No;
	}
	public String getAu_Atrty() {
		return au_Atrty;
	}
	public void setAu_Atrty(String au_Atrty) {
		this.au_Atrty = au_Atrty;
	}
	@Override
	public String toString() {
		return "AtrtyVO [au_User_No=" + au_User_No + ", au_Atrty=" + au_Atrty
				+ "]";
	}

}
