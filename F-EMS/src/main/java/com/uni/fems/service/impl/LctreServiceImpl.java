package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dto.LctreVO;
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

public class LctreServiceImpl implements LctreService {

	private LctreDAO lctreDAO;

	public void setLctreDAO(LctreDAO lctreDAO) {
		this.lctreDAO = lctreDAO;
	}

	//전체강의 가져옴
	@Override
	public List<Lctre_SearchVO> listLctre(String lu_Lctre_Nm) throws SQLException{ //int tpage, 
		List<Lctre_SearchVO> lctre_SearchVO=lctreDAO.listLctre(lu_Lctre_Nm);
		
		return lctre_SearchVO;
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

	// public LctreVO selectLctre(int lc_Lctre_No){
	// LctreVO lctre=null;
	// try {
	// lctre=lctreDAO.getLctre(lc_Lctre_No);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return lctre;
	// }

}
