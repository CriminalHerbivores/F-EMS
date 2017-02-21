package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.UsersVO;

public interface UsersDAO {
	String findId(UsersVO usersVO) throws SQLException;
	String findPw(UsersVO usersVO) throws SQLException;
}
