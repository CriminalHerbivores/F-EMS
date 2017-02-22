package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dao.Subjct_Info_TableDAO;
import com.uni.fems.dao.TuitionDAO;
import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.dto.UserSubjctVO;
import com.uni.fems.service.TuitionService;

public class TuitionServiceImpl implements TuitionService {

	private TuitionDAO tuitionDAO;
	public void setTuitionDAO(TuitionDAO tuitionDAO) {
		this.tuitionDAO = tuitionDAO;
	}
	@Autowired
	private Subjct_Info_TableDAO subDAO;
	@Autowired
	private StdntDAO stdntDAO;
	
	@Override
	public ArrayList<UserSubjctVO> selectSubjctByName(int tpage, int totalRecord, String sit_Subjct)
			throws SQLException {
		ArrayList<UserSubjctVO> list = subDAO.selectSubjctByNamePaging(tpage,totalRecord,sit_Subjct);
		return list;
	}
	@Override
	public int countSubjctByName(String sit_Subjct) throws SQLException {
		int count = subDAO.countSubjctByName(sit_Subjct);
		return count;
	}
	@Override
	public void toStdTuition() throws SQLException {
		
	}
	@Override
	public void updateTuition(Subjct_Info_TableVO subVO) throws SQLException {
		subDAO.updateTut(subVO);
	}
	@Override
	public UserSubjctVO selectSubjctByCode(String sit_Subjct_Code)
			throws SQLException {
		UserSubjctVO sub = subDAO.selectSubjctByCode(sit_Subjct_Code);
		return sub;
	}

}
