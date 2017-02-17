package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 장학금 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Schlship")
@Data
public class SchlshipVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ss_Schlship_Code;   // 장학금 코드
	private String ss_Schlship_Nm;   // 장학금 명
	private String ss_Schlship_Type;   // 유형
	private int ss_Amount;   // 금액
	private String ss_Papers_Content;   // 서류 내용
	private String ss_File;	// 첨부파일
	private String ss_useyn;	// 사용유무
}
