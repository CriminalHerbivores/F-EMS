package com.uni.fems.dto;

public class WorkVO {
	private String wk_No;   // 재직번호
	private String wk_Profsr_No;   // 교수번호
	private String wk_Dt;   // 날짜
	private String wk_Work_Status;   // 재직상태
	public String getWk_No() {
		return wk_No;
	}
	public void setWk_No(String wk_No) {
		this.wk_No = wk_No;
	}
	public String getWk_Profsr_No() {
		return wk_Profsr_No;
	}
	public void setWk_Profsr_No(String wk_Profsr_No) {
		this.wk_Profsr_No = wk_Profsr_No;
	}
	public String getWk_Dt() {
		return wk_Dt;
	}
	public void setWk_Dt(String wk_Dt) {
		this.wk_Dt = wk_Dt;
	}
	public String getWk_Work_Status() {
		return wk_Work_Status;
	}
	public void setWk_Work_Status(String wk_Work_Status) {
		this.wk_Work_Status = wk_Work_Status;
	}
	@Override
	public String toString() {
		return "WorkVO [wk_No=" + wk_No + ", wk_Profsr_No=" + wk_Profsr_No
				+ ", wk_Dt=" + wk_Dt + ", wk_Work_Status=" + wk_Work_Status
				+ "]";
	}
	

}
