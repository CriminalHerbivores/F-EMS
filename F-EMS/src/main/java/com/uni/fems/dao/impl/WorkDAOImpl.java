package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.WorkDAO;
import com.uni.fems.dto.WorkVO;

public class WorkDAOImpl implements WorkDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public void insertWork(WorkVO workVO) throws SQLException {
		
	}
	@Override
	public void updateWork(WorkVO workVO) throws SQLException {
		
	}
	@Override
	public List<WorkVO> selectWork(WorkVO workVO) throws SQLException {
		return null;
	}
}
