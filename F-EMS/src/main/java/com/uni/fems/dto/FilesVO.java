package com.uni.fems.dto;

public class FilesVO {
	private String fl_File_Type;   // 파일유형
	private String fl_File_Nm;   // 파일명
	public String getFl_File_Type() {
		return fl_File_Type;
	}
	public void setFl_File_Type(String fl_File_Type) {
		this.fl_File_Type = fl_File_Type;
	}
	public String getFl_File_Nm() {
		return fl_File_Nm;
	}
	public void setFl_File_Nm(String fl_File_Nm) {
		this.fl_File_Nm = fl_File_Nm;
	}
	@Override
	public String toString() {
		return "FilesVO [fl_File_Type=" + fl_File_Type + ", fl_File_Nm="
				+ fl_File_Nm + "]";
	}

}
