package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Bbs_AtrtyDAO;

public class Bbs_AtrtyDAOImpl implements Bbs_AtrtyDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
}
