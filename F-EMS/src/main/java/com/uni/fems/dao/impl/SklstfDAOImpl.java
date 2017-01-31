package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.SklstfDAO;

public class SklstfDAOImpl implements SklstfDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
}
