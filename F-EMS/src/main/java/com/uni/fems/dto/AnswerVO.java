package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Answer")
@Data
public class AnswerVO implements Serializable {
	private String an_Ques_No;   // 문제번호
	private String an_Tp_No;   // 시험지번호
	private String an_Stdnt_No;   // 학생번호
	private String an_Ans;   // 답안
	

}
