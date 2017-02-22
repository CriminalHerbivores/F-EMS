package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.Sklstf_AtrtyVO;

/**
 * <pre>
 * 직원에게 관리자 권한을 설정하는 DAO
 * </pre>
 * @author pc12
 * @since 2017. 2. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 22.      pc12       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Sklstf_AtrtyDAO {
	
	
	/**
	 * <pre>
	 * 직원에게 관리자 권한 설정 등록
	 * </pre>
	 * <pre>
	 * @param sklstf_AtrtyVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertSklstf_Atrty(Sklstf_AtrtyVO sklstf_AtrtyVO) throws SQLException;
	
	/**
	 * <pre>
	 * 직원의 관리자 권한 설정 수정
	 * </pre>
	 * <pre>
	 * @param sklstf_AtrtyVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateSklstf_Atrty(Sklstf_AtrtyVO sklstf_AtrtyVO) throws SQLException;
}
