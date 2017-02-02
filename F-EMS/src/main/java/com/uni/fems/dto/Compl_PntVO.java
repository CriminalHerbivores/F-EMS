package com.uni.fems.dto;

public class Compl_PntVO {
	private String cp_Subjct_Code;   // 학과 코드
	private int cp_Major_Choice;   // 전공 선택
	private int cp_Major_Essntl;   // 전공 필수
	private int cp_Cltr_Essntl;   // 교양 필수
	private int cp_Cltr_Choice;   // 교양 선택
	public String getCp_Subjct_Code() {
		return cp_Subjct_Code;
	}
	public void setCp_Subjct_Code(String cp_Subjct_Code) {
		this.cp_Subjct_Code = cp_Subjct_Code;
	}
	public int getCp_Major_Choice() {
		return cp_Major_Choice;
	}
	public void setCp_Major_Choice(int cp_Major_Choice) {
		this.cp_Major_Choice = cp_Major_Choice;
	}
	public int getCp_Major_Essntl() {
		return cp_Major_Essntl;
	}
	public void setCp_Major_Essntl(int cp_Major_Essntl) {
		this.cp_Major_Essntl = cp_Major_Essntl;
	}
	public int getCp_Cltr_Essntl() {
		return cp_Cltr_Essntl;
	}
	public void setCp_Cltr_Essntl(int cp_Cltr_Essntl) {
		this.cp_Cltr_Essntl = cp_Cltr_Essntl;
	}
	public int getCp_Cltr_Choice() {
		return cp_Cltr_Choice;
	}
	public void setCp_Cltr_Choice(int cp_Cltr_Choice) {
		this.cp_Cltr_Choice = cp_Cltr_Choice;
	}
	@Override
	public String toString() {
		return "Compl_PntVO [cp_Subjct_Code=" + cp_Subjct_Code
				+ ", cp_Major_Choice=" + cp_Major_Choice + ", cp_Major_Essntl="
				+ cp_Major_Essntl + ", cp_Cltr_Essntl=" + cp_Cltr_Essntl
				+ ", cp_Cltr_Choice=" + cp_Cltr_Choice + "]";
	}

}
