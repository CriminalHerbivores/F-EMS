package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 강의 질의응답 테이블의 컬럼을 넣는 변수VO
 * </pre>
 * @author KJS
 * @since 2017. 02. 22
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.02.22      KJS            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
 
@Alias("Lctre_Qna")
@Data
public class Lctre_QnaVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int lq_Bbs_No;			//게시판 번호
	private String lq_Stdnt_No;		//게시판 작성자
	private String lq_Sj;			//게시판 제목
	private String lq_Cn;			//게시판 내용
	private String lq_Reply;		//게시판 답글
	private Timestamp lq_Writng_Dt;	//게시판 작성날짜
	private int lq_Rdcnt;			//게시판 조회수

}
