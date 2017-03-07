package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 게시판리스트와 게시판권한의 테이블을 join하여 만든 view의 컬럼을 변수로 하는 VO클래스
 * </pre>
 * @author KJH
 * @since 2017. 02. 17
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.02.17      KJS            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
 
@Alias("Bbs_List_Atrty")
@Data
public class Bbs_List_AtrtyVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bl_Bbs_No;   // 게시판 번호
	private String bl_Bbs_Nm;   // 게시판 명
	private String bl_Table_Nm;   // 테이블 명
	private String bl_Use_Ennc;   // 사용유무
	private String ba_Manage;   // 관리자
	private String ba_Sklstf;   // 직원
	private String ba_Profsr;   // 교수
	private String ba_Stdnt;   // 학생
	
	private String ba_Alpha; //게시판 첫글자
	
}
