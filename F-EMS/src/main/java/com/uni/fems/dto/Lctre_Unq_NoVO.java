package com.uni.fems.dto;

public class Lctre_Unq_NoVO {
	private String Lu_Lctre_Code;   // 강의 코드
	private String Lu_Lctre_Nm;   // 강의명
	private String Lu_Pnt;   // 학점
	private String Lu_Compl_Se;   // 이수구분
	private String Lu_Presubjct;   // 선수과목
	public String getLu_Lctre_Code() {
		return Lu_Lctre_Code;
	}
	public void setLu_Lctre_Code(String lu_Lctre_Code) {
		Lu_Lctre_Code = lu_Lctre_Code;
	}
	public String getLu_Lctre_Nm() {
		return Lu_Lctre_Nm;
	}
	public void setLu_Lctre_Nm(String lu_Lctre_Nm) {
		Lu_Lctre_Nm = lu_Lctre_Nm;
	}
	public String getLu_Pnt() {
		return Lu_Pnt;
	}
	public void setLu_Pnt(String lu_Pnt) {
		Lu_Pnt = lu_Pnt;
	}
	public String getLu_Compl_Se() {
		return Lu_Compl_Se;
	}
	public void setLu_Compl_Se(String lu_Compl_Se) {
		Lu_Compl_Se = lu_Compl_Se;
	}
	public String getLu_Presubjct() {
		return Lu_Presubjct;
	}
	public void setLu_Presubjct(String lu_Presubjct) {
		Lu_Presubjct = lu_Presubjct;
	}
	@Override
	public String toString() {
		return "Lctre_Unq_NoVO [Lu_Lctre_Code=" + Lu_Lctre_Code
				+ ", Lu_Lctre_Nm=" + Lu_Lctre_Nm + ", Lu_Pnt=" + Lu_Pnt
				+ ", Lu_Compl_Se=" + Lu_Compl_Se + ", Lu_Presubjct="
				+ Lu_Presubjct + "]";
	}

}
