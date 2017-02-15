package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.Lctre_Unq_NoVO;

/**
 * <pre>
 * 강의고유번호 DAO
 * 같은 커리큘럼의 강의는 강의고유번호를 부여하여 관리된다
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

public interface Lctre_Unq_NoDAO {
	
	/**
	 * <pre>
	 * 강의 고유번호 등록
	 * </pre>
	 * <pre>
	 * @param lctre_Unq_NoVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertLctre_Unq_No(Lctre_Unq_NoVO lctre_Unq_NoVO) throws SQLException;	//강의고유번호 등록
	
	/**
	 * <pre>
	 * 강의 고유번호 수정
	 * </pre>
	 * <pre>
	 * @param lctre_Unq_NoVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int updateLctre_Unq_No(Lctre_Unq_NoVO lctre_Unq_NoVO) throws SQLException;	//강의고유번호 수정

}
