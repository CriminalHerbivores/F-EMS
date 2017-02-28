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
		client.update("insertWork",workVO);
	}
	@Override
	public void updateWork(WorkVO workVO) throws SQLException {
		client.update("updateWork",workVO);
	}
	@Override
	public List<WorkVO> selectWork(WorkVO workVO,int start,int count) throws SQLException {
		List<WorkVO> list = client.queryForList("selectWork",workVO,start,count);
		return list;
	}
	@Override
	public int countWork(WorkVO workVO) throws SQLException {
		int totalRecord = (int) client.queryForObject("countWork",workVO);
		return totalRecord;
	}
}
