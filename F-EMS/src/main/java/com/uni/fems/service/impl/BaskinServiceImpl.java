package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.BaskinDAO;
import com.uni.fems.dto.BaskinVO;
import com.uni.fems.service.BaskinService;

public class BaskinServiceImpl implements BaskinService{
	
	private BaskinDAO baskinDAO;
	public void setBaskinDAO(BaskinDAO baskinDAO) {
		this.baskinDAO = baskinDAO;
	}

	@Override
	public List<BaskinVO> getBaskin() throws SQLException {
		List<BaskinVO> list = baskinDAO.getBaskin();
		return list;
	}

	@Override
	public BaskinVO getThemeBaskin(String bskn_Nm) throws SQLException {
		BaskinVO vo = baskinDAO.getThemeBaskin(bskn_Nm);
		return vo;
	}
	
}
