package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Tuition")
@Data
public class TuitionVO implements Serializable{
	private int tu_No;   // 등록금번호
	private String tu_Stdnt_No;   // 학생번호
	private String tu_Subjct_Code;   // 학과코드
	private int tu_Tut;   // 등록금 금액
	private Timestamp tu_Pay_Dt; //납부일
	
}
