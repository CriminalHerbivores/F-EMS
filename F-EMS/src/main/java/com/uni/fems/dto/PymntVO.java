package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 지급 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Pymnt")
@Data
public class PymntVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int py_Schlship_Brkdn_No;   // 장학금 내역 번호
	private String py_Stdnt_No;   // 학생 번호
	private int py_Schlship_Code;   // 장학금 코드
	private String py_Crrspnd_Year;   // 해당 년도
	private String py_Semstr;   // 학기
	private Timestamp py_Schlship_Dt; // 신청날짜
	private String py_Useyn; // 승인여부
}
