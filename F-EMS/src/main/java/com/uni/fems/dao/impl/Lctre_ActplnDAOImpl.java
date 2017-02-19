package com.uni.fems.dao.impl;
 
import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Lctre_ActplnDAO;
import com.uni.fems.dto.Lctre_ActplnVO;

/**
 * <pre>
 * 강의계획서 DAO의 메서드를 구현하는 클래스
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

public class Lctre_ActplnDAOImpl implements Lctre_ActplnDAO {
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	
	// 강의계획서 등록
	@Override
	public void insertLctre_Actpln(Lctre_ActplnVO lctre_ActplnVO) throws SQLException {
		System.out.println("==================================================================================Lctre_ActplnDAOImpl  111111111111");
		client.update("insertLctre_Actpln",lctre_ActplnVO);
		System.out.println("==================================================================================Lctre_ActplnDAOImpl  2222222222222");
	}
	@Override
	public int updateLctre_Actpl(Lctre_ActplnVO lctre_ActplnVO)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
