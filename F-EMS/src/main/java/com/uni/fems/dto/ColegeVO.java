package com.uni.fems.dto;

public class ColegeVO {
	private String coleg_Code;   // 단과대학코드
	private String coleg_Nm;   // 단과대학명
	private String coleg_Useyn;   // 단과대학 사용유무
	public String getColeg_Code() {
		return coleg_Code;
	}
	public void setColeg_Code(String coleg_Code) {
		this.coleg_Code = coleg_Code;
	}
	public String getColeg_Nm() {
		return coleg_Nm;
	}
	public void setColeg_Nm(String coleg_Nm) {
		this.coleg_Nm = coleg_Nm;
	}
	public String getColeg_Useyn() {
		return coleg_Useyn;
	}
	public void setColeg_Useyn(String coleg_Useyn) {
		this.coleg_Useyn = coleg_Useyn;
	}
	@Override
	public String toString() {
		return "ColegeVO [coleg_Code=" + coleg_Code + ", coleg_Nm=" + coleg_Nm
				+ ", coleg_Useyn=" + coleg_Useyn + "]";
	}
	
	
	

}
