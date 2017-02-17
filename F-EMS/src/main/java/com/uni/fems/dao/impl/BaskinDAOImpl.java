package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.BaskinDAO;
import com.uni.fems.dto.BaskinVO;

public class BaskinDAOImpl implements BaskinDAO{
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public List<BaskinVO> getBaskin() throws SQLException {
		List<BaskinVO> list = (List<BaskinVO>) client.queryForList("getBaskin");
		return list;
	}
	@Override
	public void setBaskin(BaskinVO baskin) throws SQLException {
		client.update("setBaskin",baskin);
	}
	@Override
	public String getName() throws SQLException {
		String name = (String) client.queryForObject("getName");
		return name;
	}
}
