package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 학적 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Sknrgs")
@Data
public class SknrgsVO implements Serializable{
	private int skn_No;   // 번호
	private String skn_Stdnt_No;   // 학생번호
	private String skn_Type;   // 유형
	private Timestamp skn_Reqst_Dt;   // 신청날짜
	private String skn_Content;   // 신청사유
	private String skn_Useyn;   // 승인여부
	private String skn_File;   // 첨부파일 경로
	
}
