package com.uni.fems.dto;

public class BuildingVO {
	private String bd_No;   // 건물 번호
	private String bd_Nm;   // 건물명
	private String bd_Useyn;   // 건물 사용유무
	public String getBd_No() {
		return bd_No;
	}
	public void setBd_No(String bd_No) {
		this.bd_No = bd_No;
	}
	public String getBd_Nm() {
		return bd_Nm;
	}
	public void setBd_Nm(String bd_Nm) {
		this.bd_Nm = bd_Nm;
	}
	public String getBd_Useyn() {
		return bd_Useyn;
	}
	public void setBd_Useyn(String bd_Useyn) {
		this.bd_Useyn = bd_Useyn;
	}
	@Override
	public String toString() {
		return "BuildingVO [bd_No=" + bd_No + ", bd_Nm=" + bd_Nm
				+ ", bd_Useyn=" + bd_Useyn + "]";
	}
	
	
	

}
