package com.uni.fems.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.AddressVO;
import com.uni.fems.dto.UsersVO;

/**
 * <pre>
 * 사용자의 아이디/비밀번호 찾기 및 우편번호 검색에 활용되는 Service
 * </pre>
 * @author KJH
 * @since 2017. 1. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자        수정내용
 * --------     --------    ----------------------
 * 2017. 1. 24.      KJH       최초작성
 * 2017. 2. 15.      JAR       추가작성
 * 2017. 1. 24.      KJH       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface UsersService {
	
	/**
	 * <pre>
	 * 아이디 찾기
	 * </pre>
	 * <pre>
	 * @param usersVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String findId(UsersVO usersVO) throws SQLException;
	
	
	/**
	 * <pre>
	 * 비밀번호 찾기
	 * </pre>
	 * <pre>
	 * @param usersVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String findPw(UsersVO usersVO) throws SQLException;
	
	/**
	 * <pre>
	 * 우편번호 찾기
	 * </pre>
	 * <pre>
	 * @param dong
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ArrayList<AddressVO> selectAddressByDong(String dong) throws SQLException;
}
