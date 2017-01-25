package com.uni.fems.dto;

import java.sql.Timestamp;

public class ConsultationVO {
	private String cs_Stdnt_No;   // 학생번호
	private String cs_Profsr_No;   // 교수번호
	private Timestamp cs_Dt;   // 날짜
	private String cs_Knd;   // 종류
	private String cs_Cont;   // 내용
	public String getCs_Stdnt_No() {
		return cs_Stdnt_No;
	}
	public void setCs_Stdnt_No(String cs_Stdnt_No) {
		this.cs_Stdnt_No = cs_Stdnt_No;
	}
	public String getCs_Profsr_No() {
		return cs_Profsr_No;
	}
	public void setCs_Profsr_No(String cs_Profsr_No) {
		this.cs_Profsr_No = cs_Profsr_No;
	}
	public Timestamp getCs_Dt() {
		return cs_Dt;
	}
	public void setCs_Dt(Timestamp cs_Dt) {
		this.cs_Dt = cs_Dt;
	}
	public String getCs_Knd() {
		return cs_Knd;
	}
	public void setCs_Knd(String cs_Knd) {
		this.cs_Knd = cs_Knd;
	}
	public String getCs_Cont() {
		return cs_Cont;
	}
	public void setCs_Cont(String cs_Cont) {
		this.cs_Cont = cs_Cont;
	}
	@Override
	public String toString() {
		return "ConsultationVO [cs_Stdnt_No=" + cs_Stdnt_No + ", cs_Profsr_No="
				+ cs_Profsr_No + ", cs_Knd=" + cs_Knd + ", cs_Cont=" + cs_Cont
				+ "]";
	}

}
