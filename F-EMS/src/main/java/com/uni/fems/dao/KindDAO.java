package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.KindVO;
import com.uni.fems.dto.Lctre_SearchVO;

/**
 * <pre>
 * 강의 등록, 수정, 삭제시 강의 종류를 반영하는 DAO
 * </pre>
 * @author KJH
 * @since 2017. 2. 25.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017. 2. 25.   USER            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface KindDAO {
	
	/**
	 * <pre>
	 * 강의 등록시 강의종류를 같이 등록한다
	 * </pre>
	 * <pre>
	 * @param knd_Lctre_No
	 * @throws SQLException
	 */
	void insertKind(KindVO kindVO) throws SQLException;
	
	/**
	 * <pre>
	 * 강의 수정시 강의종류를 같이 등록한다
	 * </pre>
	 * <pre>
	 * @param knd_Lctre_No
	 * @throws SQLException
	 */
	void updateKind(Lctre_SearchVO knd_Lctre_No) throws SQLException;
	
}
