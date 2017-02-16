package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 이수 학점 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Compl_Pnt")
@Data
public class Compl_PntVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cp_Subjct_Code;   // 학과 코드
	private int cp_Major_Choice;   // 전공 선택
	private int cp_Major_Essntl;   // 전공 필수
	private int cp_Cltr_Essntl;   // 교양 필수
	private int cp_Cltr_Choice;   // 교양 선택

}
