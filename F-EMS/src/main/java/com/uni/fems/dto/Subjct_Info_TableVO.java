package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 학과 정보 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Subjct_Info_Table")
@Data
public class Subjct_Info_TableVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sit_Subjct_Code;   // 학과 코드
	private String sit_Faculty;   // 학부
	private String sit_Subjct;   // 학과
	private int sit_Tut;   // 등록금 금액
	private String sit_Subjct_Tlphon_No;   // 학과 전화 번호
	private String sit_Useyn;   // 학과 사용유무
	

}
