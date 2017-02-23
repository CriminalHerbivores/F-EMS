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
	public ArrayList<TuitionVO> tuitionStdnt(TuitionVO tuitionVO,int start, int count)
			throws SQLException {
		
		ArrayList<TuitionVO> list = (ArrayList<TuitionVO>) client.queryForList("tuitionStdnt",tuitionVO,start,count);
		return list;
	}
	@Override
	public int countTuitionStdnt(TuitionVO tuitionVO) throws SQLException {
		int count = (int) client.queryForObject("counttuitionStdnt",tuitionVO);
		return count;
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
	public ArrayList<TuitionVO> selectTuition(TuitionVO tuitionVO)
			throws SQLException {
		ArrayList<TuitionVO> list = (ArrayList<TuitionVO>) client.queryForList("selectTuition",tuitionVO);
		return list;
	}
	@Override
	public ArrayList<TuitionVO> selectNotTuition(TuitionVO tuitionVO)
			throws SQLException {
		ArrayList<TuitionVO> list = (ArrayList<TuitionVO>) client.queryForList("selectNotTuition",tuitionVO);
		return list;
	}
	
}
