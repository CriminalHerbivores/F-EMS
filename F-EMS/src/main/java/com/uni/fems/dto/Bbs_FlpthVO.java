package com.uni.fems.dto;

public class Bbs_FlpthVO {
	private int bf_No;   // 번호
	private int bf_Bbs_No_No; // 게시물 번호
	private String bf_File_Type_Code;   // 파일유형코드
	private String bf_Bbs_Code;   // 게시판 코드
	private int bf_Bbs_No;   // 게시판 번호
	private String bf_File_Path;   // 파일 경로
	private String bf_Flpth;   // 파일 유형
	private String bf_File_Nm; // 파일 이름
	public int getBf_No() {
		return bf_No;
	}
	public void setBf_No(int bf_No) {
		this.bf_No = bf_No;
	}
	public int getBf_Bbs_No_No() {
		return bf_Bbs_No_No;
	}
	public void setBf_Bbs_No_No(int bf_Bbs_No_No) {
		this.bf_Bbs_No_No = bf_Bbs_No_No;
	}
	public String getBf_File_Type_Code() {
		return bf_File_Type_Code;
	}
	public void setBf_File_Type_Code(String bf_File_Type_Code) {
		this.bf_File_Type_Code = bf_File_Type_Code;
	}
	public String getBf_Bbs_Code() {
		return bf_Bbs_Code;
	}
	public void setBf_Bbs_Code(String bf_Bbs_Code) {
		this.bf_Bbs_Code = bf_Bbs_Code;
	}
	public int getBf_Bbs_No() {
		return bf_Bbs_No;
	}
	public void setBf_Bbs_No(int bf_Bbs_No) {
		this.bf_Bbs_No = bf_Bbs_No;
	}
	public String getBf_File_Path() {
		return bf_File_Path;
	}
	public void setBf_File_Path(String bf_File_Path) {
		this.bf_File_Path = bf_File_Path;
	}
	public String getBf_Flpth() {
		return bf_Flpth;
	}
	public void setBf_Flpth(String bf_Flpth) {
		this.bf_Flpth = bf_Flpth;
	}
	public String getBf_File_Nm() {
		return bf_File_Nm;
	}
	public void setBf_File_Nm(String bf_File_Nm) {
		this.bf_File_Nm = bf_File_Nm;
	}
	
	@Override
	public String toString() {
		return "Bbs_FlpthVO [bf_No=" + bf_No + ", bf_Bbs_No_No=" + bf_Bbs_No_No
				+ ", bf_File_Type_Code=" + bf_File_Type_Code + ", bf_Bbs_Code="
				+ bf_Bbs_Code + ", bf_Bbs_No=" + bf_Bbs_No + ", bf_File_Path="
				+ bf_File_Path + ", bf_Flpth=" + bf_Flpth + ", bf_File_Nm="
				+ bf_File_Nm + "]";
	}
	

	


	
	
}
