package com.uni.fems.dto;

import java.sql.Timestamp;

public class UseVO {
	private int us_No;   // 번호
	private String us_Lctrum_No;   // 강의실 번호
	private String us_User_No;   // 사용자 번호
	private String us_User;   // 사용자
	private String us_Cttpc;   // 연락처
	private String us_Cn;   // 상태
	private Timestamp us_Dt;   // 날짜
	private String us_Period;   // 교시
	private String us_Sklstf_No;   // 직원 번호
	public int getUs_No() {
		return us_No;
	}
	public void setUs_No(int us_No) {
		this.us_No = us_No;
	}
	public String getUs_Lctrum_No() {
		return us_Lctrum_No;
	}
	public void setUs_Lctrum_No(String us_Lctrum_No) {
		this.us_Lctrum_No = us_Lctrum_No;
	}
	public String getUs_User_No() {
		return us_User_No;
	}
	public void setUs_User_No(String us_User_No) {
		this.us_User_No = us_User_No;
	}
	public String getUs_User() {
		return us_User;
	}
	public void setUs_User(String us_User) {
		this.us_User = us_User;
	}
	public String getUs_Cttpc() {
		return us_Cttpc;
	}
	public void setUs_Cttpc(String us_Cttpc) {
		this.us_Cttpc = us_Cttpc;
	}
	public String getUs_Cn() {
		return us_Cn;
	}
	public void setUs_Cn(String us_Cn) {
		this.us_Cn = us_Cn;
	}
	public Timestamp getUs_Dt() {
		return us_Dt;
	}
	public void setUs_Dt(Timestamp us_Dt) {
		this.us_Dt = us_Dt;
	}
	public String getUs_Period() {
		return us_Period;
	}
	public void setUs_Period(String us_Period) {
		this.us_Period = us_Period;
	}
	public String getUs_Sklstf_No() {
		return us_Sklstf_No;
	}
	public void setUs_Sklstf_No(String us_Sklstf_No) {
		this.us_Sklstf_No = us_Sklstf_No;
	}
	@Override
	public String toString() {
		return "UseVO [us_No=" + us_No + ", us_Lctrum_No=" + us_Lctrum_No
				+ ", us_User_No=" + us_User_No + ", us_User=" + us_User
				+ ", us_Cttpc=" + us_Cttpc + ", us_Cn=" + us_Cn + ", us_Dt="
				+ us_Dt + ", us_Period=" + us_Period + ", us_Sklstf_No="
				+ us_Sklstf_No + "]";
	}

}
