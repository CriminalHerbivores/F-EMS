package com.uni.fems.dto;

import java.io.Serializable;
import java.util.ArrayList;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 성적 테이블의 컬럼을 변수로 하는 VO클래스
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
 
@Alias("Grade")
@Data
public class GradeVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gd_Stdnt_No;   // 학생번호
	private int gd_Lctre_No;   // 강의번호
	private String gd_Grade;   // 성적
	private String gd_Tot_Score;   // 총 점수
	private String gd_Attd_Score;   // 태도 점수
	private String gd_Atend_Score;   // 출석 점수
	private String gd_Task_Score;   // 과제 점수
	private String gd_Midex_Score;   // 중간 점수
	private String gd_Fnex_Score;   // 기말 점수
	private String gd_Mini_Score; // 수시 점수
	private ArrayList<GradeVO> gradeList;
	
	private String key; //컬럼값
	private String value; //입력값
}
