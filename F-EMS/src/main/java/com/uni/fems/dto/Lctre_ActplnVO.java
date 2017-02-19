package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 강의계획서 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Lctre_Actpln")
@Data
public class Lctre_ActplnVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int la_Lctre_No;   // 강의번호
	private String la_Main_Txtbook;   // 주교재
	private String la_Sub_Txtbook;   // 부교재
	private String la_Lctre_Goal;   // 강의목표
	private String la_Lctre_Progrs_Form;   // 강의진행형태
	private String la_Midex;   // 중간고사
	private String la_Fnex;   // 기말고사
	private String la_Indvdl_Task;   // 개인과제
	private String la_Team_Task;   // 팀별과제
	private String la_Presnatn;   // 발표
	private String la_Atend;   // 출석
	private String la_Attd;   // 태도
	private String la_Week1;   // 1주차
	private String la_Week2;   // 2주차
	private String la_Week3;   // 3주차
	private String la_Week4;   // 4주차
	private String la_Week5;   // 5주차
	private String la_Week6;   // 6주차
	private String la_Week7;   // 7주차
	private String la_Week8;   // 8주차
	private String la_Week9;   // 9주차
	private String la_Week10;   // 10주차
	private String la_Week11;   // 11주차
	private String la_Week12;   // 12주차
	private String la_Week13;   // 13주차
	private String la_Week14;   // 14주차
	private String la_Week15;   // 15주차

}
