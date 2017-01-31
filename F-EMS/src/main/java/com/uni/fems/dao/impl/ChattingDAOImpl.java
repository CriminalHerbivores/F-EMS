package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.ChattingDAO;

public class ChattingDAOImpl implements ChattingDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
}
