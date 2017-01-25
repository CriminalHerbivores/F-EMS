package com.uni.fems.dto;

import java.sql.Timestamp;

public class KindVO {
	private String knd_Profsr_No;   // 교수번호
	private int knd_Lctre_No;   // 강의번호
	private String knd_Lctre_Knd;   // 강의종류
	private Timestamp knd_Dt;   // 날짜
	public String getKnd_Profsr_No() {
		return knd_Profsr_No;
	}
	public void setKnd_Profsr_No(String knd_Profsr_No) {
		this.knd_Profsr_No = knd_Profsr_No;
	}
	public int getKnd_Lctre_No() {
		return knd_Lctre_No;
	}
	public void setKnd_Lctre_No(int knd_Lctre_No) {
		this.knd_Lctre_No = knd_Lctre_No;
	}
	public String getKnd_Lctre_Knd() {
		return knd_Lctre_Knd;
	}
	public void setKnd_Lctre_Knd(String knd_Lctre_Knd) {
		this.knd_Lctre_Knd = knd_Lctre_Knd;
	}
	public Timestamp getKnd_Dt() {
		return knd_Dt;
	}
	public void setKnd_Dt(Timestamp knd_Dt) {
		this.knd_Dt = knd_Dt;
	}
	@Override
	public String toString() {
		return "KindVO [knd_Profsr_No=" + knd_Profsr_No + ", knd_Lctre_No="
				+ knd_Lctre_No + ", knd_Lctre_Knd=" + knd_Lctre_Knd + "]";
	}

}
