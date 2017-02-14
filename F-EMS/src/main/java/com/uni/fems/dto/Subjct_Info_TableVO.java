package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Subjct_Info_Table")
@Data
public class Subjct_Info_TableVO implements Serializable{
	private String sit_Subjct_Code;   // 학과 코드
	private String sit_Faculty;   // 학부
	private String sit_Subjct;   // 학과
	private int sit_Tut;   // 등록금 금액
	private String sit_Subjct_Tlphon_No;   // 학과 전화 번호
	private String sit_Useyn;   // 학과 사용유무
	

}
