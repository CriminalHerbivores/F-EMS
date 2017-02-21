package com.uni.fems.service;

import java.sql.SQLException;

import com.uni.fems.dto.LctrumVO;

/**
 * <pre>
 * 
 * </pre>
 * @author KJH
 * @since 2017. 2. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 22.      KJH       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface LctrumService {
	/**
	 * <pre>
	 * 강의실 등록을 위한 메서드
	 * </pre>
	 * <pre>
	 * @param lctrumVO
	 * @throws SQLException
	 */
	void insertLctrum(LctrumVO lctrumVO) throws SQLException;
	/**
	 * <pre>
	 * 강의실 수정을 위한 메서드
	 * </pre>
	 * <pre>
	 * @param lctrumVO
	 * @throws SQLException
	 */
	void updateLctrum(LctrumVO lctrumVO) throws SQLException;
	
	
	/**
	 * <pre>
	 * 강의실 사용 안함을 위한 메서드
	 * </pre>
	 * <pre>
	 * @param lr_Lctrum_No
	 * @throws SQLException
	 */
	void deleteLctrum(String lr_Lctrum_No) throws SQLException;
}
