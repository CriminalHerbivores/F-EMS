package com.uni.fems.dto;

public class SchlshipVO {
	private int ss_Schlship_Code;   // 장학금 코드
	private String ss_Schlship_Nm;   // 장학금 명
	private String ss_Schlship_Type;   // 유형
	private int ss_Amount;   // 금액
	private String ss_Papers_Content;   // 서류 내용
	public int getSs_Schlship_Code() {
		return ss_Schlship_Code;
	}
	public void setSs_Schlship_Code(int ss_Schlship_Code) {
		this.ss_Schlship_Code = ss_Schlship_Code;
	}
	public String getSs_Schlship_Nm() {
		return ss_Schlship_Nm;
	}
	public void setSs_Schlship_Nm(String ss_Schlship_Nm) {
		this.ss_Schlship_Nm = ss_Schlship_Nm;
	}
	public String getSs_Schlship_Type() {
		return ss_Schlship_Type;
	}
	public void setSs_Schlship_Type(String ss_Schlship_Type) {
		this.ss_Schlship_Type = ss_Schlship_Type;
	}
	public int getSs_Amount() {
		return ss_Amount;
	}
	public void setSs_Amount(int ss_Amount) {
		this.ss_Amount = ss_Amount;
	}
	public String getSs_Papers_Content() {
		return ss_Papers_Content;
	}
	public void setSs_Papers_Content(String ss_Papers_Content) {
		this.ss_Papers_Content = ss_Papers_Content;
	}
	@Override
	public String toString() {
		return "SchlshipVO [ss_Schlship_Code=" + ss_Schlship_Code
				+ ", ss_Schlship_Nm=" + ss_Schlship_Nm + ", ss_Schlship_Type="
				+ ss_Schlship_Type + ", ss_Amount=" + ss_Amount
				+ ", ss_Papers_Content=" + ss_Papers_Content + "]";
	}

}
