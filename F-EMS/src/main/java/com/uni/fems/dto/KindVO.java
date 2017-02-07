package com.uni.fems.dto;


public class KindVO {
	private int knd_Lctre_No;   // 강의번호
	private String knd_Lctre_Knd;   // 강의종류
	public int getKnd_Lctre_No() {
		return knd_Lctre_No;
	}
	public void setKnd_Lctre_No(int knd_Lctre_No) {
		this.knd_Lctre_No = knd_Lctre_No;
	}
	public String getKnd_Lctre_Knd() {
		return knd_Lctre_Knd;
	}
	public void setKnd_Lctre_Knd(String knd_Lctre_Knd) {
		this.knd_Lctre_Knd = knd_Lctre_Knd;
	}
	@Override
	public String toString() {
		return "KindVO [knd_Lctre_No=" + knd_Lctre_No + ", knd_Lctre_Knd="
				+ knd_Lctre_Knd + "]";
	}
	
	

}
