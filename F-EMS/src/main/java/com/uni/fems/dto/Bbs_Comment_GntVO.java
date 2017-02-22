package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 제너레이터로 생성한 게시판의 댓글 테이블 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Bbs_Comment_Gnt")
@Data
public class Bbs_Comment_GntVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bc_Comnt_No; //댓글번호
	private int bc_Bbs_No; // 게시판번호
	private String bc_User_Id; // 댓글 작성자 아이디
	private String bc_Comnt_Content; // 댓글 내용
	private Timestamp bc_Writng_Dt; // 댓글 작성 날짜

}
