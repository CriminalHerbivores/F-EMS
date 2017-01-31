package com.uni.fems.dto;

import java.sql.Timestamp;

public class LctreVO {

	private int lc_Lctre_No;   // 강의번호
	private String lc_Profsr_No;   // 교수번호
	private String lc_Lctre_Code;   // 강의코드
	private Timestamp lc_Lctrbgn_Dt;   // 강의개강일
	private int lc_Lctre_Nmpr;   // 강의 인원
	private String lc_Wik_Lctre_Dayweek;   // 주간 강의 요일
	private String lc_Lctre_Time;   // 강의 시간
	private String lc_Pnt;   // 학점
	private String lc_Grade;   // 학년
	private String lc_Lctrum_No;   // 강의실 번호
	private String lc_Open_At;   // 개설여부
	private String lc_Lctre_Org;   // 강의 원본
	private String lc_Lctre_Evl_Score;   // 강의 평가 점수
	private String lc_Split;   // 분반
	public int getLc_Lctre_No() {
		return lc_Lctre_No;
	}
	public void setLc_Lctre_No(int lc_Lctre_No) {
		this.lc_Lctre_No = lc_Lctre_No;
	}
	public String getLc_Profsr_No() {
		return lc_Profsr_No;
	}
	public void setLc_Profsr_No(String lc_Profsr_No) {
		this.lc_Profsr_No = lc_Profsr_No;
	}
	public String getLc_Lctre_Code() {
		return lc_Lctre_Code;
	}
	public void setLc_Lctre_Code(String lc_Lctre_Code) {
		this.lc_Lctre_Code = lc_Lctre_Code;
	}
	public Timestamp getLc_Lctrbgn_Dt() {
		return lc_Lctrbgn_Dt;
	}
	public void setLc_Lctrbgn_Dt(Timestamp lc_Lctrbgn_Dt) {
		this.lc_Lctrbgn_Dt = lc_Lctrbgn_Dt;
	}
	public int getLc_Lctre_Nmpr() {
		return lc_Lctre_Nmpr;
	}
	public void setLc_Lctre_Nmpr(int lc_Lctre_Nmpr) {
		this.lc_Lctre_Nmpr = lc_Lctre_Nmpr;
	}
	public String getLc_Wik_Lctre_Dayweek() {
		return lc_Wik_Lctre_Dayweek;
	}
	public void setLc_Wik_Lctre_Dayweek(String lc_Wik_Lctre_Dayweek) {
		this.lc_Wik_Lctre_Dayweek = lc_Wik_Lctre_Dayweek;
	}
	public String getLc_Lctre_Time() {
		return lc_Lctre_Time;
	}
	public void setLc_Lctre_Time(String lc_Lctre_Time) {
		this.lc_Lctre_Time = lc_Lctre_Time;
	}
	public String getLc_Pnt() {
		return lc_Pnt;
	}
	public void setLc_Pnt(String lc_Pnt) {
		this.lc_Pnt = lc_Pnt;
	}
	public String getLc_Grade() {
		return lc_Grade;
	}
	public void setLc_Grade(String lc_Grade) {
		this.lc_Grade = lc_Grade;
	}
	public String getLc_Lctrum_No() {
		return lc_Lctrum_No;
	}
	public void setLc_Lctrum_No(String lc_Lctrum_No) {
		this.lc_Lctrum_No = lc_Lctrum_No;
	}
	public String getLc_Open_At() {
		return lc_Open_At;
	}
	public void setLc_Open_At(String lc_Open_At) {
		this.lc_Open_At = lc_Open_At;
	}
	public String getLc_Lctre_Org() {
		return lc_Lctre_Org;
	}
	public void setLc_Lctre_Org(String lc_Lctre_Org) {
		this.lc_Lctre_Org = lc_Lctre_Org;
	}
	public String getLc_Lctre_Evl_Score() {
		return lc_Lctre_Evl_Score;
	}
	public void setLc_Lctre_Evl_Score(String lc_Lctre_Evl_Score) {
		this.lc_Lctre_Evl_Score = lc_Lctre_Evl_Score;
	}
	public String getLc_Split() {
		return lc_Split;
	}
	public void setLc_Split(String lc_Split) {
		this.lc_Split = lc_Split;
	}
	@Override
	public String toString() {
		return "LctreVO [lc_Lctre_No=" + lc_Lctre_No + ", lc_Profsr_No="
				+ lc_Profsr_No + ", lc_Lctre_Code=" + lc_Lctre_Code
				+ ", lc_Lctrbgn_Dt=" + lc_Lctrbgn_Dt + ", lc_Lctre_Nmpr="
				+ lc_Lctre_Nmpr + ", lc_Wik_Lctre_Dayweek="
				+ lc_Wik_Lctre_Dayweek + ", lc_Lctre_Time=" + lc_Lctre_Time
				+ ", lc_Pnt=" + lc_Pnt + ", lc_Grade=" + lc_Grade
				+ ", lc_Lctrum_No=" + lc_Lctrum_No + ", lc_Open_At="
				+ lc_Open_At + ", lc_Lctre_Org=" + lc_Lctre_Org
				+ ", lc_Lctre_Evl_Score=" + lc_Lctre_Evl_Score + ", lc_Split="
				+ lc_Split + "]";
	}

	
}
