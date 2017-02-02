package com.uni.fems.dao.impl;


import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dto.StdntVO;

public class StdntDAOImpl implements StdntDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public void insertStdnt(StdntVO stdntVO) throws SQLException {
		client.update("insertStdnt", stdntVO);
	}
	
}
