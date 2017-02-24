package com.uni.fems.dao.impl;
 
import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Lctre_Unq_NoDAO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.Lctre_Unq_NoVO;

/**
 * <pre>
 * 강의 고유 번호 DAO의 메서드를 구현하는 클래스
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Lctre_Unq_NoDAOImpl implements Lctre_Unq_NoDAO {
	
	private SqlMapClient client;
	private static Lctre_Unq_NoDAOImpl instance = new Lctre_Unq_NoDAOImpl();
	
	private Lctre_Unq_NoDAOImpl() {}
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	public static Lctre_Unq_NoDAOImpl getInstance() {
		return instance;
	}

	
	
	@Override
	public int insertLctre_Unq_No(Lctre_Unq_NoVO lctre_Unq_NoVO)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateLctre_Unq_No(Lctre_Unq_NoVO lctre_Unq_NoVO)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// 교수가 강의개설할 때 강의명으로 강의찾기
	@Override
	public ArrayList<Lctre_SearchVO> selectLctreByName(String lu_Lctre_Nm)
			throws SQLException {
		ArrayList<Lctre_SearchVO> lctreList;
		lctreList=(ArrayList<Lctre_SearchVO>)client.queryForList("selectLctreByName",lu_Lctre_Nm);
		return lctreList;
	}
}
