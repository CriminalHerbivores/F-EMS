package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Intrst_ListDAO;
import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;


/**
 * <pre>
 * 관심 강의 목록 조회, 추가,삭제하는 DAO
 * </pre>
 * @author KJH
 * @since 2017. 2. 20.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017. 2. 20.    KJH       최초작성
 * 2017. 2. 25.    KJH       추가작성 
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Intrst_ListDAOImpl implements Intrst_ListDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	// 관심 강의 목록
	@Override
	public List<Lctre_SearchVO> selectIntrst_List(String in_Stdnt_No) throws SQLException {
		List<Lctre_SearchVO> selectIntrst_List = (List<Lctre_SearchVO>)client.queryForList("selectIntrst_List", in_Stdnt_No);
		return selectIntrst_List;
	}
	
	// 관심 강의 추가
	@Override
	public void insertIntrst_List(Intrst_ListVO intrst_ListVO)
			throws SQLException {
		client.update("insertIntrst_List",intrst_ListVO);
	}
	
	// 관심 강의 삭제
	@Override
	public void deleteIntrst_List(Intrst_ListVO intrst_ListVO)
			throws SQLException {
		client.delete("deleteIntrst_List",intrst_ListVO);	
	}
	
}
