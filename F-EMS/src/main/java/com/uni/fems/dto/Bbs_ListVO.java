package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 게시판리스트 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Bbs_List")
@Data
public class Bbs_ListVO implements Serializable{
	private int bl_Bbs_No;   // 게시판 번호
	private String bl_Bbs_Nm;   // 게시판 명
	private String bl_Table_Nm;   // 테이블 명
	private String bl_Use_Ennc;   // 사용유무
	
}
