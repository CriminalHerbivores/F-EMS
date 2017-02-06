package com.uni.fems.dto;

import java.sql.Timestamp;

public class Bbs_CommentVO {
	private int bc_Comnt_No; //댓글번호
	private String bc_Bbs_Code; // 게시판명 ex)notice_bbs
	private int bc_Bbs_No; // 게시판번호
	private String bc_User_Id; // 댓글 작성자 아이디
	private String bc_Comnt_Content; // 댓글 내용
	private Timestamp bc_Writng_Dt; // 댓글 작성 날짜
	public int getBc_Comnt_No() {
		return bc_Comnt_No;
	}
	public void setBc_Comnt_No(int bc_Comnt_No) {
		this.bc_Comnt_No = bc_Comnt_No;
	}
	public String getBc_Bbs_Code() {
		return bc_Bbs_Code;
	}
	public void setBc_Bbs_Code(String bc_Bbs_Code) {
		this.bc_Bbs_Code = bc_Bbs_Code;
	}
	public int getBc_Bbs_No() {
		return bc_Bbs_No;
	}
	public void setBc_Bbs_No(int bc_Bbs_No) {
		this.bc_Bbs_No = bc_Bbs_No;
	}
	public String getBc_User_Id() {
		return bc_User_Id;
	}
	public void setBc_User_Id(String bc_User_Id) {
		this.bc_User_Id = bc_User_Id;
	}
	public String getBc_Comnt_Content() {
		return bc_Comnt_Content;
	}
	public void setBc_Comnt_Content(String bc_Comnt_Content) {
		this.bc_Comnt_Content = bc_Comnt_Content;
	}
	public Timestamp getBc_Writng_Dt() {
		return bc_Writng_Dt;
	}
	public void setBc_Writng_Dt(Timestamp bc_Writng_Dt) {
		this.bc_Writng_Dt = bc_Writng_Dt;
	}
	
	@Override
	public String toString() {
		return "Bbs_CommentVO [bc_Comnt_No=" + bc_Comnt_No + ", bc_Bbs_Code="
				+ bc_Bbs_Code + ", bc_Bbs_No=" + bc_Bbs_No + ", bc_User_Id="
				+ bc_User_Id + ", bc_Comnt_Content=" + bc_Comnt_Content
				+ ", bc_Writng_Dt=" + bc_Writng_Dt + "]";
	}
	
	
	
	

}
