package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.TuitionDAO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.TuitionVO;

public class TuitionDAOImpl implements TuitionDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public ArrayList<TuitionVO> tuitionStdnt(String tu_Stdnt_No)
			throws SQLException {
		ArrayList<TuitionVO> list = (ArrayList<TuitionVO>) client.queryForList("tuitionStdnt",tu_Stdnt_No);
		return list;
	}
	@Override
	public void insertTuition(TuitionVO tuitionVO) throws SQLException {
		client.update("insertTuition",tuitionVO);
	}
	@Override
	public void updateTuition(TuitionVO tuitionVO) throws SQLException {
		client.update("updateTuition",tuitionVO);
	}
	@Override
	public ArrayList<TuitionVO> selectTuition(SearchVO searchVO)
			throws SQLException {
		ArrayList<TuitionVO> list = (ArrayList<TuitionVO>) client.queryForList("selectTuition",searchVO);
		return list;
	}
	@Override
	public ArrayList<TuitionVO> selectNotTuition(SearchVO searchVO)
			throws SQLException {
		ArrayList<TuitionVO> list = (ArrayList<TuitionVO>) client.queryForList("selectNotTuition",searchVO);
		return list;
	}
	
}
