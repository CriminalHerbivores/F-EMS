package com.uni.fems.dto;

import java.sql.Timestamp;

public class Test_PaperVO {
	private String tp_No;   // 시험지번호
	private int tp_Lctre_No;   // 교수번호
	private String tp_Profsr_No;   // 강의번호
	private Timestamp tp_Dt;   // 날짜
	public String getTp_No() {
		return tp_No;
	}
	public void setTp_No(String tp_No) {
		this.tp_No = tp_No;
	}
	public int getTp_Lctre_No() {
		return tp_Lctre_No;
	}
	public void setTp_Lctre_No(int tp_Lctre_No) {
		this.tp_Lctre_No = tp_Lctre_No;
	}
	public String getTp_Profsr_No() {
		return tp_Profsr_No;
	}
	public void setTp_Profsr_No(String tp_Profsr_No) {
		this.tp_Profsr_No = tp_Profsr_No;
	}
	public Timestamp getTp_Dt() {
		return tp_Dt;
	}
	public void setTp_Dt(Timestamp tp_Dt) {
		this.tp_Dt = tp_Dt;
	}
	@Override
	public String toString() {
		return "Test_PaperVO [tp_No=" + tp_No + ", tp_Lctre_No=" + tp_Lctre_No
				+ ", tp_Profsr_No=" + tp_Profsr_No + "]";
	}

}
