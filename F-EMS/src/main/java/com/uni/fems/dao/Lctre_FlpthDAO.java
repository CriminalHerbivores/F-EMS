package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_FlpthVO;

/**
 * <pre>
 * 강의 파일 업로드 및 다운로드를 위한 DAO
 * </pre>
 * @author KJS
 * @since 2017.02.23
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.23     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Lctre_FlpthDAO {

	/**
	 * <pre>
	 *  파일 경로 출력	
	 * </pre>
	 * <pre>
	 * @param Lctre_FlpthVO
	 * @return List<Lctre_FlpthVO>
	 * @throws SQLException
	 * </pre>
	 */
	Lctre_FlpthVO getLctre_Flpth(int lf_No)
			throws SQLException;

	/**
	 * <pre>
	 *  파일 등록	
	 * </pre>
	 * <pre>
	 * @param Lctre_FlpthVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int insertLctre_Flpth(Lctre_FlpthVO lctre_Flpth) throws SQLException;

	/**
	 * <pre>
	 *  파일 삭제	
	 * </pre>
	 * <pre>
	 * @param Lctre_FlpthVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int deleteLctre_Flpth_lctre(int lf_No) throws SQLException;

	/**
	 * <pre>
	 *  파일 번호 받아오기	
	 * </pre>
	 * <pre>
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int maxLctre_Flpth() throws SQLException;

}
