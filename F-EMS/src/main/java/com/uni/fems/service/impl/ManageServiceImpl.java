package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.ManageDAO;
import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.ManageVO;
import com.uni.fems.service.ManageService;

public class ManageServiceImpl implements ManageService {

	private ManageDAO manageDAO;
	public void setManageDAO(ManageDAO manageDAO) {
		this.manageDAO = manageDAO;
	}

	@Override
	public ManageVO getManage() throws SQLException {
		ManageVO manageVO = manageDAO.getManage();
		return manageVO;
	}

	@Override
	public List<Bbs_ListVO> getBbsList(String name) throws SQLException {
		List<Bbs_ListVO> bbsListVO = manageDAO.getBbsList(name);
		return bbsListVO;
	}

	@Override
	public List<LctreVO> getStdntList(String loginUser) throws SQLException {
		List<LctreVO> list = manageDAO.getStdntList(loginUser);
		return list;
	}

	@Override
	public List<LctreVO> getProfsrList(String loginUser) throws SQLException {
		List<LctreVO> list = manageDAO.getProfsrList(loginUser);
		return list;
	}

	@Override
	public int insertUniv(ManageVO manageVO) throws SQLException {
		return manageDAO.insertUniv(manageVO);
	}

}
