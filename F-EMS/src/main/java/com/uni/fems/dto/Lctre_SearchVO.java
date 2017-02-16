package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 강의관리 및 수강신청에서 사용되는 테이블들로 구성된 뷰의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Lctre_Search")
@Data
public class Lctre_SearchVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String column;
	
	// 건물 BUILDING
	private String bd_No;   // 건물 번호
	private String bd_Nm;   // 건물명
	private String bd_useyn;   // 건물 사용유무
	
	// 강의실 LCTRUM
	private String lr_Lctrum_No;   // 강의실 번호
	private String lr_Bd_No;   // 건물 번호
	private int lr_Floor;   // 층수
	private int lr_Roomno;   // 호실
	private int lr_Accept_Nmpr;   // 수용인원
	private String lr_useyn;   // 건물 사용유무
	
	// 강의 LCTRE
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
	
	// 강의계획서 LCTRE_ACTPLN
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
	
	// 강의고유번호 LCTRE_UNQ_NO
	private String Lu_Lctre_Code;   // 강의 코드
	private String Lu_Lctre_Nm;   // 강의명
	private String Lu_Pnt;   // 학점
	private String Lu_Compl_Se;   // 이수구분
	private String Lu_Presubjct;   // 선수과목
	
	// 종류 KIND
	private int knd_Lctre_No;   // 강의번호
	private String knd_Lctre_Knd;   // 강의종류
	
	// 관심목록 INTRST_LIST
	private String in_Stdnt_No;   // 학생번호
	private int in_Lctre_No;   // 강의번호
	
	// 교수 PROFSR
	private String pr_Profsr_No;   // 교수 번호
	private String pr_Pw;   // 비밀번호
	private String pr_Nm;   // 이름
	private String pr_Eng_Nm;   // 영문 이름
	private String pr_Ihidnum;   // 주민번호
	private String pr_Moblphon_No;   // 핸드폰 번호
	private String pr_House_Tlphon_No;   // 집 전화번호
	private String pr_Profsr_Tlphon_No;   // 교수 전화번호
	private String pr_Post_No;   // 우편 번호
	private String pr_Adres1;   // 주소1
	private String pr_Adres2;   // 주소2
	private String pr_Email;   // 이메일
	
	// 교수학과배정 PROFSR_SUBJCT_ASNM
	private String psa_Code;   // 교수학과배정코드
	private String psa_Subjct_Code;   // 학과코드
	private String psa_Profsr_No;   // 교수번호
	private Timestamp psa_Dt;   // 배정일
	
	// 학과정보테이블 SUBJCT_INFO_TABLE
	private String sit_Subjct_Code;   // 학과 코드
	private String sit_Faculty;   // 학부 코드?
	private String sit_Subjct;   // 학과
	private int sit_Tut;   // 등록금 금액
	private String sit_useyn;   // 학과 사용유무
	
	// 학부 FACULTY
	private String fc_Faculty_Code;   // 학부코드
	private String fc_Coleg_Code;   // 단과대학코드
	private String fc_Faculty_Nm;   // 학부명
	private String fc_useyn;   // 학부 사용유무
	
	// 단과대학 COLEGE
	private String coleg_Code;   // 단과대학코드
	private String coleg_Nm;   // 단과대학명
	private String coleg_useyn;   // 단과대학 사용유무
	
}
