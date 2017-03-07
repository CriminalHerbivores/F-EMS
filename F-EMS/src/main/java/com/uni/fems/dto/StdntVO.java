package com.uni.fems.dto;

import java.io.Serializable;
import java.util.List;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 학생 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Stdnt")
@Data
public class StdntVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String st_Stdnt_No;   // 학생 번호
	private String st_Subjct_Code;   // 학과 코드
	private String st_Pw;   // 비밀번호
	private String st_Nm;   // 이름
	private String st_Eng_Nm;   // 영문 이름
	private String st_Ihidnum;   // 주민번호
	private String st_Moblphon_No;   // 핸드폰 번호
	private String st_House_Tlphon_No;   // 집 전화 번호
	private String st_Entsch_Dt;   // 입학 일자
	private String st_Prtctor_Nm;   // 보호자 이름
	private String st_Family_Relate;   // 가족 관계
	private String st_Post_No;   // 우편 번호
	private String st_Adres1;   // 주소1
	private String st_Adres2;   // 주소2
	private String st_Cnslt_At;   // 상담 여부
	private String st_Email;   // 이메일
	private String st_Brhs_At;   // 기숙사 여부
	private String st_Profsr_No;   // 교수 번호
	private String st_Grdtn_Dt;   // 졸업 일자
	private String createNo; // 등록용 넘버
	// Subjct
	private String coleg_Nm; // 단과
	private String fc_Faculty_Nm; // 학부
	private String sit_Subjct; // 학과
	
	private String st_Sknrgs; //학적 상태
	
	private List<StdntVO> list;
	
}
