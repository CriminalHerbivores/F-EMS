package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.dto.ManageVO;

/**
 * <pre>
 * 직원의 관리자 권한 부여 설정 및 관리 관련 입력, 수정 service
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

public interface ManageService {
	/**
	 * <pre>
	 * 대학이름과 일치하는 하나의 대학정보 가져오기
	 * </pre>
	 * <pre>
	 * @param mng_Univ_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ManageVO getManage() throws SQLException;
//	void getListSklstf(SklstfVO sklstfVO) throws SQLException;
//	
//	void setSklstfAtrty(SklstfVO sklstfVO) throws SQLException;
//	
//	void insertManage(ManageVO manageVO) throws SQLException;
//	
//	void updateManage(ManageVO manageVO) throws SQLException;
	/**
	 * <pre>
	 * 게시판 리스트를 가져옴
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_ListVO> getBbsList(String name) throws SQLException;
}
