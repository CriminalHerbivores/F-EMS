package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.SchlshipDAO;
import com.uni.fems.dto.Schafs_SchdulVO;

public class SchlshipDAOImpl implements SchlshipDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public List<Schafs_SchdulVO> listAllSchafs_Schdul() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
