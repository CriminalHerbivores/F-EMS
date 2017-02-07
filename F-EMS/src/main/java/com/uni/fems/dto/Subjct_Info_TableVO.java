package com.uni.fems.dto;

public class Subjct_Info_TableVO {
	private String sit_Subjct_Code;   // 학과 코드
	private String sit_Faculty;   // 학부
	private String sit_Subjct;   // 학과
	private int sit_Tut;   // 등록금 금액
	private String sit_Subjct_Tlphon_No;   // 학과 전화 번호
	private String sit_useyn;   // 학과 사용유무
	public String getSit_Subjct_Code() {
		return sit_Subjct_Code;
	}
	public void setSit_Subjct_Code(String sit_Subjct_Code) {
		this.sit_Subjct_Code = sit_Subjct_Code;
	}
	public String getSit_Faculty() {
		return sit_Faculty;
	}
	public void setSit_Faculty(String sit_Faculty) {
		this.sit_Faculty = sit_Faculty;
	}
	public String getSit_Subjct() {
		return sit_Subjct;
	}
	public void setSit_Subjct(String sit_Subjct) {
		this.sit_Subjct = sit_Subjct;
	}
	public int getSit_Tut() {
		return sit_Tut;
	}
	public void setSit_Tut(int sit_Tut) {
		this.sit_Tut = sit_Tut;
	}
	public String getSit_Subjct_Tlphon_No() {
		return sit_Subjct_Tlphon_No;
	}
	public void setSit_Subjct_Tlphon_No(String sit_Subjct_Tlphon_No) {
		this.sit_Subjct_Tlphon_No = sit_Subjct_Tlphon_No;
	}
	public String getSit_useyn() {
		return sit_useyn;
	}
	public void setSit_useyn(String sit_useyn) {
		this.sit_useyn = sit_useyn;
	}
	@Override
	public String toString() {
		return "Subjct_Info_TableVO [sit_Subjct_Code=" + sit_Subjct_Code
				+ ", sit_Faculty=" + sit_Faculty + ", sit_Subjct=" + sit_Subjct
				+ ", sit_Tut=" + sit_Tut + ", sit_Subjct_Tlphon_No="
				+ sit_Subjct_Tlphon_No + ", sit_useyn=" + sit_useyn + "]";
	}
	
	

}
