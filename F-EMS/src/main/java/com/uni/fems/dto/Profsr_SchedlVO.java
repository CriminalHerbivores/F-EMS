package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 교수스케줄 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Profsr_Schedl")
@Data
public class Profsr_SchedlVO implements Serializable {
	private int ps_No;   // 번호
	private String ps_Profsr_No;   // 교수 번호
	private String ps_Stdnt_No;   // 학생 번호
	private String ps_Dayweek;   // 요일
	private String ps_Period;   // 교시
	private String ps_Content;   // 내용

}
