package com.uni.fems.dto;

public class Lctre_FlpthVO {
	private int lf_No;   // 번호
	private int lf_Lctre_No;   // 강의번호
	private String lf_File_Type;   // 파일유형코드
	private String lf_Flpth;   // 파일경로
	public int getLf_No() {
		return lf_No;
	}
	public void setLf_No(int lf_No) {
		this.lf_No = lf_No;
	}
	public int getLf_Lctre_No() {
		return lf_Lctre_No;
	}
	public void setLf_Lctre_No(int lf_Lctre_No) {
		this.lf_Lctre_No = lf_Lctre_No;
	}
	public String getLf_File_Type() {
		return lf_File_Type;
	}
	public void setLf_File_Type(String lf_File_Type) {
		this.lf_File_Type = lf_File_Type;
	}
	public String getLf_Flpth() {
		return lf_Flpth;
	}
	public void setLf_Flpth(String lf_Flpth) {
		this.lf_Flpth = lf_Flpth;
	}
	@Override
	public String toString() {
		return "Lctre_FlpthVO [lf_No=" + lf_No + ", lf_Lctre_No=" + lf_Lctre_No
				+ ", lf_File_Type=" + lf_File_Type + ", lf_Flpth=" + lf_Flpth
				+ "]";
	}

}
