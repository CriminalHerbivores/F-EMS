package com.uni.fems.dto;

public class FacultyVO {
	private String fc_Faculty_Code;   // 학부코드
	private String fc_Coleg_Code;   // 단과대학코드
	private String fc_Faculty_Nm;   // 학부명
	public String getFc_Faculty_Code() {
		return fc_Faculty_Code;
	}
	public void setFc_Faculty_Code(String fc_Faculty_Code) {
		this.fc_Faculty_Code = fc_Faculty_Code;
	}
	public String getFc_Coleg_Code() {
		return fc_Coleg_Code;
	}
	public void setFc_Coleg_Code(String fc_Coleg_Code) {
		this.fc_Coleg_Code = fc_Coleg_Code;
	}
	public String getFc_Faculty_Nm() {
		return fc_Faculty_Nm;
	}
	public void setFc_Faculty_Nm(String fc_Faculty_Nm) {
		this.fc_Faculty_Nm = fc_Faculty_Nm;
	}
	@Override
	public String toString() {
		return "FacultyVO [fc_Faculty_Code=" + fc_Faculty_Code
				+ ", fc_Coleg_Code=" + fc_Coleg_Code + ", fc_Faculty_Nm="
				+ fc_Faculty_Nm + "]";
	}


}
