package com.uni.fems.service;

import java.sql.SQLException;

import com.uni.fems.dto.SklstfVO;

/**
 * <pre>
 * 직원 정보를 관리하기 위한 Service
 * </pre>
 * @author JAR
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    JAR       최초작성
 * 2017.02.15.    JAR       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface SklstfService {
	/**
	 * <pre>
	 * 직원 정보를 조회
	 * </pre>
	 * <pre>
	 * @param stf_Sklstf_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	SklstfVO getSklstf(String stf_Sklstf_No)throws SQLException;
	
	/**
	 * <pre>
	 * 관리자가 직원을 등록
	 * </pre>
	 * <pre>
	 * @param sklstfVo
	 * @throws SQLException
	 * </pre>
	 */
	void insertSklstf(SklstfVO sklstfVo)throws SQLException;
	
	/**
	 * <pre>
	 * 직원 정보를 수정
	 * </pre>
	 * <pre>
	 * @param sklstfVo
	 * @throws SQLException
	 * </pre>
	 */
	void updateSklstf(SklstfVO sklstfVo)throws SQLException;
}
