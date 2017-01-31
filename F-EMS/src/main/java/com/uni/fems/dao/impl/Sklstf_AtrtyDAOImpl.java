package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Sklstf_AtrtyDAO;

public class Sklstf_AtrtyDAOImpl implements Sklstf_AtrtyDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
}
