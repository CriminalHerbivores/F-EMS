package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapException;
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
	public int insertBuilding(BuildingVO buildingVO) throws SQLException {
		int result=client.update("insertBuilding",buildingVO);
		return result;
	}

	// 건물 수정
	@Override
	public void updateBuilding(BuildingVO buildingVO) throws SQLException {
		client.update("updateBuilding",buildingVO);
	}

	// 전체 건물 조회(사용여부 조건 가능)
	@Override
	public List<BuildingVO> selectBuilding(BuildingVO buildingVO) throws SQLException {
		List<BuildingVO> selectUseBuilding;
		selectUseBuilding = client.queryForList("selectBuilding",buildingVO);
		return selectUseBuilding;
	}

	// 건물 사용 안함
/*	@Override
	public void deleteBuilding(String bd_No) throws SQLException {
		client.update("deleteBuilding",bd_No);
	}
*/
}
