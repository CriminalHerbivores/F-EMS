package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;

/**
 * <pre>
 * 관심 강의로 조회, 추가, 삭제가 가능한 Service
 * </pre>
 * @author KJH
 * @since 2017. 2. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017. 2. 24.    KJH       최초작성
 * 2017. 2. 25.    KJH       추가작성 
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Intrst_ListService {
	
	
	/**
	 * <pre>
	 * 관심 강의로 추가된 강의 목록을 조회
	 * </pre>
	 * <pre>
	 * @param in_Stdnt_No
	 * @param in_Lctre_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_SearchVO> selectIntrst_List(String in_Stdnt_No) throws SQLException;
	
	/**
	 * <pre>
	 * 관심 강의로 추가하는 메서드
	 * </pre>
	 * <pre>
	 * @param intrst_ListVO
	 * @throws SQLException
	 */
	void insertIntrst_List(Intrst_ListVO intrst_ListVO) throws SQLException;
	
	
	/**
	 * <pre>
	 * 관심 강의에서 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param in_Stdnt_No
	 * @param in_Lctre_No
	 * @throws SQLException
	 */
	void deleteIntrst_List(Intrst_ListVO intrst_ListVO) throws SQLException;
	
}
