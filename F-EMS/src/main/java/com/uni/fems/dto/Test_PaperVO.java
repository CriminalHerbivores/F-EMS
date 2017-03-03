package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 시험문제 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Test_Paper")
@Data
public class Test_PaperVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String tp_No;   // 시험지번호
	private int tp_Lctre_No;   // 교수번호
	private String tp_Profsr_No;   // 강의번호
	private String tp_Nm; // 시험명
	private Timestamp tp_Dt;   // 날짜
	private int countAnswerSTD; // 시험본학생수
	private String nameAnswerSTD; //시험본학생이름
	private Timestamp tp_Start_Dt; // 시작날짜
	private Timestamp tp_End_Dt; // 끝날짜
	

}
