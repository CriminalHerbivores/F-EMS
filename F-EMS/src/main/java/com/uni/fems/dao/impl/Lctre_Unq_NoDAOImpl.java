package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Lctre_Unq_NoDAO;

public class Lctre_Unq_NoDAOImpl implements Lctre_Unq_NoDAO {
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
}
