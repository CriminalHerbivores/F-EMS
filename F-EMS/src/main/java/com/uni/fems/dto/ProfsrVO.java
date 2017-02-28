package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 교수 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Profsr")
@Data
public class ProfsrVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	// Profsr_Subjct_AsnmVO
	private String psa_Code;   // 교수학과배정코드
	private String psa_Subjct_Code;   // 학과코드
	private String psa_Profsr_No;   // 교수번호
	private Timestamp psa_Dt;   // 배정일
	
	// Subjct
	private String coleg_Nm; // 단과
	private String fc_Faculty_Nm; // 학부
	private String sit_Subjct; // 학과
	
	// Work
	private String pr_Work; // 재직상태
}
