package com.uni.fems.dto;

import java.sql.Timestamp;

public class StdntVO {
	private String st_Stdnt_No;   // 학생 번호
	private String st_Subjct_Code;   // 학과 코드
	private String st_Pw;   // 비밀번호
	private String st_Nm;   // 이름
	private String st_Eng_Nm;   // 영문 이름
	private String st_Ihidnum;   // 주민번호
	private String st_Moblphon_No;   // 핸드폰 번호
	private String st_House_Tlphon_No;   // 집 전화 번호
	private String st_Entsch_Dt;   // 입학 일자
	private String st_Prtctor_Nm;   // 보호자 이름
	private String st_Family_Relate;   // 가족 관계
	private String st_Post_No;   // 우편 번호
	private String st_Adres1;   // 주소1
	private String st_Adres2;   // 주소2
	private String st_Cnslt_At;   // 상담 여부
	private String st_Email;   // 이메일
	private String st_Brhs_At;   // 기숙사 여부
	private String st_Profsr_No;   // 교수 번호
	private String st_Grdtn_Dt;   // 졸업 일자
	public String getSt_Stdnt_No() {
		return st_Stdnt_No;
	}
	public void setSt_Stdnt_No(String st_Stdnt_No) {
		this.st_Stdnt_No = st_Stdnt_No;
	}
	public String getSt_Subjct_Code() {
		return st_Subjct_Code;
	}
	public void setSt_Subjct_Code(String st_Subjct_Code) {
		this.st_Subjct_Code = st_Subjct_Code;
	}
	public String getSt_Pw() {
		return st_Pw;
	}
	public void setSt_Pw(String st_Pw) {
		this.st_Pw = st_Pw;
	}
	public String getSt_Nm() {
		return st_Nm;
	}
	public void setSt_Nm(String st_Nm) {
		this.st_Nm = st_Nm;
	}
	public String getSt_Eng_Nm() {
		return st_Eng_Nm;
	}
	public void setSt_Eng_Nm(String st_Eng_Nm) {
		this.st_Eng_Nm = st_Eng_Nm;
	}
	public String getSt_Ihidnum() {
		return st_Ihidnum;
	}
	public void setSt_Ihidnum(String st_Ihidnum) {
		this.st_Ihidnum = st_Ihidnum;
	}
	public String getSt_Moblphon_No() {
		return st_Moblphon_No;
	}
	public void setSt_Moblphon_No(String st_Moblphon_No) {
		this.st_Moblphon_No = st_Moblphon_No;
	}
	public String getSt_House_Tlphon_No() {
		return st_House_Tlphon_No;
	}
	public void setSt_House_Tlphon_No(String st_House_Tlphon_No) {
		this.st_House_Tlphon_No = st_House_Tlphon_No;
	}
	public String getSt_Entsch_Dt() {
		return st_Entsch_Dt;
	}
	public void setSt_Entsch_Dt(String st_Entsch_Dt) {
		this.st_Entsch_Dt = st_Entsch_Dt;
	}
	public String getSt_Prtctor_Nm() {
		return st_Prtctor_Nm;
	}
	public void setSt_Prtctor_Nm(String st_Prtctor_Nm) {
		this.st_Prtctor_Nm = st_Prtctor_Nm;
	}
	public String getSt_Family_Relate() {
		return st_Family_Relate;
	}
	public void setSt_Family_Relate(String st_Family_Relate) {
		this.st_Family_Relate = st_Family_Relate;
	}
	public String getSt_Post_No() {
		return st_Post_No;
	}
	public void setSt_Post_No(String st_Post_No) {
		this.st_Post_No = st_Post_No;
	}
	public String getSt_Adres1() {
		return st_Adres1;
	}
	public void setSt_Adres1(String st_Adres1) {
		this.st_Adres1 = st_Adres1;
	}
	public String getSt_Adres2() {
		return st_Adres2;
	}
	public void setSt_Adres2(String st_Adres2) {
		this.st_Adres2 = st_Adres2;
	}
	public String getSt_Cnslt_At() {
		return st_Cnslt_At;
	}
	public void setSt_Cnslt_At(String st_Cnslt_At) {
		this.st_Cnslt_At = st_Cnslt_At;
	}
	public String getSt_Email() {
		return st_Email;
	}
	public void setSt_Email(String st_Email) {
		this.st_Email = st_Email;
	}
	public String getSt_Brhs_At() {
		return st_Brhs_At;
	}
	public void setSt_Brhs_At(String st_Brhs_At) {
		this.st_Brhs_At = st_Brhs_At;
	}
	public String getSt_Profsr_No() {
		return st_Profsr_No;
	}
	public void setSt_Profsr_No(String st_Profsr_No) {
		this.st_Profsr_No = st_Profsr_No;
	}
	public String getSt_Grdtn_Dt() {
		return st_Grdtn_Dt;
	}
	public void setSt_Grdtn_Dt(String st_Grdtn_Dt) {
		this.st_Grdtn_Dt = st_Grdtn_Dt;
	}
	@Override
	public String toString() {
		return "StdntVO [st_Stdnt_No=" + st_Stdnt_No + ", st_Subjct_Code="
				+ st_Subjct_Code + ", st_Pw=" + st_Pw + ", st_Nm=" + st_Nm
				+ ", st_Eng_Nm=" + st_Eng_Nm + ", st_Ihidnum=" + st_Ihidnum
				+ ", st_Moblphon_No=" + st_Moblphon_No
				+ ", st_House_Tlphon_No=" + st_House_Tlphon_No
				+ ", st_Entsch_Dt=" + st_Entsch_Dt + ", st_Prtctor_Nm="
				+ st_Prtctor_Nm + ", st_Family_Relate=" + st_Family_Relate
				+ ", st_Post_No=" + st_Post_No + ", st_Adres1=" + st_Adres1
				+ ", st_Adres2=" + st_Adres2 + ", st_Cnslt_At=" + st_Cnslt_At
				+ ", st_Email=" + st_Email + ", st_Brhs_At=" + st_Brhs_At
				+ ", st_Profsr_No=" + st_Profsr_No + ", st_Grdtn_Dt="
				+ st_Grdtn_Dt + "]";
	}

	

	
}
