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
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

@Data
public class LctreServiceImpl implements LctreService {

	private LctreDAO lctreDAO;
	private Lctre_ActplnDAO lctre_ActplnDAO;
	
	

	//전체강의 가져옴
	@Override
	public List<Lctre_SearchVO> listLctre(String lu_Lctre_Nm) throws SQLException{ //int tpage, 
		List<Lctre_SearchVO> lctre_SearchVO=lctreDAO.listLctre(lu_Lctre_Nm);
		
		return lctre_SearchVO;
	}

	
	// 교수가 개설 강의 폼을 작성하여 직원에게 강의 개설 요청
	@Override
	public void openLctre(LctreVO lctreVO, Lctre_ActplnVO lctre_ActplnVO) throws SQLException {
		System.out.println("==================================================================================LctreServiceImpl  1111111111");

		//강의등록시 필요한 정보 불러오게 해야할듯? 조회쪽
		lctreDAO.insertLctre(lctreVO);
		lctre_ActplnDAO.insertLctre_Actpln(lctre_ActplnVO);
		
		
		System.out.println("==================================================================================LctreServiceImpl  2222222222");

	}

	// public ArrayList<LctreVO> getLctreList(int key){
	// ArrayList<LctreVO> lctreList=null;
	// try {
	// lctreList = lctreDAO.listLctre(key);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return lctreList;
	// }

//	 public LctreVO selectLctre(int lc_Lctre_No){
//	 LctreVO lctre=null;
//	 try {
//	 lctre=lctreDAO.getLctre(lc_Lctre_No);
//	 } catch (SQLException e) {
//	 e.printStackTrace();
//	 }
//	 return lctre;
//	 }

}
