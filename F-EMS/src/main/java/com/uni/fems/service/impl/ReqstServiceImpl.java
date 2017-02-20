package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import lombok.Data;

import com.uni.fems.dao.Intrst_ListDAO;
import com.uni.fems.dao.ReqstDAO;
import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.service.ReqstService;

@Data
public class ReqstServiceImpl implements ReqstService {

	private ReqstDAO reqstDAO;
	private Intrst_ListDAO intrst_ListDAO; 

	
	
	// 관심 강의로 추가
	@Override
	public void insertIntrst_List(Intrst_ListVO intrst_ListVO)
			throws SQLException {
		intrst_ListDAO.insertIntrst_List(intrst_ListVO);
	}

}
