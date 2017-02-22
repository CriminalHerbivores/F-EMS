package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 강의 공지사항 테이블의 컬럼을 넣는 변수VO
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
 
@Alias("Lctre_Notice_Gnt")
@Data
public class Lctre_Notice_GntVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String table_Nm;		//테이블 명
	private int ln_Bbs_No;			//게시판 번호
	private String ln_Sj;			//게시판 제목
	private String ln_Cn;			//게시판 내용
	private Timestamp ln_Writng_Dt;	//게시판 작성날짜
	private int ln_Rdcnt;			//게시판 조회수

}
