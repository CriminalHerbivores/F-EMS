package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.SknrgsDAO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.service.SknrgsService;

public class SknrgsServiceImpl implements SknrgsService {

	private SknrgsDAO sknrgsDAO;

	public void setSknrgsDAO(SknrgsDAO sknrgsDAO) {
		this.sknrgsDAO = sknrgsDAO;
	}

	@Override
	public SknrgsVO getStudentSknrgs(String skn_Stdnt_No)  throws SQLException{
		SknrgsVO sknrgs = new SknrgsVO();
		sknrgs=sknrgsDAO.getStudentSknrgs(skn_Stdnt_No);
		return sknrgs;
	}

}
