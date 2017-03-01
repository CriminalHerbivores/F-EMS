package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

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
 
@Alias("Lctre_Watch")
@Data
public class Lctre_WatchVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int lw_Bbs_No;			//게시판 번호
	private String lw_Stdnt_No;		//게시판 작성자
	private int lw_Video_Bbs_No;	//동영상 게시판 번호
	private int lw_Watch_Time;		//동영상 시청 시간
	private String lw_Attendance;	//출결 사항

}
