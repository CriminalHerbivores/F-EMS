package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 강의 동영상 시청 여부를 알수있는 테이블의 컬럼을 넣는 변수VO
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
 * 2017.02.28	   KJS			  수정작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
 
@Alias("Lctre_Watch_Video_Gnt")
@Data
public class Lctre_Watch_Video_GntVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String table_Nm;		//테이블 명
	private int lv_Bbs_No;			//게시판 번호
	private String lv_Sj;			//게시판 제목
	private String lv_Cn;			//게시판 내용
	private Date lv_Start_Dt;		//동영상 시천 가능날짜
	private Date lv_End_Dt;			//동여앙 시청 출석 마지막 날짜
	private int lv_Time;			//총 시청 시간
	private String lv_Flpth_No;		//게시판 파일 경로 번호
	
	private String lw_Bbs_No;			//게시판 번호
	private String lw_Stdnt_No;		//게시판 작성자
	private String lw_Video_Bbs_No;	//동영상 게시판 번호
	private String lw_Watch_Time;		//동영상 시청 시간
	private String lw_Attendance;	//출결 사항

}
