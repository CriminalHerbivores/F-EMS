package com.uni.fems.dto;

public class FilesVO {
	private String fl_File_Type_Code;   // 파일유형코드
	private String fl_File_Nm;   // 파일명
	public String getFl_File_Type_Code() {
		return fl_File_Type_Code;
	}
	public void setFl_File_Type_Code(String fl_File_Type_Code) {
		this.fl_File_Type_Code = fl_File_Type_Code;
	}
	public String getFl_File_Nm() {
		return fl_File_Nm;
	}
	public void setFl_File_Nm(String fl_File_Nm) {
		this.fl_File_Nm = fl_File_Nm;
	}
	@Override
	public String toString() {
		return "FilesVO [fl_File_Type_Code=" + fl_File_Type_Code
				+ ", fl_File_Nm=" + fl_File_Nm + "]";
	}

}
