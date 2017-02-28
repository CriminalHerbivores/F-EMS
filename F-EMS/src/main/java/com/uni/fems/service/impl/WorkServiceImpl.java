package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.WorkDAO;
import com.uni.fems.dto.WorkVO;
import com.uni.fems.service.WorkService;

public class WorkServiceImpl implements WorkService {

	private WorkDAO workDAO;
	public void setWorkDAO(WorkDAO workDAO) {
		this.workDAO = workDAO;
	}
	@Override
	public void insertWork(WorkVO workVO) throws SQLException {
		workDAO.insertWork(workVO);
	}
	@Override
	public void updateWork(WorkVO workVO) throws SQLException {
		workDAO.updateWork(workVO);
	}
	@Override
	public List<WorkVO> selectWork(WorkVO workVO,int start,int count) throws SQLException {
		List<WorkVO> list = workDAO.selectWork(workVO,start,count);
		return list;
	}
	@Override
	public int countWork(WorkVO workVO) throws SQLException {
		int totalRecord = workDAO.countWork(workVO);
		return totalRecord;
	}

}
