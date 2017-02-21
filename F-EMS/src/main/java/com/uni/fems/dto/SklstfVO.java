package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 직원 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Sklstf")
@Data
public class SklstfVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stf_Sklstf_No;   // 직원 번호
	private String stf_Pw;   // 비밀번호
	private String stf_Subject_Code;   // 학과 번호
	private String stf_Nm;   // 이름
	private String stf_Eng_Nm;   // 영문 이름
	private String stf_Ihidnum;   // 주민 번호
	private String stf_Sklstf_Tlphon_No;   // 직원 전화번호
	private String stf_Moblphon_No;   // 핸드폰 번호
	private String stf_House_Tlphon_No;   // 집 전화 번호
	private String stf_Post_No;   // 우편번호
	private String stf_Adres1;   // 주소1
	private String stf_Adres2;   // 주소2
	private String stf_Email;   // 이메일
	private String stf_Useyn;   // 직원 사용여부
	
	
}
