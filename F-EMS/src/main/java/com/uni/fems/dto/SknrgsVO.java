package com.uni.fems.dto;

import java.sql.Timestamp;

public class SknrgsVO {
	private int skn_No;   // 번호
	private String skn_Stdnt_No;   // 학생번호
	private String skn_Type;   // 유형
	private Timestamp skn_Reqst_Dt;   // 신청날짜
	public int getSkn_No() {
		return skn_No;
	}
	public void setSkn_No(int skn_No) {
		this.skn_No = skn_No;
	}
	public String getSkn_Stdnt_No() {
		return skn_Stdnt_No;
	}
	public void setSkn_Stdnt_No(String skn_Stdnt_No) {
		this.skn_Stdnt_No = skn_Stdnt_No;
	}
	public String getSkn_Type() {
		return skn_Type;
	}
	public void setSkn_Type(String skn_Type) {
		this.skn_Type = skn_Type;
	}
	public Timestamp getSkn_Reqst_Dt() {
		return skn_Reqst_Dt;
	}
	public void setSkn_Reqst_Dt(Timestamp skn_Reqst_Dt) {
		this.skn_Reqst_Dt = skn_Reqst_Dt;
	}
	@Override
	public String toString() {
		return "SknrgsVO [skn_No=" + skn_No + ", skn_Stdnt_No=" + skn_Stdnt_No
				+ ", skn_Type=" + skn_Type + "]";
	}

}
