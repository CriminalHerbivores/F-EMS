package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 출결 테이블의 컬럼을 변수로 하는 VO클래스
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

@Alias("Attendance")
@Data
public class AttendanceVO implements Serializable {
	private String atd_Stdnt_No;   // 학생 번호
	private int atd_Lctre_No;   // 강의 번호
	private String atd_Atend;   // 출결
	private Timestamp atd_Dt;   // 날짜
	
}
