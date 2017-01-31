package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BuildingDAOImpl {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
}
