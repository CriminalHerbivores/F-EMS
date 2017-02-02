package com.uni.fems.dto;

import java.sql.Timestamp;

public class ChattingVO {
	private String ct_Stdnt_No;   // 학생번호
	private String ct_Profsr_No;   // 교수번호
	private String ct_Knd;   // 종류
	private Timestamp ct_Dt;   // 날짜
	private String ct_Cont;   // 내용
	public String getCt_Stdnt_No() {
		return ct_Stdnt_No;
	}
	public void setCt_Stdnt_No(String ct_Stdnt_No) {
		this.ct_Stdnt_No = ct_Stdnt_No;
	}
	public String getCt_Profsr_No() {
		return ct_Profsr_No;
	}
	public void setCt_Profsr_No(String ct_Profsr_No) {
		this.ct_Profsr_No = ct_Profsr_No;
	}
	public String getCt_Knd() {
		return ct_Knd;
	}
	public void setCt_Knd(String ct_Knd) {
		this.ct_Knd = ct_Knd;
	}
	public Timestamp getCt_Dt() {
		return ct_Dt;
	}
	public void setCt_Dt(Timestamp ct_Dt) {
		this.ct_Dt = ct_Dt;
	}
	public String getCt_Cont() {
		return ct_Cont;
	}
	public void setCt_Cont(String ct_Cont) {
		this.ct_Cont = ct_Cont;
	}
	@Override
	public String toString() {
		return "ChattingVO [ct_Stdnt_No=" + ct_Stdnt_No + ", ct_Profsr_No="
				+ ct_Profsr_No + ", ct_Knd=" + ct_Knd + ", ct_Cont=" + ct_Cont
				+ "]";
	}

}
