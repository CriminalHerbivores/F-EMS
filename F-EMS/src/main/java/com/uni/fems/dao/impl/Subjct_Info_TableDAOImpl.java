package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Subjct_Info_TableDAO;

public class Subjct_Info_TableDAOImpl implements Subjct_Info_TableDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
}
