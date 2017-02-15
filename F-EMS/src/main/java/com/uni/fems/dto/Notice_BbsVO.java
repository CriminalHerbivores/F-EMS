package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 공지게시판 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Notice_Bbs")
@Data
public class Notice_BbsVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nb_Bbs_No;   // 게시판 번호
	private String nb_Sklstf_No;   // 직원 번호
	private String nb_Sj;   // 제목
	private String nb_Cn;   // 내용
	private Timestamp nb_Writng_Dt;   // 작성 날짜
	private int nb_Rdcnt; // 조회수
}
