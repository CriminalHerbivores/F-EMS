package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dao.Lctre_ActplnDAO;
import com.uni.fems.dao.Lctre_Unq_NoDAO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_ActplnVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.service.LctreService;

/**
 * <pre>
 * 수강신청, 강의목록조회, 강의등록, 강의수정과 같은 하나의 작업을
 * 묶어서 복합적으로 처리하는 메서드들을 구현한 클래스
 * </pre>
 * 
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * 2017.02.19      KJH            강의등록
 * 2017.02.20      KJH            강의수정
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

@Data
public class LctreServiceImpl implements LctreService {

	private LctreDAO lctreDAO;
	private Lctre_ActplnDAO lctre_ActplnDAO;
	
	

	//해당 학기의 전체강의 가져옴
	@Override
	public List<Lctre_SearchVO> openLctreList(String lu_Lctre_Nm) throws SQLException{ //int tpage, 
		List<Lctre_SearchVO> lctre_SearchVO=lctreDAO.openLctreList(lu_Lctre_Nm);
		
		return lctre_SearchVO;
	}

	
	// 교수가 개설 강의 폼을 작성하여 직원에게 강의 개설 요청
	@Override
	public int openLctre(LctreVO lctreVO, Lctre_ActplnVO lctre_ActplnVO) throws SQLException {
		int maxLtr_seq=0;
		
		lctreDAO.insertLctre(lctreVO);
		maxLtr_seq=lctreDAO.selectMaxLc_Lctre_No();
		lctre_ActplnVO.setLa_Lctre_No(maxLtr_seq);	// 강의번호 최대값을 넣어줌
		lctre_ActplnDAO.insertLctre_Actpln(lctre_ActplnVO);
		
		return maxLtr_seq;
	}


	// 교수가 강의 수정
	@Override
	public void updateLctre(LctreVO lctreVO, Lctre_ActplnVO lctre_ActplnVO)
			throws SQLException {
		
		lctreDAO.updateLctre(lctreVO);
		lctre_ActplnDAO.updateLctre_Actpl(lctre_ActplnVO);
		
	}


	@Override
	public List<Lctre_SearchVO> selectLctre(Lctre_SearchVO lctre_SearchVO,
			int start, int count) throws SQLException {
		List<Lctre_SearchVO> list = lctreDAO.selectLctre(lctre_SearchVO, start, count);
		return list;
	}


	@Override
	public int countLctre(Lctre_SearchVO lctre_SearchVO) throws SQLException {
		int totalRecord = lctreDAO.countLctre(lctre_SearchVO);
		return totalRecord;
	}



}
