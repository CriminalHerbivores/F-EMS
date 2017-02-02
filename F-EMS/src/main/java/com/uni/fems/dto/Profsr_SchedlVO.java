package com.uni.fems.dto;

public class Profsr_SchedlVO {
	private int ps_No;   // 번호
	private String ps_Profsr_No;   // 교수 번호
	private String ps_Stdnt_No;   // 학생 번호
	private String ps_Dayweek;   // 요일
	private String ps_Period;   // 교시
	private String ps_Content;   // 내용
	public int getPs_No() {
		return ps_No;
	}
	public void setPs_No(int ps_No) {
		this.ps_No = ps_No;
	}
	public String getPs_Profsr_No() {
		return ps_Profsr_No;
	}
	public void setPs_Profsr_No(String ps_Profsr_No) {
		this.ps_Profsr_No = ps_Profsr_No;
	}
	public String getPs_Stdnt_No() {
		return ps_Stdnt_No;
	}
	public void setPs_Stdnt_No(String ps_Stdnt_No) {
		this.ps_Stdnt_No = ps_Stdnt_No;
	}
	public String getPs_Dayweek() {
		return ps_Dayweek;
	}
	public void setPs_Dayweek(String ps_Dayweek) {
		this.ps_Dayweek = ps_Dayweek;
	}
	public String getPs_Period() {
		return ps_Period;
	}
	public void setPs_Period(String ps_Period) {
		this.ps_Period = ps_Period;
	}
	public String getPs_Content() {
		return ps_Content;
	}
	public void setPs_Content(String ps_Content) {
		this.ps_Content = ps_Content;
	}
	@Override
	public String toString() {
		return "Profsr_SchedlVO [ps_No=" + ps_No + ", ps_Profsr_No="
				+ ps_Profsr_No + ", ps_Stdnt_No=" + ps_Stdnt_No
				+ ", ps_Dayweek=" + ps_Dayweek + ", ps_Period=" + ps_Period
				+ ", ps_Content=" + ps_Content + "]";
	}

}
