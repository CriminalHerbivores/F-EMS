package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ConsultationDAOImpl {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
}
