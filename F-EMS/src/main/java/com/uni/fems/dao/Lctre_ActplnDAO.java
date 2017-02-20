package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.Lctre_ActplnVO;

/**
 * <pre>
 * 강의계획서 DAO
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
 * 2017.02.19      KJH            강의등록
 * 2017.02.20      KJH            강의수정
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface Lctre_ActplnDAO {
	
	
	/**
	 * <pre>
	 * 교수가 개설할 강의의 강의 계획서 등록
	 * </pre>
	 * <pre>
	 * @param lctre_ActplnVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctre_Actpln(Lctre_ActplnVO lctre_ActplnVO) throws SQLException;	//강의계획서 등록
	
	
	/**
	 * <pre>
	 * 교수가 개설된 강의 혹은 개설 요청중인 강의의 강의 계획서 수정
	 * </pre>
	 * <pre>
	 * @param lctre_ActplnVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	void updateLctre_Actpl(Lctre_ActplnVO lctre_ActplnVO) throws SQLException;	//강의계획서 수정

}
