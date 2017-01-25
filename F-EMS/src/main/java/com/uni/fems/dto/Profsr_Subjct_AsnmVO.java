package com.uni.fems.dto;

import java.sql.Timestamp;

public class Profsr_Subjct_AsnmVO {
	private String psa_Code;   // 교수학과배정코드
	private String psa_Subjct_Code;   // 학과코드
	private String psa_Profsr_No;   // 교수번호
	private Timestamp psa_Dt;   // 배정일
	public String getPsa_Code() {
		return psa_Code;
	}
	public void setPsa_Code(String psa_Code) {
		this.psa_Code = psa_Code;
	}
	public String getPsa_Subjct_Code() {
		return psa_Subjct_Code;
	}
	public void setPsa_Subjct_Code(String psa_Subjct_Code) {
		this.psa_Subjct_Code = psa_Subjct_Code;
	}
	public String getPsa_Profsr_No() {
		return psa_Profsr_No;
	}
	public void setPsa_Profsr_No(String psa_Profsr_No) {
		this.psa_Profsr_No = psa_Profsr_No;
	}
	public Timestamp getPsa_Dt() {
		return psa_Dt;
	}
	public void setPsa_Dt(Timestamp psa_Dt) {
		this.psa_Dt = psa_Dt;
	}
	@Override
	public String toString() {
		return "Profsr_Subjct_AsnmVO [psa_Code=" + psa_Code
				+ ", psa_Subjct_Code=" + psa_Subjct_Code + ", psa_Profsr_No="
				+ psa_Profsr_No + "]";
	}

}
