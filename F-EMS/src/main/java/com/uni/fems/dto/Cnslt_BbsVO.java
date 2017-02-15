package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 상담게시판 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Cnslt_BbsVO")
@Data
public class Cnslt_BbsVO implements Serializable{
	private int cb_No;   // 게시판번호
	private String cb_User_No;   // 사용자번호
	private String cb_Title;   // 제목
	private String cb_Cont;   // 내용
	private Timestamp cb_Writing;   // 작성날짜
	private String cb_Answer;   // 댓글

}
