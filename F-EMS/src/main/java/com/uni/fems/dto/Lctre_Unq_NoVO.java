package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 강의고유번호 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Lctre_Unq_No")
@Data
public class Lctre_Unq_NoVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lu_Lctre_Code;   // 강의 코드
	private String lu_Lctre_Nm;   // 강의명
	private String lu_Pnt;   // 학점
	private String lu_Compl_Se;   // 이수구분
	private String lu_Presubjct;   // 선수과목
	
	private String lc_Grade;   // 학년
	

}
