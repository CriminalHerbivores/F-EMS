package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.service.StdntService;

/**
 * <pre>
 * 학생과 관련된 Service를 구현
 * </pre>
 * @author JAR
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    JAR       최초작성
 * 2017.02.15.    JAR       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
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

	@Override
	public StdntVO selectStdnt(String st_Stdnt_No) throws SQLException {
		StdntVO stdntVO = stdntDAO.selectStdnt(st_Stdnt_No);
		return stdntVO;
	}

	@Override
	public void updateStdnt(StdntVO stdntVO) throws SQLException {
		stdntDAO.updateStdnt(stdntVO);
	}

	@Override
	public void registBrhs(StdntVO stdntVO) throws SQLException {
		stdntDAO.registBrhs(stdntVO);
	}

}
