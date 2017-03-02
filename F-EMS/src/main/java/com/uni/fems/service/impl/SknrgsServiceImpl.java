package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.SknrgsDAO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.SknrgsViewVO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.request.PageRequest;
import com.uni.fems.service.SknrgsService;

/**
 * <pre>
 * 학적과 관련된 Service를 구현
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
public class SknrgsServiceImpl implements SknrgsService {

	private SknrgsDAO sknrgsDAO;
	public void setSknrgsDAO(SknrgsDAO sknrgsDAO) {
		this.sknrgsDAO = sknrgsDAO;
	}
	
	@Override
	public List<SknrgsViewVO> listAllSknrgs(int tpage, SknrgsViewVO sknrgsView) throws SQLException {
		int totalRecord = sknrgsDAO.totalSknrgs(sknrgsView);
		return sknrgsDAO.listAllSknrgs(sknrgsView,tpage, totalRecord);
		
	}
	
	@Override
	public String pageNumberSknrgs(int tpage,SknrgsViewVO sknrgsView) throws SQLException {
		int totalRecord = sknrgsDAO.totalSknrgs(sknrgsView);
		String page = new Paging().pageNumber(tpage,totalRecord,"sknrgListForm", "");
		return page;
	}
	
	
	
	
	
	
	@Override
	public List<SknrgsViewVO> getSknrgsType(String skn_Typen) throws SQLException {
		List<SknrgsViewVO> list = sknrgsDAO.getSknrgsType(skn_Typen);
		return list;
	}
	
	@Override
	public int totalRecord(PageRequest p) throws SQLException {
		return sknrgsDAO.totalRecord(p);
	}

	@Override
	public List<SknrgsVO> getStudentSknrgs(PageRequest p)  throws SQLException{
		List<SknrgsVO> sknrgs= new ArrayList<SknrgsVO>();
		sknrgs=sknrgsDAO.getStudentSknrgs(p);
		return sknrgs;
	}

	@Override
	public String pageNumber(PageRequest p) throws SQLException {
		p.setKey("");
		String page = new Paging().pageNumber(p);
		return page;
	}

	@Override
	public void writeSknrgs(SknrgsVO sknrgs) throws SQLException {
		sknrgsDAO.writeSknrgs(sknrgs);
	}

	@Override
	public String getSknrgs(String skn_Stdnt_No) throws SQLException {
		String type = sknrgsDAO.getSknrgs(skn_Stdnt_No);
		return type;
	}
	
	@Override
	public void updateUseynSknrgs(SknrgsVO sknrgs) throws SQLException {
		sknrgsDAO.updateUseynSknrgs(sknrgs);
	}

}