package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 학사일정 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Schafs_Schdul")
@Data
public class Schafs_SchdulVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sd_No;   // 번호
	private String sd_Sklstf_No;   // 직원번호
	private String sd_Schdul_Nm;   // 일정명
	private String sd_Schdul_Sumry;   // 일정 요약
	private String sd_Detail_Dc;   // 상세 설명
	private Timestamp sd_Bgnde;   // 시작일
	private Timestamp sd_Enddt;   // 종료일
	

}
