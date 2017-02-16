package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 강의 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Lctre")
@Data
public class LctreVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lc_Lctre_No;   // 강의번호
	private String lc_Profsr_No;   // 교수번호
	private String lc_Lctre_Code;   // 강의코드
	private Timestamp lc_Lctrbgn_Dt;   // 강의개강일
	private int lc_Lctre_Nmpr;   // 강의 인원
	private String lc_Wik_Lctre_Dayweek;   // 주간 강의 요일
	private String lc_Lctre_Time;   // 강의 시간
	private String lc_Pnt;   // 학점
	private String lc_Grade;   // 학년
	private String lc_Lctrum_No;   // 강의실 번호
	private String lc_Open_At;   // 개설여부
	private String lc_Lctre_Org;   // 강의 원본
	private String lc_Lctre_Evl_Score;   // 강의 평가 점수
	private String lc_Split;   // 분반
	

	
}
