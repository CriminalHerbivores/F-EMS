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

	@Override
	public List<StdntVO> selectNameAllPage(int tpage, String st_Nm)
			throws SQLException {
		List<StdntVO> list = stdntDAO.selectNameAllPage(tpage, st_Nm);
		return list;
	}

	@Override
	public String pageNumber(int tpage, String st_Nm) throws SQLException {
		String page = stdntDAO.pageNumber(tpage, st_Nm);
		return page;
	}

}
