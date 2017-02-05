package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dao.SknrgsDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.service.SknrgsService;

public class SknrgsServiceImpl implements SknrgsService {

	private SknrgsDAO sknrgsDAO;
	public void setSknrgsDAO(SknrgsDAO sknrgsDAO) {
		this.sknrgsDAO = sknrgsDAO;
	}

	@Override
	public List<SknrgsVO> getStudentSknrgs(String skn_Stdnt_No)  throws SQLException{
		List<SknrgsVO> sknrgs= new ArrayList<SknrgsVO>();
		sknrgs=sknrgsDAO.getStudentSknrgs(skn_Stdnt_No);
		return sknrgs;
	}

	@Override
	public String pageNumber(int tpage, String key, String path) throws SQLException {
		int totalRecord = sknrgsDAO.totalRecord();
		String page = new Paging().pageNumber(tpage,totalRecord,path, "&key="+key);
		return page;
	}

}
