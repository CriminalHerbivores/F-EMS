package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 상담 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Consultation")
@Data
public class ConsultationVO implements Serializable {
	private String cs_Stdnt_No;   // 학생번호
	private String cs_Profsr_No;   // 교수번호
	private Timestamp cs_Dt;   // 날짜
	private String cs_Knd;   // 종류
	private String cs_Cont;   // 내용

}
