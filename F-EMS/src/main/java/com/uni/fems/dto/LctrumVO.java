package com.uni.fems.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 강의실 테이블의 컬럼을 변수로 하는 VO클래스
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
 
@Alias("Lctrum")
@Data
public class LctrumVO {
	private String lr_Lctrum_No;   // 강의실 번호
	private String lr_Bd_No;   // 건물 번호
	private int lr_Floor;   // 층수
	private int lr_Roomno;   // 호실
	private int lr_Accept_Nmpr;   // 수용인원
	private String lr_Useyn;   // 강의실 사용유무

}
