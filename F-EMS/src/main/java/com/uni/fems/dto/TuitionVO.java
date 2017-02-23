package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

import org.springframework.beans.factory.annotation.Value;

/**
 * <pre>
 * 등록금 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Tuition")
@Data
public class TuitionVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tu_No;   // 등록금번호
	private String tu_Stdnt_No;   // 학생번호
	private String tu_Subjct_Code;   // 학과코드
	private int tu_Tut;   // 등록금 금액
	private String tu_Virtl_acnut_No; //가상계좌
	@Value("")
	private String tu_Pay_Dt; //납부일
	@Value("")
	private String tu_Dt; // 고지일
	@Value("")
	private String tu_Dt_L; // 고지 마지막일
	
	private String tu_Nm; //???
	private String coleg_Nm; //단과대학
	private String sit_Faculty;   // 학부
	private String sit_Subjct;   // 학과
	
	@Value("tu_No")
	private String key;
	@Value("")
	private String value;
	
	
}
