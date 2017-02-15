package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Test")
@Data
public class TestVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String te_Ques_No;   // 문제번호
	private String te_Tp_No;   // 시험지번호
	private String te_Ques;   // 문제
	private String te_Ca;   // 정답
	

}
