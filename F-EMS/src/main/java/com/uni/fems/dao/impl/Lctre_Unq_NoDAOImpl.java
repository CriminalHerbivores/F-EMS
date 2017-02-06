package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Lctre_Unq_NoDAO;
import com.uni.fems.dto.Lctre_Unq_NoVO;

public class Lctre_Unq_NoDAOImpl implements Lctre_Unq_NoDAO {
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public int insertLctre_Unq_No(Lctre_Unq_NoVO lctre_Unq_NoVO)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateLctre_Unq_No(Lctre_Unq_NoVO lctre_Unq_NoVO)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
