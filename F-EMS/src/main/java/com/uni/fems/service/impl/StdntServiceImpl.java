package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.service.StdntService;

public class StdntServiceImpl implements StdntService {

	private StdntDAO stdntDAO;

	public void setStdntDAO(StdntDAO stdntDAO) {
		this.stdntDAO = stdntDAO;
	}

	@Override
	public void insertStdnt(StdntVO stdntVO) throws SQLException {
		stdntDAO.insertStdnt(stdntVO);

	}

}
