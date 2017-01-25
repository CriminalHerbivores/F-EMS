package com.uni.fems.dto;

public class AnswerVO {
	private String an_Ques_No;   // 문제번호
	private String qn_Tp_No;   // 시험지번호
	private String an_Stdnt_No;   // 학생번호
	private String an_Ans;   // 답안
	public String getAn_Ques_No() {
		return an_Ques_No;
	}
	public void setAn_Ques_No(String an_Ques_No) {
		this.an_Ques_No = an_Ques_No;
	}
	public String getQn_Tp_No() {
		return qn_Tp_No;
	}
	public void setQn_Tp_No(String qn_Tp_No) {
		this.qn_Tp_No = qn_Tp_No;
	}
	public String getAn_Stdnt_No() {
		return an_Stdnt_No;
	}
	public void setAn_Stdnt_No(String an_Stdnt_No) {
		this.an_Stdnt_No = an_Stdnt_No;
	}
	public String getAn_Ans() {
		return an_Ans;
	}
	public void setAn_Ans(String an_Ans) {
		this.an_Ans = an_Ans;
	}
	@Override
	public String toString() {
		return "AnswerVO [an_Ques_No=" + an_Ques_No + ", qn_Tp_No=" + qn_Tp_No
				+ ", an_Stdnt_No=" + an_Stdnt_No + ", an_Ans=" + an_Ans + "]";
	}

}
