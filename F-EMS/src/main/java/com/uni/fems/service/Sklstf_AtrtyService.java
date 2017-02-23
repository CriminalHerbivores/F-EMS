package com.uni.fems.service;

import java.sql.SQLException;

import com.uni.fems.dto.Sklstf_AtrtyVO;

/**
 * <pre>
 * 직원 권한을 관리하기 위한 Service
 * </pre>
 * @author KJH
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    KJH       최초작성
 * 2017.02.23.    KJH       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Sklstf_AtrtyService {
	
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
