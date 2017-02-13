package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Lctre_Unq_No")
@Data
public class Lctre_Unq_NoVO implements Serializable {
	private String Lu_Lctre_Code;   // 강의 코드
	private String Lu_Lctre_Nm;   // 강의명
	private String Lu_Pnt;   // 학점
	private String Lu_Compl_Se;   // 이수구분
	private String Lu_Presubjct;   // 선수과목
	

}
