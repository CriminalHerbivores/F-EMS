package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.UsersDAO;
import com.uni.fems.dto.UsersVO;

public class UsersDAOImpl implements UsersDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public String findId(UsersVO usersVO) throws SQLException {
		String id = (String) client.queryForObject("findId", usersVO);
		return id;
	}
	@Override
	public String findPw(UsersVO usersVO) throws SQLException {
		String pw = (String) client.queryForObject("findPw", usersVO);
		return pw;
	}
	
}
