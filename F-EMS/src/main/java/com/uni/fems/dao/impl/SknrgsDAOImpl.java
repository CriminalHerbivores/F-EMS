package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.SknrgsDAO;

public class SknrgsDAOImpl implements SknrgsDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
}
