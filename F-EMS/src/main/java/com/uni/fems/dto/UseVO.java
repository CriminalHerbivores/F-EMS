package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 강의실사용 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Use")
@Data
public class UseVO implements Serializable{
	private int us_No;   // 번호
	private String us_Lctrum_No;   // 강의실 번호
	private String us_User_No;   // 사용자 번호
	private String us_User;   // 사용자
	private String us_Cttpc;   // 연락처
	private String us_Cn;   // 상태
	private Timestamp us_Dt;   // 날짜
	private String us_Period;   // 교시
	private String us_Sklstf_No;   // 직원 번호
	

}
