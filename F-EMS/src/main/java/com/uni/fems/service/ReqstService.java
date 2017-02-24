package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;

/**
 * <pre>
 * 관심강의 목록, 추가, 삭제 및 수강신청 목록, 추가, 삭제를 담당하는 service
 * </pre>
 * @author USER
 * @since 2017. 2. 21.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 21.      USER       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface ReqstService {
	
	/**
	 * <pre>
	 * 접속한 학생이 수강신청 완료한 목록을 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param re_Stdnt_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_SearchVO> selectReqst(String re_Stdnt_No) throws SQLException;
	
	
	// 개설강의 목록에서 관심등록 버튼을 눌러서 관심강의로 추가되어 관심목록으로 나타남
	// 이때 시간표상으로 겹치는 것은 관심목록으로 담기지 않는다
	//void insertIntrst_List(Intrst_ListVO intrst_ListVO) throws SQLException;
	
	
	
	
	// 개설강의 목록에서 수강신청 버튼을 누르면 바로 수강신청이 가능하여 수강신청 목록에 나타남
	// 이때 시간표상으로 겹치는 것은 수강신청이 되지 않는다
	
	
	
	
	// 관심강의에 있는 목록을 수강신청하고 조회함. 단, 이미 수강신청된 항목은 수강신청되지 않음
	
	
	
	// 관심목록에 있는 것을 관심 해제
	// 단, 이미 수강신청된 것은 수강 철회되지 않는다
	
	
	
	// 수강신청 목록에 있는 것을 수강철회 하여 수강 취소
	// 단, 관심목록에서까지 삭제되지 않는다
	
	
	// 수강신청한 것을 바탕으로 수강가능 학점 계산
	// 학생별로 학과의 졸업이수학점의 합산계를 구하여 한 학기에 들을 수 있는 학점을 계산해야 하는걸까
	
	
}
