package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dao.Lctre_Unq_NoDAO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.Lctre_Unq_NoVO;
import com.uni.fems.service.Lctre_Unq_NoService;

public class Lctre_Unq_NoServiceImpl implements Lctre_Unq_NoService {

	private Lctre_Unq_NoDAO lctre_Unq_NoDAO;

	public void setLctre_Unq_NoDAO(Lctre_Unq_NoDAO lctre_Unq_NoDAO) {
		this.lctre_Unq_NoDAO = lctre_Unq_NoDAO;
	}

	// 교수가 강의 이름으로 강의검색
	@Override
	public ArrayList<Lctre_SearchVO> selectLctreByName(String lu_Lctre_Nm)
			throws SQLException {
		System.out.println("여기일까33333===================================================================");
		List<Lctre_SearchVO> lctre_SearchVO = lctre_Unq_NoDAO
				.selectLctreByName(lu_Lctre_Nm);

		return (ArrayList<Lctre_SearchVO>) lctre_SearchVO;
	}

}
