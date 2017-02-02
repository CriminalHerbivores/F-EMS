package com.uni.fems.dto;

import java.sql.Timestamp;

public class Notice_BbsVO {
	private int nb_Bbs_No;   // 게시판 번호
	private String nb_Sklstf_No;   // 직원 번호
	private String nb_Sj;   // 제목
	private String nb_Cn;   // 내용
	private Timestamp nb_Writng_Dt;   // 작성 날짜
	public int getNb_Bbs_No() {
		return nb_Bbs_No;
	}
	public void setNb_Bbs_No(int nb_Bbs_No) {
		this.nb_Bbs_No = nb_Bbs_No;
	}
	public String getNb_Sklstf_No() {
		return nb_Sklstf_No;
	}
	public void setNb_Sklstf_No(String nb_Sklstf_No) {
		this.nb_Sklstf_No = nb_Sklstf_No;
	}
	public String getNb_Sj() {
		return nb_Sj;
	}
	public void setNb_Sj(String nb_Sj) {
		this.nb_Sj = nb_Sj;
	}
	public String getNb_Cn() {
		return nb_Cn;
	}
	public void setNb_Cn(String nb_Cn) {
		this.nb_Cn = nb_Cn;
	}
	public Timestamp getNb_Writng_Dt() {
		return nb_Writng_Dt;
	}
	public void setNb_Writng_Dt(Timestamp nb_Writng_Dt) {
		this.nb_Writng_Dt = nb_Writng_Dt;
	}
	@Override
	public String toString() {
		return "Notice_BbsVO [nb_Bbs_No=" + nb_Bbs_No + ", nb_Sklstf_No="
				+ nb_Sklstf_No + ", nb_Sj=" + nb_Sj + ", nb_Cn=" + nb_Cn + "]";
	}

}
