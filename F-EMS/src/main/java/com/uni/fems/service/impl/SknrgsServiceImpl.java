package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dao.SknrgsDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.request.PageRequest;
import com.uni.fems.service.SknrgsService;

public class SknrgsServiceImpl implements SknrgsService {

	private SknrgsDAO sknrgsDAO;
	public void setSknrgsDAO(SknrgsDAO sknrgsDAO) {
		this.sknrgsDAO = sknrgsDAO;
	}
	
	
//	직원의 학적 관리
	@Override
	public List<SknrgsVO> getSknrgsType(String skn_Typen) throws SQLException {
		List<SknrgsVO> list = sknrgsDAO.getSknrgsType(skn_Typen);
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
