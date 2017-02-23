package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 제너레이터로 생성된 게시판 VO클래스
 * </pre>
 * @author KJS
 * @since 2017. 02. 21
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.02.21      KJS            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
 
@Alias("Bbs_Gnt")
@Data
public class Bbs_GntVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bb_Bbs_No;			//게시판 번호
	private String bb_Sklstf_No;	//작성자 번호
	private String bb_Sj;			//게시판 제목
	private String bb_Cn;			//게시판 내용
	private Timestamp bb_Writng_dt;	//게시판 작성일
	private int bb_Rdcnt;		//게시판 조회수
}
