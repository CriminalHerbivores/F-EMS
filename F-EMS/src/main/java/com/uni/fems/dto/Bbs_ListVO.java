package com.uni.fems.dto;

public class Bbs_ListVO {
	private int bl_Bbs_No;   // 게시판 번호
	private String bl_Bbs_Nm;   // 게시판 명
	private String bl_Table_Nm;   // 테이블 명
	private String bl_Use_Ennc;   // 사용유무
	
	public int getBl_Bbs_No() {
		return bl_Bbs_No;
	}
	public void setBl_Bbs_No(int bl_Bbs_No) {
		this.bl_Bbs_No = bl_Bbs_No;
	}
	public String getBl_Bbs_Nm() {
		return bl_Bbs_Nm;
	}
	public void setBl_Bbs_Nm(String bl_Bbs_Nm) {
		this.bl_Bbs_Nm = bl_Bbs_Nm;
	}
	public String getBl_Table_Nm() {
		return bl_Table_Nm;
	}
	public void setBl_Table_Nm(String bl_Table_Nm) {
		this.bl_Table_Nm = bl_Table_Nm;
	}
	public String getBl_Use_Ennc() {
		return bl_Use_Ennc;
	}
	public void setBl_Use_Ennc(String bl_Use_Ennc) {
		this.bl_Use_Ennc = bl_Use_Ennc;
	}
	@Override
	public String toString() {
		return "Bbs_ListVO [bl_Bbs_No=" + bl_Bbs_No + ", bl_Bbs_Nm="
				+ bl_Bbs_Nm + ", bl_Table_Nm=" + bl_Table_Nm + ", bl_Use_Ennc="
				+ bl_Use_Ennc + "]";
	}
	
	
	
}
