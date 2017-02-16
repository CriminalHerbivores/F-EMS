package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 게시판파일경로 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Bbs_Flpth")
@Data
public class Bbs_FlpthVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bf_No;   // 번호
	private int bf_Bbs_No_No; // 게시물 번호
	private String bf_File_Type_Code;   // 파일유형코드
	private String bf_Bbs_Code;   // 게시판 코드
	private int bf_Bbs_No;   // 게시판 번호
	private String bf_File_Nm; // 파일 이름
	
}
