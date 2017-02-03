package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dao.impl.paging.Paging;
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
		int totalRecord = stdntDAO.totalRecord(st_Nm);
		List<StdntVO> list = stdntDAO.selectNameAllPage(tpage, totalRecord,st_Nm);
		return list;
	}

	@Override
	public String pageNumber(int tpage, String st_Nm) throws SQLException {
		int totalRecord = stdntDAO.totalRecord(st_Nm);
		String page = new Paging().pageNumber(tpage,totalRecord,"stdntList", "&key="+st_Nm);
		return page;
	}

}
