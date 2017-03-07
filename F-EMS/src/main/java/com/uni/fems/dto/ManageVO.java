package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
//import oracle.sql.CLOB;

/**
 * <pre>
 * 대학관리 테이블의 컬럼을 변수로 하는 VO클래스
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
 * 2017.02.15      KJH            추가작성 
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
 
@Alias("Manage")
@Data
public class ManageVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mng_Univ_Nm;   // 대학이름
	private String mng_Univ_Eng_Nm;   // 대학영문이름
	private String mng_Univ_Logo;   // 대학로고
	private String mng_Post_No;   // 우편번호
	private String mng_Adres1;   // 주소1
	private String mng_Adres2;   // 주소2
	private String mng_Tlphon_No;   // 전화번호
	private String mng_Fax_No;   // 팩스번호
	private String mng_Email;   // 이메일
	private String mng_Cpyr;   // 저작권
	private String mng_Layout_Knd;   // 레이아웃 종류
	private String mng_Left_Menu_Use_Ennc;   // 좌측메뉴 사용유무
	private String mng_Main_Color;   // 메인컬러
	private String mng_Sub_Color1;   // 보조컬러1
	private String mng_Sub_Color2;   // 보조컬러2
	private String mng_Reltv_Evl_Rate;   // 상대평가비율

	private String mng_Main_Txtclr;   // 메인 텍스트 컬러
	private String mng_Sub_Txtclr1;   // 보조 텍스트 컬러1
	private String mng_Sub_Txtclr2;   // 보조 텍스트 컬러2
	private String mng_Univ_Img;   // 대학이미지
	
	private String column1; 

	private String mng_Univ_Logo_Ori;   // 대학로고원본
	private String mng_Univ_Img_Ori;   // 대학이미지원본
}
