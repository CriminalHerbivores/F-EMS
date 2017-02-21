package com.uni.fems.service;

import java.sql.SQLException;

import com.uni.fems.dto.UsersVO;

public interface UsersService {
	String findId(UsersVO usersVO) throws SQLException;
	String findPw(UsersVO usersVO) throws SQLException;
}
