package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.MenuDAO;
import com.uni.fems.dto.MenuVO;

public class MenuDAOImpl implements MenuDAO {
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public List<MenuVO> selectMenu(int start, int end) throws SQLException {
		List<MenuVO> list = client.queryForList("selectMenu",start,end);
		return list;
	}
	@Override
	public List<MenuVO> selectMenuSe() throws SQLException {
		List<MenuVO> list = client.queryForList("selectMenuSe");
		return list;
	}
	@Override
	public void insertMenu(MenuVO menu) throws SQLException {
		client.update("insertMenu",menu);
	}
	@Override
	public void updateMenu(MenuVO menu) throws SQLException {
		client.update("updateMenu",menu);
	}
}
