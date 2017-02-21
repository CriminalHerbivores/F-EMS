package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.BuildingVO;

/**
 * <pre>
 * 건물을 등록, 수정, 사용안함 설정과 관련된 DAO
 * </pre>
 * @author KJH
 * @since 2017. 2. 18.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일         수정자       수정내용
 * --------     --------    ----------------------
 * 2017. 2. 18.      KJH       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface BuildingDAO {
	
	/**
	 * <pre>
	 * 건물 등록
	 * </pre>
	 * <pre>
	 * @param buildingVO
	 * @throws SQLException
	 */
	int insertBuilding(BuildingVO buildingVO) throws SQLException;
	
	/**
	 * <pre>
	 * 건물 수정
	 * </pre>
	 * <pre>
	 * @param buildingVO
	 * @throws SQLException
	 */
	void updateBuilding(BuildingVO buildingVO) throws SQLException;
	
	/**
	 * <pre>
	 * 건물 사용 안함
	 * </pre>
	 * <pre>
	 * @param bd_No
	 * @throws SQLException
	 */
	//void deleteBuilding(String bd_No) throws SQLException;
	

}
