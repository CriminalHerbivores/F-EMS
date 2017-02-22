package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.uni.fems.dao.UsersDAO;
import com.uni.fems.dto.AddressVO;
import com.uni.fems.dto.UsersVO;
import com.uni.fems.service.UsersService;

@Data
public class UsersServiceImpl implements UsersService {

	private UsersDAO usersDAO;

	@Override
	public String findId(UsersVO usersVO) throws SQLException {
		String id = usersDAO.findId(usersVO);
		return id;
	}
	@Override
	public String findPw(UsersVO usersVO) throws SQLException {
		String pw = usersDAO.findPw(usersVO);
		return pw;
	}
	
	// 우편번호 찾기
	@Override
	public ArrayList<AddressVO> selectAddressByDong(String dong)
			throws SQLException {
		ArrayList<AddressVO> addressVO=usersDAO.selectAddressByDong(dong);
		return addressVO;
	}

}
