package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.KindDAO;
import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dao.Lctre_ActplnDAO;
import com.uni.fems.dao.Lctre_Unq_NoDAO;
import com.uni.fems.dto.KindVO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_ActplnVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.SearchVO;
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
	private KindDAO kindDAO;
	
	// 하나의 강의를 선택하여 강의상세(강의계획서) 조회
	@Override
	public Lctre_SearchVO getDetailLctre(int lc_Lctre_No) throws SQLException {
		Lctre_SearchVO lctre_SearchVO=lctreDAO.getDetailLctre(lc_Lctre_No);
		return lctre_SearchVO;
	}

	//해당 학기의 전체강의 가져옴
	@Override
	public List<Lctre_SearchVO> openLctreList(SearchVO searchVO,int start,int counts) throws SQLException{ 
		return lctreDAO.openLctreList(searchVO, start, counts);
	}
	
	// 개설 강의 목록의 페이징 
	@Override
	public int countLctreList(int tpage,SearchVO searchVO) throws SQLException{
		int totalRecord = lctreDAO.totalOpenLctre(searchVO);
		return totalRecord;
	}

	
	// 교수가 개설 강의 폼을 작성하여 직원에게 강의 개설 요청
	@Override
	public int openLctre(LctreVO lctreVO, Lctre_ActplnVO lctre_ActplnVO, KindVO kindVO) throws SQLException {
		int maxLtr_seq=0;
		
		lctreDAO.insertLctre(lctreVO);
		maxLtr_seq=lctreDAO.selectMaxLc_Lctre_No();
		lctre_ActplnVO.setLa_Lctre_No(maxLtr_seq);	// 강의번호 최대값을 넣어줌
		lctre_ActplnDAO.insertLctre_Actpln(lctre_ActplnVO);
		//knd_Lctre_No=lctreVO.getLc_Lctre_No();
		kindVO.setKnd_Lctre_No(maxLtr_seq);
		kindDAO.insertKind(kindVO);
		
		return maxLtr_seq;
	}


	// 교수가 강의 수정
	@Override
	public void updateLctre(Lctre_SearchVO lctreVO)
			throws SQLException {
		
		lctreDAO.updateLctre(lctreVO);
		lctre_ActplnDAO.updateLctre_Actpl(lctreVO);
		//kindDAO.updateKind(lctreVO);
		
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

	@Override
	public void allowLctre(Lctre_SearchVO lctre_SearchVO) throws SQLException {
		lctreDAO.allowLctre(lctre_SearchVO);
		lctreDAO.updateSplit(lctre_SearchVO);
	}

	@Override
	public void updateSplit(Lctre_SearchVO lctre_SearchVO) throws SQLException {
		lctreDAO.updateSplit(lctre_SearchVO);
	}

	@Override
	public List<Lctre_SearchVO> selectLctreExcel(Lctre_SearchVO lctre_SearchVO) throws SQLException {
		List<Lctre_SearchVO> list = lctreDAO.selectLctreExcel(lctre_SearchVO);
		return list;
	}



}
