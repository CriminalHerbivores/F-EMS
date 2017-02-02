package com.uni.fems.dto;

import java.sql.Timestamp;

public class Cnslt_BbsVO {
	private int cb_No;   // 게시판번호
	private String cb_User_No;   // 사용자번호
	private String cb_Title;   // 제목
	private String cb_Cont;   // 내용
	private Timestamp cb_Writing;   // 작성날짜
	private String cb_Answer;   // 댓글
	public int getCb_No() {
		return cb_No;
	}
	public void setCb_No(int cb_No) {
		this.cb_No = cb_No;
	}
	public String getCb_User_No() {
		return cb_User_No;
	}
	public void setCb_User_No(String cb_User_No) {
		this.cb_User_No = cb_User_No;
	}
	public String getCb_Title() {
		return cb_Title;
	}
	public void setCb_Title(String cb_Title) {
		this.cb_Title = cb_Title;
	}
	public String getCb_Cont() {
		return cb_Cont;
	}
	public void setCb_Cont(String cb_Cont) {
		this.cb_Cont = cb_Cont;
	}
	public Timestamp getCb_Writing() {
		return cb_Writing;
	}
	public void setCb_Writing(Timestamp cb_Writing) {
		this.cb_Writing = cb_Writing;
	}
	public String getCb_Answer() {
		return cb_Answer;
	}
	public void setCb_Answer(String cb_Answer) {
		this.cb_Answer = cb_Answer;
	}
	@Override
	public String toString() {
		return "Cnslt_BbsVO [cb_No=" + cb_No + ", cb_User_No=" + cb_User_No
				+ ", cb_Title=" + cb_Title + ", cb_Cont=" + cb_Cont
				+ ", cb_Answer=" + cb_Answer + "]";
	}

}
