package com.uni.fems.dto;

import java.sql.Timestamp;

public class PymntVO {
	private int py_Schlship_Brkdn_No;   // 장학금 내역 번호
	private String py_Stdnt_No;   // 학생 번호
	private int py_Schlship_Code;   // 장학금 코드
	private Timestamp py_Crrspnd_Year;   // 해당 년도
	private String py_Semstr;   // 학기
	public int getPy_Schlship_Brkdn_No() {
		return py_Schlship_Brkdn_No;
	}
	public void setPy_Schlship_Brkdn_No(int py_Schlship_Brkdn_No) {
		this.py_Schlship_Brkdn_No = py_Schlship_Brkdn_No;
	}
	public String getPy_Stdnt_No() {
		return py_Stdnt_No;
	}
	public void setPy_Stdnt_No(String py_Stdnt_No) {
		this.py_Stdnt_No = py_Stdnt_No;
	}
	public int getPy_Schlship_Code() {
		return py_Schlship_Code;
	}
	public void setPy_Schlship_Code(int py_Schlship_Code) {
		this.py_Schlship_Code = py_Schlship_Code;
	}
	public Timestamp getPy_Crrspnd_Year() {
		return py_Crrspnd_Year;
	}
	public void setPy_Crrspnd_Year(Timestamp py_Crrspnd_Year) {
		this.py_Crrspnd_Year = py_Crrspnd_Year;
	}
	public String getPy_Semstr() {
		return py_Semstr;
	}
	public void setPy_Semstr(String py_Semstr) {
		this.py_Semstr = py_Semstr;
	}
	@Override
	public String toString() {
		return "PymntVO [py_Schlship_Brkdn_No=" + py_Schlship_Brkdn_No
				+ ", py_Stdnt_No=" + py_Stdnt_No + ", py_Schlship_Code="
				+ py_Schlship_Code + ", py_Semstr=" + py_Semstr + "]";
	}

}
