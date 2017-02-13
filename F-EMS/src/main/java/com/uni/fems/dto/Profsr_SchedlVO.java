package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Profsr_Schedl")
@Data
public class Profsr_SchedlVO implements Serializable {
	private int ps_No;   // 번호
	private String ps_Profsr_No;   // 교수 번호
	private String ps_Stdnt_No;   // 학생 번호
	private String ps_Dayweek;   // 요일
	private String ps_Period;   // 교시
	private String ps_Content;   // 내용

}
