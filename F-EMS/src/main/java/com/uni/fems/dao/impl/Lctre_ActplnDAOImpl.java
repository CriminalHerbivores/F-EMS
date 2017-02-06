package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Lctre_ActplnDAO;
import com.uni.fems.dto.Lctre_ActplnVO;

public class Lctre_ActplnDAOImpl implements Lctre_ActplnDAO {
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public int insertLctre_Actpl(Lctre_ActplnVO lctre_ActplnVO)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateLctre_Actpl(Lctre_ActplnVO lctre_ActplnVO)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
