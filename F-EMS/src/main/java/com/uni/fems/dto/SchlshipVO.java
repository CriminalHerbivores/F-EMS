package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Schlship")
@Data
public class SchlshipVO implements Serializable{
	private int ss_Schlship_Code;   // 장학금 코드
	private String ss_Schlship_Nm;   // 장학금 명
	private String ss_Schlship_Type;   // 유형
	private int ss_Amount;   // 금액
	private String ss_Papers_Content;   // 서류 내용
	private String ss_File; // 첨부파일
	
	
}
