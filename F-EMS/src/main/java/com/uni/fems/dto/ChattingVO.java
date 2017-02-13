package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Chatting")
@Data
public class ChattingVO implements Serializable{
	private String ct_Stdnt_No;   // 학생번호
	private String ct_Profsr_No;   // 교수번호
	private String ct_Knd;   // 종류
	private Timestamp ct_Dt;   // 날짜
	private String ct_Cont;   // 내용

}
