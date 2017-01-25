package com.uni.fems.dto;

public class TestVO {
	private String te_Ques_No;   // 문제번호
	private String te_Tp_No;   // 시험지번호
	private String te_Ques;   // 문제
	private String te_Ca;   // 정답
	public String getTe_Ques_No() {
		return te_Ques_No;
	}
	public void setTe_Ques_No(String te_Ques_No) {
		this.te_Ques_No = te_Ques_No;
	}
	public String getTe_Tp_No() {
		return te_Tp_No;
	}
	public void setTe_Tp_No(String te_Tp_No) {
		this.te_Tp_No = te_Tp_No;
	}
	public String getTe_Ques() {
		return te_Ques;
	}
	public void setTe_Ques(String te_Ques) {
		this.te_Ques = te_Ques;
	}
	public String getTe_Ca() {
		return te_Ca;
	}
	public void setTe_Ca(String te_Ca) {
		this.te_Ca = te_Ca;
	}
	@Override
	public String toString() {
		return "TestVO [te_Ques_No=" + te_Ques_No + ", te_Tp_No=" + te_Tp_No
				+ ", te_Ques=" + te_Ques + ", te_Ca=" + te_Ca + "]";
	}

}
