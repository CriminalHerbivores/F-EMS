package com.uni.fems.dto;

import java.sql.Timestamp;

public class Schafs_SchdulVO {
	private int sd_No;   // 번호
	private String sd_Sklstf_No;   // 직원번호
	private String sd_Schdul_Nm;   // 일정명
	private String sd_Schdul_Sumry;   // 일정 요약
	private String sd_Detail_Dc;   // 상세 설명
	private Timestamp sd_Bgnde;   // 시작일
	private Timestamp sd_Enddt;   // 종료일
	public int getSd_No() {
		return sd_No;
	}
	public void setSd_No(int sd_No) {
		this.sd_No = sd_No;
	}
	public String getSd_Sklstf_No() {
		return sd_Sklstf_No;
	}
	public void setSd_Sklstf_No(String sd_Sklstf_No) {
		this.sd_Sklstf_No = sd_Sklstf_No;
	}
	public String getSd_Schdul_Nm() {
		return sd_Schdul_Nm;
	}
	public void setSd_Schdul_Nm(String sd_Schdul_Nm) {
		this.sd_Schdul_Nm = sd_Schdul_Nm;
	}
	public String getSd_Schdul_Sumry() {
		return sd_Schdul_Sumry;
	}
	public void setSd_Schdul_Sumry(String sd_Schdul_Sumry) {
		this.sd_Schdul_Sumry = sd_Schdul_Sumry;
	}
	public String getSd_Detail_Dc() {
		return sd_Detail_Dc;
	}
	public void setSd_Detail_Dc(String sd_Detail_Dc) {
		this.sd_Detail_Dc = sd_Detail_Dc;
	}
	public Timestamp getSd_Bgnde() {
		return sd_Bgnde;
	}
	public void setSd_Bgnde(Timestamp sd_Bgnde) {
		this.sd_Bgnde = sd_Bgnde;
	}
	public Timestamp getSd_Enddt() {
		return sd_Enddt;
	}
	public void setSd_Enddt(Timestamp sd_Enddt) {
		this.sd_Enddt = sd_Enddt;
	}
	@Override
	public String toString() {
		return "Schafs_SchdulVO [sd_No=" + sd_No + ", sd_Sklstf_No="
				+ sd_Sklstf_No + ", sd_Schdul_Nm=" + sd_Schdul_Nm
				+ ", sd_Schdul_Sumry=" + sd_Schdul_Sumry + ", sd_Detail_Dc="
				+ sd_Detail_Dc + "]";
	}

}
