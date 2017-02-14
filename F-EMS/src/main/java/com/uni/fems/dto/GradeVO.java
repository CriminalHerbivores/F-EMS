package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Grade")
@Data
public class GradeVO implements Serializable {
	private String gd_Stdnt_No;   // 학생번호
	private int gd_Lctre_No;   // 강의번호
	private String gd_Grade;   // 성적
	private String gd_Tot_Score;   // 총 점수
	private String gd_Attd_Score;   // 태도 점수
	private String gd_Atend_Score;   // 출석 점수
	private String gd_Task_Score;   // 과제 점수
	private String gd_Midex_Score;   // 중간 점수
	private String gd_Fnex_Score;   // 기말 점수

}
