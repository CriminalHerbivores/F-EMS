package com.uni.fems.dto;

import java.sql.Timestamp;

public class SknrgsVO {
	private int skn_No;   // 번호
	private String skn_Stdnt_No;   // 학생번호
	private String skn_Type;   // 유형
	private Timestamp skn_Reqst_Dt;   // 신청날짜
	private String skn_Content;   // 신청사유
	private String skn_Useyn;   // 승인여부
	private String skn_File;   // 첨부파일 경로
	
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
	public String getSkn_Content() {
		return skn_Content;
	}
	public void setSkn_Content(String skn_Content) {
		this.skn_Content = skn_Content;
	}
	public String getSkn_Useyn() {
		return skn_Useyn;
	}
	public void setSkn_Useyn(String skn_Useyn) {
		this.skn_Useyn = skn_Useyn;
	}
	public String getSkn_File() {
		return skn_File;
	}
	public void setSkn_File(String skn_File) {
		this.skn_File = skn_File;
	}
	@Override
	public String toString() {
		return "SknrgsVO [skn_No=" + skn_No + ", skn_Stdnt_No=" + skn_Stdnt_No
				+ ", skn_Type=" + skn_Type + ", skn_Reqst_Dt=" + skn_Reqst_Dt
				+ ", skn_Content=" + skn_Content + ", skn_Useyn=" + skn_Useyn
				+ ", skn_File=" + skn_File + "]";
	}
	
}
