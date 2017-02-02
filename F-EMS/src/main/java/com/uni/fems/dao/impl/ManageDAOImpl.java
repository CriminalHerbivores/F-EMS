package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.ManageDAO;

public class ManageDAOImpl implements ManageDAO {
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
}
