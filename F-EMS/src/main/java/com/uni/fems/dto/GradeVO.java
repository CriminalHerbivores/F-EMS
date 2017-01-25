package com.uni.fems.dto;

public class GradeVO {
	private String gd_Stdnt_No;   // 학생번호
	private int gd_Lctre_No;   // 강의번호
	private String gd_Grade;   // 성적
	private String gd_Tot_Score;   // 총 점수
	private String gd_Attd_Score;   // 태도 점수
	private String gd_Atend_Score;   // 출석 점수
	private String gd_Task_Score;   // 과제 점수
	private String gd_Midex_Score;   // 중간 점수
	private String gd_Fnex_Score;   // 기말 점수
	public String getGd_Stdnt_No() {
		return gd_Stdnt_No;
	}
	public void setGd_Stdnt_No(String gd_Stdnt_No) {
		this.gd_Stdnt_No = gd_Stdnt_No;
	}
	public int getGd_Lctre_No() {
		return gd_Lctre_No;
	}
	public void setGd_Lctre_No(int gd_Lctre_No) {
		this.gd_Lctre_No = gd_Lctre_No;
	}
	public String getGd_Grade() {
		return gd_Grade;
	}
	public void setGd_Grade(String gd_Grade) {
		this.gd_Grade = gd_Grade;
	}
	public String getGd_Tot_Score() {
		return gd_Tot_Score;
	}
	public void setGd_Tot_Score(String gd_Tot_Score) {
		this.gd_Tot_Score = gd_Tot_Score;
	}
	public String getGd_Attd_Score() {
		return gd_Attd_Score;
	}
	public void setGd_Attd_Score(String gd_Attd_Score) {
		this.gd_Attd_Score = gd_Attd_Score;
	}
	public String getGd_Atend_Score() {
		return gd_Atend_Score;
	}
	public void setGd_Atend_Score(String gd_Atend_Score) {
		this.gd_Atend_Score = gd_Atend_Score;
	}
	public String getGd_Task_Score() {
		return gd_Task_Score;
	}
	public void setGd_Task_Score(String gd_Task_Score) {
		this.gd_Task_Score = gd_Task_Score;
	}
	public String getGd_Midex_Score() {
		return gd_Midex_Score;
	}
	public void setGd_Midex_Score(String gd_Midex_Score) {
		this.gd_Midex_Score = gd_Midex_Score;
	}
	public String getGd_Fnex_Score() {
		return gd_Fnex_Score;
	}
	public void setGd_Fnex_Score(String gd_Fnex_Score) {
		this.gd_Fnex_Score = gd_Fnex_Score;
	}
	@Override
	public String toString() {
		return "GradeVO [gd_Stdnt_No=" + gd_Stdnt_No + ", gd_Lctre_No="
				+ gd_Lctre_No + ", gd_Grade=" + gd_Grade + ", gd_Tot_Score="
				+ gd_Tot_Score + ", gd_Attd_Score=" + gd_Attd_Score
				+ ", gd_Atend_Score=" + gd_Atend_Score + ", gd_Task_Score="
				+ gd_Task_Score + ", gd_Midex_Score=" + gd_Midex_Score
				+ ", gd_Fnex_Score=" + gd_Fnex_Score + "]";
	}

}
