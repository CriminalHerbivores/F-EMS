package com.uni.fems.dto;

public class Sklstf_AtrtyVO {
	private String sa_Sklstf_No;   // 직원번호
	private String sa_Atrty;   // 권한
	public String getSa_Sklstf_No() {
		return sa_Sklstf_No;
	}
	public void setSa_Sklstf_No(String sa_Sklstf_No) {
		this.sa_Sklstf_No = sa_Sklstf_No;
	}
	public String getSa_Atrty() {
		return sa_Atrty;
	}
	public void setSa_Atrty(String sa_Atrty) {
		this.sa_Atrty = sa_Atrty;
	}
	@Override
	public String toString() {
		return "Sklstf_AtrtyVO [sa_Sklstf_No=" + sa_Sklstf_No + ", sa_Atrty="
				+ sa_Atrty + "]";
	}

}
