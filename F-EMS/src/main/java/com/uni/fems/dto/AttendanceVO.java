package com.uni.fems.dto;

import java.sql.Timestamp;

public class AttendanceVO {
	private String atd_Stdnt_No;   // 학생 번호
	private int atd_Lctre_No;   // 강의 번호
	private String atd_Atend;   // 출결
	private Timestamp atd_Dt;   // 날짜
	public String getAtd_Stdnt_No() {
		return atd_Stdnt_No;
	}
	public void setAtd_Stdnt_No(String atd_Stdnt_No) {
		this.atd_Stdnt_No = atd_Stdnt_No;
	}
	public int getAtd_Lctre_No() {
		return atd_Lctre_No;
	}
	public void setAtd_Lctre_No(int atd_Lctre_No) {
		this.atd_Lctre_No = atd_Lctre_No;
	}
	public String getAtd_Atend() {
		return atd_Atend;
	}
	public void setAtd_Atend(String atd_Atend) {
		this.atd_Atend = atd_Atend;
	}
	public Timestamp getAtd_Dt() {
		return atd_Dt;
	}
	public void setAtd_Dt(Timestamp atd_Dt) {
		this.atd_Dt = atd_Dt;
	}
	@Override
	public String toString() {
		return "AttendanceVO [atd_Stdnt_No=" + atd_Stdnt_No + ", atd_Lctre_No="
				+ atd_Lctre_No + ", atd_Atend=" + atd_Atend + "]";
	}

}
