package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.MenuDAO;

public class MenuDAOImpl implements MenuDAO {
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
}
