package com.uni.fems.dto;

public class ReqstVO {
	private int re_No;   // 번호
	private String re_Stdnt_No;   // 학생 번호
	private String re_Lctre_No;   // 강의 번호
	public int getRe_No() {
		return re_No;
	}
	public void setRe_No(int re_No) {
		this.re_No = re_No;
	}
	public String getRe_Stdnt_No() {
		return re_Stdnt_No;
	}
	public void setRe_Stdnt_No(String re_Stdnt_No) {
		this.re_Stdnt_No = re_Stdnt_No;
	}
	public String getRe_Lctre_No() {
		return re_Lctre_No;
	}
	public void setRe_Lctre_No(String re_Lctre_No) {
		this.re_Lctre_No = re_Lctre_No;
	}
	@Override
	public String toString() {
		return "ReqstVO [re_No=" + re_No + ", re_Stdnt_No=" + re_Stdnt_No
				+ ", re_Lctre_No=" + re_Lctre_No + "]";
	}

}
