package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.BuildingDAO;
import com.uni.fems.dto.BuildingVO;

/**
 * <pre>
 * 건물 등록, 수정, 사용안함을 설정
 * </pre>
 * @author USER
 * @since 2017. 2. 18.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 18.      USER       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class BuildingDAOImpl implements BuildingDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	// 건물 등록
	@Override
	public void insertBuilding(BuildingVO buildingVO) throws SQLException {
		client.update("insertBuilding",buildingVO);
		System.out.println("여기000000000000000000000000000000000000000000000");
	}

	// 건물 수정
	/*@Override
	public void updateBuilding(BuildingVO buildingVO) throws SQLException {
		client.update("updateBuilding",buildingVO);
	}
*/
	// 건물 사용 안함
/*	@Override
	public void deleteBuilding(String bd_No) throws SQLException {
		client.update("deleteBuilding",bd_No);
	}
*/
}
