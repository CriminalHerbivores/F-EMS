package com.uni.fems.dto;

import java.sql.Timestamp;

public class SknrgsDTO {
	private String sit_Subjct;		//학과명
	private int skn_No;				//학전 번호
	private String skn_Type;		//학전 유형
	private Timestamp skn_Reost_Dt;	//학전 신청 날짜
	private String skn_Content;   // 신청사유
	private String skn_Useyn;   // 승인여부
	private String st_Stdnt_No;		///학생 번호
	private String st_Nm;			//학생 이름
	private String st_Moblphon_No;	//핸드폰 번호
	private String st_Email;		//이메일
	private String skn_File;   // 첨부파일 경로
	public String getSit_Subjct() {
		return sit_Subjct;
	}
	public void setSit_Subjct(String sit_Subjct) {
		this.sit_Subjct = sit_Subjct;
	}
	public int getSkn_No() {
		return skn_No;
	}
	public void setSkn_No(int skn_No) {
		this.skn_No = skn_No;
	}
	public String getSkn_Type() {
		return skn_Type;
	}
	public void setSkn_Type(String skn_Type) {
		this.skn_Type = skn_Type;
	}
	public Timestamp getSkn_Reost_Dt() {
		return skn_Reost_Dt;
	}
	public void setSkn_Reost_Dt(Timestamp skn_Reost_Dt) {
		this.skn_Reost_Dt = skn_Reost_Dt;
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
	public String getSt_Stdnt_No() {
		return st_Stdnt_No;
	}
	public void setSt_Stdnt_No(String st_Stdnt_No) {
		this.st_Stdnt_No = st_Stdnt_No;
	}
	public String getSt_Nm() {
		return st_Nm;
	}
	public void setSt_Nm(String st_Nm) {
		this.st_Nm = st_Nm;
	}
	public String getSt_Moblphon_No() {
		return st_Moblphon_No;
	}
	public void setSt_Moblphon_No(String st_Moblphon_No) {
		this.st_Moblphon_No = st_Moblphon_No;
	}
	public String getSt_Email() {
		return st_Email;
	}
	public void setSt_Email(String st_Email) {
		this.st_Email = st_Email;
	}
	public String getSkn_File() {
		return skn_File;
	}
	public void setSkn_File(String skn_File) {
		this.skn_File = skn_File;
	}
	@Override
	public String toString() {
		return "SknrgsDTO [sit_Subjct=" + sit_Subjct + ", skn_No=" + skn_No
				+ ", skn_Type=" + skn_Type + ", skn_Reost_Dt=" + skn_Reost_Dt
				+ ", skn_Content=" + skn_Content + ", skn_Useyn=" + skn_Useyn
				+ ", st_Stdnt_No=" + st_Stdnt_No + ", st_Nm=" + st_Nm
				+ ", st_Moblphon_No=" + st_Moblphon_No + ", st_Email="
				+ st_Email + ", skn_File=" + skn_File + "]";
	}
	
	
}
