package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import lombok.Data;

import com.uni.fems.dao.Intrst_ListDAO;
import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.service.Intrst_ListService;

/**
 * <pre>
 * 관심 강의로 조회, 추가, 삭제가 가능한 Controller
 * </pre>
 * @author KJH
 * @since 2017. 2. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017. 2. 24.    KJH       최초작성
 * 2017. 2. 25.    KJH       추가작성 
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Data
public class Intrst_ListServiceImpl implements Intrst_ListService {
 
 private Intrst_ListDAO intrst_ListDAO;

 // 관심 강의 목록 조회
@Override
public List<Lctre_SearchVO> selectIntrst_List(String in_Stdnt_No) throws SQLException {
	List<Lctre_SearchVO> lctre_SearchVO=  intrst_ListDAO.selectIntrst_List(in_Stdnt_No);
	return lctre_SearchVO;
}

// 관심 강의 추가
@Override
public void insertIntrst_List(Intrst_ListVO intrst_ListVO) throws SQLException {
	
	intrst_ListDAO.insertIntrst_List(intrst_ListVO);
	 
}

// 관심 강의 삭제
@Override
public void deleteIntrst_List(Intrst_ListVO intrst_ListVO) throws SQLException {
	intrst_ListDAO.deleteIntrst_List(intrst_ListVO);
}
 
 
}


