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
	public void setBaskin(BaskinVO baskin) throws SQLException {
		String name = baskinDAO.getName();
		baskin.setBskn_Nm(name);
		baskinDAO.setBaskin(baskin);
	}
}
