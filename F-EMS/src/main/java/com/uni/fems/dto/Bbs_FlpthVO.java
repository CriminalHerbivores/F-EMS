package com.uni.fems.dto;

public class Bbs_FlpthVO {
	private int bf_No;   // 번호
	private String bf_File_Type_Code;   // 파일유형코드
	private int bf_Bbs_Code;   // 게시판 코드
	private int bf_Bbs_No;   // 게시판 번호
	private String bf_File_Type;   // 파일 경로
	private String bf_Flpth;   // 파일 유형
	public int getBf_No() {
		return bf_No;
	}
	public void setBf_No(int bf_No) {
		this.bf_No = bf_No;
	}
	public String getBf_File_Type_Code() {
		return bf_File_Type_Code;
	}
	public void setBf_File_Type_Code(String bf_File_Type_Code) {
		this.bf_File_Type_Code = bf_File_Type_Code;
	}
	public int getBf_Bbs_Code() {
		return bf_Bbs_Code;
	}
	public void setBf_Bbs_Code(int bf_Bbs_Code) {
		this.bf_Bbs_Code = bf_Bbs_Code;
	}
	public int getBf_Bbs_No() {
		return bf_Bbs_No;
	}
	public void setBf_Bbs_No(int bf_Bbs_No) {
		this.bf_Bbs_No = bf_Bbs_No;
	}
	public String getBf_File_Type() {
		return bf_File_Type;
	}
	public void setBf_File_Type(String bf_File_Type) {
		this.bf_File_Type = bf_File_Type;
	}
	public String getBf_Flpth() {
		return bf_Flpth;
	}
	public void setBf_Flpth(String bf_Flpth) {
		this.bf_Flpth = bf_Flpth;
	}
	@Override
	public String toString() {
		return "Bbs_FlpthVO [bf_No=" + bf_No + ", bf_File_Type_Code="
				+ bf_File_Type_Code + ", bf_Bbs_Code=" + bf_Bbs_Code
				+ ", bf_Bbs_No=" + bf_Bbs_No + ", bf_File_Type=" + bf_File_Type
				+ ", bf_Flpth=" + bf_Flpth + "]";
	}

}
