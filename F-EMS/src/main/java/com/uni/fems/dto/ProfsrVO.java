package com.uni.fems.dto;

public class ProfsrVO {
	private String pr_Profsr_No;   // 교수 번호
	private String pr_Pw;   // 비밀번호
	private String pr_Nm;   // 이름
	private String pr_Eng_Nm;   // 영문 이름
	private String pr_Ihidnum;   // 주민번호
	private String pr_Moblphon_No;   // 핸드폰 번호
	private String pr_House_Tlphon_No;   // 집 전화번호
	private String pr_Profsr_Tlphon_No;   // 교수 전화번호
	private String pr_Post_No;   // 우편 번호
	private String pr_Adres1;   // 주소1
	private String pr_Adres2;   // 주소2
	private String pr_Email;   // 이메일
	public String getPr_Profsr_No() {
		return pr_Profsr_No;
	}
	public void setPr_Profsr_No(String pr_Profsr_No) {
		this.pr_Profsr_No = pr_Profsr_No;
	}
	public String getPr_Pw() {
		return pr_Pw;
	}
	public void setPr_Pw(String pr_Pw) {
		this.pr_Pw = pr_Pw;
	}
	public String getPr_Nm() {
		return pr_Nm;
	}
	public void setPr_Nm(String pr_Nm) {
		this.pr_Nm = pr_Nm;
	}
	public String getPr_Eng_Nm() {
		return pr_Eng_Nm;
	}
	public void setPr_Eng_Nm(String pr_Eng_Nm) {
		this.pr_Eng_Nm = pr_Eng_Nm;
	}
	public String getPr_Ihidnum() {
		return pr_Ihidnum;
	}
	public void setPr_Ihidnum(String pr_Ihidnum) {
		this.pr_Ihidnum = pr_Ihidnum;
	}
	public String getPr_Moblphon_No() {
		return pr_Moblphon_No;
	}
	public void setPr_Moblphon_No(String pr_Moblphon_No) {
		this.pr_Moblphon_No = pr_Moblphon_No;
	}
	public String getPr_House_Tlphon_No() {
		return pr_House_Tlphon_No;
	}
	public void setPr_House_Tlphon_No(String pr_House_Tlphon_No) {
		this.pr_House_Tlphon_No = pr_House_Tlphon_No;
	}
	public String getPr_Profsr_Tlphon_No() {
		return pr_Profsr_Tlphon_No;
	}
	public void setPr_Profsr_Tlphon_No(String pr_Profsr_Tlphon_No) {
		this.pr_Profsr_Tlphon_No = pr_Profsr_Tlphon_No;
	}
	public String getPr_Post_No() {
		return pr_Post_No;
	}
	public void setPr_Post_No(String pr_Post_No) {
		this.pr_Post_No = pr_Post_No;
	}
	public String getPr_Adres1() {
		return pr_Adres1;
	}
	public void setPr_Adres1(String pr_Adres1) {
		this.pr_Adres1 = pr_Adres1;
	}
	public String getPr_Adres2() {
		return pr_Adres2;
	}
	public void setPr_Adres2(String pr_Adres2) {
		this.pr_Adres2 = pr_Adres2;
	}
	public String getPr_Email() {
		return pr_Email;
	}
	public void setPr_Email(String pr_Email) {
		this.pr_Email = pr_Email;
	}
	@Override
	public String toString() {
		return "ProfsrVO [pr_Profsr_No=" + pr_Profsr_No + ", pr_Pw=" + pr_Pw
				+ ", pr_Nm=" + pr_Nm + ", pr_Eng_Nm=" + pr_Eng_Nm
				+ ", pr_Ihidnum=" + pr_Ihidnum + ", pr_Moblphon_No="
				+ pr_Moblphon_No + ", pr_House_Tlphon_No=" + pr_House_Tlphon_No
				+ ", pr_Profsr_Tlphon_No=" + pr_Profsr_Tlphon_No
				+ ", pr_Post_No=" + pr_Post_No + ", pr_Adres1=" + pr_Adres1
				+ ", pr_Adres2=" + pr_Adres2 + ", pr_Email=" + pr_Email + "]";
	}

}
