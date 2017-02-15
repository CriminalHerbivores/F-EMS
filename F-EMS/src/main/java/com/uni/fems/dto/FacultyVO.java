package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 학부 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Faculty")
@Data
public class FacultyVO implements Serializable {
	private String fc_Faculty_Code;   // 학부코드
	private String fc_Coleg_Code;   // 단과대학코드
	private String fc_Faculty_Nm;   // 학부명
	private String fc_Useyn;   // 학부 사용유무

}
