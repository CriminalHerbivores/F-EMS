package com.uni.fems.dto;

import java.io.Serializable;
import java.util.List;

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
	private String te_No1; // 객관식 1
	private String te_No2; // 객관식 2
	private String te_No3; // 객관식 3
	private String te_No4; // 객관식 4
	private List<TestVO> list; 
	

}
