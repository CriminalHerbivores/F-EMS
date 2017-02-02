package com.uni.fems.dto;

import java.sql.Timestamp;

public class TuitionVO {
	private int tu_No;   // 등록금번호
	private String tu_Stdnt_No;   // 학생번호
	private String tu_Subjct_Code;   // 학과코드
	private int tu_Tut;   // 등록금 금액
	private Timestamp tu_Pay_Dt; //납부일
	public int getTu_No() {
		return tu_No;
	}
	public void setTu_No(int tu_No) {
		this.tu_No = tu_No;
	}
	public String getTu_Stdnt_No() {
		return tu_Stdnt_No;
	}
	public void setTu_Stdnt_No(String tu_Stdnt_No) {
		this.tu_Stdnt_No = tu_Stdnt_No;
	}
	public String getTu_Subjct_Code() {
		return tu_Subjct_Code;
	}
	public void setTu_Subjct_Code(String tu_Subjct_Code) {
		this.tu_Subjct_Code = tu_Subjct_Code;
	}
	public int getTu_Tut() {
		return tu_Tut;
	}
	public void setTu_Tut(int tu_Tut) {
		this.tu_Tut = tu_Tut;
	}
	public Timestamp getTu_Pay_Dt() {
		return tu_Pay_Dt;
	}
	public void setTu_Pay_Dt(Timestamp tu_Pay_Dt) {
		this.tu_Pay_Dt = tu_Pay_Dt;
	}
	@Override
	public String toString() {
		return "TuitionVO [tu_No=" + tu_No + ", tu_Stdnt_No=" + tu_Stdnt_No
				+ ", tu_Subjct_Code=" + tu_Subjct_Code + ", tu_Tut=" + tu_Tut
				+ ", tu_Pay_Dt=" + tu_Pay_Dt + "]";
	}
	
}
