package com.uni.fems.dto;

public class Intrst_ListVO {
	private String in_Stdnt_No;   // 학생번호
	private int in_Lctre_No;   // 강의번호
	public String getIn_Stdnt_No() {
		return in_Stdnt_No;
	}
	public void setIn_Stdnt_No(String in_Stdnt_No) {
		this.in_Stdnt_No = in_Stdnt_No;
	}
	public int getIn_Lctre_No() {
		return in_Lctre_No;
	}
	public void setIn_Lctre_No(int in_Lctre_No) {
		this.in_Lctre_No = in_Lctre_No;
	}
	@Override
	public String toString() {
		return "Intrst_ListVO [in_Stdnt_No=" + in_Stdnt_No + ", in_Lctre_No="
				+ in_Lctre_No + "]";
	}

}
