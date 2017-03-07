package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.MenuDAO;
import com.uni.fems.dto.MenuVO;
import com.uni.fems.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;
	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	@Override
	public List<MenuVO> selectMenu() throws SQLException {
		List<MenuVO> list = menuDAO.selectMenu();
		return list;
	}

	@Override
	public List<MenuVO> selectMenuSe() throws SQLException {
		List<MenuVO> list = menuDAO.selectMenuSe();
		return list;
	}

	@Override
	public void insertMenu(MenuVO menu) throws SQLException {
		menuDAO.insertMenu(menu);
	}

	@Override
	public void updateMenu(MenuVO menu) throws SQLException {
		menuDAO.updateMenu(menu);
	}

}
