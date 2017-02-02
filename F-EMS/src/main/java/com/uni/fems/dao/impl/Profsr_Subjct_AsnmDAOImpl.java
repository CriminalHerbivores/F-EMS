package com.uni.fems.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Profsr_Subjct_AsnmDAO;

public class Profsr_Subjct_AsnmDAOImpl implements Profsr_Subjct_AsnmDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
}
