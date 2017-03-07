package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dto.Lctre_NoticeVO;
import com.uni.fems.dto.Lctre_Notice_GntVO;
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

	@Override
	public ArrayList<StdntVO> selectStdntList(StdntVO stdntVO, int start,
			int count) throws SQLException {
		ArrayList<StdntVO> list = stdntDAO.selectStdntList(stdntVO, start, count);
		return list;
	}

	@Override
	public int countStdntList(StdntVO stdntVO) throws SQLException {
		int totalRecord = stdntDAO.countStdntList(stdntVO);
		return totalRecord;
	}
	
	@Override
	public List<StdntVO> selectAllStdntList2(int tpage, StdntVO stdntVO) throws SQLException {
		int totalRecord = stdntDAO.countStdntList2(stdntVO);
		return stdntDAO.selectAllStdntList2(stdntVO, tpage, totalRecord);
		
	}

	@Override
	public String pageNumber2(int tpage,StdntVO stdntVO) throws SQLException {
		int totalRecord = stdntDAO.countStdntList2(stdntVO);
		String page = new Paging().ajaxpageNumber(tpage,totalRecord,"go_StdntList","");
		return page;
	}
	
	@Override
	public void updateSt_Profsr_No(StdntVO stdntVO) throws SQLException {
		stdntDAO.updateSt_Profsr_No(stdntVO);
	}

}
