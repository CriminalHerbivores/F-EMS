package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.MenuVO;

public interface MenuService {
	/**
	 * <pre>
	 * 메뉴 가져오기
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<MenuVO> selectMenu(int start, int end) throws SQLException;
	/**
	 * <pre>
	 * 메뉴종류 가져오기
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<MenuVO> selectMenuSe() throws SQLException;
	/**
	 * <pre>
	 * 메뉴추가
	 * </pre>
	 * <pre>
	 * @param menu
	 * @throws SQLException
	 * </pre>
	 */
	void insertMenu(MenuVO menu) throws SQLException;
	/**
	 * <pre>
	 * 메뉴수정
	 * </pre>
	 * <pre>
	 * @param menu
	 * @throws SQLException
	 * </pre>
	 */
	void updateMenu(MenuVO menu) throws SQLException;
}
