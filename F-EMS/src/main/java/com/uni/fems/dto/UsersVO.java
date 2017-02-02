package com.uni.fems.dto;

public class UsersVO {
	private String user_No;   // 사용자 번호
	private String user_Sklstf_No;   // 직원번호
	private String user_Stdnt_No;   // 학생번호
	private String user_Profsr_No;   // 교수번호
	public String getUser_No() {
		return user_No;
	}
	public void setUser_No(String user_No) {
		this.user_No = user_No;
	}
	public String getUser_Sklstf_No() {
		return user_Sklstf_No;
	}
	public void setUser_Sklstf_No(String user_Sklstf_No) {
		this.user_Sklstf_No = user_Sklstf_No;
	}
	public String getUser_Stdnt_No() {
		return user_Stdnt_No;
	}
	public void setUser_Stdnt_No(String user_Stdnt_No) {
		this.user_Stdnt_No = user_Stdnt_No;
	}
	public String getUser_Profsr_No() {
		return user_Profsr_No;
	}
	public void setUser_Profsr_No(String user_Profsr_No) {
		this.user_Profsr_No = user_Profsr_No;
	}
	@Override
	public String toString() {
		return "UsersVO [user_No=" + user_No + ", user_Sklstf_No="
				+ user_Sklstf_No + ", user_Stdnt_No=" + user_Stdnt_No
				+ ", user_Profsr_No=" + user_Profsr_No + "]";
	}

}
