package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 직원권한 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Sklstf_Atrty")
@Data
public class Sklstf_AtrtyVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sa_Sklstf_No;   // 직원번호
	private String sa_Atrty;   // 권한
	

}
