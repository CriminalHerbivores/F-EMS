package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Pymnt")
@Data
public class PymntVO implements Serializable{
	private int py_Schlship_Brkdn_No;   // 장학금 내역 번호
	private String py_Stdnt_No;   // 학생 번호
	private int py_Schlship_Code;   // 장학금 코드
	private String py_Crrspnd_Year;   // 해당 년도
	private String py_Semstr;   // 학기
	private Timestamp py_Schlship_Dt; // 신청날짜
	private String py_Useyn; // 승인여부
	
}
