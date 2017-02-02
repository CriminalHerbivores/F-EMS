package com.uni.fems.dto;

public class Bbs_AtrtyVO {
	private int ba_Bbs_No;   // 게시판 번호
	private String ba_Manage;   // 관리자
	private String ba_Sklstf;   // 직원
	private String ba_Profsr;   // 교수
	private String ba_Stdnt;   // 학생
	public int getBa_Bbs_No() {
		return ba_Bbs_No;
	}
	public void setBa_Bbs_No(int ba_Bbs_No) {
		this.ba_Bbs_No = ba_Bbs_No;
	}
	public String getBa_Manage() {
		return ba_Manage;
	}
	public void setBa_Manage(String ba_Manage) {
		this.ba_Manage = ba_Manage;
	}
	public String getBa_Sklstf() {
		return ba_Sklstf;
	}
	public void setBa_Sklstf(String ba_Sklstf) {
		this.ba_Sklstf = ba_Sklstf;
	}
	public String getBa_Profsr() {
		return ba_Profsr;
	}
	public void setBa_Profsr(String ba_Profsr) {
		this.ba_Profsr = ba_Profsr;
	}
	public String getBa_Stdnt() {
		return ba_Stdnt;
	}
	public void setBa_Stdnt(String ba_Stdnt) {
		this.ba_Stdnt = ba_Stdnt;
	}
	@Override
	public String toString() {
		return "Bbs_AtrtyVO [ba_Bbs_No=" + ba_Bbs_No + ", ba_Manage="
				+ ba_Manage + ", ba_Sklstf=" + ba_Sklstf + ", ba_Profsr="
				+ ba_Profsr + ", ba_Stdnt=" + ba_Stdnt + "]";
	}

}
